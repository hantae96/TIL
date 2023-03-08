package mvc;

import inheritance05.IMemberDAO;
import inheritance05.MemberDTO;
import inheritance05.MemberDaoImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String email = "", name="", mobile="";
        int index;
        IMemberDAO memberDao = new MemberDaoImpl();


        while (true) {
            System.out.println("1. 회원 등록");
            System.out.println("2. 회원 검색");
            System.out.println("3. 회원 삭제");
            System.out.println("4. 회원 모두 보기");
            System.out.println("5. 회원 수정");
            System.out.println("6. 프로그램 종료");
            System.out.print("선택 > ");
            int select;
            try {
                select = Integer.parseInt(in.next());
            } catch (Exception e) {
                continue;
            }
            switch (select) {
                case 1:
                    System.out.println("=== 회원 등록 ===");
                    System.out.print("이메일 : "); email = in.next();
                    System.out.print("이름 : ");	name = in.next();
                    System.out.print("전화번호 : "); mobile = in.next();

                    index = memberDao.findIndexByEmail(email);
                    if(index == -1) {
                        inheritance05.MemberDTO member = new inheritance05.MemberDTO();
                        member.setEmail(email);
                        member.setName(name);
                        member.setMobile(mobile);

                        memberDao.insert(member);
                        System.out.println("회원 등록이 되었습니다.");
                    }else {
                        System.out.println("등록된 정보입니다.");
                    }
                    break;
                case 2:
                    System.out.println("=== 회원 검색 ===");
                    System.out.print("이메일 : "); email = in.next();
                    index = memberDao.findIndexByEmail(email);
                    if(index == -1) {
                        System.out.println("미등록 정보입니다.");
                    }else {
                        inheritance05.MemberDTO member = memberDao.selectEmail(index);
                        System.out.println("이메일 : " + member.getEmail());
                        System.out.println("이름 : " + member.getName());
                        System.out.println("전화번호 : " + member.getMobile());
                    }
                    break;
                case 3:
                    System.out.println("=== 회원 삭제 ===");
                    System.out.print("이메일 : "); email = in.next();
                    index = memberDao.findIndexByEmail(email);
                    if(index == -1) {
                        System.out.println("미등록 정보입니다.");
                    }else {
                        memberDao.delete(index);
                        System.out.println("정보가 삭제되었습니다.");
                    }
                    break;
                case 4:
                    ArrayList<inheritance05.MemberDTO> members = memberDao.selectAll();
                    if(members.isEmpty() == false) {
                        for(MemberDTO m : members) {
                            System.out.println("이메일 : " + m.getEmail());
                            System.out.println("이름 : " + m.getName());
                            System.out.println("전화번호 : " + m.getMobile());
                        }
                    }else {
                        System.out.println("등록된 정보가 없습니다.");
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.println("=== 회원 수정 ===");
                    System.out.print("이메일 : "); email = in.next();
                    System.out.print("이름 : ");	name = in.next();
                    System.out.print("전화번호 : "); mobile = in.next();
                    index = memberDao.findIndexByEmail(email);
                    if(index == -1) {
                        System.out.println("미등록 정보입니다.");
                    }else {
                        memberDao.update(index, name, mobile);
                        System.out.println("정보가 수정되었습니다.");
                    }
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("메뉴 확인 후 다시 입력하세요.");
            }
        }
    }
}

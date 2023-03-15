package com.example.jdbcproject.dbConcept03.view;

import com.example.jdbcproject.dbConcept03.dao.MemberDAO;
import com.example.jdbcproject.dbConcept03.dto.MemberDTO;
import com.example.jdbcproject.dbConcept03.service.MemberService;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberView implements IView{

    Scanner in = new Scanner(System.in);
    String id = "", name="", password="", email = "";

    MemberService service = new MemberService();


    @Override
    public void mainMenu() {
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
                    insertMember();
                    break;
                case 2:
                    selectId();
                    break;
                case 3:
                    deleteMember();
                    break;
                case 4:
                    selectAll();
                    break;
                case 5:
                    updateMember();
                    break;
                case 6:
                    disconnect();
                default:
                    System.out.println("메뉴 확인 후 다시 입력하세요.");
            }
        }
    }

    private void disconnect() {
        System.out.println("프로그램을 종료합니다.");

        System.exit(0);
    }


    @Override
    public void deleteMember() {
        System.out.println("=== 회원 삭제 ===");
        System.out.print("아이디 : "); id = in.next();
        System.out.print("비밀번호 : "); password = in.next();
        service.deleteMember(id,password);
    }

    @Override
    public void updateMember() {
        System.out.println("=== 회원 수정 ===");
        System.out.print("변경할 아이디 : "); id = in.next();
        service.updateMember(id,password,name,email);

    }

    @Override
    public void insertMember() {
        System.out.println("=== 회원 등록 ===");
        System.out.print("아이디 : "); id = in.next();
        System.out.print("비밀번호 : ");	password = in.next();
        System.out.print("이름 : ");	name = in.next();
        System.out.print("이메일 : "); email = in.next();
        service.insertMember(id,password,name,email);
    }

    @Override
    public void selectId() {
        System.out.println("=== 회원 검색 ===");
        System.out.print("아이디 : ");
        id = in.next();
        service.selectId(id);
    }

    @Override
    public void selectAll() {
        service.selectAll();
    }
}

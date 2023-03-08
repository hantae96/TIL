package inheritance06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
         * 회원 관리 프로그램 만들기 :  1~5번에 해당하는 메소드 구현
         * 1.회원등록 : id, password, name 3개의 정보를 id는 중복되지 않도록 등록함.
         * 2.회원검색 : id를 이용하여 회원 정보를 검색하여 출력함.
         * 3.회원삭제 : id를 이용하여 회원 정보를 삭제함.
         * 4.회원 모두 보기 : 모든 정보 출력함.
         * 5.비밀번호 수정 : id를 이용하여 비밀번호를 수정함.
         * 6.프로그램 종료 : 프로그램을 종료함.
         */
        Scanner sc = new Scanner(System.in);
        UserDAOImpl userDAO = new UserDAOImpl();

        String id;

        while(true) {
            System.out.println("1. 회원 등록");
            System.out.println("2. 회원 검색");
            System.out.println("3. 회원 삭제");
            System.out.println("4. 회원 모두 보기");
            System.out.println("5. 비밀번호 수정");
            System.out.println("6. 프로그램 종료");
            System.out.print(">>> ");
            String select = sc.next();

            switch(select) {
                case "1":
                    userDAO.insert();
                    break;
                case "2":
                    userDAO.findById();
                    break;
                case "3": System.out.println(" === 회원 삭제 === ");
                    System.out.print("아이디 : "); id = sc.next();
                    break;
                case "4":
                    userDAO.findAllById();
                    break;
                case "5": System.out.println(" === 비밀번호 수정 === ");
                    System.out.print("아이디 : "); id = sc.next();
                    System.out.print("현재 비밀번호 : "); String currentPw = sc.next();
                    System.out.print("변경 비밀번호 : "); String changePw = sc.next();
                    break;
                case "6": System.out.println("프로그램을 종료합니다."); System.exit(0);
                default:  System.out.println("메뉴 확인 후 다시 입력하세요.");

            }
        }
    }
}










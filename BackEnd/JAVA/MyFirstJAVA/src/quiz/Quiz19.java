package quiz;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Quiz19 {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> name = new ArrayList<>();
    static ArrayList<String> phone = new ArrayList<>();
    static ArrayList<String> mail = new ArrayList<>();

    public static void main(String[] args) {

        outer:
        while (true) {
            try {
                System.out.println("1. 회원 등록");
                System.out.println("2. 회원 확인");
                System.out.println("3. 회원 삭제");
                System.out.println("4. 회원 수정");
                System.out.println("5. 종료");
                int input = sc.nextInt();
                sc.nextLine();

                switch (input) {
                    case 1:
                        if (registMeber()) {
                            break;
                        } else {
                            break outer;
                        }
                    case 2:
                        checkMember();
                        break;
                    case 3:
                        deleteMember();
                        break;
                    case 4:
                        modifyMember();
                        break;
                    case 5:
                        stopProgram();
                        break outer;
                }
            } catch (Exception e) {
                System.out.println("오류가 발생했습니다. 다시 시작하십시오");
                break;
            }
        }
    }

    static boolean registMeber() {
        System.out.println("이름, 전화번호, 이메일을 작성해주세요");

        String inputName = sc.next();
        String inputPhone = sc.next();
        String inputMail = sc.next();

        if ((!checkRegular("mail", inputMail) || !checkRegular("phone", inputPhone)))
            return false;

        name.add(inputName);
        phone.add(inputPhone);
        mail.add(inputMail);
        sc.nextLine();
        return true;
    }

    static void checkMember() {
        System.out.println("이메일을 입력하여 검색하세요");
        String tempMail = sc.nextLine();

        int index = mail.indexOf(tempMail);
        if (index != -1) {
            System.out.println("이름 : " + name.get(index));
            System.out.println("전화번호 : " + phone.get(index));
            System.out.println("이메일 : " + mail.get(index));
        } else {
            System.out.println("값이 없습니다.");
        }
    }

    static void deleteMember() {
        System.out.println("이메일을 입력하여 삭제하세요");
        String tempMail = sc.nextLine();
        int index = mail.indexOf(tempMail);

        if (index != -1) {
            name.remove(index);
            phone.remove(index);
            mail.remove(index);
            System.out.println("값이 삭제 되었습니다.");
        } else {
            System.out.println("값이 없습니다.");
        }
    }

    static void modifyMember() {
        System.out.println("이메일을 입력하여 수정하세요");
        String tempMail = sc.nextLine();
        int index = mail.indexOf(tempMail);

        if (index != -1) {
            System.out.print("이름 입력 : ");
            name.set(index, sc.next());
            System.out.print("전화번호 입력 : ");
            phone.set(index, sc.next());
            System.out.println("값이 수정 되었습니다.");
        } else {
            System.out.println("값이 없습니다.");
        }
    }

    static void stopProgram() {
        System.out.println("프로그램을 종료합니다.");
    }

    static boolean checkRegular(String type, String input) {
        switch (type) {
            case "phone":
                String phonePattern = "^\\d{3}-\\d{3,4}-\\d{4}$";
                if(!Pattern.matches(phonePattern, input)) {
                    System.out.println("올바른 휴대전화 형식이 아닙니다. ");
                    return false;
                }
                break;

            case "mail":
                String mailPattern = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
                if (!Pattern.matches(mailPattern, input)) {
                    System.out.println("올바른 이메일 형식이 아닙니다. ");
                    return false;
                }
               break;
        }
        return true;
    }

}


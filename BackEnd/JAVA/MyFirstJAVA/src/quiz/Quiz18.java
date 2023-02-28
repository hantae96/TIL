package quiz;

import javaExample.IteratorTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Quiz18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> phone = new ArrayList<>();

        int idx = 0;
        String findName = "";

        outer : while (true) {
            System.out.println("1. 연락처 등록");
            System.out.println("2. 연락처 보기");
            System.out.println("3. 연락처 삭제");
            System.out.println("4. 모든 연락처 보기");
            System.out.println("5. 종료");

            int input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 1:
                    System.out.println("이름과 전화번호를 입력하세요");
                    name.add(sc.next());
                    phone.add(sc.next());
                    sc.nextLine();
                    break;

                case 2:
                    System.out.println("찾고 싶은 이름을 입력하세요");
                    findName = sc.nextLine();
                    if (name.contains(findName)) {
                        System.out.println(findName + "을 찾았습니다.");
                        idx = name.indexOf(findName);
                        System.out.println("전화 번호는 : " + phone.get(idx));
                    }
                    break;

                case 3:
                    System.out.println("삭제 하고 싶은 이름을 입력하세요");
                    findName = sc.nextLine();
                    idx = name.indexOf(findName);
                    name.remove(idx);
                    phone.remove(idx);
                    System.out.println("삭제되었습니다.");
                    break;

                case 4:
                    System.out.println("모든 연락처를 출력합니다.");
                    for (int i = 0; i < name.size(); i++) {
                        System.out.print("이름 : " + name.get(i) + " 전화번호 : " + phone.get(i)+"\n");
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    break outer;
            }

        }
    }
}

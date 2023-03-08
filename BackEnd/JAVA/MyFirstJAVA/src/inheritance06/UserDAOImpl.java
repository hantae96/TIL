package inheritance06;

import java.util.ArrayList;
import java.util.Scanner;

public class UserDAOImpl implements IUserDAO{
    // 메모리 저장소 선언
    private final ArrayList<UserDTO> users;
    private int index = 0;
    Scanner sc = new Scanner(System.in);

    public UserDAOImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void insert() {
        System.out.println(" === 회원 등록 === ");
        System.out.print("아이디 : "); String id = sc.next();
        System.out.print("비밀번호 : "); String pw = sc.next();
        System.out.print("이름 : "); String name = sc.next();

        // 중복검사
        for(UserDTO i : users) {
            if (i.getId().equals(id)) {
                System.out.println("중복된 id 입니다. 다시 입력하세요.");
                return;
            }
        }

        // 회원 등록
        UserDTO user = new UserDTO(id,pw,name,index++);
        users.add(user);
    }

    @Override
    public UserDTO findById() {
        System.out.println(" === 회원 검색 === ");
        System.out.print("아이디 : ");
        String id = sc.next();
        UserDTO findDTO = null;
        for(UserDTO i : users){
            if(i.getId().equals(id)){
                System.out.print("아이디 : " + i.getId());
                System.out.print(" 비밀번호 : "+ i.getPassward());
                System.out.print(" 이름 : "+i.getName());
                System.out.print(" idx : "+i.getIndex());
                findDTO = i;
            }
        }
        return findDTO;
    }

    @Override
    public ArrayList<UserDTO> findAllById() {
        System.out.println("유저 정보 전체 출력");
        for (UserDTO user : users) {
            System.out.println("user = " + user.getIndex());

        }
        return users;
    }

    @Override
    public void updatePasswordById(String id) {
        for(UserDTO i : users){
            if(i.getId().equals(id)){
                System.out.print("아이디 : " + i.getId());
                System.out.print(" 비밀번호 : "+ i.getPassward());
                System.out.print(" 이름 : "+i.getName());
                System.out.print(" idx : "+i.getIndex());
            }
        }
    }

    @Override
    public void delete(String id) {

    }
}

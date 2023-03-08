package mvc;

import java.util.ArrayList;

// DAO : 데이터베이스의 data가 접근 하기 위한 객체로
// DataBase에 접근하기 위한 로직 과 비즈니스 로직을 분리하기 위해 사용
public interface MemberDAO {
    // CRUD 기능이 있으며
    // C : 삽입(insert), find,select(읽기 및 조회) U:업데이트 D : delete

    public void insert(MemberDTO member);
    // 이메일을 넣어서 -> 인덱스로 반환하는 메서드
    public int findIndexByEmail(String email);
    // 인덱스를 넣어서 -> DTO 객체로 반환
    public MemberDTO selectEmail(int index);
    // 메서드 실행시키면 arrayList 형태로 DTO 전부 반환
    public ArrayList<MemberDTO> selectAll();
    // 정보를 받아서 업데이트
    public void update(int index, String name, String mobile);
    // 인덱스로 찾아서 객체 삭제
    public  void delete(int index);
}

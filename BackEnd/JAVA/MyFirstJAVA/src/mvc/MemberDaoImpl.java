package mvc;

import java.util.ArrayList;

public class MemberDaoImpl implements MemberDAO{
    // 메모리 저장소
    private ArrayList<MemberDTO> members;

    // 생성자

    public MemberDaoImpl() {
        this.members = new ArrayList<>();
    }

    @Override
    public void insert(MemberDTO member) {
        members.add(member);
    }

    @Override
    public int findIndexByEmail(String email) {
        for(MemberDTO m : members){
            if(m.getEmail().equals(email))
                return members.indexOf(m);
        }
        return -1;
    }

    @Override
    public MemberDTO selectEmail(int index) {
        return members.get(index);
    }

    @Override
    public ArrayList<MemberDTO> selectAll() {
        return members;
    }

    @Override
    public void update(int index, String name, String mobile) {
        MemberDTO member = members.get(index);
        member.setName(name);
        member.setMobile(mobile);
        // 해당인덱스의 값 수정
        members.set(index,member);

    }

    @Override
    public void delete(int index) {
        members.remove(index);
    }
}

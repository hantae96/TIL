package inheritance04;

import java.util.ArrayList;

public class MemberDaoImpl implements IMemberDAO{
	private ArrayList<MemberDTO> members;
	
	public MemberDaoImpl() {
		members = new ArrayList<>();
	}

	@Override
	public void insert(MemberDTO member) {
		members.add(member);
	}

	@Override
	public int findIndexByEmail(String email) {
		for(MemberDTO m : members) {
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
	public void delete(int index) {
		members.remove(index);
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
		members.set(index, member);
	}
	
}











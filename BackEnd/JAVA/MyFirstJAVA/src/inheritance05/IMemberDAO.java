package inheritance05;

import java.util.ArrayList;

public interface IMemberDAO {
	public void insert(MemberDTO member);
	public int findIndexByEmail(String email);
	public MemberDTO selectEmail(int index);
	public ArrayList<MemberDTO> selectAll();
	public void update(int index, String name, String mobile);
	public void delete(int index);
}

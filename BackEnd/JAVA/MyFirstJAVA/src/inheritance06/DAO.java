package inheritance06;

import java.util.ArrayList;
import java.util.HashMap;

public class DAO {
	private HashMap<String,DTO> members;
	
	public DAO() {
		members = new HashMap<>();
	}
	
	public void insert(DTO dto) {
		members.put(dto.getId(),dto);
	}
	
	public int findIndexById(String id) {
		int index = -1;

		if(members.containsKey(id)) {
			return index;
		}else{
			return index;
		}
	}
	
	public DTO selectId(int index) {
		DTO dto = members.get(index);
		return dto;
	}

	public void remove(int index) {
		members.remove(index);
	}
	
	public ArrayList<DTO> findAll(){
		return members;
	}

	public void updatePassword(int index, DTO dto) {
		members.set(index, dto);
	}
	
}









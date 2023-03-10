package inheritance06;

import java.util.ArrayList;

public class Service {
	private DAO dao;
	
	public Service() {
		dao = new DAO();
	}
	
	public void insert(String id, String pw, String name) {
		int index = dao.findIndexById(id);
		if(index == -1) {
			DTO dto = new DTO();
			dto.setId(id);
			dto.setPassword(pw);
			dto.setName(name);
			dao.insert(dto);
		}else {
			System.out.println("중복된 데이터입니다.");
		}
	}
	
	public void selectId(String id) {
		int index = dao.findIndexById(id);
		if(index != -1) {
			DTO dto = dao.selectId(index);
			System.out.println("아이디 : " + dto.getId());
			System.out.println("비밀번호 : " + dto.getPassword());
			System.out.println("이름 : " + dto.getName());
		}else { 
			System.out.println("미 등록된 데이터 입니다.");
		}
		
		System.out.println();
	}

	public void remove(String id) {
		int index = dao.findIndexById(id);
		if(index != -1) {
			dao.remove(index);
			System.out.println(id + " 계정 정보가 삭제되었습니다.");
		}else {
			System.out.println("미 등록된 데이터 입니다.");
		}
		
		System.out.println();
	}

	public void findAll() {
		ArrayList<DTO> members = dao.findAll();
		if(members.isEmpty()) {
			System.out.println("등록된 데이터가 없습니다.");
			return;
		}
			
		for(DTO dto : members) {
			System.out.println("아이디 : " + dto.getId());
			System.out.println("비밀번호 : " + dto.getPassword());
			System.out.println("이름 : " + dto.getName());
			System.out.println();
		}
	}

	public void updatePassword(String id, String currentPw, String changePw) {
		int index = dao.findIndexById(id);
		
		if(index == -1) {
			System.out.println("미 등록된 데이터 입니다.");
			return;
		}
		
		DTO dto = dao.selectId(index);
		if(dto.getPassword().equals(currentPw) == false) {
			System.out.println("아이디 / 비밀번호를 확인 후 다시 입력하세요.");
			return;
		}
		
		dto.setPassword(changePw);
		dao.updatePassword(index, dto);
		
		System.out.println("비밀번호가 변경되었습니다.");
	}
	
}




















package com.example.jdbcproject.dbConcept04.Service;

import com.example.jdbcproject.dbConcept04.DAO.MemberDAO;
import com.example.jdbcproject.dbConcept04.DTO.MemberDTO;

public class MemberDeleteService {
	
	private MemberDAO memberDao;
	
	public MemberDeleteService(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}
	
	public void checkPassword(String email, String password, String confirmPassword) {
		// 패스워드 확인
		// MemberDAO 객체 내 selectEmail() 메소드를 호출 
		// 저장된 회원 정보와 입력된 회원 정보 검증
		// MemberDAO 객체 내 delete() 호출
		MemberDTO member = memberDao.selectEmail(email);

		if(member.getEmail().equals(email)){
			if(member.getPassword().equals(confirmPassword)){
				memberDao.delete(email);
			}else{
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력하세요");
			}
		}else{
			System.out.println("이메일이 일치하지 않습니다. 다시 입력하세요");
		}
	}
}

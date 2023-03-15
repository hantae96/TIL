package com.example.jdbcproject.dbConcept04.Service;

import com.example.jdbcproject.dbConcept04.DAO.MemberDAO;
import com.example.jdbcproject.dbConcept04.DTO.MemberDTO;

import java.util.Scanner;

public class ChangePasswordService {
	private MemberDAO memberDao;
	
	public ChangePasswordService(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	public void changePassword(String email, String oldPw, String newPw) {
		// 이메일 등록여부 확인.
		// 패스워드 확인 및 MemberDAO.update() 호출

		MemberDTO member = memberDao.selectEmail(email);
		if(member.getEmail().equals(email)){
			if(member.getPassword().equals(oldPw)){
				member.setPassword(newPw);
				memberDao.update(member);
			}else{
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력하세요");
			}
		}else{
			System.out.println("이메일이 일치하지 않습니다. 다시 입력하세요");
		}

	}

}

package com.example.jdbcproject.dbConcept04.Service;

import com.example.jdbcproject.dbConcept04.DAO.MemberDAO;
import com.example.jdbcproject.dbConcept04.DTO.MemberDTO;

import java.util.ArrayList;
import java.util.Collections;


public class MemberAllService {
	private MemberDAO memberDao;
	
	public MemberAllService(MemberDAO memberDao){
		this.memberDao = memberDao;
	}
	
	public void selectAll() {
		// MemberDAO 객체 내부 selectAll() 호출 후 회원 모든 정보 출력
		ArrayList<MemberDTO> members = (ArrayList<MemberDTO>) memberDao.selectAll();

		System.out.println("전체 정보 출력");
		for (MemberDTO member : members) {
			System.out.print("Name = " + member.getName());
			System.out.print("\tEmail = " + member.getEmail());
			System.out.print("\tName = " + member.getPassword());
			System.out.println("\tRegisterDate = " + member.getRegisterDate());

		}
	}

}

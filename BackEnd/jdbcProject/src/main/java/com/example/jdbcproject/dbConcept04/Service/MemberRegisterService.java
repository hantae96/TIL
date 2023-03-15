package com.example.jdbcproject.dbConcept04.Service;

import com.example.jdbcproject.dbConcept04.DAO.MemberDAO;
import com.example.jdbcproject.dbConcept04.DTO.MemberDTO;
import com.example.jdbcproject.dbConcept04.DTO.RegisterRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberRegisterService {
	private MemberDAO memberDao;
	
	public MemberRegisterService(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}
	public void regist(RegisterRequest req) {
		// password == confirmPassword
		// email로 계정 등록 여부 확인
		// memberDao.insert() 계정 등록

		String password = req.getPassword();
		String confirmPassword = req.getConfirmPassword();

		if(!(password.equals(confirmPassword))){
			System.out.println("비밀번호와 확인 비밀번호가 일치하지 않습니다.");
		}else{

			MemberDTO member = new MemberDTO();
			member.setName(req.getName());
			member.setPassword(req.getPassword());
			member.setEmail(req.getEmail());

			// 현재 날짜를 기준으로 등록날짜 생성
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
			member.setRegisterDate(formatter.format(date));
			memberDao.insert(member);
		}
	}

}

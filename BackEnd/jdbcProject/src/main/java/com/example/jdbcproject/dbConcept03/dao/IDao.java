package com.example.jdbcproject.dbConcept03.dao;

import java.util.ArrayList;

import com.example.jdbcproject.dbConcept03.dto.MemberDTO;

public interface IDao {
	public MemberDTO selectId(String id);
	public int insertMember(MemberDTO member);
	public ArrayList<MemberDTO> selectAll();
	public int updateMember(MemberDTO member);
	public int deleteMember(String id);
}

package com.example.jdbcproject.dbConcept04.DAO;

import com.example.jdbcproject.dbConcept04.DTO.MemberDTO;

import java.util.Collection;

public interface IMemberDAO {
	public Collection<MemberDTO> selectAll() ;
	public MemberDTO selectEmail(String email);
	public void insert(MemberDTO member);
	public void update(MemberDTO member);
	public void delete(String email);
}

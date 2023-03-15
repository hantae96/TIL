package com.example.jdbcproject.dbConcept03.service;

public interface IMemberService {
    public void deleteMember(String id, String pw);
    public void updateMember(String id, String pw,String name, String email);
    public void insertMember(String id, String pw,String name, String email);
    public void selectId(String id);
    public void selectAll();
}

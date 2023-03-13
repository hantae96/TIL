package com.example.jdbcproject.service;

public interface MemberDAO {
    public void insert(MemberDTO member);
    public MemberDTO select(String name);
    public void update(String name,int salary,int score);
    public void delete(String name);

    public int findByName(String name);

}

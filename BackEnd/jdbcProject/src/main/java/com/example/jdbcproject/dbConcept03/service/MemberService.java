package com.example.jdbcproject.dbConcept03.service;

import com.example.jdbcproject.dbConcept03.dao.MemberDAO;
import com.example.jdbcproject.dbConcept03.dto.MemberDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberService implements IMemberService{
    Scanner in = new Scanner(System.in);
    MemberDTO member = null;
    MemberDAO memberDao = new MemberDAO();

    @Override
    public void deleteMember(String id, String pw) {
        member = memberDao.selectId(id);
        if(member == null) {
            System.out.println("미등록 정보입니다.");
        }else {
            int result = memberDao.deleteMember(id);
            if(result == 1)
                System.out.println("정보가 삭제되었습니다.");
            else
                System.out.println("정상적으로 처리되지 않습니다. 다시 시도하세요.");
        }
    }

    @Override
    public void updateMember(String id, String pw, String name, String email) {
        member = memberDao.selectId(id);
        if(member == null) {
            System.out.println("미등록 정보입니다.");
        }else {
            System.out.print("비밀번호 : ");pw = in.next();
            System.out.print("이메일 : ");name = in.next();

            member.setPw(pw);
            member.setName(name);

            int result = memberDao.updateMember(member);
            if(result == 1)
                System.out.println("정보가 수정되었습니다.");
            else
                System.out.println("수정이 정상적으로 처리되지 않습니다. 다시 시도하세요.");
        }
    }

    @Override
    public void insertMember(String id, String pw, String name, String email) {

        member = memberDao.selectId(id);
        if(member == null) {
            member = new MemberDTO();
            member.setId(id);
            member.setPw(pw);
            member.setName(name);
            member.setEmail(email);
            memberDao.insertMember(member);
            System.out.println("회원 등록이 되었습니다.");
        }else {
            System.out.println("등록된 정보입니다.");
        }
    }

    @Override
    public void selectId(String id) {
        member = memberDao.selectId(id);
        if(member == null) {
            System.out.println("미등록 정보입니다.");
        }else {
            System.out.println("회원번호 : " + member.getNum());
            System.out.println("이메일 : " + member.getEmail());
            System.out.println("이름 : " + member.getName());
            System.out.println("아이디 : " + member.getId());
            System.out.println("비밀번호 : " + member.getPw());
        }

    }

    @Override
    public void selectAll() {
        ArrayList<MemberDTO> members = memberDao.selectAll();
        if(members.isEmpty() == false) {
            for(MemberDTO m : members) {
                System.out.println("회원번호 : " + m.getNum());
                System.out.println("이메일 : " + m.getEmail());
                System.out.println("이름 : " + m.getName());
                System.out.println("아이디 : " + m.getId());
                System.out.println("비밀번호 : " + m.getPw());
                System.out.println();
            }
        }else {
            System.out.println("등록된 정보가 없습니다.");
        }
        System.out.println();
    }
}

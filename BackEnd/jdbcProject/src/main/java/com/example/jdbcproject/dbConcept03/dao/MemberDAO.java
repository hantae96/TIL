package com.example.jdbcproject.dbConcept03.dao;
import com.example.jdbcproject.dbConcept03.dto.MemberDTO;

import java.sql.*;
import java.util.ArrayList;

public class MemberDAO implements IDao{

    String url = "jdbc:oracle:thin:@localhost:1521/xe";
    String driver = "oracle.jdbc.driver.OracleDriver";
    String userId = "NEWLEC";
    String userPwd = "1234";
    PreparedStatement ps  = null;
    Connection con  = null;


    public MemberDAO(){
        try {
            Class.forName(driver);
             this.con = DriverManager.getConnection(url,userId, userPwd);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public MemberDTO selectId(String id) {
            MemberDTO member = new MemberDTO();
            String sql = "SELECT * FROM member WHERE id=?";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                member.setNum(rs.getInt("num"));
                member.setId(rs.getString("id"));
                member.setPw(rs.getString("password"));
                member.setName(rs.getString("name"));
                member.setEmail(rs.getString("email"));
                return member;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        exit();

        // id를 찾지 못하면 null 로 반환
        return null;
    }

    @Override
    public int insertMember(MemberDTO member) {
        try {

            String sql = "INSERT INTO member VALUES(member_seq.nextval, ?, ?, ?,?)";

            ps.setString(1, member.getId());
            ps.setString(2, member.getPw());
            ps.setString(3, member.getName());
            ps.setString(4,member.getEmail());

            int num =ps.executeUpdate();
            exit();

            if (num == 1) return 1;
            else return 0;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<MemberDTO> selectAll() {
        String sql = "SELECT * FROM member";
        ArrayList<MemberDTO> members = new ArrayList<MemberDTO>();

        try {
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                MemberDTO member = new MemberDTO();
                member.setNum(rs.getInt("num"));
                member.setId(rs.getString("id"));
                member.setPw(rs.getString("password"));
                member.setName(rs.getString("name"));
                member.setEmail(rs.getString("email"));
                members.add(member);
            }
            exit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }

    @Override
    public int updateMember(MemberDTO member) {
        String sql = "UPDATE member SET password = ?, email =?  WHERE id = ?";
        int result = 0;
        try {
            ps.setString(1, member.getPw());
            ps.setString(2,member.getEmail());
            ps.setString(3,member.getId());

            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        exit();


        return result;
    }

    @Override
    public int deleteMember(String id) {
        String sql = "DELETE FROM member WHERE id = ?";
        int result = 0;

        try {
            ps.setString(1, id);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void exit() {
        try {
            if(ps != null)
                ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

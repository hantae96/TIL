package com.example.jdbcproject.dbConcept04.DAO;

import com.example.jdbcproject.dbConcept04.DTO.MemberDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class MemberDAO implements IMemberDAO{

    private String url = "jdbc:oracle:thin:@localhost:1521/xe";
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String userId = "NEWLEC";
    private String userPwd = "1234";

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
    public Collection<MemberDTO> selectAll() {
        String sql = "SELECT * FROM member2";

        ArrayList<MemberDTO> members = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                MemberDTO member = new MemberDTO();
                member.setName(rs.getString("name"));
                member.setPassword(rs.getString("password"));
                member.setEmail(rs.getString("email"));
                member.setRegisterDate(rs.getString("regdate"));
                members.add(member);
            }

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }

    @Override
    public MemberDTO selectEmail(String email) {
        MemberDTO member = new MemberDTO();
        String sql = "SELECT * FROM member2 WHERE email=?";

        try {
            // PreparedStatements는 쿼리마다 새로 생성해야 오류가 안남
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                member.setName(rs.getString("name"));
                member.setPassword(rs.getString("password"));
                member.setEmail(rs.getString("email"));
                member.setRegisterDate(rs.getString("regDate"));
                return member;
            }
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // id를 찾지 못하면 null 로 반환
        return null;
    }

    @Override
    public void insert(MemberDTO member) {
        try {
            String sql = "INSERT INTO member2 VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println(member.getName());
            ps.setString(1, member.getName());
            ps.setString(2, member.getPassword());
            ps.setString(3, member.getEmail());
            ps.setString(4,member.getRegisterDate());

            ps.executeQuery();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(MemberDTO member) {
        int result = 0;
        try {
            String sql = "UPDATE member2 SET password = ?, email =?  WHERE name = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, member.getPassword());
            ps.setString(2,member.getEmail());
            ps.setString(3,member.getName());

            result = ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String email) {
        int result = 0;

        try {
            String sql = "DELETE FROM member2 WHERE email = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            result = ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

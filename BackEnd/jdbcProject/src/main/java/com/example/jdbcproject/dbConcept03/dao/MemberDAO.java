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



//     생성자를 통해서 클래스 드라이버를 불러오면 오류난다..
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
            // PreparedStatements는 쿼리마다 새로 생성해야 오류가 안남
            PreparedStatement ps = con.prepareStatement(sql);

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
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, member.getId());
            ps.setString(2, member.getPw());
            ps.setString(3, member.getName());
            ps.setString(4,member.getEmail());

            int num =ps.executeUpdate();
            exit();

            if (num == 1) return 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<MemberDTO> selectAll() {
        String sql = "SELECT * FROM member";
        ArrayList<MemberDTO> members = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
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

        int result = 0;
        try {
            String sql = "UPDATE member SET password = ?, email =?  WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

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
        int result = 0;

        try {
            String sql = "DELETE FROM member WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        exit();
        return result;
    }

    public void exit() {
        try {
            if(ps != null)
                ps.close();

            // 생성자를 통해서 연결을 닫기 떄문에 다시 부를때 커넥션이 없어서 오류가 나는거임
//            if(con != null)
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

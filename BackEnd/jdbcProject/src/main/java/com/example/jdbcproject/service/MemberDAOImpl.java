package com.example.jdbcproject.service;

import inheritance04.MemberDaoImpl;

import java.sql.*;

class MemberDAOImpl implements MemberDAO{
    String url = "";
    String driver = "";
    String id = "";
    String pwd = "";

    public MemberDAOImpl(){
        this.url = "jdbc:oracle:thin:@localhost:1521/xe";
        this.driver = "oracle.jdbc.driver.OracleDriver";
        this.id = "NEWLEC";
        this.pwd = "1234";
    }

    @Override
    public void insert(MemberDTO member) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            // 클래스에 드라이버 위치를 넣는다.
            Class.forName(driver);
            // DB의 위치 아이디 비번을 DriverManager를 통해 넣고, 객체로 반환하여 사용한다.
            connection = DriverManager.getConnection(url, id, pwd);

            // sql은 퀴리랑 완전히 같은 모양으로 해야된다.
            // 복붙해서 이용하자
            // 변수를 제외한 기본 모양 쿼리를 넣는다.
            String sql = "INSERT INTO tstaff VALUES(?,?,?,?,?,?,?)";
            // 준비된 쿼리를 객체에 넣고 참조변수를 사용한다.
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, member.getName());
            preparedStatement.setString(2, member.getDepart());
            preparedStatement.setString(3,member.getGender());
            preparedStatement.setString(4, member.getJoinDate());
            preparedStatement.setString(5,member.getGrade());
            preparedStatement.setInt(6,member.getSalary());
            preparedStatement.setInt(7,member.getScore());

            int temp = preparedStatement.executeUpdate();
            System.out.println(temp + "건 작업 완료");


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // 열었으면 꼭 닫자!!
        try{
            if(preparedStatement != null) preparedStatement.close();
            if(connection != null) connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public MemberDTO select(String name) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, id, pwd);
            System.out.println(name.toCharArray());
//                String sqlstr = "select * from tstaff where name = "+"'"+name+"'";
//                Statement stmt = connection.createStatement();
//                ResultSet resultSet = stmt.executeQuery(sqlstr);

            String sql = "select * from tstaff where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            MemberDTO memberDTO = new MemberDTO();
            while(resultSet.next()){
                memberDTO.setName(resultSet.getString("NAME"));
                memberDTO.setDepart(resultSet.getString("DEPART"));
                memberDTO.setGender(resultSet.getString("gender"));
                memberDTO.setJoinDate(resultSet.getString("joindate"));
                memberDTO.setGrade(resultSet.getString("grade"));
                memberDTO.setSalary(resultSet.getInt("salary"));
                memberDTO.setScore(resultSet.getInt("score"));
            }

            return memberDTO;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(String name, int salary, int score) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, id, pwd);

            String sql = "update tstaff set score = ?, salary = ? where name = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,score);
            preparedStatement.setInt(2,salary);
            preparedStatement.setString(3,name);

            int temp = preparedStatement.executeUpdate();
            if (temp == 1) System.out.println(temp + "행 업데이트 완료");
            else System.out.println("업데이트 실패");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try{
            if(preparedStatement != null) preparedStatement.close();
            if(connection != null) connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String name) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;

        try {

            // 하나의 디비에만 연결하지 않기 때문에, 다른 드라이버 매니저를 생성하여 접근한다.
            // localhost : 자기 자신의 ip 주소 이기때문에, 자신의 ip 주소를 적어도 똑같이 동작하며, 외부에서 사용할때는 외부의 ip 주소를 적으면 동작한다.
            // 연결
            Class.forName(driver);
            connection = DriverManager.getConnection(url, id, pwd);

            String sql = "DELETE FROM tstaff where name = ?";
            // sql을 우선 connection 객체에 넣는다.
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);

            // 결과셋을 반환함.
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                String NAME = resultSet.getString("NAME");
                String depart = resultSet.getString("DEPART");
                String score = resultSet.getString("SCORE");
                System.out.print("depart = " + depart);
                System.out.print(" name = " + NAME);
                System.out.println(" score = " + score);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if(preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public int findByName(String name) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, id, pwd);
            System.out.println(name.toCharArray());
//                String sqlstr = "select * from tstaff where name = "+"'"+name+"'";
//                Statement stmt = connection.createStatement();
//                ResultSet resultSet = stmt.executeQuery(sqlstr);

            String sql = "select * from tstaff where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            int num = preparedStatement.executeUpdate();
            return num;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

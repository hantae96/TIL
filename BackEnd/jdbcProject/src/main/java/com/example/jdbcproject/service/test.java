package com.example.jdbcproject.service;
import java.sql.*;

public class test {
    public static void main(String[] args) {
        String name = "최한태";
        String url = "jdbc:oracle:thin:@localhost:1521/xe";
        String driver = "oracle.jdbc.driver.OracleDriver";
        String id = "NEWLEC";
        String pwd = "1234";

        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, id, pwd);

            String sql = "select * from member where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println("T");
                System.out.println(resultSet.getString("NAME"));
                System.out.println(resultSet.getString("num"));

            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

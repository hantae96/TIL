import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521/xe";
        String sql = "select * from notice + where hit >= 10;";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(url,"NEWLEC","1234");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while(rs.next()){
            int id = rs.getInt("ID");
            String title = rs.getString("TITLE");
            String writerId = rs.getString("WRITER_ID");
            Date regDate = rs.getDate("REGDATE");
            String content = rs.getString("CONTENT");
            int hit = rs.getInt("hit");

            System.out.printf(String.valueOf(id));

        };


        rs.close();
        st.close();
        con.close();

    }
}
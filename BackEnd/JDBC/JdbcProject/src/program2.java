import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class program2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521/xe";
        String sql = "update notice set TITLE = ?,CONTENT = ?, FILES=? where ID = ?";

        String title = "JAVA 코드를 업데이트";
        String writerId = "iu";
        String content = "내용내용";
        String files = "";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(url,"NEWLEC","1234");
//        Statement st = con.createStatement();
        // 미리 쿼리문을 파라미터로 넣어서 준비해놓고 실행만 시키는 메소드
        PreparedStatement st = con.prepareStatement(sql);
        // paramterIndex 에 ? 에 해당하는 값들은 1부터!! 입력함.
        st.setString(1,title);
        st.setString(2,writerId);
        st.setString(3,content);
        st.setInt(4,17);

        // 실행
        int result = st.executeUpdate();
        System.out.println(result);
//        rs.close();
        st.close();
        con.close();

    }
}

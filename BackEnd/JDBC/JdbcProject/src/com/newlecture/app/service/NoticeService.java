package com.newlecture.app.service;

import com.newlecture.app.entity.Notice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoticeService {
    // 중복 제거를 위해 url 경로는 전역변수의 형태로 따로 뺌
    private String url = "jdbc:oracle:thin:@localhost:1521/xe";
    // 하지만 클래스 드라이버나 연결 같은 경우는 실행할때마다 새로 해줘야함.

    // 중복되는 값에 대해서 변수를 통해 유지보수를 용이하게 함.
    private String uid = "NEWLEC";
    private String pwd = "1234";
    private String driver = "oracle.jdbc.driver.OracleDriver";

    public List<Notice> getList() throws ClassNotFoundException, SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521/xe";
        String sql = "select * from notice + where hit >= 10;";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(url, "NEWLEC", "1234");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        // 리스트 형식으로 만드는 이유는 레코드가 한줄씩 들어오기 떄문이다!!
        List<Notice> list = new ArrayList<Notice>();

        while (rs.next()) {
            int id = rs.getInt("ID");
            String title = rs.getString("TITLE");
            String writerId = rs.getString("WRITER_ID");
            Date regDate = rs.getDate("REGDATE");
            String content = rs.getString("CONTENT");
            int hit = rs.getInt("hit");

            Notice notice = new Notice(
                    id, title, writerId, regDate, content, hit
            );


            list.add(notice);
        }
        rs.close();
        st.close();
        con.close();

        return list;

    }

    public int insert(Notice notice) throws ClassNotFoundException, SQLException {


        String sql = "insert into notice( title,writer_id,content,files)" +
                "values (?,?,?,?)";

        String title = notice.getTitle();
        String writerId = notice.getWriterId();
        String content = notice.getContent();
        String files = notice.getFiles();

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,uid,pwd);
//        Statement st = con.createStatement();
        // 미리 쿼리문을 파라미터로 넣어서 준비해놓고 실행만 시키는 메소드
        PreparedStatement st = con.prepareStatement(sql);
        // paramterIndex 에 ? 에 해당하는 값들은 1부터!! 입력함.
        st.setString(1,title);
        st.setString(2,writerId);
        st.setString(3,content);
        st.setString(4,files);


        // 실행
        int result = st.executeUpdate();
        System.out.println(result);
//        rs.close();
        st.close();
        con.close();

        return 0;
    }
    public int update(Notice notice) throws ClassNotFoundException, SQLException {
        String sql = "update notice set TITLE = ?,CONTENT = ?, FILES=? where ID = ?";

        String title = notice.getTitle();
        String writerId = notice.getWriterId();
        String content = notice.getContent();
        String files = notice.getFiles();
        int id = notice.getId();

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,uid,pwd);
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

        return 0;
    }

    // 삭제할땐 id만 있어도 충분히 가능하기 때문에, id만 전달
    public int delete(int id) throws ClassNotFoundException, SQLException {
        String sql = "delete notice where ID = ? ";

        String title = "JAVA 코드를 업데이트";
        String writerId = "iu";
        String content = "내용내용";
        String files = "";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,uid,pwd);
//        Statement st = con.createStatement();
        // 미리 쿼리문을 파라미터로 넣어서 준비해놓고 실행만 시키는 메소드
        PreparedStatement st = con.prepareStatement(sql);

        // 실행
        int result = st.executeUpdate();
//        rs.close();
        st.close();
        con.close();
        return 0;
    }

}

import java.sql.*;

public class Service {

    private static String url = "jdbc:oracle:thin:@localhost:1521/xe";
    private static String driver = "oracle.jdbc.driver.OracleDriver";
    private static String id = "NEWLEC";
    private static String pwd = "1234";

    PreparedStatement preparedStatement = null;
    Connection connection = null;



    static public void insert(String table){
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
            String sql = "INSERT INTO " + table + " VALUES(?,?,?,?,?,?,?)";
            // 준비된 쿼리를 객체에 넣고 참조변수를 사용한다.
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,"카리나");
            preparedStatement.setString(2,"연예과");
            preparedStatement.setString(3,"여");
            preparedStatement.setString(4,"2023/03/10");
            preparedStatement.setString(5,"사원");
            preparedStatement.setString(6,"700");
            preparedStatement.setString(7,"100");

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

    static public void printAllData(String table) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;

        try {

            // 하나의 디비에만 연결하지 않기 때문에, 다른 드라이버 매니저를 생성하여 접근한다.
            // localhost : 자기 자신의 ip 주소 이기때문에, 자신의 ip 주소를 적어도 똑같이 동작하며, 외부에서 사용할때는 외부의 ip 주소를 적으면 동작한다.
            // 연결
            connection = DriverManager.getConnection(url, id, pwd);

            String sql = "SELECT * FROM " + table;
            // sql을 우선 connection 객체에 넣는다.
            preparedStatement = connection.prepareStatement(sql);

            // 결과셋을 반환함.
            ResultSet resultSet = preparedStatement.executeQuery(sql);

            while(resultSet.next()){
                String name = resultSet.getString("NAME");
                String depart = resultSet.getString("DEPART");
                System.out.print("depart = " + depart);
                System.out.println(" name = " + name);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(preparedStatement != null) preparedStatement.close();
        if(connection != null) connection.close();
    }

    static void update(){
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        //Class 로 오라클 라이브러리 불러옴
        // DriverManager를 통해서 연결
        // 기본 틀 sql 작성
        // connection에 sql 주입

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, id, pwd);

            String sql =

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // DB의 위치 아이디 비번을 DriverManager를 통해 넣고, 객체로 반환하여 사용한다.

        // sql은 퀴리랑 완전히 같은 모양으로 해야된다.
        // 복붙해서 이용하자
        // 변수를 제외한 기본 모양 쿼리를 넣는다.
        String sql = "INSERT INTO " + table + " VALUES(?,?,?,?,?,?,?)";
        // 준비된 쿼리를 객체에 넣고 참조변수를 사용한다.
        preparedStatement = connection.prepareStatement(sql);
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String table = "tStaff";
//        printAllData(table);
        insert(table);
    }
}

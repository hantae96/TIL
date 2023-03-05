package javaExample;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTest {
    public static void main(String[] args) {
        try{
            // IP 주소 대신에 도메인 네임을 사용할려면 InetAddress 클래스사용
            //Socket socket = new Socket(new InetAddress.getByName("domainName", 50001));
            Socket socket = new Socket("localhost", 50001);

            System.out.println("클라이언트 연결 성공");

            socket.close();
            System.out.println("클라이언트 연결 끊음");
            // IP 표기 방법이 잘못됬을경우
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
            // IP와 Port로 서버에 연결할 수 없는 경우
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

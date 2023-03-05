package javaExample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
    public static void main(String[] args) {
        try{
            //
            Socket socket = new Socket("localhost",50001);
            System.out.println("클라이언트 연결 성공");

            String sendMessage = "클라이언트에서 메세지를 보내는 중";
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(sendMessage);
            dos.flush();
            System.out.println("클라이언트에서 데이터 보냄"+sendMessage);

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String receiveMessage = dis.readUTF();
            System.out.println("데이터 받음 + "+receiveMessage);

            socket.close();
            System.out.println("연결 끊음");

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

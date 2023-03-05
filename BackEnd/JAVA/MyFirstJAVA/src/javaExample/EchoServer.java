package javaExample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    private static ServerSocket serverSocket = null;

    public static void main(String[] args) {
        System.out.println("-".repeat(10));
        System.out.println("q입력 서버 종료");
        System.out.println("".repeat(10));

        startServer();

        Scanner sc = new Scanner(System.in);
        while(true){
            String key = sc.nextLine();
            if(key.equals("q")) break;
        }
        sc.close();
        stopServer();
    }

    private static void stopServer() {
        try {
            serverSocket.close();
            System.out.println("서버 종료됨");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void startServer() {

        Thread thread = new Thread(){
            @Override
            public void run(){
                try{
                    // 서버 소켓 생성후 포트 번호 바인딩
                    serverSocket = new ServerSocket(50001);
                    System.out.println("서버 시작됨");

                    while(true){
                        System.out.println("서버 요청 기다림");
                        Socket socket = serverSocket.accept();

                        // 연결한 클라이언트 쪽 소켓 정보를 얻어옴
                        InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                        System.out.println("isa.getHostName() + \"\" = " + isa.getHostName() + "연결 요청을 수락함");

                        // 데이터 받기
                        DataInputStream dis = new DataInputStream(socket.getInputStream());
                        String message = dis.readUTF();

                        //데이터 보내기
                        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                        dos.writeUTF(message);
                        dos.flush();
                        System.out.println("서버에서 받은 데이터를 다시 보냄"+message);

                        socket.close();
                        System.out.println("서버와 연결 끊음");

                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        thread.start();
    }


}

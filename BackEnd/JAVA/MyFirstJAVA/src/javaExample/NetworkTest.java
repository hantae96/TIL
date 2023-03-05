package javaExample;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;
import java.util.TreeMap;

public class NetworkTest {

    private static ServerSocket serverSocket = null;

    public static void main(String[] args) throws UnknownHostException {
//        InetAddress localHost = InetAddress.getLocalHost();
//        System.out.println(localHost);
//
//        InetAddress[] allByName = InetAddress.getAllByName("www.naver.com");
//        for(InetAddress remote : allByName){
//            System.out.println("remote = " + remote);
//        }

        System.out.println("--------------------------------");
        System.out.println("서버 종료 : Q");
        System.out.println("--------------------------------");

        startServer();

        Scanner sc = new Scanner(System.in);
        while(true){
            String key = sc.nextLine();
            if(key.toLowerCase().equals("q")){
                break;
            }
        }
        sc.close();

        stopServer();
    }

    private static void stopServer() {
        try{
            serverSocket.close();
            System.out.println("서버 소켓 종료");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void startServer() {
        Thread thread = new Thread(){
            @Override
            public void run(){
                try{
                    // 서버 소켓 생성 및 Port 번호 바인딩(할당)
                    serverSocket = new ServerSocket(50001);
                    System.out.println("서버 시작");


                    while (true){
                        System.out.println("서버 연결 대기중");
                        // 연결 수락
                        Socket socket = serverSocket.accept();

                        InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                        System.out.println("isa.getHostName() = " + isa.getHostName() + "연결 요청 수락");

                        socket.close();
                        System.out.println("연결 종료");
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        thread.start();
    }


}

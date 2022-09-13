package Ch8;
import java.io.*;
import java.rmi.server.ExportException;

public class Exception {
    public Exception(String 고의로_발생시켰음) {
    }

    public static void main(String [] args){
        try {
            File f = createFile(args[0]);
            System.out.println(f.getName() + "파일이 성공적으로 생성 되었습니다.");
        }catch (java.lang.Exception e){
            System.out.println(e.getMessage() + "다시 입력해주시기 바랍니다.");
        }
    }

    static File createFile(String filename) throws java.lang.Exception{
        if (filename == null || filename.equals(""))
            throw new java.lang.Exception("파일이름이 유효하지 않습니다.");
        File f = new File(filename);
        f.createNewFile();
        return f;
    }


}

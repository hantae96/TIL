class ParcelService {
    String parcel = "";

    ParcelService(){
        this("기본 배송 값");
    }
    ParcelService(String name){
        parcel = name;
    }


    public void total(boolean a,boolean b,boolean c){
        packing(a);
        publish(b);
        send(c);

    }

    public void packing(boolean flag){

        try{
            if (flag) System.out.println("포장" + parcel);
            else throw new Exception();
        }catch (Exception e){
            System.out.println("오류발생");
        }


    }

    public void publish(boolean flag) {

        try{
            if (flag) System.out.println("영수증 발행"+ parcel);
            else throw new Exception();
        }catch (Exception e){
            System.out.println("오류발생");
        }

    }

    public void send(boolean flag) {

        try{
            if (flag) System.out.println("발송" + parcel);
            else throw new Exception();
        }catch (Exception e){
            System.out.println("오류발생");
        }

    }
}


public class Main {
    public static void main(String[] args) {
        ParcelService parcelService = new ParcelService();
        parcelService.total(true,false,true);

    }
}

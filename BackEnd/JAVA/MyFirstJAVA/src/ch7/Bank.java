package ch7;

public interface Bank {
    public int MAX_INTEGER = 1000000;

    abstract public void withDraw(int price);
    void desposit(int price);

    default String findDormacnyAccount(String custId){
        System.out.println("**금융개정법안 00이후 고객의 휴면계좌 찾아주기 운동**");
        System.out.println("**금융결제원에서 제공하는 로직**");
        return "00은행 000-000-0000-00";
    }

    static void BCAuth(String bankName){
        System.out.println(bankName+" 에서 블록체인 인증을 요청합니다.");
        System.out.println("전 금융사 공통 블록체인 로직 수행");
    }
}


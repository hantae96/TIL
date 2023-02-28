package javaExample;

public class KBBank implements Bank{

    @Override
    public void withDraw(int price) {

    }

    @Override
    public void deposit(int price) {

    }

    @Override
    public String findDormancyAccount(String custId){
        System.out.println("**금융개정법안 00이후 고객의 휴면계좌 찾아주기 운동**");
        return "00은행 000-000-0000-00";
    }

}

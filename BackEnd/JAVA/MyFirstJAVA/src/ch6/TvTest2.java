package ch6;

class Tv {
    // Tv의 속성(멤버변수)
    String color;
    boolean power;
    int channel;

    //Tv의 기능(메소드)
    void power() {power = !power;}
    void channelUp() {++channel;}
    void getChanneDown() { --channel;}
}



class TvTest2 {
    public static void main(String args[]){
        // 길이가 3인 ch6.Tv 객체 배열
        Tv [] tvArr = new Tv[3];

        // ch6.Tv 객체를 생성해서  ch6.Tv 객체 배열의 각 요소를 저장
        for (int i = 0; i<tvArr.length;i++){
            tvArr[i] = new Tv();
            tvArr[i].channel = i+10;
        }

        for(int i = 0; i<tvArr.length;i++){
            tvArr[i].channelUp();
            System.out.printf("tvArr[%d].channel = %d\n",i,tvArr[i].channel);
        }
    }
}


class Variables
{
    int iv;
    static int cv;

    void method(){
        int lv = 0;
    }
}
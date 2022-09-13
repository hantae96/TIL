package ch7;

public class InterfaceTest {
    public static void main(String [] args){
        Fighter2 f = new Fighter2();

        if ( f instanceof Unit2)
            System.out.println("f는 Unit2의 자손");

        if (f instanceof Fightable)
            System.out.println("f는 Fightable 구현");

        if (f instanceof Movable)
            System.out.println("f는 Movable 구현");

        if (f instanceof Object)
            System.out.println("f는 Object 자손");
    }
}


class Fighter2 extends Unit2 implements Fightable{
    public void move(int x, int y){}
    public void attack(Unit2 u) {}

}

class Unit2 {
    int currentHP;
    int x;
    int y;
}

interface Fightable extends Movable,Attackable {}
interface Movable { void move(int x,int y);}
interface Attackable {void attack(Unit2 i);}
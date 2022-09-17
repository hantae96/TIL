package ch7;

public class RepairableTest {
    public static void main(String[] args){
        Tank tank = new Tank();
        Dropship dropship = new Dropship();
        Marine marine = new Marine();
        SCV scv =  new SCV();


        scv.repair(tank);
        scv.repair(dropship);
//        scv.repair(marine);
    }
}

interface Repairable {}

class Unit3 {
    int hitPoint;
    final int MAX_HP;
    Unit3(int hp){
        MAX_HP = hp;
    }

}

class GroundUnit extends Unit3 {
    GroundUnit(int hp){
        super(hp);
    }
}

class AirUnit extends Unit3{
    AirUnit(int hp){
        super(hp);
    }
}


class Tank extends GroundUnit implements Repairable {
    Tank(){
        super(150);
        hitPoint = MAX_HP;
    }

    public String toString(){
        return "Tank";
    }
}


class Dropship extends AirUnit implements Repairable {
    Dropship() {
        super(125);
    }
    public String toString(){
        return "Dropship";
    }
}

class Marine extends GroundUnit {
    Marine(){
        super(40);
        hitPoint = MAX_HP;
    }
}

class SCV extends GroundUnit implements Repairable {
    SCV(){
        super(60);
        hitPoint = MAX_HP;
    }

    void repair(Repairable r){
        if (r instanceof Unit3){
            Unit3 u = (Unit3) r;
            while(u.hitPoint != u.MAX_HP){
                u.hitPoint++;
            }
            System.out.println(u.toString() + "수리 끝");
        }
    }
}
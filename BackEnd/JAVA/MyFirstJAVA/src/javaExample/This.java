package javaExample;

class Unit{
    String name;
    String color;
    String area;
    int weight;


    Unit(String name,String color, String area, int weight){
        this.name = name;
        this.color = color;
        this.area = area;
        this.weight = weight;
    }

    Unit getUnitInstacne(){
        return this;
    }
}


public class This {
    public static void main(String[] args) {
        Unit unit = new Unit("SCV","RED","Terran",1000);
        System.out.println(unit.name);
        System.out.println(unit.color);
        System.out.println(unit.area);
        System.out.println(unit.weight);

        Unit unit2 = unit.getUnitInstacne();
        System.out.println(unit == unit2);

        System.out.println(unit2.area);
    }
}

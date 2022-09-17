package ch9;

class Point implements Cloneable {
    int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "x=" + x + ", y = " + y;
    }
}


public class clone {
}

package ch9;

class Value {
    int value;

    Value(int value){
        this.value = value;
    }

    public boolean equals(Object obj){

        if (!(obj instanceof Value)) return false;
        Value v = (Value)obj;

        return this.value == v.value;
    }
}

public class Ex9_4 {
    public static void main(String[] args){
        Value v1 = new Value(10);
        Value v2 = new Value(10);

        if(v1.equals(v2))
            System.out.println("v1 == v2");
        else
            System.out.println("v1 != v2");
    }
}

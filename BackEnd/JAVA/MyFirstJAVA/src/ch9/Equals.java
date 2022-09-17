package ch9;


class Person {
    long id;

    public boolean equals(Object obj){
        if (obj instanceof Person)
            return id == ((Person)obj).id;
        else return false;
    }

    Person (long id){
        this.id = id;
    }
}


class Equals {
    public static void main(String[] args){
        Person p1 = new Person(12312032103L);
        Person p2 = new Person(123414242142L);

        if (p1 == p2)
            System.out.println("p1 == p2");
        else
            System.out.println("p1 != p2");

        if(p1.equals(p2))
            System.out.println("p1 == p2");
        else
            System.out.println("p1 != p2");
    }
}

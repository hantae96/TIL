package ch11;
import java.util.*;


public class Ex11_11 {
    public static void main(String[] args){
        HashSet set = new HashSet();

        set.add("abc");
        set.add("abc");
        set.add(new Person("David",10));
        set.add(new Person("David",10));

        System.out.println(set);
    }
}

// equals()와 hashCode()를 오버라이딩해야 동작
class Person{
    String name;
    int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return name + ":" + age;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name,age);
    }

    @Override
    public boolean equals(Object obj) {
      if(!(obj instanceof Person)) return false;

      Person p = (Person)obj;

      return this.name.equals(p.name) && this.age == p.age;
    }

}

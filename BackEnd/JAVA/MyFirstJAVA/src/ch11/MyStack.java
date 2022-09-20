package ch11;
import java.util.*;

public class MyStack extends Vector{
    public Object push(Object item){
        addElement(item);
        return item;
    }

    public Object pop(){
        Object obj = peek();
        removeElementAt(size()-1);
        return obj;
    }

    public Object peek(){
        int len = size();

        if (len == 0)
            throw new EmptyStackException();
        return elementAt(len - 1);
    }

    public boolean empty(){
        return size() == 0;
    }

    public int search(Object o){
        int i = lastIndexOf(o);

        if(i >=0){
            return size() - i;
        }
        return -1;
    }
}

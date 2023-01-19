package ch11;

import java.util.HashMap;

public class HashMap3 {
    static HashMap phoneBook = new HashMap();
    public static void main(String[] args) {

    }

    static void addPhoneNo(String groupName,String name,String tel){
        addGroup(groupName);
        HashMap group = (HashMap)phoneBook.get(groupName);
        group.put(tel,name);
    }
    static void addGroup(String groupName){
        if(!phoneBook.containsKey(groupName)){
            phoneBook.put(groupName, new HashMap());
        }
    }
    static void addPhoneNo(String name,String tel){
        addPhoneNo("기타",name,tel);
    }
}

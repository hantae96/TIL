package remind.demo.customer;


import java.util.HashMap;

public class Customer {
    private int id;
    private final HashMap<String,Integer> record;
    private String name;
    private Tear tear;

    public Customer(int id,String name,Tear tear){
        this.id = id;
        this.name = name;
        this.tear = tear;
        this.record = new HashMap<>();
        record.put("win",0);
        record.put("lose",0);
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Tear getTear(){
        return tear;
    }

    public void setTear(Tear tear){
        this.tear = tear;
    }

    public HashMap<String,Integer> getRecord(){
        return record;
    }

    public int getRecord(String flag){
        if (flag.equals("win")){
            return record.get("win");
        }else{
            return record.get("lose");
        }
    }

    public void setRecord(String flag, int winCount,int loseCount){
        if (flag.equals("win")){
            record.put("win",winCount);
        }else{
            record.put("lose",loseCount);
        }
    }
}

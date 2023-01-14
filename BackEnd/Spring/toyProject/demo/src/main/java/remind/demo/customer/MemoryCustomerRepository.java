package remind.demo.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MemoryCustomerRepository implements CustomerRepository{
    private final HashMap<Integer,Customer> dataBase = new HashMap<>();

    @Override
    public void save(Customer customer){
        dataBase.put(customer.getId(),customer);
    }
    @Override
    public Customer findById(int customerId){
        return dataBase.get(customerId);
    }

    @Override
    public HashMap<Integer,Customer> getDataBase(){
        return dataBase;
    }
    @Override
    public Customer findByTear(Tear tear){
        int customerId = 0;
        ArrayList<Customer> tearList = new ArrayList<>();
        for(Map.Entry<Integer,Customer> customer : dataBase.entrySet()){
            System.out.println(customer);
            }
        return dataBase.get(customerId);
        }
    }

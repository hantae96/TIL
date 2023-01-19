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
    public void findByTear(Tear tear) {
        for (Map.Entry<Integer, Customer> customer : dataBase.entrySet()) {
            Customer cm = customer.getValue();
            if (cm.getTear() == tear) {
                System.out.println(cm.getName());
            }
        }
    }

    @Override
    public void clearDB(){
        dataBase.clear();
    }
}


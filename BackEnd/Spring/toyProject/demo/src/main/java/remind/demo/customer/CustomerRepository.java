package remind.demo.customer;

import java.util.ArrayList;
import java.util.HashMap;

public interface CustomerRepository {
    void save(Customer customer);
    Customer findById(int customerId);
    void findByTear(Tear tear);
    HashMap getDataBase();
    void clearDB();
}

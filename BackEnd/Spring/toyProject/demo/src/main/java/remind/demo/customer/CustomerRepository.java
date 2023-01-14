package remind.demo.customer;

import java.util.HashMap;

public interface CustomerRepository {
    void save(Customer customer);
    Customer findById(int customerId);
    Customer findByTear(Tear tear);
    HashMap getDataBase();
    void clearDB();
}

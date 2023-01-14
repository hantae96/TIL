package remind.demo.customer;

public interface CustomerService {
    void join(Customer customer);
    Customer findCustomer(int customerId);
}

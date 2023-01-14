package remind.demo.customer;

public interface CustomerService {
    void join(Customer customer) throws Exception;
    Customer findCustomer(int customerId);
}

package remind.demo.customer;

import java.util.HashMap;

public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository = new MemoryCustomerRepository();
    @Override
    public void join(Customer customer){
        int customerId = customer.getId();
        if(check(customer,customerId)){
            customerRepository.save(customer);
        }
    }

    public Customer findCustomer(int customerId){
        return customerRepository.findById(customerId);
    }

    boolean check(Customer customer, int customerId) {
        try {
            if (!customerRepository.getDataBase().containsKey(customerId)) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("중복 발생");
        }
        return false;
    }
}

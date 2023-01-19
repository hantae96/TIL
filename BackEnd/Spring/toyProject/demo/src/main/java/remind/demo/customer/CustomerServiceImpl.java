package remind.demo.customer;

public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository = new MemoryCustomerRepository();
    @Override
    public void join(Customer customer) {
        int customerId = customer.getId();
            if (check(customerId)) {
                customerRepository.save(customer);
            } else {
                System.out.println("중복");
            }
    }

    public Customer findCustomer(int customerId){
        return customerRepository.findById(customerId);
    }

    public void findByTear(Tear tear){
        customerRepository.findByTear(tear);
    }

    boolean check(int customerId){
        return !customerRepository.getDataBase().containsKey(customerId);
    }
}

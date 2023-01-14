package remind.demo;

import remind.demo.customer.Customer;
import remind.demo.customer.CustomerService;
import remind.demo.customer.CustomerServiceImpl;
import remind.demo.customer.Tear;

public class CustomerApp {
    public static void main(String[] args) throws Exception {
        CustomerService customerService = new CustomerServiceImpl();
        Customer customer = new Customer(0,"hantae", Tear.gold);
//        customerService.join(customer);
        customerService.join(customer);


        Customer findCustomer = customerService.findCustomer(0);
        System.out.println("new"+customer.getId());
        System.out.println("find"+findCustomer.getId());

    }
}

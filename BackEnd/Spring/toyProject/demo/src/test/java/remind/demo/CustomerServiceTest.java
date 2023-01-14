package remind.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import remind.demo.customer.*;

public class CustomerServiceTest {

    CustomerService customerService = new CustomerServiceImpl();

    @Test
    void join() throws Exception {
        Customer customer = new Customer(0,"hantae", Tear.Diamond);

        customerService.join(customer);
        Customer findCoustomer = customerService.findCustomer(0);

        Assertions.assertThat(customer).isEqualTo(findCoustomer);
    }
}

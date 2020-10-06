package bo;

import model.Customer;
import model.CustomerUsingService;

import java.util.List;

public interface ICustomerBO {
    List<Customer> selectAllCustomer();

    String insertCustomer(Customer customer);

    Customer selectCustomer(String customerId);

    boolean updateCustomer(Customer customer);

    boolean deleteCustomer(String customerId);

    List<Customer> searchById(String customerId);

    List<CustomerUsingService> selectAllCustomerUsingService();
}

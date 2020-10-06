package bo;

import common.Validate;
import dao.CustomerDAO;
import model.Customer;
import model.CustomerUsingService;

import java.util.List;

public class CustomerBO implements ICustomerBO {
    private CustomerDAO customerDAO = new CustomerDAO();


    @Override
    public List<Customer> selectAllCustomer() {
        return customerDAO.selectAllCustomer();
    }

    @Override
    public String insertCustomer(Customer customer) {
        String message;
        if (!Validate.regexIDCustomer(customer.getCustomerId())){
            message = "format id ....";
        }else if (Validate.regexIDCard(customer.getCustomerIdCard())){
            message = "format id card ....";
        }else if (Validate.regexEmail(customer.getCustomerEmail())){
            message = "format email ....";
        }else  message = this.customerDAO.insertCustomer(customer);

//                customerDAO.insertCustomer(customer);
        return message;
    }

    @Override
    public Customer selectCustomer(String customerId) {
        return customerDAO.selectCustomer(customerId);
    }
    @Override
    public boolean updateCustomer(Customer customer) {
        return customerDAO.updateCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(String customerId) {
        return customerDAO.deleteCustomer(customerId);
    }

    @Override
    public List<Customer> searchById(String customerId) {
        return customerDAO.searchById(customerId);
    }

    @Override
    public List<CustomerUsingService> selectAllCustomerUsingService() {
        return customerDAO.selectAllCustomerUsingService();
    }
}

package dao;

import common.DBConnection;
import model.Customer;
import model.CustomerUsingService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerDAO {
    DBConnection dBConnection = new DBConnection();
    private static final String INSERT_NEW_CUSTOMER = "insert into customer(customer_id, customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address) values (?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_ALL_CUSTOMER = "select*from customer;";
    private static final String SELECT_CUSTOMER_BY_ID = "select*from customer where customer_id = ?;";
    private static final String UPDATE_CUSTOMER = "update customer set customer_type_id = ?, customer_name = ?, customer_birthday = ?, customer_gender = ?, customer_id_card = ?, customer_phone = ?, customer_email = ?, customer_address = ? where customer_id = ?;";
    private static final String DELETE_CUSTOMER = "delete from customer where customer_id = ?;";
    private static final String SELECT_ALL_CUSTOMER_USING_SERVICE = " select customer.customer_id, customer.customer_name, service.service_id, service.service_name, contract.contract_id, attach_service.attach_service_name\n" +
            " from customer\n" +
            " join contract on customer.customer_id = contract.customer_id\n" +
            " join service on service.service_id = contract.service_id\n" +
            " join contract_detail on contract.contract_id = contract_detail.contract_id\n" +
            " join attach_service on attach_service.attach_service_id = contract_detail.attach_service_id;";
    @Override
    public List<Customer> selectAllCustomer() {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Customer> customerList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
                resultSet = statement.executeQuery();
                Customer customer = null;
                while (resultSet.next()) {
                    customer = new Customer();
                    customer.setCustomerId(resultSet.getString("customer_id"));
                    customer.setCustomerTypeId(resultSet.getInt("customer_type_id"));
                    customer.setCustomerName(resultSet.getString("customer_name"));
                    customer.setCustomerBirthday(resultSet.getString("customer_birthday"));
                    customer.setCustomerGender(resultSet.getInt("customer_gender"));
                    customer.setCustomerIdCard(resultSet.getString("customer_id_card"));
                    customer.setCustomerPhone(resultSet.getString("customer_phone"));
                    customer.setCustomerEmail(resultSet.getString("customer_email"));
                    customer.setCustomerAddress(resultSet.getString("customer_address"));
                    customerList.add(customer);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    statement.close();
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dBConnection.close();
            }
        }
        return customerList;
    }

    @Override
    public String insertCustomer(Customer customer) {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_NEW_CUSTOMER);
                statement.setString(1, customer.getCustomerId());
                statement.setInt(2, customer.getCustomerTypeId());
                statement.setString(3, customer.getCustomerName());
                statement.setString(4, customer.getCustomerBirthday());
                statement.setInt(5, customer.getCustomerGender());
                statement.setString(6, customer.getCustomerIdCard());
                statement.setString(7, customer.getCustomerPhone());
                statement.setString(8, customer.getCustomerEmail());
                statement.setString(9, customer.getCustomerAddress());
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                dBConnection.close();
            }
        }
        return "OK";
    }

    @Override
    public Customer selectCustomer(String customerId) {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Customer customer = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
                statement.setString(1, customerId);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    customer = new Customer();
                    customer.setCustomerId(resultSet.getString("customer_id"));
                    customer.setCustomerTypeId(resultSet.getInt("customer_type_id"));
                    customer.setCustomerName(resultSet.getString("customer_name"));
                    customer.setCustomerBirthday(resultSet.getString("customer_birthday"));
                    customer.setCustomerGender(resultSet.getInt("customer_gender"));
                    customer.setCustomerIdCard(resultSet.getString("customer_id_card"));
                    customer.setCustomerPhone(resultSet.getString("customer_phone"));
                    customer.setCustomerEmail(resultSet.getString("customer_email"));
                    customer.setCustomerAddress(resultSet.getString("customer_address"));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                dBConnection.close();
            }
        }
        return customer;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        boolean rowUpdate = false;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(UPDATE_CUSTOMER);
                statement.setInt(1, customer.getCustomerTypeId());
                statement.setString(2, customer.getCustomerName());
                statement.setString(3, customer.getCustomerBirthday());
                statement.setInt(4, customer.getCustomerGender());
                statement.setString(5, customer.getCustomerIdCard());
                statement.setString(6, customer.getCustomerPhone());
                statement.setString(7, customer.getCustomerEmail());
                statement.setString(8, customer.getCustomerAddress());
                statement.setString(9, customer.getCustomerId());
                rowUpdate = statement.executeUpdate() > 0;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                dBConnection.close();
            }
        }
        return rowUpdate;
    }

    @Override
    public boolean deleteCustomer(String customerId) {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        boolean rowDeleted = false;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE_CUSTOMER);
                statement.setString(1, customerId);
                rowDeleted = statement.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowDeleted;
    }

    @Override
    public List<Customer> searchById(String customerId) {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Customer> customerList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
                statement.setString(1, customerId);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Customer customer = new Customer();
                    customer.setCustomerId(resultSet.getString("customer_id"));
                    customer.setCustomerTypeId(resultSet.getInt("customer_type_id"));
                    customer.setCustomerName(resultSet.getString("customer_name"));
                    customer.setCustomerBirthday(resultSet.getString("customer_birthday"));
                    customer.setCustomerGender(resultSet.getInt("customer_gender"));
                    customer.setCustomerIdCard(resultSet.getString("customer_id_card"));
                    customer.setCustomerPhone(resultSet.getString("customer_phone"));
                    customer.setCustomerEmail(resultSet.getString("customer_email"));
                    customer.setCustomerAddress(resultSet.getString("customer_address"));
                    customerList.add(customer);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                dBConnection.close();
            }
        }
        return customerList;
    }

    @Override
    public List<CustomerUsingService> selectAllCustomerUsingService() {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<CustomerUsingService> customerUsingServiceList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_CUSTOMER_USING_SERVICE);
                resultSet = statement.executeQuery();
                CustomerUsingService customerUsingService = null;
                while (resultSet.next()) {
                    customerUsingService = new CustomerUsingService();
                    customerUsingService.setCustomerId(resultSet.getString("customer_id"));
                    customerUsingService.setCustomerName(resultSet.getString("customer_name"));
                    customerUsingService.setServiceId(resultSet.getInt("service_id"));
                    customerUsingService.setServiceName(resultSet.getString("service_name"));
                    customerUsingService.setContractId(resultSet.getInt("contract_id"));
                    customerUsingService.setAttachServiceName(resultSet.getString("attach_service_name"));
                    customerUsingServiceList.add(customerUsingService);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    statement.close();
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dBConnection.close();
            }
        }
        return customerUsingServiceList;
    }
}

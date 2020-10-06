package dao;

import common.DBConnection;
import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements IEmployeeDAO {
    DBConnection dBConnection = new DBConnection();
    private static final String SELECT_ALL_EMPLOYEE = "select*from employee;";
    private static final String INSERT_NEW_EMPLOYEE = "insert into employee(employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, username) values (?,?,?,?,?,?,?,?,?,?,?,?);";
    private static final String DELETE_EMPLOYEE = "delete from employee where employee_id = ?;";
    private static final String UPDATE_EMPLOYEE = "update employee set employee_name = ?, employee_birthday = ?, employee_id_card = ?, employee_salary = ?, employee_phone = ?, employee_email = ?, employee_address = ?, position_id = ?, education_degree_id = ?, division_id = ?, username = ?  where employee_id = ?;";
    private static final String SELECT_EMPLOYEE_BY_ID = "select*from employee where employee_id = ?;";
    @Override
    public List<Employee> selectAllEmployee() {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Employee> employeeList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
                resultSet = statement.executeQuery();
                Employee employee = null;
                while (resultSet.next()) {
                    employee = new Employee();
                    employee.setEmployeeId(resultSet.getInt("employee_id"));
                    employee.setEmployeeName(resultSet.getString("employee_name"));
                    employee.setEmployeeBirthday(resultSet.getString("employee_birthday"));
                    employee.setEmployeeIdCard(resultSet.getString("employee_id_card"));
                    employee.setEmployeeSalary(resultSet.getDouble("employee_salary"));
                    employee.setEmployeePhone(resultSet.getString("employee_phone"));
                    employee.setEmployeeEmail(resultSet.getString("employee_email"));
                    employee.setEmployeeAddress(resultSet.getString("employee_address"));
                    employee.setPositionId(resultSet.getInt("position_id"));
                    employee.setEducationDegreeId(resultSet.getInt("education_degree_id"));
                    employee.setDivisionId(resultSet.getInt("division_id"));
                    employee.setUsername(resultSet.getString("username"));
                    employeeList.add(employee);
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
        return employeeList;
    }

    @Override
    public void insertEmployee(Employee employee) {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_NEW_EMPLOYEE);
                statement.setInt(1, employee.getEmployeeId());
                statement.setString(2, employee.getEmployeeName());
                statement.setString(3, employee.getEmployeeBirthday());
                statement.setString(4, employee.getEmployeeIdCard());
                statement.setDouble(5, employee.getEmployeeSalary());
                statement.setString(6, employee.getEmployeePhone());
                statement.setString(7, employee.getEmployeeEmail());
                statement.setString(8, employee.getEmployeeAddress());
                statement.setInt(9, employee.getPositionId());
                statement.setDouble(10, employee.getEducationDegreeId());
                statement.setInt(11, employee.getDivisionId());
                statement.setString(12, employee.getUsername());
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
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        boolean rowUpdate = false;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(UPDATE_EMPLOYEE);
                statement.setString(1, employee.getEmployeeName());
                statement.setString(2, employee.getEmployeeBirthday());
                statement.setString(3, employee.getEmployeeIdCard());
                statement.setDouble(4, employee.getEmployeeSalary());
                statement.setString(5, employee.getEmployeePhone());
                statement.setString(6, employee.getEmployeeEmail());
                statement.setString(7, employee.getEmployeeAddress());
                statement.setInt(8, employee.getPositionId());
                statement.setDouble(9, employee.getEducationDegreeId());
                statement.setInt(10, employee.getDivisionId());
                statement.setString(11, employee.getUsername());
                statement.setInt(12, employee.getEmployeeId());
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
    public boolean deleteEmployee(int employeeId) {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        boolean rowDeleted = false;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE_EMPLOYEE);
                statement.setInt(1, employeeId);
                rowDeleted = statement.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowDeleted;
    }

    @Override
    public Employee selectEmployee(int employeeId) {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Employee employee = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
                statement.setInt(1, employeeId);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    employee = new Employee();
                    employee.setEmployeeId(resultSet.getInt("employee_id"));
                    employee.setEmployeeName(resultSet.getString("employee_name"));
                    employee.setEmployeeBirthday(resultSet.getString("employee_birthday"));
                    employee.setEmployeeIdCard(resultSet.getString("employee_id_card"));
                    employee.setEmployeeSalary(resultSet.getDouble("employee_salary"));
                    employee.setEmployeePhone(resultSet.getString("employee_phone"));
                    employee.setEmployeeEmail(resultSet.getString("employee_email"));
                    employee.setEmployeeAddress(resultSet.getString("employee_address"));
                    employee.setPositionId(resultSet.getInt("position_id"));
                    employee.setEducationDegreeId(resultSet.getInt("education_degree_id"));
                    employee.setDivisionId(resultSet.getInt("division_id"));
                    employee.setUsername(resultSet.getString("username"));
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
        return employee;
    }

    @Override
    public List<Employee> searchEmpById(int employeeId) {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Employee> employeeList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
                statement.setInt(1, employeeId);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Employee employee = new Employee();
                    employee.setEmployeeId(resultSet.getInt("employee_id"));
                    employee.setEmployeeName(resultSet.getString("employee_name"));
                    employee.setEmployeeBirthday(resultSet.getString("employee_birthday"));
                    employee.setEmployeeIdCard(resultSet.getString("employee_id_card"));
                    employee.setEmployeeSalary(resultSet.getDouble("employee_salary"));
                    employee.setEmployeePhone(resultSet.getString("employee_phone"));
                    employee.setEmployeeEmail(resultSet.getString("employee_email"));
                    employee.setEmployeeAddress(resultSet.getString("employee_address"));
                    employee.setPositionId(resultSet.getInt("position_id"));
                    employee.setEducationDegreeId(resultSet.getInt("education_degree_id"));
                    employee.setDivisionId(resultSet.getInt("division_id"));
                    employee.setUsername(resultSet.getString("username"));
                    employeeList.add(employee);
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
        return employeeList;
    }
}

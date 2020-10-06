package dao;

import model.Employee;

import java.util.List;

public interface IEmployeeDAO {

    List<Employee> selectAllEmployee();

    void insertEmployee(Employee employee);

    boolean updateEmployee(Employee employee);

    boolean deleteEmployee(int employeeId);

    Employee selectEmployee(int employeeId);

    List<Employee> searchEmpById(int employeeId);
}

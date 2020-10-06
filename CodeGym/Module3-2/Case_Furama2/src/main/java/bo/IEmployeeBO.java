package bo;

import model.Employee;

import java.util.List;

public interface IEmployeeBO {
    List<Employee> selectAllEmployee();

    void insertEmployee(Employee employee);

    boolean updateEmployee(Employee employee);

    boolean deleteEmployee(int employeeId);

    Employee selectEmployee(int employeeId);

    List<Employee> searchEmpById(int employeeId);
}

package bo;

import dao.EmployeeDAO;
import model.Employee;

import java.util.List;

public class EmployeeBO implements IEmployeeBO {
    EmployeeDAO employeeDAO = new EmployeeDAO();
    @Override
    public List<Employee> selectAllEmployee() {
        return employeeDAO.selectAllEmployee();
    }

    @Override
    public void insertEmployee(Employee employee) {
        employeeDAO.insertEmployee(employee);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(int employeeId) {
        return employeeDAO.deleteEmployee(employeeId);
    }

    @Override
    public Employee selectEmployee(int employeeId) {
        return employeeDAO.selectEmployee(employeeId);
    }

    @Override
    public List<Employee> searchEmpById(int employeeId) {
        return employeeDAO.searchEmpById(employeeId);
    }
}

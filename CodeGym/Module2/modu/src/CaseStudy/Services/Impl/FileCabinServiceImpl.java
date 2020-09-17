package CaseStudy.Services.Impl;

import CaseStudy.Models.Employee;
import CaseStudy.Services.Interface.FileCabinService;

import java.util.Stack;

public class FileCabinServiceImpl implements FileCabinService {
    private static Stack<Employee> employees;
    static {
        employees=new Stack<>();
        employees.push(new Employee("001","Nguyen Thien",20,"Da Nang"));
        employees.push(new Employee("002","Nguyen Dia",19,"Da Nang"));
        employees.push(new Employee("003","Nguyen Huyen",21,"Da Nang"));
        employees.push(new Employee("004","Nguyen Hoang",18,"Da Nang"));
    }


    @Override
    public Employee findEmployeeById(String id) {
        Stack<Employee> employees1 = employees;
        try {
            while (true){
                Employee employee = employees1.pop();
                if (employee == null){
                    break;
                }
                if (id.equals(employee.getIdEmployee())){
                    return employee;
                }
            }
        }catch (Exception e){
            System.out.println("Input id failed");
        }
        return null;
    }
}

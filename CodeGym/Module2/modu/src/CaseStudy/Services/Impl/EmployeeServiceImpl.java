package CaseStudy.Services.Impl;

import CaseStudy.Models.Employee;
import CaseStudy.Services.Interface.EmployeeService;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EmployeeServiceImpl implements EmployeeService {
    public static Map<String, Employee> employeeMap;
    static {
        employeeMap = new HashMap<>();
        employeeMap.put("001",new Employee("001","Nguyen Thien",20,"Da Nang"));
        employeeMap.put("002",new Employee("002","Nguyen Dia",19,"Da Nang"));
        employeeMap.put("003",new Employee("003","nguyen Huyen",21,"Da Nang"));
        employeeMap.put("004",new Employee("004","Nguyen Hoang",18,"Da Nang"));

    }
    @Override
    public void showInfoEmployee(){
        Set<String> set = employeeMap.keySet();
        for (String key : set){
            System.out.println(key + " " + employeeMap.get(key).getNameEmployee());
        }
    }
}

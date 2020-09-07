package NewCase.Models;

import NewCase.Controllers.MainController;

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Cabinet {
    private static Stack<Employee> stackEmployee = new Stack<>();

    static {
        Map<String, Employee> mapOfEmployees = MainController.readAllEmployees(MainController.EMPLOYEE);


        for (Map.Entry<String, Employee> employeeEntry : mapOfEmployees.entrySet()){
            stackEmployee.push(employeeEntry.getValue());
        }
    }

    private static Employee getFileOfEmployee(String id){
        Employee employee  = null;
        while (!stackEmployee.isEmpty()){
            employee = stackEmployee.pop();

            if (employee.getId().equals(id)){
                return employee;
            }
        }
        return employee;
    }

    public static void findFileOfEmployee(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input employee id to get file: ");
        String id = scanner.nextLine();

        Employee employee = getFileOfEmployee(id);

        if (employee != null){
            System.out.println("File employee: " + employee.toString());
        }else {
            System.out.println("File employee is not found!");
        }
    }
}

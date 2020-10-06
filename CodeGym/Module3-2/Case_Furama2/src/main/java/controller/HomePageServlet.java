package controller;

import bo.*;
import common.Validate;
import model.Contract;
import model.ContractDetail;
import model.Customer;
import model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomePageServlet", urlPatterns = {"", "/HomePage"})
public class HomePageServlet extends HttpServlet {
    CustomerBO customerBO = new CustomerBO();
    ServiceBO serviceBO = new ServiceBO();
    EmployeeBO employeeBO = new EmployeeBO();
    ContractBO contractBO = new ContractBO();
    ContractDetailBO contractDetailBO = new ContractDetailBO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "createCustomer":
                createCustomer(request, response);
                break;
            case "update":
                updateCustomer(request, response);
                break;
            case "createEmployee":
                createEmployee(request, response);
                break;
            case "updateEmployee":
                updateEmployee(request, response);
                break;
            case "createContract":
                createContract(request, response);
                break;
            case "createContractDetail":
                createContractDetail(request, response);
                break;
            default:
                homePage(request, response);
                break;
        }
    }


    private void createContractDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int contractDetailId = Integer.parseInt(request.getParameter("contractDetailId"));
        String contractId = request.getParameter("contractId");
        int attachServiceId = Integer.parseInt(request.getParameter("attachServiceId"));
        int quanlity = Integer.parseInt(request.getParameter("quanlity"));
        ContractDetail contractDetail = new ContractDetail(contractDetailId, contractId, attachServiceId, quanlity);
        contractDetailBO.insertContractDetail(contractDetail);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/contract_detail/create.jsp");
        dispatcher.forward(request, response);
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contractId = request.getParameter("contractId");
        String contractStartDate = request.getParameter("contractStartDate");
        String contractEndDate = request.getParameter("contractEndDate");
        double contractDeposit = Double.parseDouble(request.getParameter("contractDeposit"));
        double contractTotalMoney = Double.parseDouble(request.getParameter("contractTotalMoney"));
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String customerId = request.getParameter("customerId");
        String serviceId = request.getParameter("serviceId");
        Contract contract = new Contract(contractId, contractStartDate, contractEndDate, contractDeposit, contractTotalMoney, employeeId, customerId, serviceId);
        contractBO.insertContract(contract);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/contract/create.jsp");
        dispatcher.forward(request, response);
    }


    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String employeeName = request.getParameter("employeeName");
        String employeeBirthday = request.getParameter("employeeBirthday");
        String employeeIdCard = request.getParameter("employeeIdCard");
        double employeeSalary = Double.parseDouble(request.getParameter("employeeSalary"));
        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeAddress = request.getParameter("employeeAddress");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        String username = request.getParameter("username");
        Employee employee = new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId, username);

            request.setAttribute("Message1", "Input id card is wrong!!!");


            request.setAttribute("Message2", "Input phone number is wrong!!!");


            request.setAttribute("Message3", "Input email is wrong!!!");


            employeeBO.updateEmployee(employee);
            List<Employee> employeeList = employeeBO.selectAllEmployee();
            request.setAttribute("employeeList", employeeList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/employee/list.jsp");
            requestDispatcher.forward(request, response);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/update.jsp");
            dispatcher.forward(request, response);

    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String employeeName = request.getParameter("employeeName");
        String employeeBirthday = request.getParameter("employeeBirthday");
        String employeeIdCard = request.getParameter("employeeIdCard");
        double employeeSalary = Double.parseDouble(request.getParameter("employeeSalary"));
        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeAddress = request.getParameter("employeeAddress");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        String username = request.getParameter("username");
        Employee employee = new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId, username);

            request.setAttribute("Message1", "Input id card is wrong!!!");

            request.setAttribute("Message2", "Input phone number is wrong!!!");

            request.setAttribute("Message3", "Input email number is wrong!!!");

            employeeBO.insertEmployee(employee);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/create.jsp");
        dispatcher.forward(request, response);
    }


    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("customerId");
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        String customerName = request.getParameter("customerName");
        String customerBirthday = request.getParameter("customerBirthday");
        int customerGender = Integer.parseInt(request.getParameter("customerGender"));
        String customerIdCard = request.getParameter("customerIdCard");
        String customerPhone = request.getParameter("customerPhone");
        String customerEmail = request.getParameter("customerEmail");
        String customerAddress = request.getParameter("customerAddress");
        Customer customer = new Customer(customerId, customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);

            request.setAttribute("Message1", "Input id card is wrong!!!");

            request.setAttribute("Message2", "Input phone number is wrong!!!");

            request.setAttribute("Message3", "Input email is wrong!!!");

            customerBO.updateCustomer(customer);
            List<Customer> customerList = customerBO.selectAllCustomer();
            request.setAttribute("customerList", customerList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/list.jsp");
            dispatcher.forward(request, response);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customer/update.jsp");
            requestDispatcher.forward(request, response);

    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("customerId");
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        String customerName = request.getParameter("customerName");
        String customerBirthday = request.getParameter("customerBirthday");
        int customerGender = Integer.parseInt(request.getParameter("customerGender"));
        String customerIdCard = request.getParameter("customerIdCard");
        String customerPhone = request.getParameter("customerPhone");
        String customerEmail = request.getParameter("customerEmail");
        String customerAddress = request.getParameter("customerAddress");
        Customer customer = new Customer(customerId, customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);

        request.setAttribute("Message1", "Input id is wrong!!!");

        request.setAttribute("Message2", "Input id card is wrong!!!");

        request.setAttribute("Message3", "Input phone number is wrong!!!");

        request.setAttribute("Message4", "Input email is wrong!!!");

        String message = customerBO.insertCustomer(customer);
        request.setAttribute("message", message);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/create.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "createCustomer":
                showCustomerFom(request, response);
                break;
            case "listCustomer":
                listCustomer(request, response);
                break;
            case "update":
                showUpdateForm(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "search":
                searchById(request, response);
                break;
            case "createEmployee":
                showEmployeeFom(request, response);
                break;
            case "listEmployee":
                listEmployee(request, response);
                break;
            case "updateEmployee":
                showUpdateEmpForm(request, response);
                break;
            case "deleteEmployee":
                deleteEmployee(request, response);
                break;
            case "searchEmployee":
                searchEmpById(request, response);
                break;
            case "createContract":
                showContractForm(request, response);
                break;
            case "listContract":
                listContract(request, response);
                break;
            case "createContractDetail":
                showContractDetailForm(request, response);
                break;
            case "listContractDetail":
                listContractDetail(request, response);
                break;
            default:
                homePage(request, response);
                break;
        }
    }

    private void showContractForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/contract/create.jsp");
        dispatcher.forward(request, response);
    }

    private void listContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contract> contractList = contractBO.selectAllContract();
        request.setAttribute("contractList", contractList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/contract/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showContractDetailForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/contract_detail/create.jsp");
        dispatcher.forward(request, response);
    }

    private void listContractDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ContractDetail> contractDetailList = contractDetailBO.selectAllContractDetail();
        request.setAttribute("contractDetailList", contractDetailList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/contract_detail/list.jsp");
        dispatcher.forward(request, response);
    }


    private void searchEmpById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        List<Employee> employeeList = employeeBO.searchEmpById(employeeId);
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        employeeBO.deleteEmployee(employeeId);
        List<Employee> employeeList = employeeBO.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showUpdateEmpForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        Employee employee = employeeBO.selectEmployee(employeeId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/update.jsp");
        request.setAttribute("employee", employee);
        dispatcher.forward(request, response);
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeBO.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEmployeeFom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/create.jsp");
        dispatcher.forward(request, response);
    }


    private void searchById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("customerId");
        List<Customer> customerList = customerBO.searchById(customerId);
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("customerId");
        customerBO.deleteCustomer(customerId);
        List<Customer> customerList = customerBO.selectAllCustomer();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("customerId");
        Customer customer = customerBO.selectCustomer(customerId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/update.jsp");
        request.setAttribute("customer", customer);
        dispatcher.forward(request, response);
    }

    private void homePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/furama-resort/home_page.jsp");
        dispatcher.forward(request, response);
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerBO.selectAllCustomer();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCustomerFom(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/create.jsp");
        dispatcher.forward(request, response);
    }
}

package CaseStudy.Services.Impl;

import CaseStudy.Commons.CustomerComparatorName;
import CaseStudy.Commons.FuncValidate;
import CaseStudy.Commons.FuncWriteFileCSV;
import CaseStudy.Models.Customer;
import CaseStudy.Services.Interface.CustomerService;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CustomerServiceImp implements CustomerService {
    public static int id = 1;

    @Override
    public Customer addNewCustomer() {
        Scanner input = new Scanner(System.in);
        Customer customer = new Customer();
        /////Automatic Enter ID
        customer.setID(String.valueOf( id ));
        id++;
        /// Enter Name Customer
        System.out.println("Enter name of customer");
        customer.setCustomerName(input.nextLine());
        while (!FuncValidate.checkNameCustomer(customer.getCustomerName())) {
            System.out.println(" Try Again");
            System.out.println("Enter name of customer");
            customer.setCustomerName(input.nextLine());
        }
        ///Enter Birthday of Customer
        System.out.println("Enter Birthday of customer (dd/mm/yyyy)");
        customer.setBirthdayOfCustomer(input.nextLine());
        while (!FuncValidate.checkBirthday(customer.getBirthdayOfCustomer())) {
            System.out.println("Erro: try again!!!");
            System.out.println("Enter Birthday of customer (dd/mm/yyyy) and Age >18");
            customer.setBirthdayOfCustomer(input.nextLine());
        }
        //Enter Gender
        System.out.println("Enter Gender of customer");
        customer.setGender(input.nextLine());
        while (!FuncValidate.checkGender(customer.getGender())) {
            System.out.println("Gender is inval!!!");
            System.out.println("Enter try Again Gender of customer(Male, Female, Unknow");
            customer.setGender(input.nextLine());
        }
        customer.setGender(FuncValidate.formatGender(customer.getGender()));

        String cmnd;
        do {
            System.out.println("Enter ID of customer");
            cmnd = input.nextLine();
            if (FuncValidate.checkID(cmnd)) break;
            else System.out.println(" Enter ID of customer must has 9 numbers.Format (XXX XXX XXX)");
        } while (true);
        customer.setCustomerId(cmnd);

        // Enter phone number
        System.out.println("Enter phone of customer");
        customer.setCustomerPhone(input.nextLine());
        // Enter Email
        System.out.println("Enter Email of customer");
        input = new Scanner(System.in);
        customer.setCustomerEmail(input.nextLine());
        while (!FuncValidate.checkEmail(customer.getCustomerEmail())) {
            System.out.println(" Email is invalue!!!!!");
            System.out.println("Enter Email of customer (abc@abc.abc(.abc))");
            customer.setCustomerEmail(input.nextLine());
        }
        System.out.println("Enter Type of customer");
        customer.setCustomerType(input.nextLine());
        System.out.println("Enter Address of customer");
        customer.setCustomerAddress(input.nextLine());
        return customer;
    }

    @Override
    public void showInfoCustomer() {
        ArrayList<Customer> listCustomer = FuncWriteFileCSV.getCustomerListFromCSVFile();
        Collections.sort(listCustomer, new CustomerComparatorName());
        for (Customer customer : listCustomer) {
            System.out.println("----------------------");
            System.out.println(customer.ShowInFo());
            System.out.println("----------------------");
        }

    }
}

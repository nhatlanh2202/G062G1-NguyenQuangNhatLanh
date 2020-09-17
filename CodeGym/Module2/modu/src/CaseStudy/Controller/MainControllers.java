package CaseStudy.Controller;

import CaseStudy.Commons.FuncWriteFileCSV;
import CaseStudy.Models.Customer;
import CaseStudy.Models.Employee;
import CaseStudy.Services.Impl.*;
import CaseStudy.Services.Interface.*;


import java.util.ArrayList;
import java.util.Scanner;

public class MainControllers {

   public static void displayMainMenu() {
       CustomerService customerService =new CustomerServiceImp();
       BookingService bookingService=new BookingServiceImpl();
       EmployeeService employeeService =new EmployeeServiceImpl();
       BookingFilm bookingFilm =new BookingFilmImpl();
       FileCabinService fileCabinService =new FileCabinServiceImpl();
        System.out.println("--------MANAGER FURAMA--------\n" +
                "1. Add New Service\n" +
                "2. Show Service\n" +
                "3. Add Customer\n" +
                "4. Show Customer\n" +
                "5. Add New Booking\n" +
                "6. Show Info Employee\n" +
                "7. Add new booking film\n" +
                "8. Show booking\n"+
                "9. Find employee into cabin\n"+
                "10. Exit\n");
       System.out.println("--------------------------");
       System.out.println("Enter Content: ");
        Scanner input = new Scanner(System.in);
        int selection1 = input.nextInt();
        switch (selection1) {
            case 1:
                chooseServiceToAdd();
                backMainMenu();
                break;
            case 2:
                chooseShowInfoService();
                backMainMenu();
                break;
            case 3:
                addNewCustomer();
                backMainMenu();
                break;
            case 4:
                customerService.showInfoCustomer();
                backMainMenu();
                break;
            case 5:
                bookingService.addNewBookingResort();
                backMainMenu();
                break;
            case 6:
                employeeService.showInfoEmployee();
                backMainMenu();
                break;
            case 7:
                bookingFilm.addBookingFilm();
                backMainMenu();
                break;
            case 8:
                bookingFilm.showListBookingFilm();
                backMainMenu();
                break;
            case 9:
                System.out.println("Nhập id nhân viên bạn cần tìm: ");
                Scanner input1 = new Scanner(System.in);
                String id =input1.nextLine();
                Employee employee =fileCabinService.findEmployeeById(id);
                if (employee!=null){
                    System.out.println("Tên nhân viên có id= "+ id+" là: "+ employee.getNameEmployee());
                }else {
                    System.out.println("Tên nhân viên có id= "+ id+" không tồn tại trong hồ sơ");
                }
                backMainMenu();
                break;
            case 10:
                System.exit(0);
            default:
                System.out.println("Enter try Again");
                backMainMenu();

        }
    }

    private static void addNewCustomer() {
        Scanner input = new Scanner(System.in);
        CustomerService customerService =new CustomerServiceImp();
        Customer customer = customerService.addNewCustomer();
        ArrayList<Customer> listCustomer = FuncWriteFileCSV.getCustomerListFromCSVFile();
        listCustomer.add(customer);
        FuncWriteFileCSV.wirteCustomerToCSVFile(listCustomer);
        input.nextLine();
    }

    private static void chooseShowInfoService() {
        System.out.println("1. Show All Villa\n" +
                "2. Show All House\n" +
                "3. Show All Room\n" +
                "4. Show All Name Villa Not Duplicate\n" +
                "5. Show All Name House Not Duplicate\n" +
                "6. Show All Name Room Not Duplicate\n" +
                "7. Back to menu\n" +
                "8. Exit");
        Scanner input = new Scanner(System.in);
        int selection3 = input.nextInt();
        ShowInForServiceImpl showInForServiceImpl =new ShowInForServiceImpl();
        switch (selection3) {
            case 1:
                showInForServiceImpl.showInfoVilla();
                chooseShowInfoService();
                break;
            case 2:
                showInForServiceImpl.showInfoHouse();
                chooseShowInfoService();
                break;
            case 3:
                showInForServiceImpl.showInfoRoom();
                chooseShowInfoService();
                break;
            case 4:
                showInForServiceImpl.showAllNameVillaNotDuplicate();
                chooseShowInfoService();
                break;
            case 5:
                showInForServiceImpl.showAllNameHouseNotDuplicate();
                chooseShowInfoService();
                break;
            case 6:
                showInForServiceImpl.showAllNameRoomNotDuplicate();
                chooseShowInfoService();
                break;
            case 7:
                backMainMenu();
            default:
                System.out.println("Enter try Again");
                backMainMenu();
        }
    }

    private static void backMainMenu() {
        displayMainMenu();
    }

    private static void chooseServiceToAdd() {
        System.out.println("1. Add New Villa\n" +
                "2. Add New House\n" +
                "3. Add New Room\n" +
                "4. Back to menu\n" +
                "5. Exit"
        );
        Scanner input = new Scanner(System.in);
        int selection2 = input.nextInt();
        ServiceServiceImpl serviceServiceImpl =new ServiceServiceImpl();
        switch (selection2) {
            case 1:
                System.out.println("1. New Villa\n");
                serviceServiceImpl.addNewVilla();
                backMainMenu();
                break;
            case 2:
                System.out.println("2. New House\n");
                serviceServiceImpl.addNewHouse();
                backMainMenu();
                break;
            case 3:
                System.out.println("3. New Room\n");
                serviceServiceImpl.addNewRoom();
                backMainMenu();
                break;
            case 4:
                backMainMenu();
            case 5:
                System.exit(0);
            default:
                backMainMenu();
        }
   }
}

package CaseStudy.Services.Impl;

import CaseStudy.Commons.FuncValidate;
import CaseStudy.Commons.FuncWriteFileCSV;
import CaseStudy.Models.House;
import CaseStudy.Models.Room;
import CaseStudy.Models.Services;
import CaseStudy.Models.Villa;
import CaseStudy.Services.Interface.ServiceService;


import java.util.ArrayList;
import java.util.Scanner;

public class ServiceServiceImpl implements ServiceService {

    @Override
    public Services addNewService(Services services) {
        Scanner input = new Scanner(System.in);
        /////Automatic Enter ID
//        services.setiDService(UUID.randomUUID().toString().replace("-", ""));
        input.nextLine();
        System.out.println("Enter Service Id");
        services.setiDService(input.nextLine());
        while (!FuncValidate.checkIdSerice(services.getiDService(), services )){
            System.out.println("Try again");
            services.setiDService(input.nextLine());
        }
        //// Enter Service Name;
        System.out.println("Enter Service Name");
        services.setNameService(input.nextLine());
        while (!FuncValidate.checkNameService(services.getNameService())) {
            System.out.println("Try again");
            System.out.println("Enter Service Name");
            services.setNameService(input.nextLine());
        }
        /////////////Enter Area
        String content = "Enter Area >30";
        String errMess = "Erro: try again";
        services.setArea(FuncValidate.checkValidNumberDouble(content, errMess));
        while (services.getArea() < 30) {
            services.setArea(FuncValidate.checkValidNumberDouble(content, errMess));
        }
        /// Enter rental Cost;
        content = "Enter rental Cost >0 ";
        errMess = "Erro: try again";
        services.setRentCost(FuncValidate.checkValidNumberDouble(content, errMess));
        while (services.getRentCost() < 0) {
            services.setRentCost(FuncValidate.checkValidNumberDouble(content, errMess));
        }
// Enter the limited  number of person;
        content = "Enter number of person ";
        errMess = "Erro: try again";
        services.setPersonLimit(FuncValidate.checkValidNumberInt(content, errMess));
        while (services.getPersonLimit() < 0) {
            services.setPersonLimit(FuncValidate.checkValidNumberInt(content, errMess));
        }
        // Enter rental type;
        System.out.println("Enter Service Type");
        services.setRentType(input.nextLine());
        while (!FuncValidate.checkNameService(services.getRentType())) {
            System.out.println("Try again");
            System.out.println("Enter Service Type");
            services.setRentType(input.nextLine());
        }
        return services;
    }

    @Override
    public void addNewVilla() {
        Scanner input = new Scanner(System.in);
        Services villa = new Villa();
        ServiceServiceImpl serviceServiceImpl =new ServiceServiceImpl();
        serviceServiceImpl.addNewService(villa);
        // Enter room standard
        System.out.println("Enter Room standard");
        ((Villa) villa).setRoomStandard(input.nextLine());
        while (!FuncValidate.checkNameService(((Villa) villa).getRoomStandard())) {
            System.out.println("Try again");
            System.out.println("Enter Room standard");
            ((Villa) villa).setRoomStandard(input.nextLine());
        }
        ///// Enter convenient
        System.out.println("Enter convenient");
        ((Villa) villa).setConvenient(input.nextLine());
        while (!FuncValidate.checkConveninent(((Villa) villa).getConvenient())) {
            System.out.println("Try again");
            System.out.println("Enter convenient (massage)|(karaoke)|(food)|(drink)|(car)");
            ((Villa) villa).setConvenient(input.nextLine());
        }
        ////Enter the number of Floor;
        String content = "Enter number of floor ";
        String errMess = "Erro: try again";
        ((Villa) villa).setFloorNumber(FuncValidate.checkValidNumberInt(content, errMess));
        while (((Villa) villa).getFloorNumber() < 0) {
            ((Villa) villa).setFloorNumber(FuncValidate.checkValidNumberInt(content, errMess));
        }
        // Enter pool area
        content = "Enter Pool Area >30";
        errMess = "Erro: try again";
        ((Villa) villa).setPoolArea(FuncValidate.checkValidNumberDouble(content, errMess));
        while (((Villa) villa).getPoolArea() < 30) {
            ((Villa) villa).setPoolArea(FuncValidate.checkValidNumberDouble(content, errMess));
        }
        ArrayList<Villa> listVillas = FuncWriteFileCSV.getVillaListFromCSVFile();
        listVillas.add((Villa) villa);
        FuncWriteFileCSV.writeVillaToCSVFile(listVillas);

    }

    @Override
    public void addNewHouse() {
        Scanner input = new Scanner(System.in);
        Services house = new House();
        ServiceServiceImpl serviceServiceImpl = new ServiceServiceImpl();
        serviceServiceImpl.addNewService(house);
        // Enter room standard
        System.out.println("Enter Room standard");
        ((House) house).setRoomStandard(input.nextLine());
        while (!FuncValidate.checkNameService(((House) house).getRoomStandard())) {
            System.out.println("Try again");
            System.out.println("Enter Room standard");
            ((House) house).setRoomStandard(input.nextLine());
        }
        ///// Enter convenient
        System.out.println("Enter convenient");
        ((House) house).setConvenient(input.nextLine());
        while (!FuncValidate.checkConveninent(((House) house).getConvenient())) {
            System.out.println("Try again");
            System.out.println("Enter convenient (massage)|(karaoke)|(food)|(drink)|(car)");
            ((House) house).setConvenient(input.nextLine());
        }
        ////Enter the number of Floor;
        String content = "Enter number of floor ";
        String errMess = "Erro: try again";
        ((House) house).setFloorNumber(FuncValidate.checkValidNumberInt(content, errMess));
        while (((House) house).getFloorNumber() < 0) {
            ((House) house).setFloorNumber(FuncValidate.checkValidNumberInt(content, errMess));
        }

        /////Writer CSV House.
        ArrayList<House> listHouse = FuncWriteFileCSV.getHouseListFromCSVFile();
        listHouse.add(((House) house));
        FuncWriteFileCSV.writeHouseToCSVFile(listHouse);
    }

    @Override
    public void addNewRoom() {
        Scanner input = new Scanner(System.in);
        Services room = new Room();
        ServiceServiceImpl serviceServiceImpl = new ServiceServiceImpl();
        serviceServiceImpl.addNewService(room);
        System.out.println("Enter free service:");
        ((Room) room).setFreeServices(input.nextLine());
        while (!FuncValidate.checkNameService(((Room) room).getFreeServices())) {
            System.out.println("Try again");
            System.out.println("Enter free service");
            ((Room) room).setFreeServices(input.nextLine());
        }
        /// Writer CSV file Room.csv
        ArrayList<Room> listRoom = FuncWriteFileCSV.getRoomListFromCSVFile();
        listRoom.add(((Room) room));
        FuncWriteFileCSV.writeRoomToCSVFile(listRoom);
    }
}

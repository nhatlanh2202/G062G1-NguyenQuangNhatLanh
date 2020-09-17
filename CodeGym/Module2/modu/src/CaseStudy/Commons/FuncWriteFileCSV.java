package CaseStudy.Commons;


import CaseStudy.Models.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public class FuncWriteFileCSV {
    private static final String SEPRATOR =",";
    private static final String ENTER_LINE ="\n";
    private static final String HEADER_VILLA = "iDService,nameService,area,rentCost,personLimit,rentType,roomStandard,convenient,floorNumber,poolArea";
    private static final String FILE_VILLA = "D:\\C062G1-Nguyen_Quang_Nhat_Lanh\\CodeGym\\Module2\\modu\\src\\CaseStudy\\Data\\Villa.csv";
    private static final String FILE_HOUSE = "D:\\C062G1-Nguyen_Quang_Nhat_Lanh\\CodeGym\\Module2\\modu\\src\\CaseStudy\\Data\\House.csv";
    private static final String HEADER_HOUSE = "iDService,nameService,area,rentCost,personLimit,rentType,roomStandard,convenient,floorNumber";
    private static final String HEADER_ROOM ="iDService,nameService,area,rentCost,personLimit,rentType,freeServices";
    private static final String FILE_ROOM ="D:\\C062G1-Nguyen_Quang_Nhat_Lanh\\CodeGym\\Module2\\modu\\src\\CaseStudy\\Data\\Room.csv";
    private static final String HEADER_CUSTOMER ="iD,customerName,birthdayOfCustomer,gender,customerId,customerPhone,customerEmail,customerType,customerAddress";
    private static final String FILE_CUSTOMER ="D:\\C062G1-Nguyen_Quang_Nhat_Lanh\\CodeGym\\Module2\\modu\\src\\CaseStudy\\Data\\Customer.csv";
    private static final String HEADER_BOOKING_CUSTOMER ="iD,customerName,birthdayOfCustomer,gender,customerId,customerPhone,customerEmail,customerType,customerAddress,iDService,nameService,area,rentCost,personLimit,rentType";
    private static final String FILE_BOOKING_CUSTOMER ="D:\\C062G1-Nguyen_Quang_Nhat_Lanh\\CodeGym\\Module2\\modu\\src\\CaseStudy\\Data\\Booking.csv";


    public static void writeVillaToCSVFile(ArrayList<Villa> listVilla){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(FILE_VILLA);
            fileWriter.append(HEADER_VILLA);
            for (Villa villa : listVilla){
                fileWriter.append(ENTER_LINE);
                fileWriter.append(villa.getiDService());
                fileWriter.append(SEPRATOR);
                fileWriter.append(villa.getNameService());
                fileWriter.append(SEPRATOR);
                fileWriter.append(String.valueOf(villa.getArea()));
                fileWriter.append(SEPRATOR);
                fileWriter.append(String.valueOf(villa.getRentCost()));
                fileWriter.append(SEPRATOR);
                fileWriter.append(String.valueOf(villa.getPersonLimit()));
                fileWriter.append(SEPRATOR);
                fileWriter.append(villa.getRentType());
                fileWriter.append(SEPRATOR);
                fileWriter.append(villa.getRoomStandard());
                fileWriter.append(SEPRATOR);
                fileWriter.append(villa.getConvenient());
                fileWriter.append(SEPRATOR);
                fileWriter.append(String.valueOf(villa.getFloorNumber()) );
                fileWriter.append(SEPRATOR);
                fileWriter.append(String.valueOf(villa.getPoolArea()) );
            }
        } catch (IOException e) {
            System.out.println("error write CSV File!!!");
        }finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            }catch (IOException e) {
                System.out.println("error to CSV");
            }
        }
    }

    public static void writeHouseToCSVFile(ArrayList<House> listHouse) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(FILE_HOUSE);
            fileWriter.append(HEADER_HOUSE);
            fileWriter.append(ENTER_LINE);
            for (House house : listHouse) {
                fileWriter.append(house.getiDService());
                fileWriter.append(SEPRATOR);
                fileWriter.append(house.getNameService());
                fileWriter.append(SEPRATOR);
                fileWriter.append(String.valueOf(house.getArea()));
                fileWriter.append(SEPRATOR);
                fileWriter.append(String.valueOf(house.getRentCost()));
                fileWriter.append(SEPRATOR);
                fileWriter.append(String.valueOf(house.getPersonLimit()));
                fileWriter.append(SEPRATOR);
                fileWriter.append(house.getRentType());
                fileWriter.append(SEPRATOR);
                fileWriter.append(house.getRoomStandard());
                fileWriter.append(SEPRATOR);
                fileWriter.append(house.getConvenient());
                fileWriter.append(SEPRATOR);
                fileWriter.append(String.valueOf(house.getFloorNumber()) );
                fileWriter.append(SEPRATOR);
                fileWriter.append(ENTER_LINE);
            }
        } catch (IOException e) {
            System.out.println(" erross wirte CSV File!!!!!!!!!!!");
        }finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            }catch (Exception e){
                System.out.println("err to csv");
            }
        }
    }

    public static void writeRoomToCSVFile(ArrayList<Room> listRoom){
        FileWriter fileWriter=null;
        try {
            fileWriter =new FileWriter(FILE_ROOM);
            fileWriter.append(HEADER_ROOM);
            for (Room room: listRoom){
                fileWriter.append(ENTER_LINE);
                fileWriter.append(room.getiDService());
                fileWriter.append(SEPRATOR);
                fileWriter.append(room.getNameService());
                fileWriter.append(SEPRATOR);
                fileWriter.append(String.valueOf(room.getArea()));
                fileWriter.append(SEPRATOR);
                fileWriter.append(String.valueOf(room.getRentCost()));
                fileWriter.append(SEPRATOR);
                fileWriter.append(String.valueOf(room.getPersonLimit()));
                fileWriter.append(SEPRATOR);
                fileWriter.append(room.getRentType());
                fileWriter.append(SEPRATOR);
                fileWriter.append(room.getFreeServices());
            }
        }catch (Exception e){
            System.out.println(" erross wirte CSV File!!!!!!!!!!!");
        }
        finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            }catch (Exception e){
                System.out.println("err to csv");
            }
        }
    }
    public static TreeSet<String> getServiceListFromCSVFile(String path){
        TreeSet<String> serviceNameList=new TreeSet<>();
        BufferedReader br;
        String line;
        try {

            br =new BufferedReader(new FileReader(path));
            while ((line=br.readLine())!=null){
                String[] splitData =line.split(",");
                if (splitData[0].equals("iDService")){
                    continue;
                }
                serviceNameList.add(splitData[1]);
            }
        }catch (Exception ex){
            System.out.println("Read file CSV erross!!!!!!!!!!!!!!!!!!!!!");
        }finally {
            try {

            }catch (Exception ex){
                System.out.println("erro");
            }
        }
        return serviceNameList;
    }


    public static ArrayList<Villa> getVillaListFromCSVFile(){
        ArrayList<Villa> listVilla=new ArrayList<>();
        BufferedReader br;
        String line;
        try {
            br =new BufferedReader(new FileReader(FILE_VILLA));
            while ((line=br.readLine())!=null){
                Villa villa =new Villa();
                String[] splitData =line.split(",");
                if (splitData[0].equals("iDService")){
                    continue;
                }
                villa.setiDService(splitData[0]);
                villa.setNameService(splitData[1]);
                villa.setArea(Double.parseDouble(splitData[2]));
                villa.setRentCost(Double.parseDouble(splitData[3]));
                villa.setPersonLimit(Integer.parseInt(splitData[4]));
                villa.setRentType(splitData[5]);
                villa.setRoomStandard(splitData[6]);
                villa.setConvenient(splitData[7]);
                villa.setFloorNumber(Integer.parseInt(splitData[8]));
                villa.setPoolArea(Double.parseDouble(splitData[9]));

                listVilla.add(villa);
            }
        }catch (Exception ex){
            System.out.println("Read file CSV erross!!!!!!!!!!!!!!!!!!!!!");
        }finally {
            try {

            }catch (Exception ex){
                System.out.println("erro");
            }
        }
        return listVilla;
    }

    public static ArrayList<House> getHouseListFromCSVFile(){
        ArrayList<House> listHouse=new ArrayList<>();
        BufferedReader br;
        String line;
        try {
            br =new BufferedReader(new FileReader(FILE_HOUSE));
            while ((line=br.readLine())!=null){
                House house =new House();
                String[] splitData =line.split(",");
                if (splitData[0].equals("iDService")){
                    continue;
                }
                house.setiDService(splitData[0]);
                house.setNameService(splitData[1]);
                house.setArea(Double.parseDouble(splitData[2]));
                house.setRentCost(Double.parseDouble(splitData[3]));
                house.setPersonLimit(Integer.parseInt(splitData[4]));
                house.setRentType(splitData[5]);
                house.setRoomStandard(splitData[6]);
                house.setConvenient(splitData[7]);
                house.setFloorNumber(Integer.parseInt(splitData[8]));


                listHouse.add(house);
            }
        }catch (Exception ex){
            System.out.println("Read file CSV erross!!!!!!!!!!!!!!!!!!!!!");
        }finally {
            try {

            }catch (Exception ex){
                System.out.println("erro");
            }
        }
        return listHouse;
    }

    public static ArrayList<Room> getRoomListFromCSVFile(){
        ArrayList<Room> listRoom=new ArrayList<>();
        BufferedReader br;
        String line;
        try {
            br =new BufferedReader(new FileReader(FILE_ROOM));
            while ((line=br.readLine())!=null){
                Room room =new Room();
                String[] splitData =line.split(",");
                if (splitData[0].equals("iDService")){
                    continue;
                }
                room.setiDService(splitData[0]);
                room.setNameService(splitData[1]);
                room.setArea(Double.parseDouble(splitData[2]));
                room.setRentCost(Double.parseDouble(splitData[3]));
                room.setPersonLimit(Integer.parseInt(splitData[4]));
                room.setRentType(splitData[5]);
                room.setFreeServices(splitData[6]);
                listRoom.add(room);
            }
        }catch (Exception ex){
            System.out.println("Read file CSV erross!!!!!!!!!!!!!!!!!!!!!");
        }finally {
            try {

            }catch (Exception ex){
                System.out.println("erro");
            }
        }
        return listRoom;
    }

    public static void wirteCustomerToCSVFile(ArrayList<Customer> listCustomer){
        FileWriter fileWriter=null;
        try {
            fileWriter =new FileWriter(FILE_CUSTOMER);
            fileWriter.append(HEADER_CUSTOMER);
            for (Customer customer: listCustomer){
                fileWriter.append(ENTER_LINE);
                fileWriter.append(customer.getID());
                fileWriter.append(SEPRATOR);
                fileWriter.append(customer.getCustomerName());
                fileWriter.append(SEPRATOR);
                fileWriter.append(customer.getBirthdayOfCustomer());
                fileWriter.append(SEPRATOR);
                fileWriter.append(customer.getGender());
                fileWriter.append(SEPRATOR);
                fileWriter.append(customer.getCustomerId());
                fileWriter.append(SEPRATOR);
                fileWriter.append(customer.getCustomerPhone());
                fileWriter.append(SEPRATOR);
                fileWriter.append(customer.getCustomerEmail());
                fileWriter.append(SEPRATOR);
                fileWriter.append(customer.getCustomerType());
                fileWriter.append(SEPRATOR);
                fileWriter.append(customer.getCustomerAddress());

            }
        }catch (Exception e){
            System.out.println(" erross wirte CSV File!!!!!!!!!!!");
        }
        finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            }catch (Exception e){
                System.out.println("err to csv");
            }
        }
    }


    public static ArrayList<Customer> getCustomerListFromCSVFile(){
        ArrayList<Customer> listCustomer=new ArrayList<>();
        BufferedReader br;
        String line;
        try {
            br =new BufferedReader(new FileReader(FILE_CUSTOMER));
            while ((line=br.readLine())!=null){
                Customer customer =new Customer();
                String[] splitData =line.split(",");
                if (splitData[0].equals("iD")){
                    continue;
                }
                customer.setID(splitData[0]);
                customer.setCustomerName(splitData[1]);
//                "iD,customerName,birthdayOfCustomer,gender,customerId,customerPhone,customerEmail,customerType,customerAddress";
                customer.setBirthdayOfCustomer(splitData[2]);
                customer.setGender(splitData[3]);
                customer.setCustomerId(splitData[4]);
                customer.setCustomerPhone(splitData[5]);
                customer.setCustomerEmail(splitData[6]);
                customer.setCustomerType(splitData[7]);
                customer.setCustomerAddress(splitData[8]);
                listCustomer.add(customer);
            }
        }catch (Exception ex){
            System.out.println("Read file CSV erross!!!!!!!!!!!!!!!!!!!!!");
        }finally {
            try {

            }catch (Exception ex){
                System.out.println("erro");
            }
        }
        return listCustomer;
    }


    public static void writeBookingToCSVFile(ArrayList<Customer> listCustomer){
        FileWriter fileWriter=null;
        try {
            fileWriter =new FileWriter(FILE_BOOKING_CUSTOMER);
            fileWriter.append(HEADER_BOOKING_CUSTOMER);
            for (Customer customer: listCustomer){

//               iD,customerName,birthdayOfCustomer,gender,customerId,customerPhone,customerEmail,customerType,customerAddress,
//
                fileWriter.append(ENTER_LINE);
                fileWriter.append(customer.getID());
                fileWriter.append(SEPRATOR);
                fileWriter.append(customer.getCustomerName());
                fileWriter.append(SEPRATOR);
                fileWriter.append(customer.getBirthdayOfCustomer());
                fileWriter.append(SEPRATOR);
                fileWriter.append(customer.getGender());
                fileWriter.append(SEPRATOR);
                fileWriter.append(customer.getCustomerId());
                fileWriter.append(SEPRATOR);
                fileWriter.append(customer.getCustomerPhone());
                fileWriter.append(SEPRATOR);
                fileWriter.append(customer.getCustomerEmail());
                fileWriter.append(SEPRATOR);
                fileWriter.append(customer.getCustomerType());
                fileWriter.append(SEPRATOR);
                fileWriter.append(customer.getCustomerAddress());
//                iDService,nameService,area,rentCost,personLimit,rentType"
                fileWriter.append(SEPRATOR);
                fileWriter.append(customer.getCustomerUseServieceType().getiDService());
                fileWriter.append(SEPRATOR);
                fileWriter.append(customer.getCustomerUseServieceType().getNameService());
                fileWriter.append(SEPRATOR);
                fileWriter.append(String.valueOf(customer.getCustomerUseServieceType().getArea()));
                fileWriter.append(SEPRATOR);
                fileWriter.append(String.valueOf(customer.getCustomerUseServieceType().getRentCost()));
                fileWriter.append(SEPRATOR);
                fileWriter.append(String.valueOf(customer.getCustomerUseServieceType().getPersonLimit()));
                fileWriter.append(SEPRATOR);
                fileWriter.append(customer.getCustomerUseServieceType().getRentType());

            }
        }catch (Exception e){
            System.out.println(" erross wirte CSV File!!!!!!!!!!!");
        }
        finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            }catch (Exception e){
                System.out.println("err to csv");
            }
        }
    }

    public static ArrayList<Customer> getBookingCustomerListFromCSVFile(){
        ArrayList<Customer> listCustomer=new ArrayList<>();
        BufferedReader br;
        String line;
        try {
            br =new BufferedReader(new FileReader(FILE_BOOKING_CUSTOMER));
            while ((line=br.readLine())!=null){
                Customer customer =new Customer();
                String[] splitData =line.split(",");
                if (splitData[0].equals("iD")){
                    continue;
                }
                customer.setID(splitData[0]);
                customer.setCustomerName(splitData[1]);
//                "iD,customerName,birthdayOfCustomer,gender,customerId,customerPhone,customerEmail,customerType,customerAddress";
                customer.setBirthdayOfCustomer(splitData[2]);
                customer.setGender(splitData[3]);
                customer.setCustomerId(splitData[4]);
                customer.setCustomerPhone(splitData[5]);
                customer.setCustomerEmail(splitData[6]);
                customer.setCustomerType(splitData[7]);
                customer.setCustomerAddress(splitData[8]);
/// trả về service : iDService,nameService,area,rentCost,personLimit,rentType"
                Services villa =new Villa();
                villa.setiDService(splitData[9]);
                villa.setNameService(splitData[10]);
                villa.setArea(Double.parseDouble(splitData[11]));
                villa.setRentCost(Double.parseDouble(splitData[12]));
                villa.setPersonLimit(Integer.parseInt(splitData[13]));
                villa.setRentType(splitData[14]);
                customer.setCustomerUseServieceType(villa);
                listCustomer.add(customer);
            }
        }catch (Exception ex){
            System.out.println("Read file CSV erross!!!!!!!!!!!!!!!!!!!!!");
        }finally {
            try {

            }catch (Exception ex){
                System.out.println("erro");
            }
        }
        return listCustomer;
    }

}

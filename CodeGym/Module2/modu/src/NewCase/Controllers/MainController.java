package NewCase.Controllers;

import NewCase.Commons.ConvertUtils;
import NewCase.Commons.FileUtils;
import NewCase.Commons.StringUtils;
import NewCase.Commons.Validators;
import NewCase.Exceptions.*;
import NewCase.Models.*;

import java.util.*;

public class MainController {
    private static Scanner scanner = new Scanner( System.in );
    private static String VILLA = "villa";
    private static String HOUSE = "house";
    private static String ROOM = "room";
    private static String CUSTOMER = "customer";
    private static String BOOKING = "booking";
    public static String EMPLOYEE = "employee";
    private static boolean isExit;
    private static boolean isBackToMenu;


    public static void main(String[] args) {
        MainController.displayMainMenu();
    }


    public static void displayMainMenu() {
        int choose = 0;
        do {
            System.out.println( "1.\tAdd New Services\n" +
                    "2.\tShow Services\n" +
                    "3.\tAdd New Customer\n" +
                    "4.\tShow Information of Customer\n" +
                    "5.\tAdd New Booking\n" +
                    "6.\tShow Information of Employee\n" +
                    "7.\tExit\n" +
                    "8.\tShow Queue of Customer\n" +
                    "9.\tFind file of employee\n");
            System.out.println( "Your choose: " );
            choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    addNewServices();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                    addNewCustomer(CUSTOMER);
                    break;
                case 4:
                    showInformationOfCustomer(CUSTOMER);
                    break;
                case 5:
                    addNewBooking();
                    break;
                case 6:
                    showInformationOfEmployee();
                    break;
                case 7:
                    isExit = true;
                    break;
                case 8:
                    showQueueOfCustomers();
                    break;
                case 9:
                    Cabinet.findFileOfEmployee();
                    break;
            }
            if (isExit){
                break;
            }
        } while (choose >= 1 && choose <= 9);
    }

    private static void showQueueOfCustomers() {
        Queue<Customer> queueCustomer = new LinkedList<>();
        List<Customer> listOfCustomers = readAllCustomer(CUSTOMER);
        showInformationOfCustomer(CUSTOMER);
        queueCustomer.add(listOfCustomers.get(3));
        queueCustomer.add(listOfCustomers.get(4));
        queueCustomer.add(listOfCustomers.get(1));

        Customer customer = null;
        System.out.println("--------------------------");
        System.out.println("List customer who buy ticket: ");
        while (!queueCustomer.isEmpty()){
            customer = queueCustomer.poll();
            customer.showInfo();
        }
    }

    private static void addNewServices() {
        int choose = 0;
        do {
            System.out.println( "1.\tAdd New Villa\n" +
                    "2.\tAdd New House\n" +
                    "3.\tAdd New Room\n" +
                    "4.\tBack to menu\n" +
                    "5.\tExit\n" );
            System.out.println( "Your choose to add: " );
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    addNewService(VILLA);
                    isBackToMenu = false;
                    break;
                case 2:
                    addNewService(HOUSE);
                    isBackToMenu = false;
                    break;
                case 3:
                    addNewService(ROOM);
                    isBackToMenu = false;
                    break;
                case 4:
                    isBackToMenu = true;
                    break;
                case 5:
                    isExit = true;
                    break;
            }
            if (isBackToMenu || isExit){
                return;
            }
        }while (choose >= 1 && choose <= 5);
    }

    private static void addNewService(String fileName) {
        scanner.nextLine();
        String id = null;
        do {
            System.out.println("Input id service: ");
            id = scanner.nextLine();
        }while (!Validators.isValidRegex(id, Validators.SERVICE_CODE_REGEX));

        String serviceName = null;
        do {
            System.out.println("Input name service: ");
            serviceName = scanner.nextLine();
        }while (!Validators.isValidRegex(serviceName, Validators.SERVICE_NAME_REGEX));

        double areaUse = 0;
        do {
            System.out.println("Input area use: ");
            areaUse = scanner.nextDouble();
        }while (!Validators.isMoreThan(areaUse, 30));


        double rentCost = 0;
        do {
            System.out.println("Input rent cost: ");
            rentCost = scanner.nextDouble();
        }while (!Validators.isMoreThan(rentCost, 0));


        int numberOfPeoples = 0;
        do {
            System.out.println("Input number of people: ");
            numberOfPeoples = scanner.nextInt();
        }while (!Validators.isMoreThan(numberOfPeoples,0, 20));


        scanner.nextLine();
        String typeRent = null;
        do {
            System.out.println("Input type rent: ");
            typeRent = scanner.nextLine();
        }while (!Validators.isValidRegex(typeRent, Validators.SERVICE_NAME_REGEX));

        FileUtils.setFullPathFile(fileName);


        if (fileName.equals(VILLA)){

            String standardRoom = null;
            do {
                System.out.println("Input standard room: ");
                standardRoom = scanner.nextLine();
            }while (!Validators.isValidRegex(standardRoom, Validators.SERVICE_NAME_REGEX));


            System.out.println("Input other description: ");
            String otherDescription = scanner.nextLine();

            double areaPool = 0;
            do {
                System.out.println("Input area pool: ");
                areaPool = scanner.nextDouble();
            }while (!Validators.isMoreThan(areaPool, 30));


            int numberOfFFloors = 0;
            do {
                System.out.println("Input number of floors: ");
                numberOfFFloors = scanner.nextInt();

            }while (!Validators.isMoreThan(numberOfFFloors,0));


            FileUtils.writeFile(new String[]{id,serviceName, String.valueOf( areaUse ), String.valueOf( rentCost ),
                    String.valueOf( numberOfPeoples ),typeRent,standardRoom, otherDescription,
                    String.valueOf( areaPool ), String.valueOf( numberOfFFloors )});


        }else if (fileName.equals(HOUSE)){
            System.out.println("Input standard room: ");
            String standardRoom = scanner.nextLine();

            System.out.println("Input other description: ");
            String otherDescription = scanner.nextLine();

            int numberOfFFloors = 0;
            do {
                System.out.println("Input number of floors: ");
                numberOfFFloors = scanner.nextInt();

            }while (!Validators.isMoreThan(numberOfFFloors,0));

            FileUtils.writeFile(new String[]{id,serviceName, String.valueOf( areaUse ), String.valueOf( rentCost ),
                    String.valueOf( numberOfPeoples ),typeRent,standardRoom, otherDescription, String.valueOf( numberOfFFloors )});


        }else if (fileName.equals(ROOM)){
            String extraService = null;
            do {
                System.out.println("Input extra service name: ");
                extraService = scanner.nextLine();
            }while (!Validators.isValidExtraServiceName(extraService));


            System.out.println("Input unit: ");
            String unit = scanner.nextLine();

            System.out.println("Input money: ");
            double money = scanner.nextDouble();
            FileUtils.writeFile(new String[]{id,serviceName, String.valueOf( areaUse ), String.valueOf( rentCost ),
                    String.valueOf( numberOfPeoples ),typeRent,extraService,unit, String.valueOf( money )});
        }
    }


    private static void showServices() {
        int choose = 0;
        do {
            System.out.println("1.\tShow all Villa\n" +
                    "2.\tShow all House\n" +
                    "3.\tShow all Room\n" +
                    "4.\tShow All Name Villa Not Duplicate\n" +
                    "5.\tShow All Name House Not Duplicate\n" +
                    "6.\tShow All Name Name Not Duplicate\n" +
                    "7.\tBack to menu\n" +
                    "8.\tExit\n");
            System.out.println( "Your choose to add: " );
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    showAllService(VILLA);
                    isBackToMenu = false;
                    break;
                case 2:
                    showAllService(HOUSE);
                    isBackToMenu = false;
                    break;
                case 3:
                    showAllService(ROOM);
                    isBackToMenu = false;
                    break;
                case 4:
                    showAllNameNotDuplicate(VILLA);
                    isBackToMenu = true;
                    break;
                case 5:
                    showAllNameNotDuplicate(HOUSE);
                    isBackToMenu = true;
                    break;
                case 6:
                    showAllNameNotDuplicate(ROOM);
                    isBackToMenu = true;
                    break;
                case 7:
                    isBackToMenu = true;
                    break;
                case 8:
                    isExit = true;
                    break;
            }
            if (isBackToMenu || isExit){
                return;
            }
        }while (choose >= 1 && choose <= 5);
    }


    public static List<Services> readAllServices(String fileName){
        FileUtils.setFullPathFile(fileName);
        List<String> propertiesService = FileUtils.readFile();
        List<Services> listOfServices = new ArrayList<>();
        String[] propertiesElement = null;

        Services services = null;
        ExtraService extraService = null;
        for (String properties : propertiesService){
            propertiesElement = properties.split(StringUtils.COMMA);
            if (fileName.equals(VILLA)){
                services = new Villa();
                ((Villa) services).setStandardRoom(propertiesElement[6]);
                ((Villa) services).setOtherDescription(propertiesElement[7]);
                ((Villa) services).setAreaPool(Double.parseDouble(propertiesElement[8]));
                ((Villa) services).setNumberOfFFloors(Integer.parseInt(propertiesElement[9]));
            }else if (fileName.equals(HOUSE)){
                services = new House();

                ((House) services).setStandardRoom(propertiesElement[6]);
                ((House) services).setOtherDescription(propertiesElement[7]);
                ((House) services).setNumberOfFFloors(Integer.parseInt(propertiesElement[8]));
            }else if (fileName.equals(ROOM)){
                extraService = new ExtraService(propertiesElement[6],propertiesElement[7],Double.parseDouble(propertiesElement[8]));
                services = new Room();
                ((Room) services).setExtraService(extraService);
            }
            services.setId(propertiesElement[0]);
            services.setServiceName(propertiesElement[1]);
            services.getAreaUse(Double.parseDouble(propertiesElement[2]));
            services.setRentCost(Double.parseDouble(propertiesElement[3]));
            services.setNumberOfPeoples(Integer.parseInt(propertiesElement[4]));
            services.setTypeRent(propertiesElement[5]);

            listOfServices.add(services);
        }
        return listOfServices;
    }

    private static void showAllService(String fileName) {
        System.out.println("-----------------------------");
        System.out.println("List services: ");

        List<Services> listOfServices = readAllServices(fileName);
        Services services = null;
        for (int i = 0; i < listOfServices.size(); i++){
            services = listOfServices.get(i);
            System.out.println((i + 1) + ". ");
            services.showInfo();
        }
    }

    private static void showAllNameNotDuplicate(String fileName) {
        Set<String> setOfServices = new TreeSet<>();
        System.out.println("-----------------------------");
        System.out.println("List services not duplicate name: ");
        for (Services services : readAllServices(fileName)){
            setOfServices.add(services.getServiceName());
        }
        for (String name : setOfServices){
            System.out.println(name);
        }
        System.out.println("------------------------------");
    }


    private static void addNewCustomer(String fileName) {
        scanner.nextLine();
        boolean flag = true;

        String fullName = null;
        do {
            System.out.println("Input full name: ");
            fullName = scanner.nextLine();
            try {
                Validators.isValidFullName(fullName);
            } catch (NameException e) {
                flag = false;
                e.printStackTrace();
            }
        }while (!flag);


        String dateOfBirth = null;
        do {
            flag =true;
            System.out.println("Input date of birth:");
            dateOfBirth = scanner.nextLine();
            try {
                Validators.isValidBirthDay(dateOfBirth);
            } catch (BirthDayException e) {
                flag = false;
                e.printStackTrace();
            }
        }while (!flag);


        String gender = null;
        do {
            flag = true;
            System.out.println("Input gender: ");
            gender = scanner.nextLine();
            try {
                Validators.isValidGender(gender);
            } catch (GenderException e) {
                flag = false;
                e.printStackTrace();
            }
        }while (!flag);
        gender = ConvertUtils.normalizeStr(gender);


        String idCard = null;
        do {
            flag = true;
            System.out.println("Input id card: ");
            idCard = scanner.nextLine();
            try {
                Validators.isValidIdCard(idCard);
            } catch (IdCardException e) {
                flag = false;
                e.printStackTrace();
            }
        }while (!flag);




        System.out.println("Input phone number: ");
        String phoneNumber = scanner.nextLine();

        String email = null;
        do {
            flag = true;
            System.out.println("Input email: ");
            email = scanner.nextLine();
            try {
                Validators.isValidEmail(email);
            } catch (EmailException e) {
                flag = false;
                e.printStackTrace();
            }
        }while (!flag);



        System.out.println("Input type of customer: ");
        String typeOfCustomer = scanner.nextLine();

        System.out.println("Input address: ");
        String address = scanner.nextLine();


        FileUtils.setFullPathFile(fileName);
        FileUtils.writeFile(new String[]{fullName,dateOfBirth,gender,idCard,phoneNumber,email,typeOfCustomer,address});
    }

    private static List<Customer> readAllCustomer(String fileName){
        FileUtils.setFullPathFile(fileName);
        List<String> propertiesCustomer = FileUtils.readFile();
        List<Customer> listOfCustomers = new ArrayList<>();
        String[] arrPropertyCustomer = null;
        Customer customer = null;

        for (String properties : propertiesCustomer){
            arrPropertyCustomer = properties.split(StringUtils.COMMA);

            customer = new Customer();
            customer.setFullName(arrPropertyCustomer[0]);
            customer.setDateOfBirth(arrPropertyCustomer[1]);
            customer.setGender(arrPropertyCustomer[2]);
            customer.setIdCard(arrPropertyCustomer[3]);
            customer.setPhoneNumber(arrPropertyCustomer[4]);
            customer.setEmail(arrPropertyCustomer[5]);
            customer.setTypeOfCustomer(arrPropertyCustomer[6]);
            customer.setAddress(arrPropertyCustomer[7]);

            listOfCustomers.add(customer);
        }
        Collections.sort(listOfCustomers);
        return listOfCustomers;
    }

    private static void showInformationOfCustomer(String fileName) {
        System.out.println("---------------------------");
        System.out.println("List customer: ");
        List<Customer> listOfCustomers = readAllCustomer(fileName);


        Customer customer = null;
        for (int i = 0; i < listOfCustomers.size(); i++){
            customer = listOfCustomers.get(i);
            System.out.print((i + 1) + ". ");
            customer.showInfo();
        }
    }

    private static void addNewBooking() {
        List<Customer> listOfCustomer = readAllCustomer(CUSTOMER);
        showInformationOfCustomer(CUSTOMER);
        System.out.println("Please choose customer to booking: ");
        int iCustomer = scanner.nextInt();
        System.out.println("1.\tBooking Villa\n" +
                "2.\tBooking House\n" +
                "3.\tBooking Room\n");
        System.out.println("Please choose type of service: ");
        int iTypeOfServices = scanner.nextInt();
        List<Services> listOfService = null;

        switch (iTypeOfServices){
            case 1:
                listOfService = readAllServices(VILLA);
                showAllService(VILLA);
                break;
            case 2:
                listOfService = readAllServices(HOUSE);
                showAllService(HOUSE);
                break;
            case 3:
                listOfService = readAllServices(ROOM);
                showAllService(ROOM);
                break;
        }
        System.out.println("Please choose service to booking: ");
        int iService = scanner.nextInt();
        Customer customer = listOfCustomer.get(iCustomer - 1);
        customer.setServices(listOfService.get(iService - 1));
        FileUtils.setFullPathFile(BOOKING);
        FileUtils.writeFile(new String[]{customer.toString()});

        System.out.println("BOOKING IS DONE!");
    }


    public static Map<String, Employee> readAllEmployees(String fileName){
        FileUtils.setFullPathFile(fileName);
        List<String> propertiesEmployee = FileUtils.readFile();
        Map<String, Employee> mapOfEmploees = new HashMap<>();
        String[] arrPropertyEmployee = null;
        Employee employee = null;

        for (String properties : propertiesEmployee){
            arrPropertyEmployee = properties.split(StringUtils.COMMA);

            employee = new Employee();
            employee.setId(arrPropertyEmployee[0]);
            employee.setFullName(arrPropertyEmployee[1]);
            employee.setDateOfBirth(arrPropertyEmployee[2]);
            employee.setAddress(arrPropertyEmployee[3]);
            mapOfEmploees.put(employee.getId(), employee);
        }
        return mapOfEmploees;
    }

    private static void showInformationOfEmployee() {
        Map<String, Employee> mapOfEmployees = readAllEmployees(EMPLOYEE);

        System.out.println("-----------------------------");
        System.out.println("List employee: ");
        for (Map.Entry<String, Employee> employeeEntry : mapOfEmployees.entrySet()){
            System.out.println(employeeEntry.getKey() + " " + employeeEntry.getValue().toString());
        }
    }

}

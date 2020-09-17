package CaseStudy.Models;

public abstract class Services {
    private String iDService;
    private String nameService;
    private double area;
    private double rentCost;
    private int personLimit;
    private String rentType;

    public Services() {
    }

    public Services(String iDService, String nameService, double area, double rentCost, int personLimit, String rentType) {
        this.iDService = iDService;
        this.nameService = nameService;
        this.area = area;
        this.rentCost = rentCost;
        this.personLimit = personLimit;
        this.rentType = rentType;
    }

    public String getiDService() {
        return iDService;
    }

    public void setiDService(String iDService) {
        this.iDService = iDService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getRentCost() {
        return rentCost;
    }

    public void setRentCost(double rentCost) {
        this.rentCost = rentCost;
    }

    public int getPersonLimit() {
        return personLimit;
    }

    public void setPersonLimit(int personLimit) {
        this.personLimit = personLimit;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }
    public String ShowInfo(){
        return "\nId Service: " + getiDService()+
                "\nServiceType: " +getNameService()+
                "\nArea: " + getArea()+
                "\nRental Cost: " + getRentCost()+
                "\nMaxium person: " +getPersonLimit()+
                "\nRent type: " + getRentType();
    };
}

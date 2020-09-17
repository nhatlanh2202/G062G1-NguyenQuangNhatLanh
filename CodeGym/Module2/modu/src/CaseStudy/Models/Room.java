package CaseStudy.Models;

public class Room extends Services {
    private String freeServices;

    public Room(String iDService, String nameService, String s, String s1, String s2, String rentType, String freeServices) {
    }

    public Room(String iDService, String nameService, double area, double rentCost, int personLimit, String rentType,String freeServices) {
        super(iDService, nameService, area, rentCost, personLimit, rentType);
        this.freeServices=freeServices;
    }

    public Room() {

    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    @Override
    public String  ShowInfo() {
        return super.ShowInfo()+"\nFree Service:"+freeServices;
    }
}

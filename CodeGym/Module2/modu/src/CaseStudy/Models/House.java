package CaseStudy.Models;

public class House extends Services {
    private String roomStandard;
    private String convenient;
    private int floorNumber;

    public House(String iDService, String nameService, String s, String s1, String s2, String rentType, String roomStandard, String convenient, String s3) {
    }

    public House(String iDService, String nameService, double area, double rentCost, int personLimit, String rentType, String roomStandard, String convenient, int floorNumber) {
        super(iDService, nameService, area, rentCost, personLimit, rentType);
        this.roomStandard=roomStandard;
        this.convenient=convenient;
        this.floorNumber=floorNumber;
    }

    public House() {

    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getConvenient() {
        return convenient;
    }

    public void setConvenient(String convenient) {
        this.convenient = convenient;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String ShowInfo() {
        return super.ShowInfo()+
                "\nRoom.csv standard: " + getRoomStandard() +
                "\nConvenient: " + getConvenient() +
                "\nFloor Number: " + getFloorNumber();

    }
}

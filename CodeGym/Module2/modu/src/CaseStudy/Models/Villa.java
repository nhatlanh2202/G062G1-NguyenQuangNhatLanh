package CaseStudy.Models;

public class Villa extends Services {
    private String roomStandard;
    private String convenient;
    private int floorNumber;
    private double poolArea;

    public Villa() {

    }

    public double getPoolArea() {
        return poolArea;
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

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }


    public Villa(double poolArea) {
        this.poolArea = poolArea;
    }
    public Villa(String iDService, String nameService, String s, String s1, String s2, String rentType, String roomStandard, String convenient, String s3, String s4){

    }
    public Villa(String iDService, String nameService, double area, double rentCost, int personLimit, String rentType, String roomStandard, String convenient, int floorNumber, double poolArea) {
        super(iDService, nameService, area, rentCost, personLimit, rentType);
        this.roomStandard = roomStandard;
        this.convenient = convenient;
        this.floorNumber = floorNumber;
        this.poolArea = poolArea;
    }

    @Override
    public String ShowInfo() {
        return super.ShowInfo()+"\nPoolArea:"+poolArea+ "\nRoom.csv standard: " + getRoomStandard() +
                "\nConvenient: " + getConvenient() +
                "\nFloor Number: " + getFloorNumber();
    }
}

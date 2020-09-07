package NewCase.Models;

public class Villa extends Services {
    private String standardRoom;
    private String otherDescription;
    private double areaPool;
    private int numberOfFFloors;


    public Villa(){}

    public Villa(String id, String serviceName, double areaUse, double rentCost, int numberOfPeoples, String typeRent, String standardRoom, String otherDescription, double areaPool, int numberOfFFloors) {
        super( id, serviceName, areaUse, rentCost, numberOfPeoples, typeRent );
        this.standardRoom = standardRoom;
        this.otherDescription = otherDescription;
        this.areaPool = areaPool;
        this.numberOfFFloors = numberOfFFloors;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberOfFFloors() {
        return numberOfFFloors;
    }

    public void setNumberOfFFloors(int numberOfFFloors) {
        this.numberOfFFloors = numberOfFFloors;
    }

    @Override
    public void showInfo() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Villa{" +
                "standardRoom='" + standardRoom + '\'' +
                ", otherDescription='" + otherDescription + '\'' +
                ", areaPool=" + areaPool +
                ", numberOfFFloors=" + numberOfFFloors +
                '}' + super.toString();
    }
}

package NewCase.Models;

public class House extends Services {
    private String standardRoom;
    private String otherDescription;
    private int numberOfFFloors;

    public House(){}

    public House(String id, String serviceName, double areaUse, double rentCost, int numberOfPeoples, String typeRent, String standardRoom, String otherDescription, int numberOfFFloors) {
        super( id, serviceName, areaUse, rentCost, numberOfPeoples, typeRent );
        this.standardRoom = standardRoom;
        this.otherDescription = otherDescription;
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
        return "House{" +
                "standardRoom='" + standardRoom + '\'' +
                ", otherDescription='" + otherDescription + '\'' +
                ", numberOfFFloors=" + numberOfFFloors +
                '}' + super.toString();
    }
}

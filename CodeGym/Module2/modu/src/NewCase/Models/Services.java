package NewCase.Models;

public abstract class Services {
    protected String id;
    protected String serviceName;
    protected double areaUse;
    protected double rentCost;
    protected int numberOfPeoples;
    protected String typeRent;

    public Services(){}

    public Services(String id, String serviceName, double areaUse, double rentCost, int numberOfPeoples, String typeRent) {
        this.id = id;
        this.serviceName = serviceName;
        this.areaUse = areaUse;
        this.rentCost = rentCost;
        this.numberOfPeoples = numberOfPeoples;
        this.typeRent = typeRent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getAreaUse(double v) {
        return areaUse;
    }

    public void setAreaUse(double areaUse) {
        this.areaUse = areaUse;
    }

    public double getRentCost() {
        return rentCost;
    }

    public void setRentCost(double rentCost) {
        this.rentCost = rentCost;
    }

    public int getNumberOfPeoples() {
        return numberOfPeoples;
    }

    public void setNumberOfPeoples(int numberOfPeoples) {
        this.numberOfPeoples = numberOfPeoples;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }

    public abstract void showInfo();

    @Override
    public String toString() {
        return "Services{" +
                "id='" + id + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", areaUse=" + areaUse +
                ", rentCost=" + rentCost +
                ", numberOfPeoples=" + numberOfPeoples +
                ", typeRent='" + typeRent + '\'' +
                '}';
    }
}

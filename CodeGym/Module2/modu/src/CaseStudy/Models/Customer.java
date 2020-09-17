package CaseStudy.Models;

public class Customer{
    private String iD;
    private String customerName;
    private String birthdayOfCustomer;
    private String gender;
    private String customerId;
    private String customerPhone;
    private String customerEmail;
    private String customerType;
    private String customerAddress;
    private Services customerUseServieceType;

    public Customer(String id,String customerName, String birthdayOfCustomer, String gender, String customerId,
                    String customerPhone, String customerEmail, String customerType, String customerAddress,
                    Services customerUseServieceType) {
        this.iD = id;
        this.customerName = customerName;
        this.birthdayOfCustomer = birthdayOfCustomer;
        this.gender = gender;
        this.customerId = customerId;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerType = customerType;
        this.customerAddress = customerAddress;
        this.customerUseServieceType = customerUseServieceType;
    }
    public Customer(){

    }
    public String getID(){
        return this.iD;
    }
    public void setID(String iD){
        this.iD=iD;
    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBirthdayOfCustomer() {
        return birthdayOfCustomer;
    }

    public void setBirthdayOfCustomer(String birthdayOfCustomer) {
        this.birthdayOfCustomer = birthdayOfCustomer;
    }

    public String  getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Services getCustomerUseServieceType() {
        return customerUseServieceType;
    }

    public void setCustomerUseServieceType(Services customerUseServieceType) {
        this.customerUseServieceType = customerUseServieceType;
    }
    public String ShowInFo() {
        return
                "\nID: "+ iD +
                        "\nCustomerName: "+ customerName +
                        "\nBirthdayOfCustomer: " + birthdayOfCustomer +
                        "\nGender: " + gender +
                        "\nCustomerId: " + customerId +
                        "\nCustomerPhone: " + customerPhone +
                        "\nCustomerEmail: " + customerEmail +
                        "\nCustomerType: " + customerType +
                        "\nCustomerAddress: " + customerAddress;

    }
}

package bai_tap;

public class customers {
    private String name;
    private String birthday;
    private String address;
    private String image;

    public customers() {
    }

    public customers(String name, String birthday, String address, String image){
        super();
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.image = image;
    }


//    public customers(String name, String birthday, String address){
//        super();
//        this.name = name;
//        this.birthday = birthday;
//        this.address = address;
//        image = "add image";
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}


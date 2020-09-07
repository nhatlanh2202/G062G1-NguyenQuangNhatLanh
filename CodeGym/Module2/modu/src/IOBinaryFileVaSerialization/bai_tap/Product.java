package IOBinaryFileVaSerialization.bai_tap;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private String brandName;
    private double price;
    private String description;

    public Product(int id, String name, String brandName, double price, String description) {
        this.id = id;
        this.name = name;
        this.brandName = brandName;
        this.price = price;
        this.description = description;
    }

    public Product() {
    }

    public Product(String id, String name, String brandName, String price, String description) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Id: " + id +
                "Name: " + name +
                "Brand Name: " + brandName +
                "Price: " + price +
                "Description: " + description;
    }
}

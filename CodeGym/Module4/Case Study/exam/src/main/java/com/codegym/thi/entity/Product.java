package com.codegym.thi.entity;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 5,max = 50, message = "Độ dài tên sản phẩm từ 5 --> 50 ký tự")
    private String productName;

    @NotBlank
    @Min(value = 100000,message = "Giá sản phẩm thấp nhất 100000")
    private String startPrice;

    @NotBlank(message = "Tình Trạng sản Phẩm không được để trống")
    private String status;

    @ManyToOne
    @JoinColumn(name = "type_product_id")
    private TypeProduct typeProduct;

    public Product() {
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(String startPrice) {
        this.startPrice = startPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

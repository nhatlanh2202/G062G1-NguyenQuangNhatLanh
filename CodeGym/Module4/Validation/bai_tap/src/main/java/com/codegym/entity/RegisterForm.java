package com.codegym.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity(name = "register_form")
public class RegisterForm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    @Size(min = 5, max = 45)
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty
    @Size(min = 5, max = 45)
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Min(value = 18)
    private Integer age;

    @NotEmpty
    @Pattern(regexp = "\\d{10}", message = ".....!")
    private String phone;

    @NotEmpty
    @Email
    private String email;

    public RegisterForm() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

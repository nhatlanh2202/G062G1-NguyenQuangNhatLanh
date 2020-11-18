package com.codegym.entity;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "contract")
public class Contract {
    @Id
    private Long idContract;

    private String startDate;

    private String endDate;

    private double deposit;

    private double totalMoney;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_service")
    private Services services;

//    @OneToMany
//    private List<ContractDetail> contractDetails;




    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public Long getIdContract() {
        return idContract;
    }

    public void setIdContract(Long idContract) {
        this.idContract = idContract;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }
//
//    public List<ContractDetail> getContractDetails() {
//        return contractDetails;
//    }
//
//    public void setContractDetails(List<ContractDetail> contractDetails) {
//        this.contractDetails = contractDetails;
//    }
}

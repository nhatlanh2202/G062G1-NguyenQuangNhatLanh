package CaseStudy.Services.Impl;

import CaseStudy.Models.Customer;
import CaseStudy.Services.Interface.BookingFilm;


import java.util.LinkedList;
import java.util.Queue;

public class BookingFilmImpl implements BookingFilm {
    static Queue<Customer> customerQueue = new LinkedList<>();
    CustomerServiceImp customerService = new CustomerServiceImp();
    @Override
    public void addBookingFilm() {
        Customer customer = customerService.addNewCustomer();
        customerQueue.add(customer);
    }

    @Override
    public void showListBookingFilm() {
        while (true){
            Customer customer = customerQueue.poll();
            if (customer == null){
                break;
            }
            System.out.println(customer.getCustomerName());
        }
    }
}

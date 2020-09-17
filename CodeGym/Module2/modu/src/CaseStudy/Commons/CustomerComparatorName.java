package CaseStudy.Commons;

import CaseStudy.Models.Customer;

import java.util.Comparator;
import java.util.Date;


public class CustomerComparatorName implements Comparator<Customer> {

    @Override
    public int compare(Customer  o1, Customer  o2) {
        if (o1.getCustomerName().compareTo(o2.getCustomerName())==0){
            Date birthday1=new Date(o1.getBirthdayOfCustomer());
            Date birthday2=new Date(o2.getBirthdayOfCustomer());
            Date nowDay =new Date();
            long age1= nowDay.getTime()-birthday1.getTime();
            long age2= nowDay.getTime()-birthday2.getTime();

            if (age1>age2){
                return 1;
            }else if (age1<age2){
                return -1;
            }else {
                return 0;
            }
        }
        return o1.getCustomerName().compareTo(o2.getCustomerName());
    }
}

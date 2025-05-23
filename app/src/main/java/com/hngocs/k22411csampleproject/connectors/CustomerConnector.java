package com.hngocs.k22411csampleproject.connectors;
import com.hngocs.k22411csampleproject.models.Customer;
import com.hngocs.k22411csampleproject.models.ListCustomer;

import java.util.ArrayList;

public class CustomerConnector {
    ListCustomer listCustomer;
    public CustomerConnector(){
        listCustomer = new ListCustomer();
        listCustomer.generate_sample_dataset();
    }
    public ArrayList<Customer>get_all_customer(){
        if (listCustomer==null){
            listCustomer = new ListCustomer();
            listCustomer.generate_sample_dataset();
        }
        return listCustomer.getCustomers();
    }
    public  ArrayList<Customer>get_customer_by_provider(String provider){
        if (listCustomer==null){
            listCustomer = new ListCustomer();
            listCustomer.generate_sample_dataset();
        }
        ArrayList<Customer>results=new ArrayList<>();
        for (Customer c : listCustomer.getCustomers()){
            if(c.getPhone().startsWith(provider))
            {
                results.add(c);
            }
        }
        return results;
    }
}
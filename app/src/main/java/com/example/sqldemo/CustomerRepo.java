package com.example.sqldemo;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepo {

    public static List<CustomerModel> getCustomerModel(){

        List<CustomerModel> customerModels = new ArrayList<>();
        CustomerModel customerModel = new CustomerModel(1,"Aqib",26,true);
        return customerModels;
    }
}

package com.example.sqldemo;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class DataRepo {

    public  static List<CustomerModel> getAllClassItem(Context context){

        DataBaseHelper db = new DataBaseHelper(context);
        List<CustomerModel> list = db.getEveryone();
       /* List<CustomerModel> customerModels = new ArrayList<>();
        CustomerModel customerModel = new CustomerModel(1,"Aqib",26,true);
        customerModels.add(customerModel);
        customerModels.add(customerModel);
        customerModels.add(customerModel);
        customerModels.add(customerModel);
        customerModels.add(customerModel);
        customerModels.add(customerModel);
        customerModels.add(customerModel);
        customerModels.add(customerModel);
        customerModels.add(customerModel);
        customerModels.add(customerModel);
        customerModels.add(customerModel);
        customerModels.add(customerModel);
        customerModels.add(customerModel);*/
        return list;
    }
}

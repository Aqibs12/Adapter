package com.example.sqldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Reference to buttons and other controls in the layout
    Button btn_add, btn_viewAll;
    EditText et_customerName, age;
    Switch switch1;
    ListView list_lv;
    ArrayAdapter customerArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_Add);
        btn_viewAll = findViewById(R.id.btn_ViewAll);
        et_customerName = findViewById(R.id.tv_Customer);
        age = findViewById(R.id.tv_Age);
        switch1 = findViewById(R.id.sw_active);
        list_lv = findViewById(R.id.list_detail);

        DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);

        ArrayAdapter customerArrayAdapter = new ArrayAdapter<CustomerModel>(MainActivity.this, android.R.layout.simple_list_item_1, dataBaseHelper.getEveryone());
        list_lv.setAdapter(customerArrayAdapter);

        // Button listeners for the add and viewAll

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CustomerModel customerModel;
                try {

                    customerModel = new CustomerModel(-1, et_customerName.getText().toString(), Integer.parseInt(age.getText().toString()), switch1.isActivated());

                    Toast.makeText(MainActivity.this, customerModel.toString(), Toast.LENGTH_SHORT).show();

                } catch (Exception e) {

                    Toast.makeText(MainActivity.this, "Error creating customer", Toast.LENGTH_SHORT).show();

                    customerModel = new CustomerModel(-1, "Error", 0, false);
                }

                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);

                boolean success = dataBaseHelper.addOne(customerModel);
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();


                ArrayAdapter customerArrayAdapter = new ArrayAdapter<CustomerModel>(MainActivity.this, android.R.layout.simple_list_item_1, dataBaseHelper.getEveryone());



            }


        });

      /*  list_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> Parent, View view, int i, long l) {

            }
        });*/



        btn_viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {


                    DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
                    List<CustomerModel> everyone = dataBaseHelper.getEveryone();


                    ArrayAdapter customerArrayAdapter = new ArrayAdapter<CustomerModel>(MainActivity.this, android.R.layout.simple_list_item_1, dataBaseHelper.getEveryone());
                    list_lv.setAdapter(customerArrayAdapter);

                }
                catch (Exception e){

                    Toast.makeText(MainActivity.this,"Fail to view",Toast.LENGTH_SHORT ).show();


                }



            }
        });





    }
}
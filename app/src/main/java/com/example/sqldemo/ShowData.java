package com.example.sqldemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ShowData extends AppCompatActivity {

    TextView textView;
    RecyclerView recyclerView;
    private MyAdapter myAdapter;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show1_data);
        init();


    }
    private void init(){
        context = this;
        textView = findViewById(R.id.tv_data);
        recyclerView = findViewById(R.id.recycler1);
        List<CustomerModel> customerModels = DataRepo.getAllClassItem(context);
        myAdapter = new MyAdapter(customerModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
    }
}
package com.example.sqldemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    List<CustomerModel> customerModels;
    public MyAdapter(List<CustomerModel> customerModels){
        this.customerModels = customerModels;
    }
    @NonNull
    @Override
    public MyAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.data, parent, false);
        return new MyHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        CustomerModel customerModel = customerModels.get(position);
        holder.tvId.setText("ID#"+ customerModel.getId());
        holder.tvName.setText("Aqib"+customerModel.getName());
        holder.tvAge.setText("" + customerModel.getAge());
        holder.tvIsActive.setText(customerModel.isActive());
    }

    @Override
    public int getItemCount() {
        return customerModels.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tvId,tvName,tvAge,tvIsActive;

        public MyHolder(@NonNull View itemView) {

            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAge = itemView.findViewById(R.id.tv_age);
            tvIsActive = itemView.findViewById(R.id.tv_isActive);
        }
    }
}



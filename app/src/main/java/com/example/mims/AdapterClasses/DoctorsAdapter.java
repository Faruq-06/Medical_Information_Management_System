package com.example.mims.AdapterClasses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mims.ModelClasses.DoctorsModel;
import com.example.mims.R;

import java.util.ArrayList;

public class DoctorsAdapter extends RecyclerView.Adapter<DoctorsAdapter.myviewHolder> {
    ArrayList<DoctorsModel> dataList;

    public DoctorsAdapter(ArrayList<DoctorsModel> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public DoctorsAdapter.myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.doctorslist,parent,false);
        return new myviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorsAdapter.myviewHolder holder, int position) {
        holder.fullname.setText(dataList.get(position).getFullname());
        holder.e_mail.setText(dataList.get(position).getE_mail());
        holder.Specialist.setText(dataList.get(position).getSpecialist());
        //holder.email.setText(dataList.get(position).getEmail());
       // holder.speciality.setText(dataList.get(position).getSpeciality());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class myviewHolder extends RecyclerView.ViewHolder{
        TextView fullname,e_mail,Specialist;

        public myviewHolder(@NonNull View itemView) {
            super(itemView);
            fullname = itemView.findViewById(R.id.t1);
            e_mail = itemView.findViewById(R.id.t2);
            Specialist = itemView.findViewById(R.id.t3);


        }

    }
}


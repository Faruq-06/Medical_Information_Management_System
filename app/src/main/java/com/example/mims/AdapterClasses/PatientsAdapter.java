package com.example.mims.AdapterClasses;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mims.AES256;
import com.example.mims.ModelClasses.DoctorsModel;
import com.example.mims.ModelClasses.PatientModel_show;
import com.example.mims.R;

import java.util.ArrayList;

public class PatientsAdapter extends RecyclerView.Adapter<PatientsAdapter.myviewHolder> {
    ArrayList<PatientModel_show> dataList;

    public PatientsAdapter(ArrayList<PatientModel_show> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public PatientsAdapter.myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.patients_list,parent,false);
        return new myviewHolder(view).linkAdapter(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull PatientsAdapter.myviewHolder holder, int position) {
        holder.fullname.setText(AES256.decrypt(dataList.get(position).getFullname()));
        holder.phone.setText(AES256.decrypt(dataList.get(position).getPhone()));
      //  holder.Specialist.setText(dataList.get(position).getSpecialist());
        //holder.email.setText(dataList.get(position).getEmail());
        // holder.speciality.setText(dataList.get(position).getSpeciality());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class myviewHolder extends RecyclerView.ViewHolder{
        TextView fullname,phone;
        private PatientsAdapter adapter;

        public myviewHolder(@NonNull View itemView) {
            super(itemView);
            fullname = itemView.findViewById(R.id.t1);
            phone = itemView.findViewById(R.id.t2);
           // Specialist = itemView.findViewById(R.id.t3);


        }
        public myviewHolder linkAdapter(PatientsAdapter adapter){
            this.adapter = adapter;
            return this;

        }

    }
}


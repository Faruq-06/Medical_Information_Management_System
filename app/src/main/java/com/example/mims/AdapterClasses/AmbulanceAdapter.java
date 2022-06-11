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
import com.example.mims.ModelClasses.AmbulanceModel;
import com.example.mims.ModelClasses.PatientModel_show;
import com.example.mims.R;

import java.util.ArrayList;

public class AmbulanceAdapter extends RecyclerView.Adapter<AmbulanceAdapter.myviewHolder> {
    ArrayList<AmbulanceModel> dataList;

    public AmbulanceAdapter(ArrayList<AmbulanceModel> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public AmbulanceAdapter.myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_ambulance,parent,false);
        return new myviewHolder(view).linkAdapter(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull AmbulanceAdapter.myviewHolder holder, int position) {
        holder.fullname.setText(dataList.get(position).getName());
        holder.phone.setText(dataList.get(position).getMobile());
        holder.vehicle.setText(dataList.get(position).getVehicle_number());
        //  holder.Specialist.setText(dataList.get(position).getSpecialist());
        //holder.email.setText(dataList.get(position).getEmail());
        // holder.speciality.setText(dataList.get(position).getSpeciality());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class myviewHolder extends RecyclerView.ViewHolder{
        TextView fullname,phone,vehicle;
        private AmbulanceAdapter adapter;

        public myviewHolder(@NonNull View itemView) {
            super(itemView);
            fullname = itemView.findViewById(R.id.t1);
            phone = itemView.findViewById(R.id.t2);
            vehicle = itemView.findViewById(R.id.t3);
            // Specialist = itemView.findViewById(R.id.t3);


        }
        public myviewHolder linkAdapter(AmbulanceAdapter adapter){
            this.adapter = adapter;
            return this;

        }

    }
}


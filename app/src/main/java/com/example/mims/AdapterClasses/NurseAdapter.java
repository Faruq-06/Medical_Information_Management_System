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
import com.example.mims.ModelClasses.NurseModel;
import com.example.mims.R;

import java.util.ArrayList;

public class NurseAdapter extends RecyclerView.Adapter<NurseAdapter.myviewHolder> {
    ArrayList<NurseModel> dataList;

    public NurseAdapter(ArrayList<NurseModel> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public NurseAdapter.myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.nurselist,parent,false);
        return new NurseAdapter.myviewHolder(view).linkAdapter(this);


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull NurseAdapter.myviewHolder holder, int position) {
        holder.fullname.setText(AES256.decrypt(dataList.get(position).getFullname()));
        holder.phone.setText(AES256.decrypt(dataList.get(position).getPhone()));
        holder.wardno.setText(AES256.decrypt(dataList.get(position).getW_number()));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class myviewHolder extends RecyclerView.ViewHolder {
        TextView fullname,phone,wardno;
        private NurseAdapter adapter;
        public myviewHolder(@NonNull View itemView) {
            super(itemView);
            fullname = itemView.findViewById(R.id.t1);
            phone = itemView.findViewById(R.id.t2);
            wardno = itemView.findViewById(R.id.t3);
        }
        public NurseAdapter.myviewHolder linkAdapter(NurseAdapter adapter){
            this.adapter = adapter;
            return this;

        }
    }

}

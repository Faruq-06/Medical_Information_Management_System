package com.example.mims.AdapterClasses;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mims.AES256;
import com.example.mims.ModelClasses.DoctorsModel;
import com.example.mims.ModelClasses.NurseModel;
import com.example.mims.NurseUpdate;
import com.example.mims.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class NurseAdapter extends RecyclerView.Adapter<NurseAdapter.myviewHolder> {
    ArrayList<NurseModel> dataList;
    Context context;

    public NurseAdapter(ArrayList<NurseModel> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
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
        NurseModel nurseModel = dataList.get(position);
        holder.fullname.setText(AES256.decrypt(nurseModel.getFullname()));
        holder.phone.setText(AES256.decrypt(nurseModel.getPhone()));
        holder.wardno.setText(AES256.decrypt(nurseModel.getW_number()));

        holder.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseFirestore.getInstance().collection("Nurses")
                        .document(nurseModel.getId()).delete();
                dataList.remove(nurseModel);
                notifyDataSetChanged();
            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context, NurseUpdate.class);
                i.putExtra("name",nurseModel.getFullname());
                i.putExtra("email",nurseModel.getEmail());
                i.putExtra("ward",nurseModel.getW_number());
                i.putExtra("pass",nurseModel.getPassword());
                i.putExtra("dept",nurseModel.getSpeciality());
                i.putExtra("phone",nurseModel.getPhone());
                i.putExtra("id",nurseModel.getId());
                context.startActivity(i);
                //context.startActivity(new Intent(context, NurseUpdate.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class myviewHolder extends RecyclerView.ViewHolder {
        TextView fullname,phone,wardno;
        private FloatingActionButton floatingActionButton;
        private NurseAdapter adapter;
        private CardView cardView;
        public myviewHolder(@NonNull View itemView) {
            super(itemView);
            fullname = itemView.findViewById(R.id.t1);
            floatingActionButton = itemView.findViewById(R.id.floating_subtract_button);
            phone = itemView.findViewById(R.id.t2);
            wardno = itemView.findViewById(R.id.t3);
            cardView = itemView.findViewById(R.id.cardview);

        }
        public NurseAdapter.myviewHolder linkAdapter(NurseAdapter adapter){
            this.adapter = adapter;
            return this;

        }
    }

}

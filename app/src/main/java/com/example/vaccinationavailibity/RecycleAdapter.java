package com.example.vaccinationavailibity;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder>
{
 ArrayList<model> myarr;
   private LayoutInflater layoutInflater;

    public RecycleAdapter(ArrayList<model> a ,Context context) {
        this.layoutInflater=LayoutInflater.from(context);
     this.myarr=a;
    }
    @NonNull
    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=layoutInflater.inflate(R.layout.items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.ViewHolder holder, int position) {
        holder.centern.setText(myarr.get(position).getCenter_name());
        holder.loc.setText(myarr.get(position).getLocation());
        holder.time.setText(myarr.get(position).getTime());
        holder.vaccn.setText(myarr.get(position).getVaccine());

        holder.fe.setText(myarr.get(position).getFees());
        holder.age.setText(myarr.get(position).getAge());
        holder.avail.setText(myarr.get(position).getAvail());

    }
    @Override
    public int getItemCount()
    {
        String s= Integer.valueOf(myarr.size()).toString();
        Toast.makeText(layoutInflater.getContext(),s, Toast.LENGTH_SHORT).show();
        return myarr.size() ;
    }



public  class ViewHolder extends RecyclerView.ViewHolder
{
    TextView centern,vaccn,fe,age,avail,time,loc;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        loc=itemView.findViewById(R.id.location);
  centern=itemView.findViewById(R.id.etext);
   vaccn =itemView.findViewById(R.id.vaccine);
   fe = itemView.findViewById(R.id.fees);
  age=itemView.findViewById(R.id.age);
   avail=itemView.findViewById(R.id.avail);
   time=itemView.findViewById(R.id.timing);




    }
}

}

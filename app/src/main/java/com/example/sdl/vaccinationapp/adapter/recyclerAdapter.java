package com.example.sdl.vaccinationapp.adapter;

import android.content.Context;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.design.animation.AnimationUtils;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sdl.vaccinationapp.R;
import com.example.sdl.vaccinationapp.model.VaccineTimeTable;

import java.util.List;

import static android.content.ContentValues.TAG;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder>{

    private List<VaccineTimeTable> vaccineList;
    private LayoutInflater inflater;

    public recyclerAdapter(Context context, List<VaccineTimeTable> myVaccineList)
    {
        this.vaccineList = myVaccineList;
        this.inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       Log.d(TAG,"onCreateViewHolder");
        View view = inflater.inflate(R.layout.list_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d(TAG,"onCreateViewHolder "+position);

        VaccineTimeTable currentObj = vaccineList.get(position);
        holder.getData(currentObj,position);
    }

    @Override
    public int getItemCount() {
        return vaccineList.size();
    }

    class MyViewHolder extends  RecyclerView.ViewHolder {

        TextView title,t;
        ImageView done;
        int position;
        VaccineTimeTable current;

        public MyViewHolder(View itemView){
            super(itemView);
            t = itemView.findViewById(R.id.t);
            title = (TextView) itemView.findViewById(R.id.VaccineName);
            done = (ImageView) itemView.findViewById(R.id.doneVaccine);

                    }

        public void getData(VaccineTimeTable currentObj, int position) {
            this.title.setText(currentObj.getTitle());
            this.t.setText(currentObj.getDescription());
            this.done.setImageResource(currentObj.getImage());
            this.position=position;
            this.current=currentObj;
            //final Animation a = android.view.animation.AnimationUtils.loadAnimation(this,R.anim.mytransition);
        }
    }

}

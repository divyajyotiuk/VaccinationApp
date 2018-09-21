package com.example.sdl.vaccinationapp.adapter;

import android.content.Context;
import android.service.autofill.CharSequenceTransformation;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sdl.vaccinationapp.R;
import com.example.sdl.vaccinationapp.model.BackdropMenu;

import java.util.Collections;
import java.util.List;

import static android.content.ContentValues.TAG;

public class BackdropMenuAdapter extends RecyclerView.Adapter<BackdropMenuAdapter.MyViewHolder> {

    private List<BackdropMenu> dataList = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

//    static String titles[] = { "My Account", "Vaccine Chart", "Calendar", "Info", "Feedback", "Settings" };
    public BackdropMenuAdapter(Context context, List<BackdropMenu> data)
    {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.dataList = data;
    }

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG,"onCreateViewHolder");
        View view = inflater.inflate(R.layout.nav_drawer_list_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Log.d(TAG,"onCreateViewHolder "+ position);
        BackdropMenu currentObj =  dataList.get(position);

        holder.getData(currentObj,position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "selected",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class MyViewHolder extends  RecyclerView.ViewHolder {

        TextView menuTitle;
        ImageView imgIcon;
        int position;
        BackdropMenu current;


        public MyViewHolder(View itemView){
            super(itemView);
            menuTitle = (TextView) itemView.findViewById(R.id.menuTitle);
            imgIcon = (ImageView) itemView.findViewById(R.id.imgIcon);

        }

        public void getData(BackdropMenu currentObj, int position) {
            this.menuTitle.setText(currentObj.getTitle());
            this.imgIcon.setImageResource(currentObj.getImageID());
            this.position=position;
            this.current=currentObj;

        }
    }

}


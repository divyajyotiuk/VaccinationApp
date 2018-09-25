package com.example.sdl.vaccinationapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sdl.vaccinationapp.R;
import com.example.sdl.vaccinationapp.adapter.recyclerAdapter;
import com.example.sdl.vaccinationapp.model.VaccineTimeTable;

public class FragmentPending extends Fragment {


    public static FragmentPending newInstance() {
        FragmentPending fragment = new FragmentPending();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_pending,container,false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.pendingRecyclerView);
       recyclerAdapter adapter = new recyclerAdapter(getContext(), VaccineTimeTable.getdata());
     //   LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
      //  linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return rootView;

    }
}

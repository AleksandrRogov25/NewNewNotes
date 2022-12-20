package com.example.newnotes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ListFragment extends Fragment {

    public static ListFragment newInstanse(){
        return new ListFragment();
    }

    public ListFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycle_view_lines);
        CardSours data = new CardSoursImpl(getResources()).init();
        initRecyclerView(recyclerView, data);
        return view;
    }
    private void initRecyclerView(RecyclerView recyclerView, CardSours data){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        ListAdapter listAdapter = new ListAdapter(data);
        recyclerView.setAdapter(listAdapter);
        listAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
    }
}
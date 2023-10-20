package com.example.finalproject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyplansFragment extends Fragment {
    private RecyclerView plansRecyclerView;
    private List<Service> planPolicies = new ArrayList<>(); // This list will store the collected plan policies

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_myplans, container, false);




        SharedViewModel sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        sharedViewModel.getPurchasedPolicy().observe(getViewLifecycleOwner(), service -> {
            if (service != null) {
                planPolicies.add(service);
                plansRecyclerView.getAdapter().notifyDataSetChanged();
            }
        });
        sharedViewModel.getPurchasedPolicy().observe(getViewLifecycleOwner(), service -> {
            if (service != null) {
                Log.d("MyplansFragment", "New policy observed: " + service.getName());
                planPolicies.add(service);
                plansRecyclerView.getAdapter().notifyDataSetChanged();
            }
        });

        return view;

    }

}

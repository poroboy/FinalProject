package com.example.finalproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BuynewplanFragment extends Fragment {
    private RecyclerView recyclerView;
    private TextView userNameIDTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buynewplan, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Assuming you're passing userID as an argument to the fragment

        // Create a list of services
        List<Service> serviceList = new ArrayList<>();
        serviceList.add(new Service("Car Insurance", "Insurance for cars", R.drawable.car_icon));
        serviceList.add(new Service("Motorcycle Insurance", "Insurance for motorcycles", R.drawable.motorcycle_icon));
        serviceList.add(new Service("Health Insurance", "Insurance for health", R.drawable.health_icon));

        // Create and set the adapter
        ServiceAdapter serviceAdapter = new ServiceAdapter(serviceList);
        recyclerView.setAdapter(serviceAdapter);

        // Set the recommendation text
        TextView recommendationTextView = view.findViewById(R.id.tv_recommendation);
        recommendationTextView.setText("Recommendation: Choose the insurance that best suits your needs.");
    }
}

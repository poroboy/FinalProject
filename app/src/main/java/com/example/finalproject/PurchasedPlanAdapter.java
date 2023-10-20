package com.example.finalproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PurchasedPlanAdapter extends RecyclerView.Adapter<PurchasedPlanAdapter.PlanViewHolder> {

    private List<Service> purchasedPlans;

    public PurchasedPlanAdapter(List<Service> purchasedPlans) {
        this.purchasedPlans = purchasedPlans;
    }

    @NonNull
    @Override
    public PlanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plan_policy, parent, false);
        return new PlanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanViewHolder holder, int position) {
        Service plan = purchasedPlans.get(position);
        holder.bind(plan);
    }

    @Override
    public int getItemCount() {
        return purchasedPlans.size();
    }

    public class PlanViewHolder extends RecyclerView.ViewHolder {

        private TextView planNameTextView;
        private TextView planDetailsTextView;
        private ImageView planImageView;

        public PlanViewHolder(@NonNull View itemView) {
            super(itemView);
            planNameTextView = itemView.findViewById(R.id.planNameTextView);
            planDetailsTextView = itemView.findViewById(R.id.planDetailsTextView);
            planImageView = itemView.findViewById(R.id.planImageView);
        }

        public void bind(Service plan) {
            planNameTextView.setText(plan.getName());
            planDetailsTextView.setText(plan.getDescription());
            planImageView.setImageResource(plan.getImageResourceId());
        }
    }
}


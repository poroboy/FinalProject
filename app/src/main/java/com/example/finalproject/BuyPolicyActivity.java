package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

public class BuyPolicyActivity extends AppCompatActivity {

    Spinner insuranceTypeSpinner;
    TextView costTextView;
    CheckBox coverage1CheckBox;
    CheckBox coverage2CheckBox;
    int[] insuranceCosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_policy);



        // Initialize the views
        insuranceTypeSpinner = findViewById(R.id.spinner_insurance_type);
        costTextView = findViewById(R.id.tv_cost);
        coverage1CheckBox = findViewById(R.id.cb_coverage1);
        coverage2CheckBox = findViewById(R.id.cb_coverage2);
        insuranceCosts = getResources().getIntArray(R.array.insurance_costs);
        Button buyPolicyButton = findViewById(R.id.btn_submit);
        SharedViewModel sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);

        buyPolicyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String serviceName = insuranceTypeSpinner.getSelectedItem().toString();
                String serviceDescription = costTextView.getText().toString();
                // Assuming you have an image resource ID for the selected insurance type
                int imageResourceId = R.drawable.car_icon/* fetch the appropriate image resource ID based on the selected insurance type */;

                // Create the Service object with the fetched details
                Service purchasedService = new Service(serviceName, serviceDescription, imageResourceId);

                // Set the purchased policy in the shared ViewModel
                sharedViewModel.setPurchasedPolicy(purchasedService);

                Intent intent = new Intent(BuyPolicyActivity.this, MainActivity.class);
                intent.putExtra("navigateTo", "MyplansFragment");
                startActivity(intent);
                finish();
            }
        });

        coverage1CheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> updateTotalCost());
        coverage2CheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> updateTotalCost());

        // Set the listener for the spinner
        insuranceTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int selectedCost = insuranceCosts[position];
                costTextView.setText("ราคา: " + selectedCost + " .-");
                costTextView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                costTextView.setVisibility(View.GONE);
            }
        });
    }

    private void updateTotalCost() {
        int baseCost = insuranceCosts[insuranceTypeSpinner.getSelectedItemPosition()];
        if (coverage1CheckBox.isChecked()) {
            baseCost += 300;  // Additional cost for Coverage 1
        }
        if (coverage2CheckBox.isChecked()) {
            baseCost += 300;  // Additional cost for Coverage 2
        }
        costTextView.setText("ราคา: " + baseCost + " .-");
    }

}




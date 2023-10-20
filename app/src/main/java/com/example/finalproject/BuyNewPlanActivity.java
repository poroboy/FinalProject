package com.example.finalproject;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class BuyNewPlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buynewplan); // Assuming you have this layout

        // Check if the fragment is already added, if not, add it
        if (savedInstanceState == null) {
            BuynewplanFragment fragment = new BuynewplanFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container, fragment); // Assuming you have a FrameLayout with id 'fragment_container' in activity_buynewplan.xml
            transaction.commit();
        }
    }
}

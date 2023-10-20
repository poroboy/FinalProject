package com.example.finalproject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Service> purchasedPolicy = new MutableLiveData<>();



    public void setPurchasedPolicy(Service service) {
        purchasedPolicy.setValue(service);
    }

    public LiveData<Service> getPurchasedPolicy() {
        return purchasedPolicy;
    }
}


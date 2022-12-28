package com.max.healthy.ui.specialistes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SpecialistesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SpecialistesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Specialistes fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
package com.max.healthy.ui.specialistes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.max.healthy.databinding.FragmentSpecialistesBinding;

public class SpecialistesFragment extends Fragment {

    private FragmentSpecialistesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SpecialistesViewModel specialistesViewModel =
                new ViewModelProvider(this).get(SpecialistesViewModel.class);

        binding = FragmentSpecialistesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textNotifications;
        //notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
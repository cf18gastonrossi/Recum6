package com.example.recum6.ui.modificacio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.recum6.R;

public class ModificacioFragment extends Fragment {

    private ModificacioViewModel modificacioViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        modificacioViewModel =
                ViewModelProviders.of(this).get(ModificacioViewModel.class);
        View root = inflater.inflate(R.layout.fragment_modificacio, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        modificacioViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
package com.example.recum6.ui.alta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.recum6.R;
import com.example.recum6.model.Hotel;
import com.example.recum6.repository.DatabaseManager;
import com.example.recum6.repository.RoomUse;

import java.util.List;

public class AltaBajaFragment extends Fragment {

    private TextView nameEditText, cifEditText, cifBajaEditText;

    private Button altaButton, bajaButton;

    private RoomUse roomDB;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_alta, container, false);

        roomDB = RoomUse.get(getContext());

        altaButton = root.findViewById(R.id.altaButton);
        bajaButton = root.findViewById(R.id.bajaButton);
        nameEditText = root.findViewById(R.id.nameEditText);
        cifEditText = root.findViewById(R.id.cifEditText);
        cifBajaEditText = root.findViewById(R.id.cifBajaEditText);

        altaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Hotel.checkInput(nameEditText.getText().toString(), cifEditText.getText().toString())) {
                    try {
                        roomDB.insert(new Hotel(nameEditText.getText().toString(), cifEditText.getText().toString()));
                    }
                    catch (Exception e) {
                        Toast.makeText(getContext(), "Parece que ya hay un hotel con ese nombre", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "No se pudo dar de alta al hotel.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bajaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!cifBajaEditText.getText().toString().equalsIgnoreCase("")) {
                    try {
                        roomDB.delete(cifBajaEditText.getText().toString());
                        Toast.makeText(getContext(), "Hotel dado de baja correctamente.", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(getContext(), "Este hotel no se puede dar de baja.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        return root;
    }
}
package com.example.recum6.ui.modificacio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.recum6.R;
import com.example.recum6.model.Hotel;
import com.example.recum6.repository.DatabaseManager;

public class ModificacioFragment extends Fragment {

    private TextView nameEditText, cifEditText, cifConsultaEditText, consultaTextView;

    private Button modificarButton, consultaButton;
    private DatabaseManager dbManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_modificacio, container, false);

        modificarButton = root.findViewById(R.id.modificarButton);
        consultaButton = root.findViewById(R.id.consultaButton);

        nameEditText = root.findViewById(R.id.nameEditText);
        cifEditText = root.findViewById(R.id.cifEditText);
        cifConsultaEditText = root.findViewById(R.id.cifConsultaEditText);
        consultaTextView = root.findViewById(R.id.consultaTextView);

        consultaTextView.setVisibility(View.INVISIBLE);

        modificarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Hotel.checkInput(nameEditText.getText().toString(), cifEditText.getText().toString())) {
                    dbManager = new DatabaseManager(getContext());
                    dbManager.open();
                    dbManager.update(new Hotel(nameEditText.getText().toString(), cifEditText.getText().toString()));
                    Toast.makeText(getContext(), "Hotel modificado correctamente.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Hotel no se pudo modificar.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return root;
    }
}
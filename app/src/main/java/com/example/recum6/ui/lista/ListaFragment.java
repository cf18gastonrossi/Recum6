package com.example.recum6.ui.lista;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.recum6.R;
import com.example.recum6.repository.DatabaseHelper;
import com.example.recum6.repository.DatabaseManager;

public class ListaFragment extends Fragment {

    private DatabaseManager dbManager;

    private ListView listView;

    private SimpleCursorAdapter adapter;

    final String[] from = new String[]{DatabaseHelper._ID,
            DatabaseHelper.NOMBRE, DatabaseHelper.CIF};

    final int[] to = new int[]{R.id.id, R.id.title, R.id.desc};


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_lista, container, false);

        dbManager = new DatabaseManager(getContext());
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        listView = root.findViewById(R.id.list_view);
        listView.setEmptyView(root.findViewById(R.id.empty));

        adapter = new SimpleCursorAdapter(getContext(),R.layout.listview_layout,cursor,from,to,0);

        listView.setAdapter(adapter);

        dbManager.close();

        return root;
    }
}
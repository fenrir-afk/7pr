package com.example.a7pr.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.a7pr.Adapters.MainAdapter;
import com.example.a7pr.Data.Models.MainData;
import com.example.a7pr.Data.Room.RoomDB;
import com.example.a7pr.MainActivity;
import com.example.a7pr.databinding.FragmentContentBinding;
import com.example.a7pr.ui.state_holder.ContentViewModel;

import java.util.ArrayList;
import java.util.List;

public class ContentFragment extends Fragment {
    private FragmentContentBinding binding;
    List<MainData> dataList = new ArrayList<>();
    RoomDB database;
    MainAdapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ContentViewModel contentViewModel =
                new ViewModelProvider(this).get(ContentViewModel.class);

        binding = FragmentContentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        database = RoomDB.getInstance(getContext());////
        dataList = database.userDao().getAll();
        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(getContext());///
        binding.recyclerView.setLayoutManager(LinearLayoutManager);
        adapter = new MainAdapter(getActivity(),dataList);////
        binding.recyclerView.setAdapter(adapter);
        binding.btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sText = String.valueOf(binding.editText.getText());
                if (!sText.equals("")){
                    MainData data = new MainData();
                    data.setText(sText);
                    database.userDao().insert(data);
                    binding.editText.setText("");
                    dataList.clear();
                    dataList.addAll(database.userDao().getAll());
                    adapter.notifyDataSetChanged();
                }
            }
        });
        binding.btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.userDao().reset(dataList);
                dataList.clear();
                dataList.addAll(database.userDao().getAll());
                adapter.notifyDataSetChanged();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

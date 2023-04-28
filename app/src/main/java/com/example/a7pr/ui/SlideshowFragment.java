package com.example.a7pr.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a7pr.Data.Models.Exhibit;
import com.example.a7pr.Adapters.RecycleAdapter;
import com.example.a7pr.databinding.FragmentSlideshowBinding;
import com.example.a7pr.state_holder.SlideshowViewModel;

import java.util.List;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;
    RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);
        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = binding.RecycleView;
        slideshowViewModel.getExhibitList().observe(getViewLifecycleOwner(), new Observer<List<Exhibit>>() {
            @Override
            public void onChanged(List<Exhibit> exhibits) {
                RecycleAdapter adapter;
                adapter = new RecycleAdapter(root.getContext(), exhibits);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

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
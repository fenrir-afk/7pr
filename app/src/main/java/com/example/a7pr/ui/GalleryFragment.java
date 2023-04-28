package com.example.a7pr.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.a7pr.Adapters.CustomAdapter;
import com.example.a7pr.Data.Models.Exhibit;
import com.example.a7pr.R;
import com.example.a7pr.databinding.FragmentGalleryBinding;
import com.example.a7pr.state_holder.GalleryViewModel;

import java.util.List;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ListView listView = (ListView) root.findViewById(R.id.MylistView);

        galleryViewModel.getExhibitList().observe(getViewLifecycleOwner(), new Observer<List<Exhibit>>() {
            @Override
            public void onChanged(List<Exhibit> exhibits) {
                CustomAdapter adapter;
                adapter = new CustomAdapter(root.getContext(), exhibits);
                listView.setAdapter(adapter);
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
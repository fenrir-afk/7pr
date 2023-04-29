package com.example.a7pr.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.a7pr.Data.Models.Exhibit;
import com.example.a7pr.R;
import com.example.a7pr.databinding.FragmentResourcesBinding;
import com.example.a7pr.ui.state_holder.ResourcesViewModel;

import java.util.List;

public class ResourcesFragment extends Fragment {
    private FragmentResourcesBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ResourcesViewModel contentViewModel =
                new ViewModelProvider(this).get(ResourcesViewModel.class);

        binding = FragmentResourcesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ListView listView = (ListView) root.findViewById(R.id.MylistView);

        contentViewModel.getExhibitList().observe(getViewLifecycleOwner(), new Observer<List<Exhibit>>() {
            @Override
            public void onChanged(List<Exhibit> exhibits) {
                TextView text1  = binding.textView5;
                text1.setText("         " + exhibits.size());
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

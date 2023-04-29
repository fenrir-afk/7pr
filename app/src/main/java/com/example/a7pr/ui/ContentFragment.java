package com.example.a7pr.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.a7pr.Data.Models.Exhibit;
import com.example.a7pr.R;
import com.example.a7pr.databinding.FragmentContentBinding;
import com.example.a7pr.ui.state_holder.ContentViewModel;

import java.util.List;

public class ContentFragment extends Fragment {
    private FragmentContentBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ContentViewModel contentViewModel =
                new ViewModelProvider(this).get(ContentViewModel.class);

        binding = FragmentContentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ListView listView = (ListView) root.findViewById(R.id.MylistView);

        contentViewModel.getExhibitList().observe(getViewLifecycleOwner(), new Observer<List<Exhibit>>() {
            @Override
            public void onChanged(List<Exhibit> exhibits) {
                TextView text1 = binding.exampleText;
                ImageView img = binding.exampleImg;
                text1.setText(exhibits.get(8).getName());
                img.setImageResource(exhibits.get(8).getImgID());
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

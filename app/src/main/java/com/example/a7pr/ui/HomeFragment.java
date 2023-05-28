package com.example.a7pr.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.a7pr.R;
import com.example.a7pr.databinding.FragmentHomeBinding;
import com.example.a7pr.ui.state_holder.HomeViewModel;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final Button button = binding.Button1;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("Per", (String) button.getText());
                Navigation.findNavController(v).navigate(R.id.nav_slideshow,bundle);
            }
        });
        binding.Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("Per", (String) button.getText());
                Navigation.findNavController(v).navigate(R.id.nav_gallery,bundle);
            }
        });
        binding.Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("Per", (String) button.getText());
                Navigation.findNavController(v).navigate(R.id.nav_resources,bundle);
            }
        });
        binding.Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("Per", (String) button.getText());
                Navigation.findNavController(v).navigate(R.id.nav_content,bundle);
            }
        });
        binding.Button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MyTag","Share button pressed");
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,"GOAL_SSS+");
                intent.putExtra(Intent.EXTRA_EMAIL,"79652331953");
                intent.putExtra(Intent.EXTRA_TEXT,"Попробуй приложение");
                getActivity().startActivity(intent);
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
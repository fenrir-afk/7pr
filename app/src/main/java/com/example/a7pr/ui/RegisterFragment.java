package com.example.a7pr.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.a7pr.MainActivity;
import com.example.a7pr.R;
import com.example.a7pr.databinding.FragmentGalleryBinding;
import com.example.a7pr.databinding.FragmentRegisterBinding;
import com.example.a7pr.ui.state_holder.RegisterViewModel;

public class RegisterFragment extends Fragment {
    private FragmentRegisterBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText editText = view.findViewById(R.id.edit_text);
        Intent intent = getActivity().getIntent();
        if (intent != null){
            String action = intent.getAction();
            String type = intent.getType();
            if (Intent.ACTION_SEND.equals("text/plain")){
                String text = intent.getStringExtra(Intent.EXTRA_TEXT);
                editText.setText(text);
            }

        }
        else{
            Log.e("Tag","Intent is empty");
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RegisterViewModel registerViewModel =
                new ViewModelProvider(this).get(RegisterViewModel.class);

        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

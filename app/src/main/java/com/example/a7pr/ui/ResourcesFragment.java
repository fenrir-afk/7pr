package com.example.a7pr.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.a7pr.Data.Models.Exhibit;
import com.example.a7pr.R;
import com.example.a7pr.databinding.FragmentResourcesBinding;
import com.example.a7pr.ui.state_holder.ResourcesViewModel;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ResourcesFragment extends Fragment {
    private FragmentResourcesBinding binding;
    ListView listView;
    TextView text1;
    Button button;
    EditText userNameEditText;
    String userName ="";
    public static final String FILE_NAME = "user_name";

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = (ListView) view.findViewById(R.id.MylistView);
        text1  = binding.textView5;
        button = binding.button;
        userNameEditText = binding.editText;

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ResourcesViewModel contentViewModel =
                new ViewModelProvider(this).get(ResourcesViewModel.class);

        binding = FragmentResourcesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        if(isUserNameFileExist()) {userName = contentViewModel.readUserName();}
        if (!userName.isEmpty()){binding.editText.setText(userName);}
        contentViewModel.getExhibitList().observe(getViewLifecycleOwner(), new Observer<List<Exhibit>>() {
            @Override
            public void onChanged(List<Exhibit> exhibits) {
                text1.setText("         " + exhibits.size());
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userName = userNameEditText.getText().toString();
                        contentViewModel.writeUserName(userName);
                    }
                });

            }
        });
        return root;
    }

    private boolean isUserNameFileExist() {
        for (String fileName : getContext().fileList()){
            if (fileName.equals(FILE_NAME)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

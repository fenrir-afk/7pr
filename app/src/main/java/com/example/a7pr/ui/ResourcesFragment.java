package com.example.a7pr.ui;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.a7pr.Data.Models.Exhibit;
import com.example.a7pr.R;
import com.example.a7pr.databinding.FragmentResourcesBinding;
import com.example.a7pr.ui.state_holder.ResourcesViewModel;

import java.io.File;
import java.util.List;

public class ResourcesFragment extends Fragment {
    private FragmentResourcesBinding binding;
    ListView listView;
    TextView text1;
    Button button;
    EditText userNameEditText;
    String userName ="";
    private int EXTERNAL_STORAGE_PERMISSION_CODE = 23;
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
                binding.button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (checkPermission()){
                            String editTextData = binding.editText2.getText().toString();
                            File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                            File file = new File(folder, "MuseumData.txt");
                            contentViewModel.writeTextData(file, editTextData);
                            binding.editText2.setText("");
                        }else {
                            requestPermission();
                            String editTextData = binding.editText2.getText().toString();
                            File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                            File file = new File(folder, "MuseumData.txt");
                            contentViewModel.writeTextData(file, editTextData);
                            binding.editText2.setText("");
                        }


                    }
                });
                binding.loadButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        binding.editText3.setText(contentViewModel.SharePrefLoadText());
                    }
                });
                binding.saveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        contentViewModel.SharePrefSaveText(binding.editText3.getText().toString());
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

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(getActivity(), "Write External Storage permission allows us to create files. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 200);
        }
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

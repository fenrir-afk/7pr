package com.example.a7pr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.a7pr.databinding.ActivityReg2Binding;
import com.example.a7pr.databinding.FragmentRegisterBinding;

public class RegActivity extends AppCompatActivity {
    FragmentRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_register);
        binding = FragmentRegisterBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        EditText editText = findViewById(R.id.edit1);
        TextView textView = findViewById(R.id.textView3);
        textView.setText("Имя");
        Intent intent = getIntent();
        if (intent != null){
            String action = intent.getAction();
            String type = intent.getType();
            String text = intent.getStringExtra(Intent.EXTRA_TEXT);
            editText.setText(text);

        }
        else{
            Log.e("Tag","Intent is empty");
        }
    }
}
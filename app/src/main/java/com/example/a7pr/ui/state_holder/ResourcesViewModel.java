package com.example.a7pr.ui.state_holder;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.a7pr.Data.Models.Exhibit;
import com.example.a7pr.Data.Repository.MuseumRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ResourcesViewModel extends AndroidViewModel {
    private final MuseumRepository museumRepository;
    private final MutableLiveData<String> mText;
    public static final String FILE_NAME = "user_name";

    public ResourcesViewModel(Application application) {
        super(application);
        this.museumRepository = new MuseumRepository();
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }
    public LiveData<List<Exhibit>> getExhibitList(){
        return museumRepository.getExhibitList();
    }


    public LiveData<String> getText() {
        return mText;
    }


    public void writeUserName(String userName){/////////
        try(FileOutputStream fos = getApplication().openFileOutput(FILE_NAME, Context.MODE_PRIVATE)) {
            fos.write(userName.getBytes());
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public String readUserName(){ ////////
        StringBuilder sb = new StringBuilder();
        String userName = "";
        try {
            FileInputStream fis = getApplication().openFileInput(FILE_NAME);
            InputStreamReader inputStreamReader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(inputStreamReader);
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            userName = sb.toString();
        }
        return userName.replace("\n","").replace("\r","");
    }

    public void writeTextData(File file, String data) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(data.getBytes());
            Toast.makeText(getApplication(), "Complete" + file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void SharePrefSaveText(String text){
        SharedPreferences sPref = getApplication().getSharedPreferences("pref",getApplication().MODE_PRIVATE);
        SharedPreferences.Editor ed  = sPref.edit();
        ed.putString("saved_text",text);
        ed.commit();
        Toast.makeText(getApplication(), "Text saved", Toast.LENGTH_SHORT).show();
    }
    public String SharePrefLoadText(){
        SharedPreferences sPref = getApplication().getSharedPreferences("pref",getApplication().MODE_PRIVATE);
        String savedText = sPref.getString("saved_text","");
        Toast.makeText(getApplication(), "Text loaded", Toast.LENGTH_SHORT).show();
        return savedText;

    }

}

package com.example.a7pr.ui.state_holder;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a7pr.Data.Models.Exhibit;
import com.example.a7pr.Data.Repository.MuseumRepository;

import java.util.List;

public class GalleryViewModel extends ViewModel {
    private final MuseumRepository museumRepository;
    private final MutableLiveData<String> mText;

    public GalleryViewModel() {
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
}
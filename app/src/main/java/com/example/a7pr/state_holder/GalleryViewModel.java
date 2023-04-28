package com.example.a7pr.state_holder;

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
        MutableLiveData<List<Exhibit>> ExhibitArray = new MutableLiveData<>();
        ExhibitArray.setValue(museumRepository.getExhibitList());
        return ExhibitArray;
    }
    public LiveData<String> getText() {
        return mText;
    }
}
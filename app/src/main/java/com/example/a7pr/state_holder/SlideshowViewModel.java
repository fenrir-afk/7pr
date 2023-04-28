package com.example.a7pr.state_holder;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a7pr.Data.Models.Exhibit;
import com.example.a7pr.Data.Repository.MuseumRepository;
import com.example.a7pr.ui.SlideshowFragment;

import java.util.List;

public class SlideshowViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final SlideshowFragment fragment;
    private final MuseumRepository museumRepository;

    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        fragment = new SlideshowFragment();
        museumRepository = new MuseumRepository();
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
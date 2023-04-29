package com.example.a7pr.Data.Repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.a7pr.Data.DataSource.MuseumDataSource;
import com.example.a7pr.Data.Models.Exhibit;

import java.util.List;

public class MuseumRepository  implements MuseumRepositoryInterface{
    private final MuseumDataSource museumDataSource;
    public MuseumRepository() {museumDataSource = new MuseumDataSource();}
    @Override
    public LiveData<List<Exhibit>> getExhibitList() {
        MutableLiveData<List<Exhibit>> ExhibitList =  new MutableLiveData<>();
        ExhibitList.setValue(museumDataSource.getExhibitList());
        return ExhibitList;
    }

    @Override
    public void addExhibit(Exhibit exhibit) {

    }

    @Override
    public void deleteExhibit(int id) {

    }
}

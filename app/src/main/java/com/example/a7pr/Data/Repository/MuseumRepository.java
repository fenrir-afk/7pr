package com.example.a7pr.Data.Repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.a7pr.Data.DataSource.MuseumDataSource;
import com.example.a7pr.Data.Models.Exhibit;

import java.util.ArrayList;
import java.util.List;

public class MuseumRepository  implements MuseumRepositoryInterface{
    private final MuseumDataSource museumDataSource;
    public MuseumRepository() {museumDataSource = new MuseumDataSource();}
    @Override
    public List<Exhibit> getExhibitList() {
        List<Exhibit> ExhibitList =  new ArrayList<>();
        ExhibitList =  museumDataSource.getExhibitList();
        return ExhibitList;
    }

    @Override
    public void addExhibit(Exhibit exhibit) {

    }

    @Override
    public void deleteExhibit(int id) {

    }
}

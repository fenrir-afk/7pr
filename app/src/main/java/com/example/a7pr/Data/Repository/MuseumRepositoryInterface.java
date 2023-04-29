package com.example.a7pr.Data.Repository;

import androidx.lifecycle.LiveData;

import com.example.a7pr.Data.Models.Exhibit;

import java.util.List;

public interface MuseumRepositoryInterface {
    LiveData<List<Exhibit>> getExhibitList();
    void addExhibit(Exhibit exhibit);
    void deleteExhibit(int id);
}

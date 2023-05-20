package com.example.a7pr.Data.DataSource;

import android.app.Application;

import com.example.a7pr.Data.Models.Exhibit;
import com.example.a7pr.R;

import java.util.ArrayList;
import java.util.List;

public class MuseumDataSource extends  Application{
    private final List<Exhibit> ExhibitList;

    public MuseumDataSource() {
        ExhibitList = new ArrayList<>();
        String[] ExhibitNames = {"Pyatnitskisaurus","Tarbosauros","Allosaurus","evoplocephalus","Apatosaurus","Dodo","Dunkleosteus","Sarcosuchus","Titanoboa"};
        int[] imgId = new int[]{R.drawable.piatnitzkysaurus, R.drawable.tarbo,R.drawable.allosauros,R.drawable.euoplocephalus,R.drawable.apatosaurus,R.drawable.dodo,R.drawable.dunkleo,R.drawable.sarko,R.drawable.snake};
        for (int i =0;i< ExhibitNames.length;i=i+1){
            Exhibit exhibit = new Exhibit(ExhibitNames[i],imgId[i]);
            ExhibitList.add(exhibit);
        }
    }
    public List<Exhibit> getExhibitList() {
        return ExhibitList;
    }

}

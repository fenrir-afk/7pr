package com.example.a7pr.Data.Room;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.a7pr.Data.Models.MainData;

import java.util.List;

@Dao
public interface UserDao {
    @Insert(onConflict = REPLACE)
    void insert(MainData mainData);
    @Delete
    void delete(MainData mainData);
    @Delete
    void reset(List<MainData> people);
    @Query("UPDATE table_name SET text = :sText WHERE ID = :sID")
    void update(int sID,String sText);
    @Query("SELECT * FROM table_name")
    List<MainData> getAll();
}

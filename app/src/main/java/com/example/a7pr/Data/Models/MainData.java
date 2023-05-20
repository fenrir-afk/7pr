package com.example.a7pr.Data.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_name")
public class MainData {
    @PrimaryKey(autoGenerate = true)
    public int ID;
    @ColumnInfo(name ="text")
    public String text;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getID() {
        return ID;
    }

    public String getText() {
        return text;
    }
}

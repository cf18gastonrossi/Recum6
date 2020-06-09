package com.example.recum6.model;

import android.database.Cursor;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface HotelDao {

    @Query("select * from hotel")
    Cursor getHoteles();

    @Insert
    void insert(Hotel hotel);

    @Query("update hotel set nombre = :nombre where cif = :cif")
    void update(String nombre, String cif);

    @Query("delete from hotel where cif = :cif")
    void delete(String cif);

    @Query("select * from hotel where cif = :cif")
    Hotel getHotelesByCif(String cif);


}

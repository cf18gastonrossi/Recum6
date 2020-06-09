package com.example.recum6.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface HotelDao {

    @Query("select * from hotel")
    List<Hotel> getHoteles();

    @Insert
    void insert(Hotel hotel);

    @Update
    void update(Hotel hotel);

    @Delete
    void delete(Hotel hotel);

    @Query("select * from hotel where cif = :cif")
    Hotel getHotelesByCif(String cif);


}

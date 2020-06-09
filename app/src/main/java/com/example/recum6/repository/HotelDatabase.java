package com.example.recum6.repository;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.recum6.model.Hotel;
import com.example.recum6.model.HotelDao;

@Database(entities = {Hotel.class}, version = 1)
public abstract class HotelDatabase extends RoomDatabase {
    public abstract HotelDao getHotelDao();
}

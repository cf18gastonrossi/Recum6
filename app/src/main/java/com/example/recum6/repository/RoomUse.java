package com.example.recum6.repository;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.room.Room;

import com.example.recum6.model.Hotel;
import com.example.recum6.model.HotelDao;

import java.util.List;

public class RoomUse {
    @SuppressLint("StaticFieldLeak")
    private static RoomUse room;

    private HotelDao hotelDao;

    private RoomUse(Context context) {
        Context appContext = context.getApplicationContext();
        HotelDatabase database = Room.databaseBuilder(appContext, HotelDatabase.class, "nota")
                .allowMainThreadQueries().build();
        hotelDao = database.getHotelDao();
    }

    public static RoomUse get(Context context) {
        if (room == null) {
            room = new RoomUse(context);
        }
        return room;
    }

    public List<Hotel> getHoteles() {
        return hotelDao.getHoteles();
    }

    public Hotel getHotelesByCif(String cif) {
        return hotelDao.getHotelesByCif(cif);
    }

    public void insert(Hotel hotel) {
        hotelDao.insert(hotel);
    }

    public void update(Hotel hotel) {
        hotelDao.update(hotel);
    }

    public void delete(Hotel hotel) {
        hotelDao.delete(hotel);
    }
}

package com.ahamed.digitalkot.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ahamed.digitalkot.dao.PanDao;
import com.ahamed.digitalkot.entites.Pizza;

@Database(entities = {Pizza.class}, version = 1)
public abstract class PanPizzaDatabase extends RoomDatabase {
    public abstract PanDao getPanDao();
    private static PanPizzaDatabase database;
    public static PanPizzaDatabase getDatabase(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context, PanPizzaDatabase.class,
                            "pan_pizza_db")
                    .allowMainThreadQueries()
                    .build();
            return database;
        }
        return database;
    }

}

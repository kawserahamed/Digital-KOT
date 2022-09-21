package com.ahamed.digitalkot.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ahamed.digitalkot.dao.CbDao;
import com.ahamed.digitalkot.entites.Cheesy;

@Database(entities = {Cheesy.class}, version = 1)
public abstract class CbDatabase extends RoomDatabase {

    public abstract CbDao getCBDao();

    private static CbDatabase database;

    public static CbDatabase getDatabase(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context, CbDatabase.class,
                            "cb_pizza_db")
                    .allowMainThreadQueries()
                    .build();
            return database;
        }
        return database;
    }
}

package com.jenyasubbotina.adoptme.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.jenyasubbotina.adoptme.db.dao.PetTypeDao;
import com.jenyasubbotina.adoptme.model.PetTypeModel;

//@Database(entities = {}, version = 8, exportSchema = false)
//public abstract class LocalDB extends RoomDatabase {
//    public static final String DATABASE_NAME = "adopt_me_local_database.db";
//    public abstract PetTypeDao petTypeDao();
//
//    private static volatile LocalDB instance;
//
//    public static LocalDB getInstance(final Context context) {
//        if (instance == null) {
//            synchronized (LocalDB.class) {
//                if (instance == null) {
//                    instance = Room.databaseBuilder(context.getApplicationContext(), LocalDB.class, DATABASE_NAME)
//                            .fallbackToDestructiveMigration()
//                            .addCallback(new Callback() {
//                                @Override
//                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
//                                    super.onCreate(db);
//                                }
//
//                                @Override
//                                public void onOpen(@NonNull SupportSQLiteDatabase db) {
//                                    super.onOpen(db);
//                                }
//                            }).build();
//                }
//            }
//        }
//        return instance;
//    }
//}

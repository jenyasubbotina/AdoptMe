package com.jenyasubbotina.adoptme.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.jenyasubbotina.adoptme.model.PetTypeModel;

import java.util.List;

@Dao
public interface PetTypeDao {
//    @Insert(onConflict = OnConflictStrategy.ABORT)
//    long insertContact(final PetTypeModel contact);
//
//    @Delete
//    int deleteContact(final PetTypeModel contact);

//    @Query("SELECT * FROM pet_type_list")
//    LiveData<List<PetTypeModel>> selectAllContacts();
}

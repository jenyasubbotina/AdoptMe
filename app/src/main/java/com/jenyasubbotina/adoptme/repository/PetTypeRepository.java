package com.jenyasubbotina.adoptme.repository;

import android.content.Context;

//import com.jenyasubbotina.adoptme.db.LocalDB;
import com.jenyasubbotina.adoptme.model.PetTypeModel;
import com.jenyasubbotina.adoptme.network.RetrofitClient;

import java.util.List;

import retrofit2.Callback;

public class PetTypeRepository {
    private final Context context;
    //private final LocalDB localDatabase;

    public PetTypeRepository(final Context context) {
        this.context = context;
        //this.localDatabase = LocalDB.getInstance(context);
    }

    public void fetchPetTypes(final Callback<List<PetTypeModel>> callback) {
        System.out.println("pet type repository");
        RetrofitClient.getInstance(context).setAuthorizationHeader(context);
        RetrofitClient.getInstance(context).getAvailablePetTypes(callback);
    }
}

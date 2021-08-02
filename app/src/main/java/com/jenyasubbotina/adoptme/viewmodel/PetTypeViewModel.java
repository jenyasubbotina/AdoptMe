package com.jenyasubbotina.adoptme.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.jenyasubbotina.adoptme.model.PetTypeModel;
import com.jenyasubbotina.adoptme.repository.PetTypeRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PetTypeViewModel extends ViewModel {
    private final PetTypeRepository petTypeRepository;
    private final MutableLiveData<List<PetTypeModel>> petTypeList;

    public PetTypeViewModel(final Context context) {
        this.petTypeRepository = new PetTypeRepository(context);
        this.petTypeList = new MutableLiveData<>();
    }

    public LiveData<List<PetTypeModel>> getPetTypesList() {
        return petTypeList;
    }

    public void getAvailablePetTypes() {
        petTypeRepository.fetchPetTypes(new Callback<List<PetTypeModel>>() {
            @Override
            public void onResponse(@NotNull Call<List<PetTypeModel>> call, @NotNull Response<List<PetTypeModel>> response) {
                System.out.println("response1");
                if (response.code() == 200) {
                    System.out.println("response");
                    List<PetTypeModel> petTypeModelList = response.body();
                    petTypeList.postValue(petTypeModelList);
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<PetTypeModel>> call, @NotNull Throwable t) {
                System.out.println(t.getMessage() + " message error");
            }
        });
    }
}

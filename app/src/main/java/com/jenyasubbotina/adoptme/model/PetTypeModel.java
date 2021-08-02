package com.jenyasubbotina.adoptme.model;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PetTypeModel {
    @Expose
    @SerializedName("_id")
    private final String id;

    @Expose
    @SerializedName("name")
    private final String name;

    @Expose
    @SerializedName("imgURL")
    private final String imgURL;

    public PetTypeModel(String id, String name, String imgURL) {
        this.id = id;
        this.name = name;
        this.imgURL = imgURL;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImgURL() {
        return imgURL;
    }
}

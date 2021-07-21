package com.jenyasubbotina.adoptme.ui.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterRequest {
    @Expose
    @SerializedName("firstname")
    String firstname;

    @Expose
    @SerializedName("lastname")
    String lastname;

    @Expose
    @SerializedName("username")
    String username;

    @Expose
    @SerializedName("locationId")
    Long locationId;

    @Expose
    @SerializedName("password")
    String password;

    public RegisterRequest(String firstname, String lastname, String username,
                           Long locationId, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.locationId = locationId;
        this.password = password;
    }
}

package com.jenyasubbotina.adoptme.ui.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterResponse {
    @Expose
    @SerializedName("result")
    private String result;
}

package com.example.myapplication.NetworkCall;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {
    @GET("/nzin01312019187360.json")
    Call<JsonObject> getNewIndDataIndNZ();

    @GET("/sapk01222019186652.json")
    Call<JsonObject> getNewIndDataSAPAK();
}


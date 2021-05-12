package com.example.mapboxsavefields.retrofit;

import com.example.mapboxsavefields.pojo.forServer.DataRequestSendField;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitApi {
    @POST("/api/farmers/api/cadast-fields")
    Call<Object> getSendNewField(@Body List<DataRequestSendField> fields);

}

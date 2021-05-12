package com.example.mapboxsavefields.request;

import android.util.Log;

import com.example.mapboxsavefields.pojo.Field;
import com.example.mapboxsavefields.pojo.forServer.DataRequestSendField;
import com.example.mapboxsavefields.retrofit.RetrofitApi;
import com.example.mapboxsavefields.retrofit.RetrofitApiUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SendNewField {
    public static void sendNewFields(List<Field> fields, SendFieldComplete sendFieldComplete) throws JSONException {
        /*RetrofitApiUtils retrofitApiUtils = new RetrofitApiUtils();
        RetrofitApi retrofitApi = retrofitApiUtils.getRetrofitApi();*/
        List<DataRequestSendField> dataRequestSendFields=new ArrayList<>();
        for(Field field:fields){
            DataRequestSendField dataRequestSendField=new DataRequestSendField();
            //dataRequestSendField.setFieldCadastralNumber(" ");
            dataRequestSendField.setFieldLon(field.getFieldLon());
            dataRequestSendField.setFieldLat(field.getFieldLat());
            dataRequestSendField.setFieldPoly(field.getFieldPoly());
            //dataRequestSendField.setHouseholdId(field.getHouseholdId());
            dataRequestSendField.setFieldName(field.getFieldName());
            dataRequestSendField.setCurrentCrop(field.getCurrentCrop());
            //dataRequestSendField.setHouseholdId(field.getHouseholdInfo().getId());
            //prev_crop

            dataRequestSendFields.add(dataRequestSendField);
            Gson gson=new Gson();
            String json=gson.toJson(dataRequestSendFields);
            System.out.println(json);
            List<Field> fieldList = new Gson().fromJson(json, new TypeToken<ArrayList<Field>>() {}.getType());

        }
       /* retrofitApi.getSendNewField(dataRequestSendFields).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Object fieldsResponse = response.body();
                if (response.isSuccessful() && fieldsResponse != null) {
                    Gson gson = new Gson();
                    String fieldSave = String.valueOf(gson.toJson(fieldsResponse));
                    sendFieldComplete.successfulSendFields(true, fieldSave, fields );
                } else {
                    try {
                        String errorRespbody = Objects.requireNonNull(response.errorBody()).string();
                        if (errorRespbody != null) {
                            sendFieldComplete.successfulSendFields(false, errorRespbody,fields);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.e("ERROR POST REQUEST", "--- UNSUCCESSFUL REQUEST TO SAVE FIELDS ---");
                Log.e("ERROR ", String.valueOf(t));
                Log.e("ERROR ", String.valueOf(call));
            }
        });*/
    }
}

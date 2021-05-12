package com.example.mapboxsavefields.retrofit;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.mapboxsavefields.App;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Objects;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.example.mapboxsavefields.Config;


public class RetrofitApiUtils {
    private static final String BASE_URL = Config.protocol + Config.IP;

    public RetrofitApiUtils() {

    }



    public RetrofitApi getRefreshRetrofitApi(String refreshToken) {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(chain -> {
            Request newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer " + refreshToken)
                    .build();
            return chain.proceed(newRequest);
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        return retrofitApi;
    }

    public RetrofitApi getRetrofitApi() {
        String token = App.agronom.getToken().getAccessToken();
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(chain -> {
            Request newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer " + token)
                    .build();
            return chain.proceed(newRequest);
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        return retrofitApi;
    }

    public static String editErrors(String answerServer) throws JSONException {
        Gson gson = new Gson();
        Log.e("!!!!!!!!!!!!!!!!!!!!", answerServer);
        JSONObject data = new JSONObject(answerServer);
        JSONArray errorslist = data.optJSONArray("errors");
        List<Error> errors = gson.fromJson(Objects.requireNonNull(errorslist).toString(), new TypeToken<List<Error>>() {
        }.getType());
        String discerror = "";
        for (Error error : errors) {
            discerror += error.getMessage();
            System.out.println(error.getMessage());
            discerror += '\n';
        }
        System.out.println(discerror);
        return discerror;
    }
}





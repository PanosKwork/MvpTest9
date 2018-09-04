package com.kwork.mvptest9.data;

import android.support.annotation.NonNull;
import android.util.Log;

import com.kwork.mvptest9.GankConfig;
import com.kwork.mvptest9.data.remote.GankAndroidApi;
import com.kwork.mvptest9.data.remote.GankAndroidClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Author：PanosKwork
 * Time：2018/8/20 14:32
 * Annotation：
 */
public class ResultRepository implements ResultDataSource {
    private List<Result> results;
    private AndroidData androidData;


    @Override
    public void loadResultData(final OnLoadResultDataCallback callback) {
         //Call<List<Result>> call = GankAndroidClient.getGankRetrofitInstance().getAndroidData(10,1);
        /*call.enqueue(new Callback<List<Result>>() {
             @Override
             public void onResponse(@NonNull Call<List<Result>> call, @NonNull Response<List<Result>> response) {
                 results = response.body();
                 callback.onComplete(results);
                // Log.e("++++++++++++++++++++",response.body().toString());
             }

             @Override
             public void onFailure(@NonNull Call<List<Result>> call, @NonNull Throwable t) {
                 //Log.e("---------------------","加载失败");
             }
         });*/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GankConfig.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GankAndroidApi androidApi = retrofit.create(GankAndroidApi.class);
        Call<AndroidData> call = androidApi.getAndroidData(10,1);
        call.enqueue(new Callback<AndroidData>() {
            @Override
            public void onResponse(@NonNull Call<AndroidData> call, @NonNull Response<AndroidData> response) {
                androidData = response.body();
                if (androidData!= null){
                    results = androidData.getResults();
                    callback.onComplete(results);
                }
                Log.e("---------------------","androidData为空");

            }

            @Override
            public void onFailure(@NonNull Call<AndroidData> call, @NonNull Throwable t) {
                Log.e("debug", "测试", t);
            }
        });

        /*Call<AndroidData> call = GankAndroidClient.getGankRetrofitInstance().getAndroidData(10,1);
        call.enqueue(new Callback<AndroidData>() {
            @Override
            public void onResponse(@NonNull Call<AndroidData> call, @NonNull Response<AndroidData> response) {
                androidData = response.body();
                results = androidData.getResults();
                callback.onComplete(results);
            }

            @Override
            public void onFailure(Call<AndroidData> call, Throwable t) {

            }
        });*/
    }
}

package com.kwork.mvptest9.data.remote;

import com.kwork.mvptest9.data.AndroidData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Author：PanosKwork
 * Time：2018/8/20 14:18
 * Annotation：
 */
public interface GankAndroidApi {
    @GET("data/Android/{count}/{page}")
    Call<AndroidData> getAndroidData(@Path("count") int count, @Path("page") int page);

}

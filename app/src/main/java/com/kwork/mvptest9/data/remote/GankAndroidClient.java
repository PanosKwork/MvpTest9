package com.kwork.mvptest9.data.remote;

import com.kwork.mvptest9.GankConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author：PanosKwork
 * Time：2018/8/20 14:33
 * Annotation：
 */
public class GankAndroidClient {
    private static GankAndroidApi gankAndroidApi;
    private static final Object monitor = new Object();
    private static Retrofit retrofit;

    /**
     * 私有的构造方法
     */
    private GankAndroidClient(){

    }

    static{
        retrofit = new Retrofit.Builder()
                //设置网络请求的Url地址
                .baseUrl(GankConfig.HOST)
                //设置数据解析器,使得来自接口的json结果会自动解析成定义好了的字段和类型都相符的json对象接受类
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * 获取实例的get方法
     * @return
     */
    public static GankAndroidApi getGankRetrofitInstance() {
        synchronized (monitor) {
            if (gankAndroidApi == null) {
                gankAndroidApi = retrofit.create(GankAndroidApi.class);
            }
            return gankAndroidApi;
        }
    }

}

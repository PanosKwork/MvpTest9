package com.kwork.mvptest9.data;

import java.util.List;

/**
 * Author：PanosKwork
 * Time：2018/8/20 14:28
 * Annotation：
 */
public interface ResultDataSource {
    void loadResultData(OnLoadResultDataCallback callback);
    interface OnLoadResultDataCallback{
        void onComplete(List<Result> resultList);
    }
}

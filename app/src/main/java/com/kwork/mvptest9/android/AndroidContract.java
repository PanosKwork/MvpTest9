package com.kwork.mvptest9.android;

import com.kwork.mvptest9.BasePresenter;
import com.kwork.mvptest9.BaseView;
import com.kwork.mvptest9.data.Result;

import java.util.List;

/**
 * Author：PanosKwork
 * Time：2018/8/20 14:45
 * Annotation：
 */
public interface AndroidContract {
    interface View extends BaseView<Presenter>{
        void showLoading();
        void showAndroidResults(List<Result> results);
    }

    interface Presenter extends BasePresenter{
        void loadAndroidResults();
    }
}

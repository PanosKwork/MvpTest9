package com.kwork.mvptest9.android;

import com.kwork.mvptest9.data.Result;
import com.kwork.mvptest9.data.ResultDataSource;
import com.kwork.mvptest9.data.ResultRepository;

import java.util.List;

/**
 * Author：PanosKwork
 * Time：2018/8/20 14:49
 * Annotation：
 */
public class AndroidPresenter implements AndroidContract.Presenter {
    private ResultRepository resultRepository;
    private AndroidContract.View view;

    public AndroidPresenter(AndroidContract.View view) {
        this.view = view;
        view.setPresenter(this);
        resultRepository = new ResultRepository();
    }

    @Override
    public void loadAndroidResults() {
        view.showLoading();
        resultRepository.loadResultData(new ResultDataSource.OnLoadResultDataCallback() {
            @Override
            public void onComplete(List<Result> resultList) {
                view.showAndroidResults(resultList);
            }
        });
    }

    @Override
    public void start() {
        loadAndroidResults();
    }
}

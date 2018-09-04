package com.kwork.mvptest9.android;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kwork.mvptest9.R;
import com.kwork.mvptest9.data.Result;
import com.kwork.mvptest9.data.ResultAdapter;

import java.util.List;

/**
 * Author：PanosKwork
 * Time：2018/8/20 11:48
 * Annotation：
 */
public class AndroidFragment extends Fragment implements AndroidContract.View{
    private AndroidContract.Presenter mPresenter;
    private RecyclerView recyclerView;

    public AndroidFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_android,container,false);
        recyclerView = view.findViewById(R.id.android_recycler_view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter = new AndroidPresenter(this);
        mPresenter.start();
    }

    @Override
    public void showLoading() {
        Toast.makeText(getActivity(), "正在加载....", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAndroidResults(List<Result> results) {
        ResultAdapter adapter = new ResultAdapter(results);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setPresenter(AndroidContract.Presenter presenter) {
        mPresenter = presenter;
    }
}

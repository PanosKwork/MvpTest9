package com.kwork.mvptest9.data;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kwork.mvptest9.R;

import java.util.List;

/**
 * Author：PanosKwork
 * Time：2018/8/20 15:08
 * Annotation：
 */
public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ViewHolder> {
    private List<Result> resultList;

    public ResultAdapter(List<Result> resultList) {
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.android_recycler_item_view,null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Result result = resultList.get(i);
        viewHolder.tv_time.setText(result.getCreatedAt());
        viewHolder.tv_title.setText(result.getDesc());
        viewHolder.tv_author.setText(result.getWho());
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_time,tv_title,tv_author;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_time = itemView.findViewById(R.id.tv_android_time);
            tv_title = itemView.findViewById(R.id.tv_android_title);
            tv_author = itemView.findViewById(R.id.tv_android_author);
        }
    }
}

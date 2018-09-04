package com.kwork.mvptest9.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Author：PanosKwork
 * Time：2018/8/20 14:11
 * Annotation：
 */
public class AndroidData {
    @SerializedName("error")
    private Boolean error;
    @SerializedName("results")
    private List<Result> results = null;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}

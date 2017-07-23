package com.swarawan.mvp.base.base;

/**
 * Created by rioswarawan on 9/1/16.
 */
public interface MvpView {

    void showLoading();

    void hideLoading();

    void onError(String message);
}

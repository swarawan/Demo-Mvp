package com.swarawan.mvp.view.student;

import android.text.TextUtils;

import com.swarawan.mvp.base.base.BasePresenter;

/**
 * Created by rioswarawan on 7/23/17.
 */

public class StudentPresenter extends BasePresenter<OnStudentListener> {

    @Override
    public void attachView(OnStudentListener mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void addStudent(StudentModel model) {
        checkViewAttached();
        getMvpView().showLoading();

        if (!isEmpty(model)) {
            getMvpView().onError("Form tidak boleh kosong");
        } else {
            getMvpView().onStudentAdded(model);
        }
        getMvpView().hideLoading();
    }

    private boolean isEmpty(StudentModel model) {
        if (TextUtils.isEmpty(model.nim))
            return false;
        if (TextUtils.isEmpty(model.name))
            return false;
        if (TextUtils.isEmpty(model.address))
            return false;
        return true;
    }
}

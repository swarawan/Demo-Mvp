package com.swarawan.mvp.view.login;

import android.text.TextUtils;

import com.swarawan.mvp.base.base.BasePresenter;

/**
 * Created by rioswarawan on 7/23/17.
 */

public class LoginPresenter extends BasePresenter<OnLoginListener> {

    @Override
    public void attachView(OnLoginListener mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void doLogin(LoginModel model) {
        checkViewAttached();
        getMvpView().showLoading();

        if (!isEmpty(model)) {
            getMvpView().onError("Email dan password tidak boleh kosong");
        } else {
            if (!validate(model)) {
                getMvpView().onError("Email dan password tidak cocok. Coba lagi...");
            } else {
                getMvpView().onLoginSuccess();
            }
        }
        getMvpView().hideLoading();
    }

    private boolean validate(LoginModel model) {
        if (!model.email.equalsIgnoreCase("user@example.com")) {
            return false;
        } else if (!model.password.equalsIgnoreCase("12345678")) {
            return false;
        }
        return true;
    }

    private boolean isEmpty(LoginModel model) {
        if (TextUtils.isEmpty(model.email))
            return false;
        if (TextUtils.isEmpty(model.password))
            return false;
        return true;
    }
}

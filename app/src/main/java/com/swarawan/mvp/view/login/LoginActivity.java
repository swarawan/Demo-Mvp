package com.swarawan.mvp.view.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.swarawan.mvp.R;
import com.swarawan.mvp.view.student.StudentActivity;

public class LoginActivity extends AppCompatActivity {

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter();
        presenter.attachView(onLoginListener);

        findViewById(R.id.btn_login).setOnClickListener(onLoginClicked);
    }

    private View.OnClickListener onLoginClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            LoginModel model = new LoginModel();
            model.email = ((EditText) findViewById(R.id.input_email)).getText().toString();
            model.password = ((EditText) findViewById(R.id.input_password)).getText().toString();

            presenter.doLogin(model);
        }
    };

    private OnLoginListener onLoginListener = new OnLoginListener() {
        @Override
        public void onLoginSuccess() {
            startActivity(new Intent(LoginActivity.this, StudentActivity.class));
        }

        @Override
        public void showLoading() {
            // add dialog show here
        }

        @Override
        public void hideLoading() {
            // add dialog dismiss here
        }

        @Override
        public void onError(String message) {
            Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
        }
    };
}

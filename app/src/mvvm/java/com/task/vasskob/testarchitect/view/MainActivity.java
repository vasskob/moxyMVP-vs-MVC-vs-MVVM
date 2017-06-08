package com.task.vasskob.testarchitect.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.task.vasskob.testarchitect.R;
import com.task.vasskob.testarchitect.controller.MainView;
import com.task.vasskob.testarchitect.presenter.MyPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.tv_msg)
    TextView tvMsg;

    @BindView(R.id.iv_avatar)
    ImageView ivAvatar;
    private MyPresenterImpl presenter;

    @SuppressWarnings("unused")
    @OnClick(R.id.btn_say_hello)
    void onBtnClick() {
        Log.d(TAG, "onBtnClick: ");
        presenter.showMsg("!!!");
        presenter.showAvatar();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MyPresenterImpl(this);
    }

    @Override
    public void showMessage(String msg) {
        tvMsg.setText(msg);
    }

    @Override
    public void showAvatar(String avatar) {
        Glide.with(this)
                .load(avatar)
                .into(ivAvatar);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}

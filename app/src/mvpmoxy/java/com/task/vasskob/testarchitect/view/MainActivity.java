package com.task.vasskob.testarchitect.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bumptech.glide.Glide;
import com.task.vasskob.testarchitect.R;
import com.task.vasskob.testarchitect.controller.MainView;
import com.task.vasskob.testarchitect.presenter.MyPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.tv_msg)
    TextView tvMsg;

    @BindView(R.id.iv_avatar)
    ImageView ivAvatar;

    @SuppressWarnings("unused")
    @OnClick(R.id.btn_say_hello)
    void onBtnClick() {
        Log.d(TAG, "onBtnClick: ");
        presenter.showMsg("!!!");
        presenter.showPhoto();
    }

    @InjectPresenter
    MyPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void showMessage(String msg) {
        tvMsg.setText(String.format(getString(R.string.message), msg));
    }

    @Override
    public void showPhoto(String avatar) {
        Glide.with(this)
                .load(avatar)
                .into(ivAvatar);
    }
}

package com.task.vasskob.testarchitect.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.task.vasskob.testarchitect.R;
import com.task.vasskob.testarchitect.presenter.MyPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.task.vasskob.testarchitect.Constants.STATE_MSG;
import static com.task.vasskob.testarchitect.Constants.STATE_Photo;

public class MainActivity extends AppCompatActivity implements MainView {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.tv_msg)
    TextView tvMsg;

    @BindView(R.id.iv_avatar)
    ImageView ivAvatar;
    private MyPresenterImpl presenter;
    private String msg;
    private String photo;

    @SuppressWarnings("unused")
    @OnClick(R.id.btn_say_hello)
    void onBtnClick() {
        Log.d(TAG, "onBtnClick: ");
        presenter.showUserName();
        presenter.showUserPhoto();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (presenter == null) {
            presenter = new MyPresenterImpl(this);
        }
    }

    @Override
    public void showMessage(String msg) {
        this.msg = msg;
        String message = String.format(getString(R.string.message), msg);
        tvMsg.setText(message);
    }

    @Override
    public void showPhoto(String photo) {
        this.photo = photo;
        Glide.with(this)
                .load(photo)
                .into(ivAvatar);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_MSG, msg);
        outState.putString(STATE_Photo, photo);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        showMessage(savedInstanceState.getString(STATE_MSG));
        showPhoto(savedInstanceState.getString(STATE_Photo));
    }
}

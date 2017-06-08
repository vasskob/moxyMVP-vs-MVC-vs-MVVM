package com.task.vasskob.testarchitect.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.task.vasskob.testarchitect.R;
import com.task.vasskob.testarchitect.model.User;
import com.task.vasskob.testarchitect.view.CustomTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.task.vasskob.testarchitect.Constants.MICHAEL_AVATAR;
import static com.task.vasskob.testarchitect.Constants.MICHAEL_NAME;
import static com.task.vasskob.testarchitect.Constants.STATE_MSG;
import static com.task.vasskob.testarchitect.Constants.STATE_Photo;

// Activity is a Controller & View in the same time
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.tv_msg)
    CustomTextView tvMsg;

    @BindView(R.id.iv_avatar)
    ImageView ivAvatar;
    private User user;
    private String msg;
    private String photo;

    @OnClick(R.id.btn_say_hello)
    void onBtnClick() {
        msg = String.format(getResources().getString(R.string.message), user.getName());
        photo = user.getAvatarURL();
        showMessage(msg);
        showPhoto(photo);
    }

    private void showMessage(String msg) {
        tvMsg.setText(msg);
    }

    private void showPhoto(String photo) {
        Glide.with(this)
                .load(photo)
                .into(ivAvatar);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        user = new User(1, MICHAEL_NAME, MICHAEL_AVATAR);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: msg= " + msg);
        outState.putString(STATE_MSG, msg);
        outState.putString(STATE_Photo, photo);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        msg = savedInstanceState.getString(STATE_MSG);
        photo = savedInstanceState.getString(STATE_Photo);
        showMessage(msg);
        showPhoto(photo);
    }
}

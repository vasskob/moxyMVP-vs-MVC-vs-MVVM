package com.task.vasskob.testarchitect.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.task.vasskob.testarchitect.BR;
import com.task.vasskob.testarchitect.R;
import com.task.vasskob.testarchitect.model.UserMVVM;

import static com.task.vasskob.testarchitect.Constants.MICHAEL_AVATAR;
import static com.task.vasskob.testarchitect.Constants.MICHAEL_NAME;

public class MainViewModel extends BaseObservable {

    public UserMVVM user;
    private String temp;

    @Bindable
    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
        notifyPropertyChanged(BR.temp);
    }

    public MainViewModel() {
        user = new UserMVVM();
    }

    public void onBtnClick(View v) {
        user.setUserID(1);
        user.setName(MICHAEL_NAME);
        user.setAvatarURL(MICHAEL_AVATAR);
        setTemp(String.format(v.getResources().getString(R.string.message), user.getName()));
    }

    @BindingAdapter({"imageUrl"})
    public static void setImageUrl(ImageView view, String imageUrl) {
        Glide.with(view.getContext()).load(imageUrl).into(view);
    }
}

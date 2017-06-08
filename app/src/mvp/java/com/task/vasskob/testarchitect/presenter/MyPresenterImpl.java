package com.task.vasskob.testarchitect.presenter;

import com.task.vasskob.testarchitect.controller.MainView;
import com.task.vasskob.testarchitect.model.User;

import static com.task.vasskob.testarchitect.Constants.MICHAEL_AVATAR;
import static com.task.vasskob.testarchitect.Constants.MICHAEL_NAME;


public class MyPresenterImpl implements MyPresenter {
    private User user;
    private MainView view;

    public MyPresenterImpl(MainView view) {
        if (user == null) {
            user = new User(1, MICHAEL_NAME, MICHAEL_AVATAR);
        }
        this.view = view;
    }

    @Override
    public void showUserName() {
        view.showMessage(user.getName());
    }

    @Override
    public void showUserPhoto() {
        view.showPhoto(user.getAvatarURL());
    }

    @Override
    public void onDestroy() {
        view = null;
    }
}

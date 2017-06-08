package com.task.vasskob.testarchitect.presenter;

import com.task.vasskob.testarchitect.controller.MainView;
import com.task.vasskob.testarchitect.model.User;

import static com.task.vasskob.testarchitect.Constants.MICHAEL_AVATAR;


public class MyPresenterImpl implements MyPresenter {
    private User user;
    private MainView view;

    public MyPresenterImpl(MainView view) {
        if (user == null) {
            user = new User(1, "Michael", MICHAEL_AVATAR);
        }
        this.view = view;
    }

    @Override
    public void showMsg(String msg) {
        view.showMessage("Hallo Man! " + user.getName() + " is here");
    }

    @Override
    public void showAvatar() {
        view.showAvatar(user.getAvatarURL());
    }

    @Override
    public void onDestroy() {
        view = null;
    }
}

package com.task.vasskob.testarchitect.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.task.vasskob.testarchitect.view.MainView;
import com.task.vasskob.testarchitect.model.User;

import static com.task.vasskob.testarchitect.Constants.MICHAEL_AVATAR;
import static com.task.vasskob.testarchitect.Constants.MICHAEL_NAME;

@InjectViewState
public class MyPresenterImpl extends MvpPresenter<MainView> implements MyPresenter {
    private User user;

    public MyPresenterImpl() {
        if (user == null) {
            user = new User(1, MICHAEL_NAME, MICHAEL_AVATAR);
        }
    }

    @Override
    public void showMsg(String msg) {
        getViewState().showMessage(user.getName());
    }

    @Override
    public void showPhoto() {
        getViewState().showPhoto(user.getAvatarURL());
    }
}

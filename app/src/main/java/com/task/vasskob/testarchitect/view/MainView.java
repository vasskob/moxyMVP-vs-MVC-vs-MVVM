package com.task.vasskob.testarchitect.view;

import com.arellomobile.mvp.MvpView;

public interface MainView extends MvpView {
    void showMessage(String msg);

    void showPhoto(String avatar);
}

package com.task.vasskob.testarchitect.controller;

import com.arellomobile.mvp.MvpView;

public interface MainView extends MvpView {
    void showMessage(String msg);
    void showPhoto(String avatar);
}

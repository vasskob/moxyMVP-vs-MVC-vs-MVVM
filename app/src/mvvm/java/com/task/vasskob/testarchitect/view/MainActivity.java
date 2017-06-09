package com.task.vasskob.testarchitect.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.task.vasskob.testarchitect.R;
import com.task.vasskob.testarchitect.databinding.ActivityMainBinding;
import com.task.vasskob.testarchitect.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_USER = "user";
    private static final String TAG = MainActivity.class.getSimpleName();
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
    }

    private void initDataBinding() {
        // ActivityMainBinding name consist of layout name + Binding
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new MainViewModel();
        // setViewModel consist of set + layout data variable name
        binding.setViewModel(viewModel);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: userName=" + viewModel.user.getName());
        outState.putParcelable(KEY_USER, viewModel.user);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        viewModel.user = savedInstanceState.getParcelable(KEY_USER);
        viewModel.setTemp(String.format(getResources().getString(R.string.message), viewModel.user.getName()));
    }
}

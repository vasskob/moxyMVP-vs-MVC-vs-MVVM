package com.task.vasskob.testarchitect.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.task.vasskob.testarchitect.R;
import com.task.vasskob.testarchitect.databinding.ActivityMainBinding;
import com.task.vasskob.testarchitect.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
    }

    private void initDataBinding() {
        // ActivityMainBinding name consist of layout name + Binding
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainViewModel viewModel = new MainViewModel(this);
        // setViewModel consist of set + layout data variable name
        binding.setViewModel(viewModel);
    }

}

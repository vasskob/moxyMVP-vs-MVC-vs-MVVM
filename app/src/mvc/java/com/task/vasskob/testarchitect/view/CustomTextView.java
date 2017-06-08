package com.task.vasskob.testarchitect.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.task.vasskob.testarchitect.R;


public class CustomTextView extends android.support.v7.widget.AppCompatTextView {

    public CustomTextView(Context context) {
        super(context);
        initFont();
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initFont();
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFont();
    }

    private void initFont() {
        setCustomTypeFace(getResources().getString(R.string.pacifico_regular));
    }

    private void setCustomTypeFace(String typeFaceAssetPath) {
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), typeFaceAssetPath);
        setTypeface(typeface);
    }
}

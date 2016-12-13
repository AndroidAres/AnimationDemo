package com.ares.animationdemo.drawable_animation;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ares.animationdemo.R;
import com.ares.animationdemo.databinding.ActivityDrawableAnimationBinding;

public class DrawableAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDrawableAnimationBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_drawable_animation);
    }
}

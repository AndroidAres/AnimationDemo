package com.ares.animationdemo;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ares.animationdemo.view_animation.ViewAnimationActivity;
import com.ares.animationdemo.view_animation.activity.AlphaAnimationActivity;
import com.ares.animationdemo.view_animation.activity.RotateAnimationActivity;
import com.ares.animationdemo.view_animation.activity.ScaleAnimationActivity;
import com.ares.animationdemo.view_animation.activity.TranslateAnimationActivity;
import com.ares.animationdemo.databinding.ActivityMainBinding;

/**
 * 首页展示
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setPresenter(new Presenter(this));
    }

    public class Presenter{

        Activity activity;

        public Presenter(Activity activity) {
            this.activity = activity;
        }

        public void onClick(int position){
            Intent intent = null;
            switch (position){
                case 0:
                    intent = new Intent(MainActivity.this, ViewAnimationActivity.class);
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
            activity.startActivity(intent);
        }
    }
}

package com.ares.animationdemo;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.ares.animationdemo.activity.AlphaAnimationActivity;
import com.ares.animationdemo.activity.RotateAnimationActivity;
import com.ares.animationdemo.activity.ScaleAnimationActivity;
import com.ares.animationdemo.activity.TranslateAnimationActivity;
import com.ares.animationdemo.databinding.ActivityMainBinding;

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
                    intent = new Intent(activity, AlphaAnimationActivity.class);
                    break;
                case 1:
                    intent = new Intent(activity, RotateAnimationActivity.class);
                    break;
                case 2:
                    intent = new Intent(activity, ScaleAnimationActivity.class);
                    break;
                case 3:
                    intent = new Intent(activity, TranslateAnimationActivity.class);
                    break;
            }
            activity.startActivity(intent);
        }
    }
}

package com.ares.animationdemo.view_animation;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ares.animationdemo.R;
import com.ares.animationdemo.databinding.ActivityViewAnimationBinding;
import com.ares.animationdemo.view_animation.activity.AlphaAnimationActivity;
import com.ares.animationdemo.view_animation.activity.RotateAnimationActivity;
import com.ares.animationdemo.view_animation.activity.ScaleAnimationActivity;
import com.ares.animationdemo.view_animation.activity.TranslateAnimationActivity;

public class ViewAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityViewAnimationBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_view_animation);
        binding.setPresenter(new ViewAnimationPresenter());
    }

    public class ViewAnimationPresenter{
        public void onClick(int position){
            Intent intent = null;
            switch (position){
                case 0:
                    intent = new Intent(ViewAnimationActivity.this, AlphaAnimationActivity.class);
                    break;
                case 1:
                    intent = new Intent(ViewAnimationActivity.this, RotateAnimationActivity.class);
                    break;
                case 2:
                    intent = new Intent(ViewAnimationActivity.this, ScaleAnimationActivity.class);
                    break;
                case 3:
                    intent = new Intent(ViewAnimationActivity.this, TranslateAnimationActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}

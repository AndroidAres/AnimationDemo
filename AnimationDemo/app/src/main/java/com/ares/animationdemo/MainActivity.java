package com.ares.animationdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ares.animationdemo.view_animation.ViewAnimationActivity;

/**
 * 首页展示
 */
public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.activity_main_btn_view).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.activity_main_btn_view:
                intent = new Intent(MainActivity.this, ViewAnimationActivity.class);
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
        startActivity(intent);
    }
}

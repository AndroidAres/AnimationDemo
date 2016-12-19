package com.ares.animationdemo.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import java.util.Stack;

/**
 * 自定义Application
 * Created by Ares on 2016/12/19/019.
 */

public class MyApplication extends Application {

    private static Stack<Activity> activityStack;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        activityStack = new Stack<>();
        this.context = this.getApplicationContext();
    }

    public static Context getContext(){ return context; }

    public static void addActivity(Activity activity){
        if (activity != null) {
            activityStack.add(activity);
        }
    }

    public static void removeActivity(Activity activity){
        if (activity == null) {
            return;
        }
        for (Activity act : activityStack) {
            if (act.getClass().getSimpleName().equals(activity.getClass().getSimpleName())) {
                activityStack.remove(activity);
            }
        }
    }

    public static void finishAllAct(){
        for (Activity act : activityStack) {
            act.finish();
        }
        activityStack.clear();
    }

    public static void exit(){
        finishAllAct();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}

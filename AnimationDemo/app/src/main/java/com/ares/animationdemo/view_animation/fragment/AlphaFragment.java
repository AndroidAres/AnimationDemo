package com.ares.animationdemo.view_animation.fragment;

import android.animation.Animator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ares.animationdemo.R;
import com.ares.animationdemo.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Ares on 2016/12/16.
 */

public class AlphaFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener,CompoundButton.OnCheckedChangeListener{

    /**   动画公共属性 */
    @BindView(R.id.layout_constant_iv_graph)
    ImageView graphIV;
    @BindView(R.id.layout_constant_cb_detachwallpaper)
    CheckBox detachWallpaperCB;
    @BindView(R.id.layout_constant_cb_fillafter)
    CheckBox fillAfterCB;
    @BindView(R.id.layout_constant_cb_fillbefore)
    CheckBox fillBeforeCB;
    @BindView(R.id.layout_constant_cb_fillenable)
    CheckBox fillEnableCB;
    @BindView(R.id.layout_constant_rb_restart)
    RadioButton reStartRB;
    @BindView(R.id.layout_constant_rb_reverse)
    RadioButton reVerseRB;
    @BindView(R.id.layout_constant_rb_normal)
    RadioButton nomalRB;
    @BindView(R.id.layout_constant_rb_bottom)
    RadioButton bottomRB;
    @BindView(R.id.layout_constant_rb_top)
    RadioButton topRB;
    @BindView(R.id.layout_constant_et_repeatcount)
    EditText repeatCountET;
    @BindView(R.id.layout_constant_et_duration)
    EditText durationET;
    @BindView(R.id.layout_constant_et_startoffset)
    EditText startOffsetET;
    /**  Alpha动画特有属性 */
    @BindView(R.id.fragment_alpha_et_fromalpha)
    EditText fromAlphaET;
    @BindView(R.id.fragment_alpha_et_toalpha)
    EditText toAlphaET;

    private int repeatCount = 0,duration = 3000,startOffset = 0;
    private float fromAlpha = 1.0f,toAlpha = 0.0f;
    private AlphaAnimation alphaAnimation;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_alpha;
    }

    @Override
    protected void initParams() {
        alphaAnimation = (AlphaAnimation) AnimationUtils.loadAnimation(getActivity(),R.anim.anim_alpha);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        graphIV.setAnimation(alphaAnimation);

        detachWallpaperCB.setOnCheckedChangeListener(this);
        fillAfterCB.setOnCheckedChangeListener(this);
        fillBeforeCB.setOnCheckedChangeListener(this);
        fillEnableCB.setOnCheckedChangeListener(this);
        reStartRB.setOnCheckedChangeListener(this);
        reVerseRB.setOnCheckedChangeListener(this);
        nomalRB.setOnCheckedChangeListener(this);
        bottomRB.setOnCheckedChangeListener(this);
        topRB.setOnCheckedChangeListener(this);
        repeatCountET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                repeatCount = TextUtils.isEmpty(editable.toString()) ? 0 : Integer.parseInt(editable.toString());
                alphaAnimation.setRepeatCount(repeatCount);
            }
        });
        durationET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                duration = TextUtils.isEmpty(editable.toString()) ? 3000 : Integer.parseInt(editable.toString());
                alphaAnimation.setDuration(duration);
            }
        });
        startOffsetET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                startOffset = TextUtils.isEmpty(editable.toString()) ? 0 : Integer.parseInt(editable.toString());
                alphaAnimation.setStartOffset(startOffset);
            }
        });
        fromAlphaET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                fromAlpha = TextUtils.isEmpty(editable.toString()) ? 1.0f : Float.parseFloat(editable.toString());
                toAlpha = TextUtils.isEmpty(editable.toString()) ? 0.0f : Float.parseFloat(editable.toString());
//                alphaAnimation = new AlphaAnimation(fromAlpha,toAlpha);
            }
        });
        toAlphaET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                fromAlpha = TextUtils.isEmpty(editable.toString()) ? 1.0f : Float.parseFloat(editable.toString());
                toAlpha = TextUtils.isEmpty(editable.toString()) ? 0.0f : Float.parseFloat(editable.toString());
//                alphaAnimation = new AlphaAnimation(fromAlpha,toAlpha);
            }
        });
    }

    @OnClick(R.id.layout_constant_iv_graph)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.layout_constant_iv_graph:
                view.startAnimation(alphaAnimation);
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.layout_constant_rb_restart:
                alphaAnimation.setRepeatMode(AlphaAnimation.RESTART);
                break;
            case R.id.layout_constant_rb_reverse:
                alphaAnimation.setRepeatMode(AlphaAnimation.REVERSE);
                break;
            case R.id.layout_constant_rb_normal:
                alphaAnimation.setZAdjustment(AlphaAnimation.ZORDER_NORMAL);
                break;
            case R.id.layout_constant_rb_bottom:
                alphaAnimation.setZAdjustment(AlphaAnimation.ZORDER_BOTTOM);
                break;
            case R.id.layout_constant_rb_top:
                alphaAnimation.setZAdjustment(AlphaAnimation.ZORDER_TOP);
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()){
            case R.id.layout_constant_cb_detachwallpaper:
                alphaAnimation.setDetachWallpaper(detachWallpaperCB.isChecked());
                break;
            case R.id.layout_constant_cb_fillafter:
                alphaAnimation.setFillAfter(fillAfterCB.isChecked());
                break;
            case R.id.layout_constant_cb_fillbefore:
                alphaAnimation.setFillBefore(fillBeforeCB.isChecked());
                break;
            case R.id.layout_constant_cb_fillenable:
                alphaAnimation.setFillEnabled(fillEnableCB.isChecked());
                break;
        }
    }
}

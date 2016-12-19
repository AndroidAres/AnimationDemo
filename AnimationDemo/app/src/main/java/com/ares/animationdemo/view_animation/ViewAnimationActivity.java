package com.ares.animationdemo.view_animation;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.widget.TableLayout;

import com.ares.animationdemo.R;
import com.ares.animationdemo.adapter.MyFragmentPagerAdapter;
import com.ares.animationdemo.base.BaseActivity;
import com.ares.animationdemo.view_animation.fragment.AlphaFragment;
import com.ares.animationdemo.view_animation.fragment.RotateFragment;
import com.ares.animationdemo.view_animation.fragment.ScaleFragment;
import com.ares.animationdemo.view_animation.fragment.TranslateFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ViewAnimationActivity extends BaseActivity implements TabLayout.OnTabSelectedListener{

    @BindView(R.id.activity_view_animation_tablayout)
    TabLayout tabLayout;
    @BindView(R.id.activity_view_animation_viewpager)
    ViewPager viewPager;

    private List<Fragment> fragmentList;
    private AlphaFragment alphaFragment;
    private RotateFragment rotateFragment;
    private ScaleFragment scaleFragment;
    private TranslateFragment translateFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_view_animation;
    }

    @Override
    protected void initParams() {
        /**  准备选项卡数据 */
        String[] title = new String[]{getString(R.string.alpha_animation),
                getString(R.string.rotate_animation),
                getString(R.string.scale_animation),
                getString(R.string.translate_animation)};

        fragmentList = new ArrayList<>();
        alphaFragment = new AlphaFragment();
        rotateFragment = new RotateFragment();
        scaleFragment = new ScaleFragment();
        translateFragment = new TranslateFragment();
        fragmentList.add(alphaFragment);
        fragmentList.add(rotateFragment);
        fragmentList.add(scaleFragment);
        fragmentList.add(translateFragment);

        /** 绑定选项卡数据 */
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),this,title,fragmentList);
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(this);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}

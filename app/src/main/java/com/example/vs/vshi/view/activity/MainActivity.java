package com.example.vs.vshi.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.vs.vshi.R;
import com.example.vs.vshi.utils.BottomNavigationViewHelper;
import com.example.vs.vshi.view.fragment.ChoicenessFragment;
import com.example.vs.vshi.view.fragment.FindFragment;
import com.example.vs.vshi.view.fragment.LiveFragment;
import com.example.vs.vshi.view.fragment.MineFragment;
import com.example.vs.vshi.view.fragment.SpecialFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.contenet)
    FrameLayout contenet;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;
    private List<Fragment> fragments;
    private int lastShowFragment=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //沉浸式的代码
        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(option);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        BottomNavigationViewHelper.disableShiftMode(bottomNavigation);
        bottomNavigation.setOnNavigationItemSelectedListener(this);
        initFragment();

    }

    private void initFragment() {
        fragments=new ArrayList<>();
        fragments.add(new ChoicenessFragment());
        fragments.add(new SpecialFragment());
        fragments.add(new FindFragment());
        fragments.add(new MineFragment());
        fragments.add(new LiveFragment());

        lastShowFragment=0;
        /**
         * 在 Activity 中加载第一个 Fragment
         */
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contenet,fragments.get(0))
                .show(fragments.get(0))
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                if(lastShowFragment!=0){
                    replaceFragment(lastShowFragment,0);
                    lastShowFragment=0;
                }
                break;
            case R.id.community:
                if(lastShowFragment!=1){
                    replaceFragment(lastShowFragment,1);
                    lastShowFragment=1;
                }
                break;
            case R.id.rebate:
                if(lastShowFragment!=2){
                    replaceFragment(lastShowFragment,2);
                    lastShowFragment=2;
                }
                break;
            case R.id.shopcar:
                if(lastShowFragment!=3){
                    replaceFragment(lastShowFragment,3);
                    lastShowFragment=3;
                }
                break;
            case R.id.mine:
                if(lastShowFragment!=4){
                    replaceFragment(lastShowFragment,4);
                    lastShowFragment=4;
                }
                break;
        }
        // 默认 false
        // false 的话 下面颜色不会变化
        return true;
    }
    //替换碎片
    private void replaceFragment(int lastShowFragment,int index){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments.get(lastShowFragment));
        // 确认需要的 Fragment 是否已添加
        if(!fragments.get(index).isAdded()){
            transaction.add(R.id.contenet, fragments.get(index));
        }
        transaction.show(fragments.get(index)).commitAllowingStateLoss();
    }
}

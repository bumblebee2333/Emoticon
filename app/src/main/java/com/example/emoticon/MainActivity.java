package com.example.emoticon;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.emoticon.Fragment.CreativeFragment;
import com.example.emoticon.Fragment.EmoticonFragment;
import com.example.emoticon.Fragment.MyFragment;
import com.example.emoticon.Fragment.PaintFragment;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView navigation;
    private EmoticonFragment mEmoticonFragment;
    private CreativeFragment mCreativeFragment;
    private PaintFragment mPaintFragment;
    private MyFragment myFragment;
    private Fragment[] fragments;//fragment数组
    private int lastShowFragment;//表示最后一个显示的Fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            getWindow().setStatusBarColor(Color.parseColor("#FFFF00"));
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        //隐藏ActionBar
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        navigation = findViewById(R.id.bottomNavigation);
        initFragments();//初始化Fragment数组，将四个碎片加入
        //底部导航栏的点击事件
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.
                OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_emoticon:
                        if(lastShowFragment!=0){
                            switchFragment(lastShowFragment,0);
                            lastShowFragment=0;
                        }
                        return true;
                    case R.id.navigation_DIY:
                        if(lastShowFragment!=1){
                            switchFragment(lastShowFragment,1);
                            lastShowFragment=1;
                        }
                        return true;
                    case R.id.navigation_paint:
                        if(lastShowFragment!=2){
                            switchFragment(lastShowFragment,2);
                            lastShowFragment=2;
                        }
                        return true;
                    case R.id.navigation_my:
                        if(lastShowFragment!=3){
                            switchFragment(lastShowFragment,3);
                            lastShowFragment=3;
                        }
                        return true;
                }
                return false;
            }
        });
    }

    public void initFragments(){
        mEmoticonFragment=new EmoticonFragment();
        mCreativeFragment=new CreativeFragment();
        mPaintFragment=new PaintFragment();
        myFragment=new MyFragment();
        fragments=new Fragment[]{mEmoticonFragment,mCreativeFragment,mPaintFragment,myFragment};
        lastShowFragment=0;
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_container,mEmoticonFragment)
                .show(mEmoticonFragment)
                .commit();
    }
    //判断Fragment 上一个隐藏 下一个显示
    private void switchFragment(int lastIndex, int index){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastIndex]);
        if(!fragments[index].isAdded()){
            transaction.add(R.id.main_container,fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();
    }
}


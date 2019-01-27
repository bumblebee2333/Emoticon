package com.example.emoticon.Fragment;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.emoticon.R;

public class MyFragment extends Fragment {
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDawerToggle;
    private ListView mListView;
    private String[] menus=new String[]{"我的收藏"};
    private ArrayAdapter arrayAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_fragment,container,false);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //获取控件
        mToolbar = getActivity().findViewById(R.id.toolbar);
        mDrawerLayout = getActivity().findViewById(R.id.drawerLayout);
        mListView = getActivity().findViewById(R.id.list_item);
        //设置ToolBar支持actionbar
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        mToolbar.setTitle("我");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //创建返回键 并实现打开关、闭监听
        //mDrawerLayout.setScrimColor(Color.parseColor("#ffffff"));
        mDawerToggle = new ActionBarDrawerToggle(getActivity(),mDrawerLayout,mToolbar,0,0){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDawerToggle.syncState();//将左上角的图标和侧滑监听进行联动 达到动画效果显示
        mDrawerLayout.addDrawerListener(mDawerToggle);//设置侧滑菜单的监听
        //设置菜单列表
        arrayAdapter = new ArrayAdapter(getActivity(),R.layout.layout_listview_item,menus);
        mListView.setAdapter(arrayAdapter);
    }
}

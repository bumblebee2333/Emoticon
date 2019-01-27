package com.example.emoticon.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.emoticon.Activity.SearchActivity;
import com.example.emoticon.Adapter.MainPageAdapter;
import com.example.emoticon.R;

public class EmoticonFragment extends Fragment {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private EditText editText;

    @SuppressLint("ResourceType")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.emoticon_fragment,container,false);
        editText = view.findViewById(R.id.edit_text);
        //跳转到搜索界面
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SearchActivity.class);
                startActivity(intent);
           }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mTabLayout = getActivity().findViewById(R.id.tabLayout_1);
        mViewPager = getActivity().findViewById(R.id.viewPager);

        mTabLayout.addTab(mTabLayout.newTab().setText("最新"));
        mTabLayout.addTab(mTabLayout.newTab().setText("热门"));
        mTabLayout.setTabTextColors(getResources().getColor(R.color.darkgray),
                getResources().getColor(R.color.gold));
        mViewPager.setAdapter(new MainPageAdapter(getChildFragmentManager()));
        mViewPager.addOnPageChangeListener(new TabLayout.
                TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}

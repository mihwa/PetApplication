package com.naver.mycnex.viewpageapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.naver.mycnex.viewpageapplication.Fragment.ViewP1Fragment;
import com.naver.mycnex.viewpageapplication.Fragment.ViewP2Fragment;


public class ViewPagerAdapter extends FragmentStatePagerAdapter{
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return ViewP1Fragment.getInstance();
        } else if (position == 1){
            return ViewP2Fragment.getInstance();
        }
        return null;
    }

    @Override
    public int getCount()
    {

        return 2;
    }
}

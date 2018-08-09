package com.naver.mycnex.viewpageapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import com.naver.mycnex.viewpageapplication.Bus.BusProvider;
import com.naver.mycnex.viewpageapplication.adapter.ViewPagerAdapter;
import com.squareup.otto.Bus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;



public class ViewPagerActivity extends AppCompatActivity {
    ViewPager viewpager;
    ViewPagerAdapter viewPagerAdapter;


    Bus bus = BusProvider.getInstance().getBus();
    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        unbinder = ButterKnife.bind(this);
        bus.register(this);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(viewPagerAdapter);

    }

    @OnClick
    public void btn_0() {
        viewpager.setCurrentItem(0);

    }
    @OnClick
    public void btn_1() {
        viewpager.setCurrentItem(1);

    }

    @BindView(R.id.btn_0) Button btn_0;
    @BindView(R.id.btn_1) Button btn_1;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }
}

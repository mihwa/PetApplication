package com.naver.mycnex.viewpageapplication;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.naver.mycnex.viewpageapplication.Bus.BusProvider;
import com.naver.mycnex.viewpageapplication.adapter.ViewPagerAdapter;
import com.squareup.otto.Bus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;



public class ViewPagerActivity extends AppCompatActivity {
    //ViewPager viewpager;
    ViewPagerAdapter viewPagerAdapter;
    Bus bus = BusProvider.getInstance().getBus();
    Unbinder unbinder;
   // Button btn_0;


    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.spinner0)
    Spinner spinner0;
    @BindView(R.id.spinner1)
    Spinner spinner1;
    @BindView(R.id.spinner2)
    Spinner spinner2;
    @BindView(R.id.btn_0)
    Button btn_0;
    @BindView(R.id.btn_1)
    Button btn_1;
    @BindView(R.id.btn_openDrawer)
    Button btn_openDrawer;              //메뉴버튼~~~

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        unbinder = ButterKnife.bind(this);
        bus.register(this);

        ArrayAdapter addressAdapter = ArrayAdapter.createFromResource(this, R.array.address1, android.R.layout.simple_spinner_item);
        addressAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner0.setAdapter(addressAdapter);

        ArrayAdapter dogsizeAdapter = ArrayAdapter.createFromResource(this, R.array.dogsize, android.R.layout.simple_spinner_item);
        dogsizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dogsizeAdapter);

        ArrayAdapter placeAdapter = ArrayAdapter.createFromResource(this, R.array.place, android.R.layout.simple_spinner_item);
        placeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(placeAdapter);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(viewPagerAdapter);


        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewpager.setCurrentItem(0);
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewpager.setCurrentItem(1);
            }
        });
        
        btn_openDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewPagerActivity.this, SlideMenuActivity.class);
                startActivity(intent);
                finish();
            }
        });


        /*@BindView(R.id.btn_1) Button btn_1;
        @OnClick
        public void btn_1() {
            viewpager.setCurrentItem(1);

        }*/


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        bus.unregister(this);
    }
}

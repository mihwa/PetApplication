package com.naver.mycnex.viewpageapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

public class SlideMenuActivity extends AppCompatActivity {
    private final String[] navItems = {"로그인하러가기", "북마크", "설정", "가게등록" };
    private ListView lvNavList;
    private FrameLayout flContainer;
    private DrawerLayout dlDrawer;
    private Button btn;



  /*  @Override
    public void onBackPressed() {
        if (dlDrawer.isDrawerOpen(lvNavList)) {
            dlDrawer.closeDrawer(lvNavList);

        } else {
            super.onBackPressed();

        }

    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_menu);

        lvNavList =  findViewById(R.id.lv_activity_main_nav_list);
        flContainer = findViewById(R.id.fl_activity_main_container);
        btn = findViewById(R.id.btn);


        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "open", Toast.LENGTH_SHORT).show();
                dlDrawer.openDrawer(lvNavList);

            }

        });

        dlDrawer = (DrawerLayout)findViewById(R.id.dl_activity_main_drawer);
        lvNavList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, navItems));
        lvNavList.setOnItemClickListener(new DrawerItemClickListener());

    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
            switch (position) {
                case 0://로그인/로그아웃
                    Intent intent = new Intent(SlideMenuActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();

                    flContainer.setBackgroundColor(Color.parseColor("#A52A2A"));

                    break;

                case 1://북마크
                    intent = new Intent(SlideMenuActivity.this, BookmarkList_Activity.class);
                    startActivity(intent);
                    finish();

                    flContainer.setBackgroundColor(Color.parseColor("#5F9EA0"));
                    break;

                case 2://설정
                    intent = new Intent(SlideMenuActivity.this, SettingActivity.class);
                    startActivity(intent);
                    finish();
                    flContainer.setBackgroundColor(Color.parseColor("#556B2F"));
                    break;

                case 3://가게등록
                    intent = new Intent(SlideMenuActivity.this, RegisterShopActivity.class);
                    startActivity(intent);
                    finish();
                    flContainer.setBackgroundColor(Color.parseColor("#FF8C00"));
                    break;
                /*case 4:

                    flContainer.setBackgroundColor(Color.parseColor("#DAA520"));

                    break;*/

            }

            dlDrawer.closeDrawer(lvNavList);



        }

    }



}



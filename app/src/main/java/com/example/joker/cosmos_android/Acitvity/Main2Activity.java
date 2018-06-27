package com.example.joker.cosmos_android.Acitvity;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.Toolbar;



import com.example.joker.cosmos_android.R;

import static android.support.v4.view.ViewPager.*;

public class Main2Activity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    PageAdapter pageAdapter;
    TabItem tabchat;
    TabItem tabstatus;
    TabItem tabcalls;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        tabLayout=findViewById(R.id.tablayout);
        tabchat=findViewById(R.id.chat);

        tabstatus=findViewById(R.id.status);
        tabcalls=findViewById(R.id.call);
        viewPager=findViewById(R.id.pager);

        //tabLayout.addTab(tabLayout.newTab().setText("CHATS"));

        pageAdapter=new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        tabLayout.setupWithViewPager(viewPager);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==1)
                {
                    toolbar.setBackgroundColor(ContextCompat.getColor(Main2Activity.this,R.color.amber_500));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(Main2Activity.this,R.color.amber_500));
                    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP)
                    {
                        getWindow().setStatusBarColor(ContextCompat.getColor(Main2Activity.this,R.color.amber_500));
                    }
                }
                else if(tab.getPosition()==2)
                {
                    toolbar.setBackgroundColor(ContextCompat.getColor(Main2Activity.this,R.color.blue_500));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(Main2Activity.this,R.color.blue_500));
                    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP)
                    {
                        getWindow().setStatusBarColor(ContextCompat.getColor(Main2Activity.this,R.color.blue_500));
                    }

                }
                else
                {
                    toolbar.setBackgroundColor(ContextCompat.getColor(Main2Activity.this,R.color.red_500));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(Main2Activity.this,R.color.red_500));
                    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP)
                    {
                        getWindow().setStatusBarColor(ContextCompat.getColor(Main2Activity.this,R.color.red_500));
                    }

                }
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

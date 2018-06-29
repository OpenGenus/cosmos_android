package com.example.joker.cosmos_android.Acitvity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Build;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.joker.cosmos_android.Adapter.AlgorithmAdapter;
import com.example.joker.cosmos_android.Adapter.TabPagerAdapter;
import com.example.joker.cosmos_android.Database.Algorithms;
import com.example.joker.cosmos_android.Database.SubAlgorithms;
import com.example.joker.cosmos_android.R;
import com.example.joker.cosmos_android.Utils.AlgorithmsClickListener;
import com.example.joker.cosmos_android.ViewModel.AlgorithmsViewModel;

public class AlgorithmsActivity extends AppCompatActivity{

    private RecyclerView recyclerView;
    private AlgorithmAdapter algorithmAdapter;
//    private AlgorithmsViewModel algorithmsViewModel;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabPagerAdapter tabPagerAdapter;

    private TabItem tabchat;
    private TabItem tabstatus;
    private TabItem tabcalls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));

        tabLayout=findViewById(R.id.tablayout);

        tabchat=findViewById(R.id.chat);
        tabstatus=findViewById(R.id.status);
        tabcalls=findViewById(R.id.call);

        viewPager=findViewById(R.id.pager);

        tabPagerAdapter =new TabPagerAdapter(getSupportFragmentManager(),this);
        viewPager.setAdapter(tabPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
        setColor(R.color.cyan_600,R.color.cyan_800);      //default color

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());

                switch (tab.getPosition()){
                    case 0:
                            setColor(R.color.cyan_600,R.color.cyan_800);
                            break;
                    case 1:
                            setColor(R.color.teal_500,R.color.teal_700);
                            break;
                    case 2:
                            setColor(R.color.orange_600,R.color.orange_800);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }

            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });

    }

    private void setColor(int primary, int primaryDark) {

        toolbar.setBackgroundColor(ContextCompat.getColor(AlgorithmsActivity.this,primary));
        tabLayout.setBackgroundColor(ContextCompat.getColor(AlgorithmsActivity.this,primary));

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP)
        {
            getWindow().setStatusBarColor(ContextCompat.getColor(AlgorithmsActivity.this,primaryDark));
        }

    }

}

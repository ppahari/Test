package com.example.realnapster.test;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public TabLayout tabLayout;
    public ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout =findViewById(R.id.tabLayout);

        viewPager=findViewById(R.id.viewPager);

        ViewPageAdapter viewPageAdapter= new ViewPageAdapter(getFragmentManager());
        viewPageAdapter.addFragment(new TabOne(),"Tab One");
        viewPageAdapter.addFragment(new TabTwo(),"Tab Two");
        viewPager.setAdapter(viewPageAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}

package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.myapplication.Adapters.ViewPagerAdapter;
import com.example.myapplication.Fragments.InfoFragment;
import com.example.myapplication.Fragments.SquadsFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity2 extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getIntent().getStringExtra("team1")+" vs "+getIntent().getStringExtra("team2"));


        viewPager = findViewById(R.id.vpPager);
        toolbar =  findViewById(R.id.toolbar);

        toolbar.setTitle("Sportz Interactive");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupViewPager(viewPager);


    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new InfoFragment(), "Info");
        adapter.addFragment(new SquadsFragment(), "Squads");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slideleft,
                R.anim.slideright);
    }
}
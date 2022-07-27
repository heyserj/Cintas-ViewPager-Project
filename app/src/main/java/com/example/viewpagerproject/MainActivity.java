package com.example.viewpagerproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends FragmentActivity implements UpdateText {
    private static final int NUM_PAGES = 2;
    private ViewPager mPager;
    private TabLayout tabLayout;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mPager);

        /*FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction t = manager.beginTransaction();
        ScreenSlidePageFragment s = new ScreenSlidePageFragment(0);
        DisplayTextFragment d = new DisplayTextFragment(1);
        t.add(R.id.content, s);
        t.add(R.id.display_text_fragment, d);
        t.commit();*/
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    @Override
    public void updateValues(String text1, String text2) {
        Log.e("Jacob", text1);
        MyPreference.setUsername(this, text1);
        DisplayTextFragment displayTextFragment = new DisplayTextFragment(1);
        displayTextFragment.updateTextView();
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new ScreenSlidePageFragment(position);
            } else {
                return new DisplayTextFragment(position);
            }
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position){
            switch (position){
                case 0: {
                    return "Login";
                }
                case 1: {
                    return "Display";
                }
                default: {
                    return "Display";
                }
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
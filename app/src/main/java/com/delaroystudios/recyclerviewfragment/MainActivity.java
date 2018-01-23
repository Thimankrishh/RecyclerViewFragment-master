package com.delaroystudios.recyclerviewfragment;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.delaroystudios.recyclerviewfragment.BlankFragment;

public class MainActivity extends AppCompatActivity {
        private Toolbar toolbar;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
     //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }



        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), MainActivity.this);
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        for(int i = 0; i < tabLayout.getTabCount(); i++){
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(pagerAdapter.getTabView(i));
        }
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

    }

    public void Card(){


    }

    @Override
    public void onResume() { super.onResume();}

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.action_settings){
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    class PagerAdapter extends FragmentPagerAdapter {

        String tabTitles[] = new String[]{"Single", "Double", "DoubleD","Cabana","Twin","Parlor"};
        Context context;



        public PagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public int getCount() {
            return tabTitles.length;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new BlankFragment();
                case 1:
                    return new FragmentOne();
                case 2:
                    return new BlankFragment();
                case 3:
                    return new FragmentTwo();
                case 4:
                    return new BlankFragment();
                case 5:
                    return new FragmentTwo();
            }

            return null;
        }


    @Override
    public CharSequence getPageTitle(int position){
        return tabTitles[position];
    }

    public View getTabView(int position){
        View tab = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_tab, null);
        TextView tv = (TextView) tab.findViewById(R.id.custom_text);
        tv.setText(tabTitles[position]);
        return tab;
    }
}
}

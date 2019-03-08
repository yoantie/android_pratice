package com.example.jinfuture.oschina;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            ResetNavigationItemIcon();

            switch (item.getItemId()) {
                case R.id.navigation_comprehensive:
                    mTextMessage.setText(R.string.title_comprehensive);
                    item.setIcon(R.mipmap.ic_nav_news_actived);
                    return true;
                case R.id.navigation_tweet:
                    mTextMessage.setText(R.string.title_tweet);
                    item.setIcon(R.mipmap.ic_nav_tweet_actived);
                    return true;
                case R.id.navigation_add:
                    mTextMessage.setText(R.string.title_add);

                    return true;
                case R.id.navigation_find:
                    item.setIcon(R.mipmap.ic_nav_discover_actived);
                    return true;
                case R.id.navigation_mine:
                    item.setIcon(R.mipmap.ic_nav_my_pressed);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setItemIconTintList(null);
    }

    private void ResetNavigationItemIcon() {
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        MenuItem item_cmph = navigation.getMenu().findItem(R.id.navigation_comprehensive);
        MenuItem item_tweet = navigation.getMenu().findItem(R.id.navigation_tweet);
        MenuItem item_add = navigation.getMenu().findItem(R.id.navigation_add);
        MenuItem item_find = navigation.getMenu().findItem(R.id.navigation_find);
        MenuItem item_my = navigation.getMenu().findItem(R.id.navigation_mine);

        item_cmph.setIcon(R.mipmap.ic_nav_news_normal);
        item_tweet.setIcon(R.mipmap.ic_nav_tweet_normal);
        item_find.setIcon(R.mipmap.ic_nav_discover_normal);
        item_my.setIcon(R.mipmap.ic_nav_my_normal);
    }
}

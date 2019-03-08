package com.example.jinfuture.oschina;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button postBarrageButton = null,
                   writeBlogButton = null,
                   postNewsButton = null;

    private TextView mTextMessage;
    BottomNavigationView bottomNavigationView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            resetNavigationItemIcon();

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
                    showHidenNavigationButton();
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
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setItemIconTintList(null);

        addHidenButtonForNavigation();
    }

    private void resetNavigationItemIcon() {
        MenuItem item_cmph = bottomNavigationView.getMenu().findItem(R.id.navigation_comprehensive);
        MenuItem item_tweet = bottomNavigationView.getMenu().findItem(R.id.navigation_tweet);
        MenuItem item_add = bottomNavigationView.getMenu().findItem(R.id.navigation_add);
        MenuItem item_find = bottomNavigationView.getMenu().findItem(R.id.navigation_find);
        MenuItem item_my = bottomNavigationView.getMenu().findItem(R.id.navigation_mine);

        item_cmph.setIcon(R.mipmap.ic_nav_news_normal);
        item_tweet.setIcon(R.mipmap.ic_nav_tweet_normal);
        item_find.setIcon(R.mipmap.ic_nav_discover_normal);
        item_my.setIcon(R.mipmap.ic_nav_my_normal);
    }

    private void addHidenButtonForNavigation() {
        if (postBarrageButton == null) {
            postBarrageButton = new Button(getApplicationContext());
            postBarrageButton.setBackgroundResource(R.mipmap.ic_new_tweet);
            postBarrageButton.setText("发动弹");
            postBarrageButton.setVisibility(View.INVISIBLE);

           // navigation.addView(postBarrageButton);
        }

        if (writeBlogButton == null) {
            writeBlogButton = new Button(getApplicationContext());
            writeBlogButton.setBackgroundResource(R.mipmap.ic_new_blog);
            writeBlogButton.setText("写微博");
            postBarrageButton.setVisibility(View.INVISIBLE);

         //   navigation.addView(writeBlogButton);
        }

        if (postNewsButton == null) {
            postNewsButton = new Button(getApplicationContext());
            postNewsButton.setBackgroundResource(R.mipmap.ic_new_article);
            postNewsButton.setText("发文章");
            postBarrageButton.setVisibility(View.INVISIBLE);

          //  navigation.addView(postNewsButton);
        }
    }

    private void showHidenNavigationButton() {
        float xPos = bottomNavigationView.getX();
        float yPos = bottomNavigationView.getY();

        float xAniStartPos = xPos/2;
        float yAniStartPos = yPos;

        ObjectAnimator translationX = new ObjectAnimator().ofFloat(postBarrageButton, "translationX", xAniStartPos, 600f);
        ObjectAnimator translationY = new ObjectAnimator().ofFloat(postBarrageButton, "translationY", yAniStartPos, 50f);

        AnimationSet animationSet = new AnimationSet(true);
     //   animationSet.playTogether(translationX, translationY);
        animationSet.addAnimation(translationX);
        animationSet.setDuration(300);
        animationSet.start();
    }
}

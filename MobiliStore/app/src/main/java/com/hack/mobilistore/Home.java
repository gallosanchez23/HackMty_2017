package com.hack.mobilistore;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.google.zxing.client.android.CaptureActivity;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onBackPressed() {
        this.moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    public void gotoNews(View w){
        Intent k = new Intent(this, NewsFeedActivity.class);
        k.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(k);
    }

    public void gotoSearch(View w){
        Intent k = new Intent(this, SearchActivity.class);
        k.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(k);
    }

    public void gotoCart(View w){
        Intent k = new Intent(this, CartActivity.class);
        k.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(k);
    }

    public void gotoHome(View w){
        Intent k = new Intent(this, Home.class);
        k.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(k);
    }
}

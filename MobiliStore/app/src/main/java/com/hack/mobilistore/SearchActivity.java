package com.hack.mobilistore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
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

    public void gotoSearchStore(View w){
        Intent k = new Intent(this, SearchStore.class);
        k.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(k);
    }


}

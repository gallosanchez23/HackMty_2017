package com.hack.mobilistore;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.google.zxing.client.android.CaptureActivity;

public class CarritoDeCompras extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito_de_compras);

        //Para que aparezca la flecha atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String codigoBarras = getIntent().getStringExtra("codigoBarras");
        ((Button)findViewById(R.id.btnCarritoCompras)).setText(codigoBarras==null?"nada":codigoBarras);
    }

    public void listenerAddNewProduct(View v) {
        Intent intent=new Intent(this, CaptureActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {

        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                onBackPressed();
                return true;

        }
        return super.onKeyDown(keyCode, event);

    }

    //Metodo listener usado para escuchar el clic en el btn atras dela actionbar
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();

        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this, Home.class);
        startActivity(intent);
    }

}

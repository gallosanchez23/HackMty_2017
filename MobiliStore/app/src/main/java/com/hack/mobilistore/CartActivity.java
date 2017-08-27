package com.hack.mobilistore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.zxing.client.android.CaptureActivity;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private static final ArrayList<LinearLayout> articulos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        String codigoBarras = getIntent().getStringExtra("codigoBarras");
        if (codigoBarras != null) {
            //We inflate the component
            LayoutInflater inflater = LayoutInflater.from(this);
            LinearLayout newArticulo = (LinearLayout)
                    inflater.inflate(R.layout.panel_articulo_carrito, null, false);

            ((TextView) newArticulo.findViewById(R.id.titleArticulo)).setText("Aguita");
            ((TextView) newArticulo.findViewById(R.id.articuloCodigo)).setText(codigoBarras);
            ((TextView) newArticulo.findViewById(R.id.articuloPrecio)).setText("$5");

            articulos.add(newArticulo);
        }

        //We add the products to the panel
        final LinearLayout panelArticulos = (LinearLayout) findViewById(R.id.panelListaArticulos);
        for(int x = 0; x < articulos.size() - (codigoBarras == null ? 0:1); x++) {
            ((ViewGroup)articulos.get(x).getParent()).removeView(articulos.get(x));
        }
        for(int x = 0; x < articulos.size(); x++) {
            panelArticulos.addView(articulos.get(x));
        }
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
    public void gotoNews(View w) {
        Intent k = new Intent(this, NewsFeedActivity.class);
        k.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(k);
    }

    public void gotoSearch(View w) {
        Intent k = new Intent(this, SearchActivity.class);
        k.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(k);
    }

    public void gotoCart(View w) {
        Intent k = new Intent(this, CartActivity.class);
        k.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(k);
    }

    public void gotoHome(View w) {
        Intent k = new Intent(this, Home.class);
        k.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(k);
    }
}

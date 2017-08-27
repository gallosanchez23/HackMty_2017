package com.hack.mobilistore;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.client.android.CaptureActivity;

public class Home extends AppCompatActivity {
    Bundle savedInstanceState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        setContentView(R.layout.activity_home);
    }


    public void abrirCapture(View v) {
        Intent intent=new Intent(this, CarritoDeCompras.class);
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
        this.moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    public void goToCarritoDeCompras(View v) {
            Intent k = new Intent(this, CarritoDeCompras.class);
            startActivity(k);
    }
}

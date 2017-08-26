package com.hack.mobilistore;

import android.app.usage.UsageEvents;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BeaconActivity extends AppCompatActivity {
    EditText cajaText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beacon);

        cajaText = (EditText) this.findViewById(R.id.caja);
    }

    public void listener(View e){
        String txt = cajaText.getText().toString();

        ((Button)this.findViewById(R.id.btn)).setText(txt);
    }

}

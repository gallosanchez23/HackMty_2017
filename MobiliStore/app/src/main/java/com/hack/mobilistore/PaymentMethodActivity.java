package com.hack.mobilistore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PaymentMethodActivity extends AppCompatActivity {
    EditText boxCardNumber, boxExpDate, boxCSC, boxAddress1, boxAddress2, boxCP, boxCountry, boxCity, boxState, boxPhone;
    String cardNumber, expDate, CSC, address, CP, country, state, city, phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);
        boxCardNumber = (EditText) this.findViewById(R.id.card_input);
        boxExpDate = (EditText) this.findViewById(R.id.expdate_input);
        boxAddress1 = (EditText) this.findViewById(R.id.address1_input);
        boxAddress2 = (EditText) this.findViewById(R.id.address2_input);
        boxCP = (EditText) this.findViewById(R.id.cp_input);
        boxCSC = (EditText) this.findViewById(R.id.csc_input);
        boxCountry = (EditText) this.findViewById(R.id.country_input);
        boxCity = (EditText) this.findViewById(R.id.city_input);
        boxState = (EditText) this.findViewById(R.id.state_input);
        boxPhone = (EditText) this.findViewById(R.id.phone_input);
    }

    public void finish(View e){
        cardNumber = boxCardNumber.getText().toString();
        expDate = boxExpDate.getText().toString();
        address = boxAddress1.getText().toString() + " " + boxAddress2.getText().toString();
        CSC = boxCSC.getText().toString();
        CP = boxCP.getText().toString();
        country = boxCountry.getText().toString();
        state = boxState.getText().toString();
        city = boxCity.getText().toString();
        phone = boxPhone.getText().toString();
        if(cardNumber.length() == 0 || expDate.length() == 0 || CSC.length() == 0 || address.length() == 0 || CP.length() == 0 || country.length() == 0 || state.length() == 0 || city.length() == 0 || phone.length() == 0){
            Toast aviso = Toast.makeText(this, "ERROR", Toast.LENGTH_LONG);
            aviso.setDuration(Toast.LENGTH_LONG);
            aviso.setText("Some fields are missing. Try again.");
            aviso.show();
        }
        else{
            Toast aviso = Toast.makeText(this, "SUCCESSFUL", Toast.LENGTH_LONG);
            aviso.setDuration(Toast.LENGTH_LONG);
            //address = boxAddress1.getText().toString() + " " + boxAddress2.getTe
            aviso.setText("User was registered successfully");
            aviso.show();
            Intent k = new Intent(this, Home.class);
            startActivity(k);
        }
    }
}

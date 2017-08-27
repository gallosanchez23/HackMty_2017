package com.hack.mobilistore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {
    EditText boxEmail, boxPassword, boxConfirm, boxFirstName, boxLastName;
    String email, password, firstName, lastName, confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        boxEmail = (EditText) this.findViewById(R.id.email_input);
        boxPassword = (EditText) this.findViewById(R.id.password_input);
        boxLastName = (EditText) this.findViewById(R.id.last_name_input);
        boxFirstName = (EditText) this.findViewById(R.id.first_name_input);
        boxConfirm = (EditText) this.findViewById(R.id.confirm_input);
    }

    public void nextStep(View e){
        email = boxEmail.getText().toString();
        password = boxPassword.getText().toString();
        confirm = boxConfirm.getText().toString();
        firstName = boxFirstName.getText().toString();
        lastName = boxLastName.getText().toString();
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        System.out.println("Confirm: " + confirm);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        if(password == confirm){
            Intent k = new Intent(this, PaymentMethodActivity.class);
            startActivity(k);
        }
        else{
            boxPassword.setText("");
            boxConfirm.setText("");
        }
    }


}

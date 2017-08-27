package com.hack.mobilistore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainLogInActivity extends AppCompatActivity {
    EditText boxEmail, boxPassword;
    String email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_log_in);

        boxEmail = (EditText) this.findViewById(R.id.email_input);
        boxPassword = (EditText) this.findViewById(R.id.password_input);

    }

    public void getLoginInformation(View e){
        email = boxEmail.getText().toString();
        password = boxPassword.getText().toString();
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
    }

    public void signUp(View e){
        Intent k = new Intent(this, SignUpActivity.class);
        startActivity(k);
    }

}

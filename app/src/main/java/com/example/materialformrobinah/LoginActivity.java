package com.example.materialformrobinah;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

    EditText email,password;
    Button buttonLogin;
    String email_address,passward1;
    TextView text_to_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        email = (EditText) findViewById(R.id.editTextEmailLogin);
        password = (EditText) findViewById(R.id.editPasswordLogin);
        text_to_register = (TextView) findViewById(R.id.already_signup);


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //converting the user input into string

                email_address = email.getText().toString();
                passward1 = password.getText().toString();


                //validations

                if (email_address.isEmpty()) {
                    email.setError("Please provide your email address ");
                }
                if (passward1.isEmpty()) {
                    password.setError("Please enter your passward");
                } else {
                    Toast.makeText(LoginActivity.this, "logged into your account", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                }


            }
        });

        text_to_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_register_page = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent_register_page);

            }
        });
    }

}

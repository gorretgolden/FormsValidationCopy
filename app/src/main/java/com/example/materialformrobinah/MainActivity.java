package com.example.materialformrobinah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username,email,password_one,password_two,phone_number;
    Button button;
    String name,email_address,phone,passward1,passward2;
    TextView text_to_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button) findViewById(R.id.buttonSubmit);
        username = (EditText) findViewById(R.id.editTextName);
        email = (EditText) findViewById(R.id.editTextEmail);
        phone_number = (EditText) findViewById(R.id.editTextMobile);
        password_one = (EditText) findViewById(R.id.editPassword);
        password_two = (EditText) findViewById(R.id.editPassword2);
        text_to_login = findViewById(R.id.already_signin);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //converting the user input into string
                email_address = email.getText().toString();
                phone = phone_number.getText().toString();
                name = username.getText().toString();
                passward1 = password_one.getText().toString();
                passward2 = password_two.getText().toString();


                //validations

                if (name.isEmpty()) {
                    username.setError("Please provide your username");
                }

                if (email_address.isEmpty()) {
                    email.setError("Please provide your email address");
                }
                if (phone.isEmpty()) {
                    phone_number.setError("Please provide your contact number");
                }

                if (passward1.isEmpty()) {
                    password_one.setError("Please enter your passward");
                }

                if (passward1.length()<=4) {
                    password_two.setError("Your password is too short!");
                }

                if (passward2.isEmpty()) {
                    password_one.setError("Please confirm your password");
                }

                if (!passward2.equals(passward1)){
                    password_two.setError("Passwords don't match");
//

                }
                if(!email_address.isEmpty() && !name.isEmpty() && !passward1.isEmpty() && passward2.equals(passward1) && passward1.length()>=8 && !phone.isEmpty()){
                    Toast.makeText(MainActivity.this, "You successfully created a new account!", Toast.LENGTH_SHORT).show();
                    Intent Login = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(Login);
                }
                else {

                    Toast.makeText(MainActivity.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();


                }

            }

        });
        text_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent  Register = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(Register);

            }
        });

    }
}
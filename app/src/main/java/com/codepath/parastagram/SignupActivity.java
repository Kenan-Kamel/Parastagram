package com.codepath.parastagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {
    public static final String TAG = "SingupActivity";
    private EditText etusername ;
    private EditText etpassword ;
    private EditText etemail ;
    private Button   btn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etusername = findViewById(R.id.etsignup_username);
        etpassword = findViewById(R.id.etsignup_passwrod);
        etemail = findViewById(R.id.etemail);

        btn = findViewById(R.id.btn);

       btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ParseUser user = new ParseUser();
                // Set core properties
                String username , password , email, phone;
                username = etusername.getText().toString();
               user.setUsername(username);
                password = etpassword.getText().toString();
               user.setPassword(password);
               email = etemail.getText().toString();
               user.setEmail(email);

              // Invoke signUpInBackground
                user.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            gotoLogin();
                            Toast.makeText(SignupActivity.this,"Signup Successful!", Toast.LENGTH_SHORT).show();

                        } else {
                            Log.e(TAG,"Issue with login", e );
                            Toast.makeText(SignupActivity.this,"Faild to singup!", Toast.LENGTH_SHORT).show();
                            // Sign up didn't succeed. Look at the ParseException
                            // to figure out what went wrong
                        }
                    }
                });

            }
        });
    }

    private void gotoLogin() {

            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }

}
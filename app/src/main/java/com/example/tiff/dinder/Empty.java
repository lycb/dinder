package com.example.tiff.dinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Empty extends AppCompatActivity
{
    TextView title;
    EditText username;
    EditText password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        title = (TextView) findViewById(R.id.title);

        username = (EditText) findViewById(R.id.username);
        final PrimaryUser user = new PrimaryUser("Jenny", "Ly", "jenny.ly@example.com", "p@ssword",
                "College student at NCSU looking for someone in computer science to eat with. I love to talk about technology, Vietnamese food, coffee cereal, Grey's Anatomy, and Game of Thrones!");

        password = (EditText) findViewById(R.id.password);

        loginButton = (Button) findViewById(R.id.loginButton);
                loginButton.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        Log.d("Username", user.getEmail());
                        Log.d("Password", user.getPassword());
                        Log.d("Login", "button clicked");
                        if (user.getEmail().equals(username.getText().toString())&& user.getPassword().equals(password.getText().toString()))
                        {
                            Log.d("Login", "success");
                            Intent myIntent = new Intent(Empty.this, Profile.class);
                            Empty.this.startActivity(myIntent);
                        }

                    }
                });
    }
}


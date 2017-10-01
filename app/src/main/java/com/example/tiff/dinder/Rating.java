package com.example.tiff.dinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class Rating extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        final RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        Button ratingButton = (Button) findViewById(R.id.ratingButton);
        ratingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rating = "Rating: " + ratingBar.getRating();
                Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(Rating.this, Profile.class);
                Rating.this.startActivity(myIntent);
            }
            });
        };
    }


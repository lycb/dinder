package com.example.tiff.dinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

/**
 * Created by jenny on 9/30/17.
 */

public class Profile extends AppCompatActivity
{
    EditText firstname;
    EditText lastname;
    EditText email;
    EditText bio;
    Button updateBtn;
    Button searchBtn;
    final static int PLACE_PICKER_REQUEST = 1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_profile);
            firstname = (EditText) findViewById(R.id.firstname);
            lastname = (EditText) findViewById(R.id.lastname);
            email = (EditText) findViewById(R.id.email);
            bio = (EditText) findViewById(R.id.bio);
            updateBtn = (Button) findViewById(R.id.updateButton);
            searchBtn = (Button) findViewById(R.id.searchButton);

            firstname.setText(PrimaryUser.firstName);
            lastname.setText(PrimaryUser.lastName);
            bio.setText(PrimaryUser.bio);
            email.setText(PrimaryUser.email);

            (updateBtn)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(!(firstname.getText().toString().equals("")) && !(lastname.getText().toString().equals("")) && !(bio.getText().toString().equals("")) &&!(email.getText().toString().equals("")))
                            PrimaryUser.firstName = firstname.getText().toString();
                            PrimaryUser.lastName = lastname.getText().toString();
                            PrimaryUser.bio = bio.getText().toString();
                            PrimaryUser.email = email.getText().toString();
                        }
                    });
            (searchBtn)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                            Intent intent;
                            try {
                                intent = builder.build(Profile.this);
                                startActivityForResult(intent, PLACE_PICKER_REQUEST); // for activty
                                //startActivityForResult(builder.build(getActivity()), PLACE_PICKER_REQUEST); // for fragment
                            } catch (GooglePlayServicesRepairableException e) {
                                e.printStackTrace();
                            } catch (GooglePlayServicesNotAvailableException e) {
                                e.printStackTrace();
                            }
                        }
                    });

        }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(this, data);
                String toastMsg = String.format("Place: %s", place.getName());
                Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();

                Intent myIntent = new Intent(Profile.this, FindPeopleActivity.class);
                Profile.this.startActivity(myIntent);
            }
        }

    }

}

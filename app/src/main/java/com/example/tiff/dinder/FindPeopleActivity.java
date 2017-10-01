package com.example.tiff.dinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tiff on 9/30/17.
 */

public class FindPeopleActivity extends AppCompatActivity{

    TextView nameTxt;
    TextView bioTxt;
    Button rejectBtn;
    Button acceptBtn;
    Button exitBtn;

    User[] userArray = new User[6];
    Integer counter = 0;
    String[] firstNames = {"Jessica", "Rob", "Anna", "Sophia", "Andreas", "Farhaan"};
    String[] lastNames = {"Vásquez", "Steiner", "Wang", "Nilsson", "Castillo", "Asfour"};
    String[] bios = {"My name is Jessica and I like hiking and spending time with my family.  My major is Parks and Recreation with a minor in Biology.  My friends don’t share my class schedule so I am looking for someone to hang out with during lunch.",
            "Hi!  I like gamming and playing the guitar.  I am also in a band and like to talk politics.  This is my first time in this city and I am looking for someone to eat dinner with.",
            "In my free time I like to go to the zoo and aquarium.  I love movies, but not scary ones.  I am bored, hungry, and looking for someone to entertain me.",
            "I am a Freshman in elementary education.  I work with habitat for humanity and at the GAP on the weekends.  I would really like to talk to someone and learn about which food is the best at this dining hall :P",
            "I grew up in New York and my favorite foods are Mac and Cheese and really good curry.  I love talking all about food and I am looking for someone fun to hang out with for a bit.",
            "I am currently working on the business team at a local nonprofit, but I would prefer to teach business at a university.  I got a late start today and I am looking for someone to eat some breakfast with."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findpeople);

        for(int i = 0; i < 6; i++) {
            User usr = new User();
            usr.setFirst_name(firstNames[i]);
            usr.setLast_name(lastNames[i]);
            usr.setBio(bios[i]);
            userArray[i] = usr;
        }

        nameTxt = (TextView) findViewById(R.id.nameText);
        bioTxt = (TextView) findViewById(R.id.bioText);
        rejectBtn = (Button) findViewById(R.id.rejectBtn);
        acceptBtn = (Button) findViewById(R.id.acceptBtn);
        exitBtn = (Button) findViewById(R.id.exitBtn);

        (exitBtn)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent myIntent = new Intent(FindPeopleActivity.this, MainActivity.class);
                        FindPeopleActivity.this.startActivity(myIntent);
                    }
                });

            nameTxt.setText(firstNames[counter] + " " + lastNames[counter]);
            bioTxt.setText(bios[counter]);
            counter++;
            (rejectBtn)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.d("Counter", counter.toString());
                            Log.d("userArray length", Integer.toString(userArray.length));
                            if(counter < userArray.length - 1) {
                                counter++;
                                nameTxt.setText(firstNames[counter] + " " + lastNames[counter]);
                                bioTxt.setText(bios[counter]);
                            }
                        }
                    });
            (acceptBtn)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent myIntent = new Intent(FindPeopleActivity.this, MainActivity.class);
                            FindPeopleActivity.this.startActivity(myIntent);
                        }
                    });

    }

}

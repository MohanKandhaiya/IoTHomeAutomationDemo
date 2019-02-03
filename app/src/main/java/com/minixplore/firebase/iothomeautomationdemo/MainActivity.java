package com.minixplore.firebase.iothomeautomationdemo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button Room_1;
    private Button Room_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Room_1 = (Button) findViewById(R.id.room1);
        Room_2 = (Button) findViewById(R.id.room2);

        Room_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent FirstIntent = new Intent(MainActivity.this, Room1Activity.class);
                startActivity(FirstIntent);
            }
        });

        Room_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SecondIntent = new Intent(MainActivity.this, Room2Activity.class);
                startActivity(SecondIntent);
            }
        });


    }
}
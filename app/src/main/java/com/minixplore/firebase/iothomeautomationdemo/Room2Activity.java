package com.minixplore.firebase.iothomeautomationdemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Room2Activity extends AppCompatActivity {

    private ToggleButton light_1;
    private ToggleButton light_2;

    private TextView SensorValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room1);

        light_1 = (ToggleButton)findViewById(R.id.toggleButton1);
        light_2 = (ToggleButton)findViewById(R.id.toggleButton2);

        SensorValue = (TextView)findViewById(R.id.sensorText);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference dataRef = firebaseDatabase.getReference("Room 2/Sensor Value");

        dataRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String sensorValue = dataSnapshot.getValue().toString();
                SensorValue.setText(sensorValue);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        light_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (light_1.isChecked()){
                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference dataRef = firebaseDatabase.getReference("Room 2/Light 1");
                    dataRef.setValue("ON");
                }
                else {
                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference dataRef = firebaseDatabase.getReference("Room 2/Light 1");
                    dataRef.setValue("OFF");
                }
            }
        });

        light_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (light_2.isChecked()){
                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference dataRef = firebaseDatabase.getReference("Room 2/Light 2");
                    dataRef.setValue("ON");
                }
                else {
                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference dataRef = firebaseDatabase.getReference("Room 2/Light 2");
                    dataRef.setValue("OFF");
                }
            }
        });

    }
}


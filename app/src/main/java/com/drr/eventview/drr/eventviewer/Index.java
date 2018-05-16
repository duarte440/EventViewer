package com.drr.eventview.drr.eventviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Index extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        Button login = (Button) this.findViewById(R.id.Login_button);
        TextView textView = (TextView) findViewById(R.id.textView4);
        setContentView(R.layout.activity_index);

    }

    public void onClick(View v) {
        Intent myIntent = new Intent(Index.this, register_account.class);
        startActivity(myIntent);
    }

    public void gotoeventos(View v){
        Intent eventos = new Intent(Index.this, eventos.class);
        startActivity(eventos);
    }
}


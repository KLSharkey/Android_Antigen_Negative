package com.kristensharkey.antigen_negative;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle b = getIntent().getExtras();
        int resultsNumberS = b.getInt("antigen");

        //int numberUnits = b.getInt("numberUnits");
        //int answer = resultsNumberS/numberUnits;
        TextView myTextView = (TextView) findViewById(R.id.resultsNumber);
        myTextView.setText(String.valueOf(resultsNumberS));
        //myTextView.setText(resultsNumberS);

        Button back = (Button) findViewById(R.id.Back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //go back to main page
                Intent intent = new Intent(Results.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //myTextView.setText(resultsNumber);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

    }

}

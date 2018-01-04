package com.kristensharkey.antigen_negative;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import java.text.DecimalFormat;
import android.widget.NumberPicker;
import android.widget.TextView;

import static com.kristensharkey.antigen_negative.R.id.C;
import static com.kristensharkey.antigen_negative.R.id.E;
import static com.kristensharkey.antigen_negative.R.id.N;
import static com.kristensharkey.antigen_negative.R.id.c;
import static com.kristensharkey.antigen_negative.R.id.numberOfUnits;
import static com.kristensharkey.antigen_negative.R.id.s;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //double C = 1;
                EditText numberOfUnits = (EditText) findViewById(R.id.numberOfUnits);

                String numberUnitsS = numberOfUnits.getText().toString();
                if (TextUtils.isEmpty(numberUnitsS)) {
                    numberOfUnits.setError("Cannot be left blank");
                    return;
                }
                if(numberUnitsS.matches("0")){
                    numberOfUnits.setError("Must be greater than 0");
                    return;
                }
                /*if (numberUnitsS.equals(Integer.parseInt(numberUnitsS))){
                    numberOfUnits.setError("Must be an integer value");
                    return;
                }*/
                if (Integer.parseInt(numberUnitsS) > 50){
                    numberOfUnits.setError("Must be at or below 50");
                    return;
                }
                int numberUnits = Integer.parseInt(numberUnitsS);
                /*if (numberUnits <= 0){
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setMessage("Cannot be left blank");
                    alert.setTitle("Error1");
                    alert.create().show();
                }*/

                DecimalFormat format = new DecimalFormat("##.00");

                CheckBox Cbox = (CheckBox) findViewById(R.id.C);
                CheckBox cBox = (CheckBox) findViewById(R.id.c);
                CheckBox Ebox = (CheckBox) findViewById(R.id.E);
                CheckBox eBox = (CheckBox) findViewById(R.id.e);
                CheckBox Kbox = (CheckBox) findViewById(R.id.K);
                CheckBox Fyabox = (CheckBox) findViewById(R.id.Fya);
                CheckBox Fybbox = (CheckBox) findViewById(R.id.Fyb);
                CheckBox Jkabox = (CheckBox) findViewById(R.id.Jka);
                CheckBox Jkbbox = (CheckBox) findViewById(R.id.Jkb);
                CheckBox Leabox = (CheckBox) findViewById(R.id.Lea);
                CheckBox Lebbox = (CheckBox) findViewById(R.id.Leb);
                CheckBox Mbox = (CheckBox) findViewById(R.id.M);
                CheckBox Nbox = (CheckBox) findViewById(R.id.N);
                CheckBox Sbox = (CheckBox) findViewById(R.id.S);
                CheckBox sBox = (CheckBox) findViewById(R.id.s);
                double C;
                double c;
                double E;
                double e;
                double K;
                double Fya;
                double Fyb;
                double Jka;
                double Jkb;
                double Lea;
                double Leb;
                double M;
                double N;
                double S;
                double s;

                if (Cbox.isChecked()) {
                    C = 0.32;
                } else {
                    C = 1;
                }
                if (cBox.isChecked()) {
                    c = 0.20;
                } else {
                    c = 1;
                }
                if (Ebox.isChecked()) {
                    E = 0.71;
                } else {
                    E = 1;
                }
                if (eBox.isChecked()) {
                    e = 0.02;
                } else {
                    e = 1;
                }
                if (Kbox.isChecked()) {
                    K = 0.91;
                } else {
                    K = 1;
                }
                if (Fyabox.isChecked()) {
                    Fya = 0.34;
                } else {
                    Fya = 1;
                }
                if (Fybbox.isChecked()) {
                    Fyb = 0.17;
                } else {
                    Fyb = 1;
                }
                if (Jkabox.isChecked()) {
                    Jka = 0.23;
                } else {
                    Jka = 1;
                }
                if (Jkbbox.isChecked()) {
                    Jkb = 0.26;
                } else {
                    Jkb = 1;
                }
                if (Leabox.isChecked()) {
                    Lea = 0.78;
                } else {
                    Lea = 1;
                }
                if (Lebbox.isChecked()) {
                    Leb = 0.28;
                } else {
                    Leb = 1;
                }
                if (Mbox.isChecked()) {
                    M = 0.22;
                } else {
                    M = 1;
                }
                if (Nbox.isChecked()) {
                    N = 0.28;
                } else {
                    N = 1;
                }
                if (sBox.isChecked()) {
                    s = 0.11;
                } else {
                    s = 1;
                }
                if (Sbox.isChecked()) {
                    S = 0.45;
                } else {
                    S = 1;
                }
                double antigenDouble = C * c * N * s *S*K *Fya*Fyb* M * Lea *Leb * Jka *Jkb*E *e;
                double antigenDivided = numberUnits / antigenDouble; //gets units in double

                double antigenHundreth = Double.parseDouble(format.format(antigenDivided)); //gets to 100th point
                if (antigenHundreth > (int) antigenHundreth) {
                    antigenHundreth += 1;
                }

                int antigen = (int) antigenHundreth;

                Intent intent = new Intent(MainActivity.this, Results.class);
                intent.putExtra("antigen", antigen);
                //intent.putExtra("numberUnits", numberUnits);
                startActivity(intent);
            }

        });
    }
}

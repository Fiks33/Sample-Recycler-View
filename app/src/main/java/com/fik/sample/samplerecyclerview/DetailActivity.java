package com.fik.sample.samplerecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Mochamad Taufik on 19-Apr-18.
 * Email   : thidayat13@gmail.com
 * Company : TRUSTUDIO
 */

public class DetailActivity extends AppCompatActivity{

    private Toolbar mToolbar;
    private TextView txtJudul,txtDeskripsi, txtTgl;
    private Spinner mSpinner;

    private String judul,deskripsi,tgl;

    private String itemSpinner[]    = {"Spinner1","Spinner2","Spinner3","Spinner4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mToolbar        = (Toolbar) findViewById(R.id.toolbar);
        txtJudul        = (TextView) findViewById(R.id.judul);
        txtDeskripsi    = (TextView) findViewById(R.id.deskripsi);
        txtTgl          = (TextView) findViewById(R.id.tgl);
        mSpinner        = (Spinner) findViewById(R.id.spinner);

        setSupportActionBar(mToolbar);

        //get data dari activity sebelumnya
        getBundle();

        //set ke textview
        txtJudul.setText(judul);
        txtDeskripsi.setText(deskripsi);
        txtTgl.setText(tgl);

        //set Adapter Spinner
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.spinner_item, itemSpinner);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(spinnerArrayAdapter);
    }

    //get data dari activity sebelumnya
    private void getBundle(){
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            judul = extras.getString("judul");
            deskripsi = extras.getString("deskripsi");
            tgl = extras.getString("tgl");
        }
    }
}

package com.fik.sample.samplerecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Created by Mochamad Taufik on 19-Apr-18.
 * Email   : thidayat13@gmail.com
 * Company : TRUSTUDIO
 */

public class DetailActivity extends AppCompatActivity{

    private Toolbar mToolbar;
    private TextView txtJudul,txtDeskripsi, txtTgl;

    private String judul,deskripsi,tgl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mToolbar        = (Toolbar) findViewById(R.id.toolbar);
        txtJudul        = (TextView) findViewById(R.id.judul);
        txtDeskripsi    = (TextView) findViewById(R.id.deskripsi);
        txtTgl          = (TextView) findViewById(R.id.tgl);

        setSupportActionBar(mToolbar);

        //get data dari activity sebelumnya
        getBundle();

        //set ke textview
        txtJudul.setText(judul);
        txtDeskripsi.setText(deskripsi);
        txtTgl.setText(tgl);
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

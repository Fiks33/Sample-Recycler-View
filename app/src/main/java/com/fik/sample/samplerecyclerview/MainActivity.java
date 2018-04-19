package com.fik.sample.samplerecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private Toolbar mToolbar;

    private LinearLayoutManager mLayoutManager;
    private ListAdapter mAdapter;

    private ArrayList<Model> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView	= (RecyclerView) findViewById(R.id.rv_country);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);

        // inisialisasi recycler view
        mAdapter            = new ListAdapter(this);
        mLayoutManager      = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //set data ke list
        setList();
    }

    //list dummy
    private void setList() {

        String[] text2 = {"Judul 1","Judul 2", "Judul 3", "Judul 4","Judul 5","Judul 6","Judul 7"};
        String[] text3 = {"Deskrisi 1", "Deskrisi 2", "Deskrisi 3","Deskrisi 4","Deskrisi 5","Deskrisi 6","Deskrisi 7"};
        String[] text5 = {"19-04-2018", "18-04-2018", "17-04-2018","16-04-2018","15-04-2018","14-04-2018","13-04-2018"};

        for (int i = 0; i < text2.length; i++) {
            Model data       = new Model();
            data.judul       = text2[i];
            data.deskripsi   = text3[i];
            data.tgl         = text5[i];


            mList.add(data);

        }
        mAdapter.setArray(mList);
        mRecyclerView.setAdapter(mAdapter);
    }
}

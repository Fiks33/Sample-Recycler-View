package com.fik.sample.samplerecyclerview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mochamad Taufik on 19-Apr-18.
 * Email   : thidayat13@gmail.com
 * Company : TRUSTUDIO
 */

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Model> arrlist;
    private String search = null;

    private static Context context;
    private Activity parentAct;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_adapter, parent, false);
        return new RecyclerView.ViewHolder(view) {
        };
    }

    public void setArray(ArrayList<Model> dList) {
        this.arrlist = dList;
    }

    public ListAdapter(Context c) {
        context = c;
    }

    public void setActivity(Activity act) {
        parentAct = act;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        TextView mJudul = (TextView) holder.itemView.findViewById(R.id.judul);
        TextView mTgl = (TextView) holder.itemView.findViewById(R.id.tgl);

        //set data ke textview
        mJudul.setText(arrlist.get(position).judul);
        mTgl.setText(arrlist.get(position).tgl);

        //intent data ke activity lain
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailActivity.class);
                i.putExtra("judul", arrlist.get(position).judul);
                i.putExtra("tgl", arrlist.get(position).tgl);
                i.putExtra("deskripsi", arrlist.get(position).deskripsi);
                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrlist.size();
    }


}
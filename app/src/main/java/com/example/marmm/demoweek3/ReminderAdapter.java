package com.example.marmm.demoweek3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by marmm on 3/28/17.
 */

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.Viewholder> {


    private Context mContext;

    public ReminderAdapter(Context mContext, ArrayList<Reminder> mReminders) {
        this.mContext = mContext;
        this.mReminders = mReminders;
    }

    private ArrayList<Reminder> mReminders;


    @Override
    public ReminderAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);

// Inflate the custom layout
        View geoObjectView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);

// Return a new holder instance
        ReminderAdapter.ViewHolder viewHolder = new ReminderAdapter.ViewHolder(geoObjectView);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(ReminderAdapter.Viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

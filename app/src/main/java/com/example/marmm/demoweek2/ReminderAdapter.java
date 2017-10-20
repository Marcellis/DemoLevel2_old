package com.example.marmm.demoweek2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;


/**
 * Created by marmm on 3/28/17.
 */

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.ViewHolder>  {

    private List<Reminder> mReminders;

    final private ReminderClickListener mReminderClickListener;


    public interface ReminderClickListener{

        void ReminderonLongClick (int position);
    }


    public ReminderAdapter(ReminderClickListener reminderClickListener, List<Reminder> mReminders) {
        this.mReminders = mReminders;
        this.mReminderClickListener = reminderClickListener;
    }

    @Override
    public ReminderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, null);

        // Return a new holder instance
        ReminderAdapter.ViewHolder viewHolder = new ReminderAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ReminderAdapter.ViewHolder holder, final int position) {

        final Reminder reminder =  mReminders.get(position);

        holder.textView.setText(reminder.getmReminderText());


        holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mReminderClickListener.ReminderonLongClick(position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mReminders.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public View mView;

        //Constructor
        public ViewHolder(View v) {


            super(v);
            textView = (TextView) v.findViewById(android.R.id.text1);
            mView = v;
        }

    }


}




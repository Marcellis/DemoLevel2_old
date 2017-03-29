package com.example.marmm.demoweek3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

import static com.example.marmm.demoweek3.MainActivity.INTENT_DETAIL_REMINDER_TEXT;
import static com.example.marmm.demoweek3.MainActivity.INTENT_DETAIL_ROW_NUMBER;
import static com.example.marmm.demoweek3.MainActivity.REQUESTCODE;


/**
 * Created by marmm on 3/28/17.
 */

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.ViewHolder>  {

    private List<Reminder> mReminders;
    private Context mContext;

    public ReminderAdapter(Context mContext, List<Reminder> mReminders) {
        this.mContext = mContext;
        this.mReminders = mReminders;
    }

    @Override
    public ReminderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_1, null);

        // Return a new holder instance
        ReminderAdapter.ViewHolder viewHolder = new ReminderAdapter.ViewHolder(view);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(ReminderAdapter.ViewHolder holder, final int position) {
        holder.textView.setText(mReminders.get(position).getmReminderText());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, UpdateActivity.class);
                intent.putExtra(INTENT_DETAIL_ROW_NUMBER, position);
                intent.putExtra(INTENT_DETAIL_REMINDER_TEXT, mReminders.get(position).getmReminderText());
                ((MainActivity) mContext).startActivityForResult(intent, REQUESTCODE);
            }
        });


        holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mReminders.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,mReminders.size());
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return mReminders.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        //Constructor
        public ViewHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(android.R.id.text1);


        }


        }
    }




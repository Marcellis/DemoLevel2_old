package com.example.marmm.demoweek2;

/**
 * Created by marmm on 3/26/17.
 */

public class Reminder {

    private String mReminderText;

    public Reminder(String mReminderText) {
        this.mReminderText = mReminderText;
    }

    @Override
    public String toString() {
        return mReminderText;
    }

    public String getmReminderText() {
        return mReminderText;
    }

    public void setmReminderText(String mReminderText) {
        this.mReminderText = mReminderText;
    }
}

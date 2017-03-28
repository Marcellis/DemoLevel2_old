package com.example.marmm.demoweek3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    //Local variables
    private EditText mReminderView;
    private int mPosInArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        //Init local variables
        mReminderView = (EditText) findViewById(R.id.editText_update);

        mReminderView.setText(getIntent().getStringExtra(MainActivity.INTENT_DETAIL_REMINDER_TEXT));

        //Obtain the parameters provided by MainActivity
        mPosInArray =  getIntent().getIntExtra(MainActivity.INTENT_DETAIL_ROW_NUMBER, -1);
        //If no "position in list" can be found, the default value is -1. This could be used to recognize an issue.


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Return entered data to MainActivity (if not empty, else throw a snackbar message
                String updatedReminderText = mReminderView.getText().toString();
                if (updatedReminderText.length() != 0) {
                    //Prepare the return parameter and return
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra(MainActivity.INTENT_DETAIL_ROW_NUMBER, mPosInArray);
                    resultIntent.putExtra(MainActivity.INTENT_DETAIL_REMINDER_TEXT,mReminderView.getText().toString());
                    setResult(Activity.RESULT_OK, resultIntent);
                    finish();
                } else {
                    Snackbar.make(view, "Enter some data", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
    }

}

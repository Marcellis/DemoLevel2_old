package com.example.marmm.demoweek3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{



    //Local variables
    private List<Reminder> mReminders;
    private EditText mNewReminderText;

    private ReminderAdapter mAdapter;
    private RecyclerView mRecyclerView;

    //Constants used when calling the detail activity
    public static final String INTENT_DETAIL_ROW_NUMBER = "Row number";
    public static final String INTENT_DETAIL_REMINDER_TEXT = "Reminder text";
    public static final int REQUESTCODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Initialize the local variables
        mNewReminderText = (EditText) findViewById(R.id.editText_main);
        mReminders = new ArrayList<Reminder>();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager mLayoutManager
                           = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        updateUI();



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get the user text from the textfield
                String text = mNewReminderText.getText().toString();
                Reminder newReminder = new Reminder(text);

//Check if some text has been added
                if (!(TextUtils.isEmpty(text))) {
                    //Add the text to the list (datamodel)
                    mReminders.add(newReminder);


                    //Tell the adapter that the data set has been modified: the screen will be refreshed.
                    updateUI();


                    //Initialize the EditText for the next item
                    mNewReminderText.setText("");
                } else {
                    //Show a message to the user if the textfield is empty
                    Snackbar.make(view, "Please enter some text in the textfield", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }

            }
        });
    }



    private void updateUI() {
        if (mAdapter == null) {
            mAdapter = new ReminderAdapter(this, mReminders);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }


    //Process return parameters
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUESTCODE) {
            if (resultCode == RESULT_OK) {
                int positionOfReminder = data.getIntExtra(MainActivity.INTENT_DETAIL_ROW_NUMBER, -1);
                //-1 being the default value in case of failure. Can be used to detect an issue.

                Reminder updatedReminder = new Reminder ( data.getStringExtra(MainActivity.INTENT_DETAIL_REMINDER_TEXT) ) ;
                // New timestamp: timestamp of update
                Toast.makeText(this, mReminders.get(0).getmReminderText()+mReminders.get(1).getmReminderText()+mReminders.get(2).getmReminderText(), Toast.LENGTH_SHORT).show();
                mReminders.set(positionOfReminder, updatedReminder);
                mAdapter.notifyDataSetChanged();
                // or UpdateUI() if this method has been implemented
            }
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

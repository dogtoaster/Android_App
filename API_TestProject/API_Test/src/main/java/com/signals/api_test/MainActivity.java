package com.signals.api_test;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/*

Rechenmaschine
Kugel dei hin an hier sprengt
Koordinaten rooden
Kamera
Maps

 */

public class MainActivity extends Activity {

    public final static String EXTRA_MESSAGE ="com.signals.API_Test.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void btnOpenEnterText(View view){

        Intent in = new Intent(MainActivity.this, EnterTextActivity.class);
        startActivity(in);

    }

    public void btnOpenSendText (View view){

        Intent in = new Intent(this, ReceiveTextActivity.class);

        String sendMessage = ((EditText) findViewById(R.id.edtOpenSendText)).getText().toString();

        if (!sendMessage.isEmpty()) {
            in.putExtra(EXTRA_MESSAGE, sendMessage);
            startActivity(in);
        }

    }

    public void btnOpenDrawCircle (View view){

        Intent in = new Intent(MainActivity.this, TouchCircleActivity.class);
        startActivity(in);

    }


}

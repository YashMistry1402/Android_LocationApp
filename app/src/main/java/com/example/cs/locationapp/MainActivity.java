package com.example.cs.locationapp;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LocationListener
{
    Button b1;
    TextView t1;
    LocationManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocation();

            }
        });
    }
public void getLocation(){
    try{
        lm=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        lm.RequestLocationUpdates(LocationManager.NETWORK_PROVIDER,5000,0,this);


    }
    catch (SecurityException c){}


    public void onLocationChanged(Location Location){
        t1.setText("Current location="+ Location.getLatitude()+","+ Location.getLongitude());
        Log.d("data"+ Location.getLatitude()+","+ Location.getLongitude());


    }
    onProviderDisabled(String provider){

    }
}

    @Override

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

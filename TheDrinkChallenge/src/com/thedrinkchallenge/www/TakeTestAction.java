package com.thedrinkchallenge.www;

import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
<<<<<<< HEAD
=======
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
>>>>>>> origin/master
import android.os.Bundle;
import android.widget.TextView;

public class TakeTestAction extends Activity {
	public static final String TIME_SERVER = "time-a.nist.gov";
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.take_test);
        
        //Location location = getLocation();

        TextView testResult = (TextView) findViewById(R.id.testResultString);
        Random r = new Random();
        Double rd = r.nextDouble();
        testResult.setText(rd + "");
        
        SharedPreferences pref = getApplicationContext().getSharedPreferences("UserPref", 0); 
        Editor editor = pref.edit();
        
        //Get current number of points.
        int currentPoints = pref.getInt("currentPoints", 0);
        
        //Set the number of points for test according to the BAC.
        int pointsForTest;
        if (rd > 0 && rd <= 0.10)
        	pointsForTest = 5;
        else if (rd > 0.10 && rd <= 0.15)
        	pointsForTest = 0;
        else if (rd > 0.15 && rd <= 0.20)
        	pointsForTest = -5;
        else 
        	pointsForTest = -10;
        
        //Set the current number of points for days of the month to take the test in a row.
        //Get previous number of points for month day.
        int currentPointsForMonth = pref.getInt("currentPointsForMonth", 0);
        
        //Keep track of number of days the user didn't take the test in a month.
        int noOfDaysTestNotTaken = pref.getInt("noOfDaysTestNotTaken", 0);
        int daysInRow = pref.getInt("daysInRow", 0);
        
        //Get month day.
        int monthDay = pref.getInt("currentMonthDay", 0);
        if (monthDay == 28)
        	monthDay = 1;
        else
        	monthDay++;
        
        if (monthDay == 1) //first day in month.
        {
        	currentPointsForMonth = 1;
        	noOfDaysTestNotTaken = 0;
        }
        else if (currentPointsForMonth + 1 == monthDay){
        	currentPointsForMonth++;
        	daysInRow++;
        	
        }
        //else it means they stopped so start from 1 again.
        else if (currentPointsForMonth + 1 < monthDay)
        {
        	noOfDaysTestNotTaken++;
        	currentPointsForMonth = 1; //reset to 1.
        	daysInRow = 1;
        }
        
        TextView daysInRowString = (TextView) findViewById(R.id.daysInRowString);

      
        
        if(daysInRow == 7){
        	
        	  AlertDialog alertDialog = new AlertDialog.Builder(this).create();
              alertDialog.setTitle("Achievement Unlocked - Rookie responsible drinker");
              alertDialog.setMessage("You have taken the test 7 days in a row!");
             
              alertDialog.show();
        }
        
        else if(daysInRow == 14){
        	AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Achievement Unlocked - Professional responsible drinker");
            alertDialog.setMessage("You have taken the test 14 days in a row!");
           
            alertDialog.show();
        }
        
        else if(daysInRow == 28){
        	AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Achievement Unlocked - World Class responsible drinker");
            alertDialog.setMessage("You have taken the test 28 days in a row!");
           
            alertDialog.show();
        	
        }
        
        //Update the current number of points.
        currentPoints += currentPointsForMonth + pointsForTest;
        editor.putInt("currentPoints", currentPoints); //total nr of points
        editor.putInt("noOfDaysTestNotTaken", noOfDaysTestNotTaken);
        editor.putInt("currentPointsForMonth", currentPointsForMonth); //nr of points for entire month
        editor.putInt("currentMonthDay", monthDay);
        editor.putInt("daysInRow", daysInRow);
        editor.commit();
        

        //Display currentNumberOfPoints
        TextView balance = (TextView) findViewById(R.id.pointsBalanceString);
        balance.setText("Balance: " + currentPoints);
        
        //Display current day in 4 weeks period:
        TextView monthDayString = (TextView) findViewById(R.id.monthDayString);
        monthDayString.setText("Day of Test in 4 weeks: " + monthDay);
        

        
        
    }
	
	/*public Location getLocation()
	{
		  //Check time is later than 8PM and less than 4 AM next day to allow test taking.
        long networkTS = 0;
        LocationManager locMan = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        Location location;
        
        // getting GPS status
        boolean isGPSEnabled = locMan
                .isProviderEnabled(LocationManager.GPS_PROVIDER);

        // getting network status
        boolean isNetworkEnabled = locMan
                .isProviderEnabled(LocationManager.NETWORK_PROVIDER);


        Log.d("nw", "nw: " + isNetworkEnabled);
        Log.d("nw", "gps: " + isGPSEnabled);
        
        
        if (!isGPSEnabled && !isNetworkEnabled) {
            // no network provider is enabled
        } else {
            if (isNetworkEnabled) {
            	locMan.requestLocationUpdates(
                        LocationManager.NETWORK_PROVIDER,
                        1000,
                        0, this);
                Log.d("Network", "Network Enabled");
                if (locMan != null) {
                    location = locMan
                            .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    if (location != null) {
                    	networkTS = location.getTime();
                    }
                }
            }
            
            if (isGPSEnabled) {
                if (location == null) {
                	locMan.requestLocationUpdates(
                            LocationManager.GPS_PROVIDER,
                            1000,
                            0, this);
                    Log.d("GPS", "GPS Enabled");
                    if (locMan != null) {
                        location = locMan
                                .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                        if (location != null) {
                        	networkTS = location.getTime();
                        }
                    }
                }
            }
            TextView networkTime = (TextView) findViewById(R.id.networkTimeString);
            networkTime.setText("Network time: " + networkTS);
        }
	}*/
	
}//class

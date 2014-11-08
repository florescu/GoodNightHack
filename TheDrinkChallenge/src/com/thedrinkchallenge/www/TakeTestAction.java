package com.thedrinkchallenge.www;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.TextView;
import java.util.*;

public class TakeTestAction extends Activity {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.take_test);
        TextView textView = (TextView) findViewById(R.id.testResultString);
        Random r = new Random();
        Double rd = r.nextDouble();
        textView.setText(rd + "");
        
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
        
        //Get month day.
        int monthDay = 0;
       // LocationManager locMan = (LocationManager) this.getSystemService(this.LOCATION_SERVICE);
       // long networkTS = locMan.getLastKnownLocation(LocationManager.NETWORK_PROVIDER).getTime();
        
        if (monthDay == 1) //first day in month.
        {
        	currentPointsForMonth = 1;
        	noOfDaysTestNotTaken = 0;
        }
        else if (currentPointsForMonth + 1 == monthDay)
        	currentPointsForMonth++;
        //else it means they stopped so start from 1 again.
        else if (currentPointsForMonth + 1 < monthDay)
        {
        	noOfDaysTestNotTaken++;
        	currentPointsForMonth = 1; //reset to 1. 
        }
        
        //Update the current number of points.
        currentPoints += currentPointsForMonth + pointsForTest;
        editor.putInt("currentPoints", currentPoints);
        editor.putInt("noOfDaysTestNotTaken", noOfDaysTestNotTaken);
        editor.putInt("currentPointsForMonth", currentPointsForMonth);
        editor.commit();
        
        //Display currentNumberOfPoints
        TextView balance = (TextView) findViewById(R.id.pointsBalanceString);
        balance.setText("Balance: " + currentPoints);
        
    }
}

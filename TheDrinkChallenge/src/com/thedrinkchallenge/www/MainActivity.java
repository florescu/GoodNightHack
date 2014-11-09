package com.thedrinkchallenge.www;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        SharedPreferences pref = getApplicationContext().getSharedPreferences("UserPref", 0); 
        int currentPoints = pref.getInt("currentPoints", 0);
        TextView balanceMainScreen = (TextView) findViewById(R.id.balanceMainScreen);
        balanceMainScreen.setText("Balance: " + currentPoints);
    }
    
    @Override
    public void onResume()
        {  // After a pause OR at startup
        super.onResume();
        //Refresh your stuff here
        SharedPreferences pref = getApplicationContext().getSharedPreferences("UserPref", 0); 
        int currentPoints = pref.getInt("currentPoints", 0);
        TextView balanceMainScreen = (TextView) findViewById(R.id.balanceMainScreen);
        balanceMainScreen.setText("Balance: " + currentPoints);
    }
    
    @Override
    public void onRestart()
        {  // After a pause OR at startup
        super.onResume();
        //Refresh your stuff here
        SharedPreferences pref = getApplicationContext().getSharedPreferences("UserPref", 0); 
        int currentPoints = pref.getInt("currentPoints", 0);
        TextView balanceMainScreen = (TextView) findViewById(R.id.balanceMainScreen);
        balanceMainScreen.setText("Balance: " + currentPoints);
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

        return super.onOptionsItemSelected(item);
    }
    
   
    
    public void takeTestAction(View view){
    	Intent intent = new Intent(this, TakeTestAction.class);
    	startActivity(intent);
    }
   
    public void showBacTable(View view){
    	Intent intent = new Intent(this, BacTable.class);
    	startActivity(intent);
    }
    
    public void displayAchievements(View view){
    	Intent intent = new Intent(this, Achievements.class);
    	startActivity(intent);
    }
    
    public void displayReward(View view){
    	Intent intent = new Intent(this, Reward.class);
    	startActivity(intent);
    }
    
}//class

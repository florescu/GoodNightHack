package com.thedrinkchallenge.www;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.widget.TextView;

public class Achievements extends Activity{
	@Override
	protected void onCreate(Bundle icicle) {
         super.onCreate(icicle);
         setContentView(R.layout.achievements);  
         SharedPreferences pref = getApplicationContext().getSharedPreferences("UserPref", 0); 
         Editor editor = pref.edit();
         int daysInRow = pref.getInt("daysInRow", 0);
         
         TextView days7 = (TextView) findViewById(R.id.daysInRow7String);
         TextView days14 = (TextView) findViewById(R.id.daysInRow14String);
         TextView days28 = (TextView) findViewById(R.id.daysInRow28String);

         
         if(daysInRow == 7){
         	
               

         	  
               days7.setText("Rookie in responsible drinking");
         }
         
         else if(daysInRow == 14){
         	 

             days7.setText("Rookie in responsible drinking");

             days14.setText("Professional in responsible drinking");
         }
         
         else if(daysInRow == 28){
         	 
        	 days7.setText("Rookie in responsible drinking");

             days14.setText("Professional in responsible drinking");
         	
             days28.setText("World Class in responsible drinking");
         }
    }
}

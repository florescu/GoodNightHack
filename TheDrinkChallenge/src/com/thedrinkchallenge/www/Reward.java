package com.thedrinkchallenge.www;

import java.math.BigDecimal;
import java.math.RoundingMode;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.widget.Toast;

public class Reward extends Activity{
	
	@Override
	protected void onCreate(Bundle icicle) {
         super.onCreate(icicle);
         setContentView(R.layout.reward); 
         
         SharedPreferences pref = getApplicationContext().getSharedPreferences("UserPref", 0); 
         Editor editor = pref.edit();
         int currentPoints = pref.getInt("currentPoints", 0);
         //Button btn = (Button) findViewById(R.id.claimRewardsButton);

         //if(currentPoints < 0){
        //	 btn.setEnabled(false);
         //}
        //else{
         double rewardSum = (double)currentPoints/1000;
         BigDecimal bd = new BigDecimal(rewardSum).setScale(2, RoundingMode.HALF_EVEN);

         //TextView reward = (TextView) findViewById(R.id.rewardAmount);
         //reward.setText("Your reward is £" + bd + " worth of Amazon vouchers.");
         AlertDialog alertDialog = new AlertDialog.Builder(this).create();
         alertDialog.setTitle("Claim Reward");
         alertDialog.setMessage("Your reward is £"+bd+" worth of Amazon vouchers");
         alertDialog.setButton("Cancel", new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
				
			}
        	 
         });
         alertDialog.setButton("Confirm", new DialogInterface.OnClickListener(){

 			@Override
 			public void onClick(final DialogInterface dialog, final int which) {
 				final Intent i = new Intent(Intent.ACTION_SEND);
 				i.setType("message/rfc822");
 				i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"danyela_1310@yahoo.com"});
 				i.putExtra(Intent.EXTRA_SUBJECT, "Claiming reward");
 				i.putExtra(Intent.EXTRA_TEXT   , "I would like to claim my reward");
 				try {
 				    startActivity(Intent.createChooser(i, "Send mail..."));
 				} catch (final android.content.ActivityNotFoundException ex) {
 				    Toast.makeText(Reward.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
 				}
 				
 			}
         	 
          });
         alertDialog.show();
         //}
         editor.putInt("currentPoints", 0);
         editor.commit();
	}
}

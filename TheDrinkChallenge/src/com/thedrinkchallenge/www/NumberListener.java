package com.thedrinkchallenge.www;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

//Receiver class for listening outgoing calls and messages
public class NumberListener extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		//Get the contact number.
		String phoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER).toString();
		if (phoneNumber.contentEquals("blockedNumbers"))
		{
			setResultData(null);
			Toast.makeText(context, "Call not allowed by TheDrinkingChallenge app as set by you.", Toast.LENGTH_LONG).show();
		}
	}
}


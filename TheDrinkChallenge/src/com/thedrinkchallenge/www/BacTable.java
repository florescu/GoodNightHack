package com.thedrinkchallenge.www;

import java.io.Serializable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;


public class BacTable extends Activity {
	@Override
	protected void onCreate(Bundle icicle) {
         super.onCreate(icicle);
         setContentView(R.layout.bac_text);   
    }

}//class


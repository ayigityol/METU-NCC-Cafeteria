package com.example.akanmenu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.metuncccafeteria.R;

public class P4 extends Activity {
	
	public static Typeface tf ;


	Button bHome, bCal, bCall;
	TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,bsch;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p4);
		
		tf = Typeface.createFromAsset(getAssets(), "fonts/t.ttf");
		
		bHome = (Button) findViewById(R.id.now);
		bCal = (Button) findViewById(R.id.cal);
        bCall = (Button) findViewById(R.id.call);
        
        bsch=(TextView) findViewById(R.id.busSch);
		t1 = (TextView) findViewById(R.id.tx1);
		t2 = (TextView) findViewById(R.id.tx2);
		t3 = (TextView) findViewById(R.id.tx3);
		t4 = (TextView) findViewById(R.id.tx4);
		t5 = (TextView) findViewById(R.id.tx5);
		t6 = (TextView) findViewById(R.id.tx6);
		t7 = (TextView) findViewById(R.id.tx7);
		t8 = (TextView) findViewById(R.id.tx8);
		t9 = (TextView) findViewById(R.id.tx9);
		t10 = (TextView) findViewById(R.id.tx10);
		t11 = (TextView) findViewById(R.id.tx11);
		
		bsch.setTypeface(tf);
		t1.setTypeface(tf);
		t2.setTypeface(tf);
		t3.setTypeface(tf);
		t4.setTypeface(tf);
		t5.setTypeface(tf);
		t6.setTypeface(tf);
		t7.setTypeface(tf);
		t8.setTypeface(tf);
		t9.setTypeface(tf);
		t10.setTypeface(tf);
		t11.setTypeface(tf);
		

		bHome.setOnClickListener(new View.OnClickListener() {
					
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
		
						Intent intent = new Intent(P4.this, MainActivity.class);
						startActivity(intent);
						finish(); 		
					}
				});
	

        bCal.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent = new Intent(P4.this, P2.class);
				startActivity(intent);
				finish(); 		
			}
		});


        bCall.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent = new Intent(P4.this, P3.class);
				startActivity(intent);
				finish(); 		
			}
		});
        
	}
  
	public void onBackPressed()
	{
		  finish();
          System.exit(0);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
		case R.id.item1:
		    Toast toast1 = new Toast(getApplicationContext());
		    LayoutInflater inflater = getLayoutInflater();
		    View layout = inflater.inflate(R.layout.toast,
		                                   (ViewGroup) findViewById(R.id.toast_layout_root));
		    
		    toast1.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		    toast1.setDuration(Toast.LENGTH_LONG);
		    toast1.setView(layout);
		    toast1.show();
		    break;
		case R.id.item2:
			  finish();
	          System.exit(0);
			break;
		default:
			break;
		}
    	
    	return super.onOptionsItemSelected(item);
    }
}

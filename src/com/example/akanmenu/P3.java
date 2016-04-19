package com.example.akanmenu;

import android.net.Uri;
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

public class P3 extends Activity {
	Button bHome, bCal,  bBus, yb1,yb2,yb3,yb4,yb5;
	TextView text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p3);
		Typeface tf;
		bCal = (Button) findViewById(R.id.cal);
        bHome = (Button) findViewById(R.id.now);
        bBus	 = (Button) findViewById(R.id.bus);
        tf = Typeface.createFromAsset(getAssets(), "fonts/t.ttf");
        text = (TextView) findViewById(R.id.foodpro);
        yb1= (Button) findViewById(R.id.ymk1);
        yb2= (Button) findViewById(R.id.ymk2);
        yb3= (Button) findViewById(R.id.ymk3);
        yb4= (Button) findViewById(R.id.ymk4);
        yb5= (Button) findViewById(R.id.ymk5);
        yb1.setTypeface(tf);
        yb2.setTypeface(tf);
        yb3.setTypeface(tf);
        yb4.setTypeface(tf);
        yb5.setTypeface(tf);
        text.setTypeface(tf);
        
        yb1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String number = "05338463695";
			    Intent intent = new Intent(Intent.ACTION_CALL);
			    intent.setData(Uri.parse("tel:" +number));
			    startActivity(intent);
			}
		});
		yb2.setOnClickListener(new View.OnClickListener() {
								
								@Override
								public void onClick(View v) {
									// TODO Auto-generated method stub
									String number = "05338455024";
								    Intent intent = new Intent(Intent.ACTION_CALL);
								    intent.setData(Uri.parse("tel:" +number));
								    startActivity(intent);
								}
							});
		yb3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String number = "05338574848";
			    Intent intent = new Intent(Intent.ACTION_CALL);
			    intent.setData(Uri.parse("tel:" +number));
			    startActivity(intent);
			}
		});
		yb4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String number = "05338363818";
			    Intent intent = new Intent(Intent.ACTION_CALL);
			    intent.setData(Uri.parse("tel:" +number));
			    startActivity(intent);
			}
		});
		yb5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String number = "05338331705";
			    Intent intent = new Intent(Intent.ACTION_CALL);
			    intent.setData(Uri.parse("tel:" +number));
			    startActivity(intent);
			}
				});
	
		
        
 //yemek butolari bitis radio group baslayis       
		
            bBus.setOnClickListener(new View.OnClickListener() {
				@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(P3.this, P4.class);
				startActivity(intent);	 
				finish(); 				
			}
		});   
        bCal.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent = new Intent(P3.this, P2.class);
				startActivity(intent);
				finish(); 		
			}
		});
        bHome.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent = new Intent(P3.this, MainActivity.class);
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

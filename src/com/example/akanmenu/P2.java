package com.example.akanmenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
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
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.metuncccafeteria.R;

public class P2 extends Activity   {
	public static Typeface tf;
	Button bHome, bCal, bCall, button5, bBus;
	
	
	Button goster;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p2);
		
		tf = Typeface.createFromAsset(getAssets(), "fonts/t.ttf");
		
    	TextView textview1 = (TextView)findViewById(R.id.t11);
		textview1.setTypeface(tf);
		int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		int mo = Calendar.getInstance().get(Calendar.MONTH);
		final NumberPicker np = (NumberPicker) findViewById(R.id.numberPicker1);
		final NumberPicker np2 = (NumberPicker) findViewById(R.id.numberPicker2);
		
		
		np.setMinValue(day);
		switch (mo+1) {
		case 2: mo = 28; break;
		case 4: mo = 30; break;
		case 6: mo = 30; break;
		case 9: mo = 30; break;
		case 11: mo=30; break;
		default : mo = 31;	
		}
		np.setMaxValue(mo);
		
		np2.setMinValue(0);
		np2.setMaxValue(1);
		np2.setDisplayedValues( new String[] { "Lunch", "Dinner"} ) ;
		
		
		np.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
		np2.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
		
		goster = (Button) findViewById(R.id.butongoster);
		goster.setTypeface(tf);
		goster.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String type = new String();
				String[] foods=new String[7];
				int sDay = np.getValue();
				int mo2 = Calendar.getInstance().get(Calendar.MONTH);
				int year2= Calendar.getInstance().get(Calendar.YEAR);
				ImageView image = (ImageView) findViewById(R.id.imageView1);
				
				
				if (np2.getValue() == 0)
					type = "ÖÐLE YEMEÐÝ / LUNCH";
				else 
					type = "AKÞAM YEMEÐÝ / DÝNNER";
				
				InputStream is = getResources().openRawResource(R.raw.aksamyemek);
			    InputStream is2 = getResources().openRawResource(R.raw.oglenyemek);
			    if(type.equals("ÖÐLE YEMEÐÝ / LUNCH"))
			    	foods=readTxt(is2,sDay);
			    else
			    	foods=readTxt(is,sDay);
			    	
			    if(foods[0]==null){
			    	TextView textview = (TextView) findViewById(R.id.t31);
			    	textview.setText( "There is no food service on " + Integer.toString(sDay) +"."+ Integer.toString(mo2+1) +"."+ Integer.toString(year2));
			    	textview.setTypeface(tf);
			    }
			    else{
			    	String month = new String();
				    switch (mo2+1){
				    case 1: month = "January";
				    case 2:	month = "Feburary ";
				    case 3:	month = "March";
				    case 4:	month = "April";
				    case 5: month = "May";
				    case 6: month = "June";
				    case 7: month = "July";
				    case 8: month = "August ";
				    case 9: month = "September";
				    case 10: month = "October";
				    case 11: month = "November";
				    case 12: month = "December";
				    
				    }
				    TextView textview1 = (TextView)findViewById(R.id.t11);
			    	
			    	TextView tv9 = (TextView) findViewById(R.id.t91);
				    TextView textview2 = (TextView)findViewById(R.id.t21);
				    TextView textview3 = (TextView)findViewById(R.id.t31);
				    TextView textview4 = (TextView)findViewById(R.id.t41);
				    TextView textview5 = (TextView)findViewById(R.id.t51);
				    TextView textview6 = (TextView)findViewById(R.id.t61);
				    TextView textview7 = (TextView)findViewById(R.id.t71);
				    textview1.setText(foods[0]+" "+month+" "+Integer.toString(year2));
				    tv9.setText(type);
				    textview2.setVisibility(View.VISIBLE);
				    tv9.setVisibility(View.VISIBLE);
				    textview2.setText(foods[1]);
				    textview3.setText(foods[2]);
				    textview4.setText(foods[3]);
				    textview5.setText(foods[4]);
				    textview6.setText(foods[5]);
				    textview7.setText(foods[6]);
				    image.setVisibility(View.VISIBLE);
				    tv9.setTypeface(tf);	    
				    textview2.setTypeface(tf);	    
				    textview3.setTypeface(tf);	    
				    textview4.setTypeface(tf);	    
				    textview5.setTypeface(tf);	    
				    textview6.setTypeface(tf);	    
				    textview7.setTypeface(tf);	    
			    }
				goster.setVisibility(View.GONE);
				np.setVisibility(View.GONE);
				np2.setVisibility(View.GONE);
			}
		});
		
		bHome = (Button) findViewById(R.id.now);
		bCal = (Button) findViewById(R.id.cal);
        bCall = (Button) findViewById(R.id.call);
        bBus = (Button) findViewById(R.id.bus);
        
        bHome.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(P2.this, MainActivity.class);
				startActivity(intent);
				finish(); 		
			}
		});
                
        bCal.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(P2.this, P2.class);
				startActivity(intent);
				finish(); 		
				}
		  });
        
        bCall.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(P2.this, P3.class);
				startActivity(intent);
				finish(); 		
			}
		});
        
        bBus.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(P2.this, P4.class);
				startActivity(intent);	
				finish(); 		 		
				}
		});
        
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
    	
	@Override
	public void onBackPressed()
	{
		  finish();
          System.exit(0);
	}


private String[] readTxt(InputStream isi, int day1)  {
	
	BufferedReader r = new BufferedReader(new InputStreamReader(isi));
	String line;
	String dayS=Integer.toString(day1);
	String[] foods=new String[7];
	int count=0;
	try {
		while ((line = r.readLine()) != null ) {
		    
			if(count % 7==0){
				if(dayS.equals(line) ){
					foods[0]=line;
					for(int i=1; i<7;i++){
						line=r.readLine();
						foods[i]=line;
						count++;}
					break;
	
				}
			}
			count++;
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.exit(RESULT_OK);
	}
	return foods;
}





}
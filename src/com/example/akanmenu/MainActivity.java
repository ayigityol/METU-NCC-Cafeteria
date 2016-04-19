package com.example.akanmenu;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import android.os.Bundle;
import android.app.ActionBar.LayoutParams;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.metuncccafeteria.R;

public class MainActivity extends Activity {

	public static Typeface tf ;
	Button bCal, bBus, bCall;
	String[] foods=new String[7];
    String type = new String();

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tf = Typeface.createFromAsset(getAssets(), "fonts/t.ttf");
		InputStream aksamStream = getResources().openRawResource(R.raw.aksamyemek);
	    InputStream ogleYemek = getResources().openRawResource(R.raw.oglenyemek);
	    int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		int time = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		int mo = Calendar.getInstance().get(Calendar.MONTH);
		int ye = Calendar.getInstance().get(Calendar.YEAR);
		
		bCal = (Button) findViewById(R.id.cal);
        bCall = (Button) findViewById(R.id.call);
        bBus  = (Button) findViewById(R.id.bus);
        
        bCal.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent = new Intent(MainActivity.this, P2.class);
				startActivity(intent);
				finish(); 		
			}
		});
        
        bCall.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent = new Intent(MainActivity.this, P3.class);
				startActivity(intent);
				finish();
			}
		});
        
        bBus.setOnClickListener(new View.OnClickListener() {
    		
        	@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, P4.class);
				startActivity(intent);
				finish(); 		
				}
		});
        //button islemleri tamam   
        if(time>19){
	    	day++;
	    	time = 10;
	    }
	    
	    if(time<=13){
	    	foods=readTxt(ogleYemek,day);
			type="ÖÐLE YEMEÐÝ / LUNCH";
	    }
	    else{
			foods=readTxt(aksamStream,day);	
			type="AKÞAM YEMEÐÝ / DÝNNER";
		}
	    
	    if(foods[0]==null){
	    	TextView textview = (TextView) findViewById(R.id.t4);	
	    	textview.setTypeface(tf);	    

	    	LinearLayout.LayoutParams params1 = new 
	    			   LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
	    	textview.setLayoutParams(params1);
	    	textview.setGravity(Gravity.CENTER_HORIZONTAL);
	    	ImageView im = (ImageView) findViewById(R.id.imageView1);
	    	im.setVisibility(View.GONE);
	    	textview.setText("There is no food service today.");
	    	
	    	}
	    
	    else{
	    String month = new String();
	    TextView textview1 = (TextView)findViewById(R.id.t1);
	    TextView textview2 = (TextView)findViewById(R.id.t2);
	    TextView textview3 = (TextView)findViewById(R.id.t3);
	    TextView textview4 = (TextView)findViewById(R.id.t4);
	    TextView textview5 = (TextView)findViewById(R.id.t5);
	    TextView textview6 = (TextView)findViewById(R.id.t6);
	    TextView textview7 = (TextView)findViewById(R.id.t7);
	    TextView tv8 = (TextView)findViewById(R.id.textView1);
	    TextView tv9 = (TextView) findViewById(R.id.t9);
	    
	    switch (mo+1){
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
	    
	    textview1.setText(foods[0]+" "+month+" "+Integer.toString(ye));
	    tv9.setText(type);
	    textview2.setText(foods[1]);
	    textview3.setText(foods[2]);
	    textview4.setText(foods[3]);
	    textview5.setText(foods[4]);
	    textview6.setText(foods[5]);
	    textview7.setText(foods[6]);
	    tv8.setText("HAVE A NICE MEAL :)");
	    
	    textview1.setTypeface(tf);
	    tv9.setTypeface(tf);
	    textview1.setTypeface(tf);	    
	    textview2.setTypeface(tf);	    
	    textview3.setTypeface(tf);	    
	    textview4.setTypeface(tf);
	    textview5.setTypeface(tf);	    
	    textview6.setTypeface(tf);	    
	    textview7.setTypeface(tf);	    
	    tv8.setTypeface(tf);
	    }
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

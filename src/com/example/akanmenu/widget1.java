package com.example.akanmenu;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Typeface;
import android.widget.RemoteViews;
import com.metuncccafeteria.R;

public class widget1 extends AppWidgetProvider{
   
	public static Typeface tf ;

    RemoteViews rmViews;
    ComponentName cmName;
    AppWidgetManager appWidgetManager;
    
	@Override
    public void onUpdate( Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds ){
        //widget çalýþtýðýnda ilk olarak bu metod çaðýrýlýr
	    rmViews = new RemoteViews(context.getPackageName(), R.layout.main);
	    appWidgetManager = this.appWidgetManager;
	    cmName = new ComponentName(context, widget1.class);
	    super.onUpdate(context, appWidgetManager, appWidgetIds);
		InputStream aksamStream = context.getResources().openRawResource(R.raw.aksamyemek);
	    InputStream ogleYemek = context.getResources().openRawResource(R.raw.oglenyemek);

		String[] foods=new String[7];

	    int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		int time = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		
		if(time>19){
	    	day++;
	    	time = 10;
	    }
	    if(time<=13){
	    	foods=readTxt(ogleYemek,day);
	    }
	    else{
			foods=readTxt(aksamStream,day);	
		}
	    
	    	
	    if(foods[0]==null){
	    	foods[2]="There is no food service today.";
	    	M.updateWidget(context, appWidgetIds[0],foods); 
	    	}
	    
	    else{
    
	    	int appWidgetId;
	            appWidgetId = appWidgetIds[0] ;

	            // I previously saved "widgetLabel" when I created the widget in my 
	            // ConfigurationActivity
	            M.updateWidget(context, appWidgetId, foods);
	                // I put this in another class so it's more manageable.
	        }
	    
	    
	    
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
	        System.exit(0);	
	        }
	    return foods;
	}
		

}
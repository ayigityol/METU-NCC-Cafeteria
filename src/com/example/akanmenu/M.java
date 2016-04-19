package com.example.akanmenu;

import java.util.Calendar;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.RemoteViews;
import com.metuncccafeteria.R;

public class M {

	public static void updateWidget(Context context, int appWidgetId, String[] widgetLabel){

        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();

        RemoteViews updateViews;
        int layoutId = R.layout.main;
        int viewId = R.id.main;
        int time = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        
        updateViews = new RemoteViews(context.getPackageName(),
                layoutId);
        updateViews.setTextViewText(R.id.widget3, "     "+widgetLabel[2]);
        
        if(!(widgetLabel[2].equals("There is no food service today."))){
	        updateViews.setTextViewText(R.id.widget, "Closest meal");
        	if(time<14||time>19){
	        	updateViews.setTextViewText(R.id.widget2, "Lunch / Öðle Yemeði");
        		}
        	else{
        		updateViews.setTextViewText(R.id.widget2, "Dinner / Akþam Yemeði");
        	} 
	        updateViews.setTextViewText(R.id.widget4, "     "+widgetLabel[3]);
	        updateViews.setTextViewText(R.id.widget5, "     "+widgetLabel[4]);
	        updateViews.setTextViewText(R.id.widget6, "     "+widgetLabel[5]);
	        updateViews.setTextViewText(R.id.widget7, "     "+widgetLabel[6]);
	    }
        editor.commit();

        Intent intent = new Intent(context, widget1.class); 
        PendingIntent pendingIntent = PendingIntent.getActivity(context, appWidgetId, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        updateViews.setOnClickPendingIntent(viewId, pendingIntent);

        AppWidgetManager.getInstance(context).updateAppWidget(appWidgetId, updateViews);
    }
}

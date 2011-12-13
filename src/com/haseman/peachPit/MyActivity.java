package com.haseman.peachPit;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

public class MyActivity extends Activity {

	private BroadcastReceiver simpleReceiver = new BroadcastReceiver() {
		public void onReceive(Context context, Intent intent) {
			if(intent.getAction() == null)
				return;
			if(intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
				Toast.makeText(context, R.string.airplane_change, Toast.LENGTH_LONG).show();
			}
			
		}
	};
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(simpleReceiver, intentFilter);
    }
    public void onStop(){
    	super.onStop();
    }
    public void onDestroy(){
    	super.onDestroy();
    	unregisterReceiver(simpleReceiver);	
    }
    public boolean onKeyDown(int keyCode, KeyEvent event){
    	if(keyCode == KeyEvent.KEYCODE_DPAD_CENTER){
    		Intent startIntent=new Intent(this, NewActivity.class);
    		startActivity(startIntent);
    		return true;
    	}
    	if(keyCode == KeyEvent.KEYCODE_DPAD_DOWN){
    		Intent actionStartIntent= new Intent("com.haseman.PURPLE_PONY_POWER");
    		actionStartIntent.putExtra("newBodyText", "You Pressed the Down Key!");
    		startActivity(actionStartIntent);
    	}
    	return super.onKeyDown(keyCode, event);
    }
}
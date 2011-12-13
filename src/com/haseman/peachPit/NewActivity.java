package com.haseman.peachPit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NewActivity extends Activity{

	public void onCreate(Bundle icicle){
		super.onCreate(icicle);
		setContentView(R.layout.new_activity);
		Intent currentIntent = getIntent();
		if(currentIntent.hasExtra("newBodyText")){
			String newText = currentIntent.getExtras().getString("newBodyText");
			TextView bodyView = (TextView)findViewById(R.id.new_activity_text_view);
			bodyView.setText(newText);
		}
	}
}

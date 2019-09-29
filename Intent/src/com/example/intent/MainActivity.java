package com.example.intent;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button homeBtn;
    Button urlBtn;
    Button sendSmsBtn;
    Button dialViewBtn;
    Button dialBtn;
    Button openCameraBtn;
    Button secondActivityBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeBtn=(Button)this.findViewById(R.id.homeBtn);
        urlBtn=(Button)this.findViewById(R.id.urlBtn);
        sendSmsBtn=(Button)this.findViewById(R.id.sendSmsBtm);
        dialViewBtn=(Button)this.findViewById(R.id.dialViewBtn);
        dialBtn=(Button)this.findViewById(R.id.dialBtn);
        openCameraBtn=(Button)this.findViewById(R.id.openCameraBtn);
        secondActivityBtn=(Button)this.findViewById(R.id.secondActivityBtn);
        
        homeBtn.setOnClickListener(new View.OnClickListener() {
        	
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent();
				intent.setAction(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				startActivity(intent);
			}
		});
			
        urlBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("www.baidu.com"));
				intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
				startActivity(intent);
			}
		});
        
        sendSmsBtn.setOnClickListener(new View.OnClickListener() {
        	
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent();
				intent.setAction(Intent.ACTION_SENDTO);
				intent.addCategory("android.intent.category.DEFAULT");
				intent.setData(Uri.parse("smsto:17666415927"));
				intent.putExtra("sms_body", "土豪我们做朋友吧");
				startActivity(intent);
			}
		});
        
        dialViewBtn.setOnClickListener(new View.OnClickListener() {
        	
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent();
				intent.setAction(intent.ACTION_DIAL);
    			intent.setData(Uri.parse("tel:17666415927"));
				startActivity(intent);
			}
		});
        
        dialBtn.setOnClickListener(new View.OnClickListener() {
        	
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent();
				intent.setAction(intent.ACTION_CALL);
    			intent.setData(Uri.parse("tel:17666415927"));
				startActivity(intent);
			}
		});
        
        openCameraBtn.setOnClickListener(new View.OnClickListener() {
        	
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent();
				intent.setAction("android.media.action.IMAGE_CAPTURE");
				intent.addCategory("android.intent.category.DEFAULT");
				startActivity(intent);
			}
		});
        
        secondActivityBtn.setOnClickListener(new View.OnClickListener() {
        	
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent();
				intent.setClassName(MainActivity.this,"com.example.intent.SecondActivity");
				startActivity(intent);
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

package com.android.letmesee;

import com.android.beefnky.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
 
import library.*;
import photoLib.*;
import imageFromUrl.*;
 
public class DashboardActivity extends Activity {
    
	UserFunctions userFunctions;
	
    Button btnLogout;
    Button photographs;
    Button contract;
    Button communication;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         
        /**
         * Dashboard Screen for the application
         * */       
        // Check login status in database
        userFunctions = new UserFunctions();
    
        //if(userFunctions.isUserLoggedIn(getApplicationContext())){
        // user already logged in show databoard
            setContentView(R.layout.dashboard);
            btnLogout = (Button) findViewById(R.id.logoutBtn); 
            btnLogout.setOnClickListener(new View.OnClickListener() {
                 
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    userFunctions.logoutUser(getApplicationContext());
                    Intent login = new Intent(getApplicationContext(), LoginActivity.class);
                    login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(login);
                    // Closing dashboard screen
                    finish();
                }
            });
            
            photographs = (Button) findViewById(R.id.photoBtn); 
            photographs.setOnClickListener(new View.OnClickListener() {
                
               public void onClick(View arg0) {
            	   Intent photographs = new Intent(getApplicationContext(), PhotoMenuActivity.class);
            	   //photographs.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            	   startActivity(photographs);
            	   // Closing dashbaod screen
            	   //finish();
               }
            });
            
            contract = (Button) findViewById(R.id.contractBtn);
            contract.setOnClickListener(new View.OnClickListener() {
            	public void onClick(View arg0) {
            	   Intent contract = new Intent(getApplicationContext(), ContractActivity.class);
             	   //contract.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
             	   startActivity(contract);
             	   // Closing dashboard screen
             	   //finish();
            	}
            });
            
            communication = (Button) findViewById(R.id.commBtn);
            communication.setOnClickListener(new View.OnClickListener() {
            	public void onClick(View arg9) {
            		
            	}
            });
             
        /*}else{
            // user is not logged in show login screen
            Intent login = new Intent(getApplicationContext(), LoginActivity.class);
            login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(login);
            // Closing dashboard screen
            finish();
        } */
    }
}
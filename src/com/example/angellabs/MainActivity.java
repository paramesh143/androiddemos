package com.example.angellabs;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;



 
public class MainActivity extends TabActivity {
 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
 
		//Resources ressources = getResources(); 
		TabHost tabHost = getTabHost(); 
 
		// Android tab
		Intent intentHome = new Intent().setClass(this, Home.class);
		TabSpec tabSpecHome = tabHost
		  .newTabSpec("Home")
		  .setIndicator("Home")
		  .setContent(intentHome);
 
		// Apple tab
		Intent intentEntreprenures = new Intent().setClass(this, Entreprenuers.class);
		TabSpec tabSpecEntreprenures = tabHost
		  .newTabSpec("Entreprenuers")
		 .setIndicator("Entreprenuers")
		  .setContent(intentEntreprenures);
 
		// Windows tab
		Intent intentInvestors = new Intent().setClass(this, Investors.class);
		TabSpec tabSpecInvestors = tabHost
		  .newTabSpec("Investors")
		  .setIndicator("Investors")
		  .setContent(intentInvestors);
 
		// Blackberry tab
		Intent intentCompanies = new Intent().setClass(this, Companies.class);
		TabSpec tabSpecCompanies = tabHost
		  .newTabSpec("Companies")
		 .setIndicator("Companies") 
		  .setContent(intentCompanies);
 
		// add all tabs 
		tabHost.addTab(tabSpecHome);
		tabHost.addTab(tabSpecEntreprenures);
		tabHost.addTab(tabSpecInvestors);
		tabHost.addTab(tabSpecCompanies);
 
		//set Windows tab as default (zero based)
		tabHost.setCurrentTab(2);
	}
 
}

package org.hicapacity.techhui;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class TechHuiActivity extends TabActivity {
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    Resources res = getResources(); // Resource object to get Drawables
    TabHost tabHost = getTabHost(); // The activity TabHost
    TabHost.TabSpec spec; // Resusable TabSpec for each tab
    Intent intent; // Reusable Intent for each tab

    // Create an Intent to launch an Activity for the tab (to be reused)
    intent = new Intent().setClass(this, ConferenceActivity.class);

    // Initialize a TabSpec for each tab and add it to the TabHost
    spec = tabHost.newTabSpec("conference")
        .setIndicator("Conference", res.getDrawable(R.drawable.ic_tab_conference))
        .setContent(intent);
    tabHost.addTab(spec);

    // Do the same for the other tabs
    intent = new Intent().setClass(this, WebScheduleActivity.class);
    spec = tabHost.newTabSpec("web_schedule")
        .setIndicator("Web Schedule", res.getDrawable(R.drawable.ic_tab_conference)).setContent(intent);
    tabHost.addTab(spec);

    intent = new Intent().setClass(this, CommunityActivity.class);
    spec = tabHost.newTabSpec("community")
        .setIndicator("Community", res.getDrawable(R.drawable.ic_tab_community)).setContent(intent);
    tabHost.addTab(spec);

    tabHost.setCurrentTab(2);
  }
}
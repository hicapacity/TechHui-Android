package org.hicapacity.techhui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * @author Jason Axelson
 * 
 */
public class ConferenceActivity extends Activity {
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    TextView textview = new TextView(this);
    textview.setText("This is the conference tab");
    setContentView(textview);
  }
}

package org.hicapacity.techhui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class NewSplashScreen extends Activity {

  /**
   * The thread to process splash screen events
   */
  private Thread mSplashThread;

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Splash screen view
    setContentView(R.layout.splash);
    
    ImageView timeView = (ImageView) this.findViewById(R.id.SplashImageView);
    timeView.setScaleType(ScaleType.FIT_XY);
    
    final NewSplashScreen sPlashScreen = this;
    
//    imgview.setScaleType(ScaleType.FIT_XY);

    // The thread to wait for splash screen events
    mSplashThread = new Thread() {
      @Override
      public void run() {
        try {
          synchronized (this) {
            // Wait given period of time or exit on touch
            wait(1000);
          }
        }
        catch (InterruptedException ex) {
        }

        finish();

        // Run next activity
        Intent intent = new Intent();
        intent.setClass(sPlashScreen, TechHuiActivity.class);
        startActivity(intent);
        stop();
      }
    };

    mSplashThread.start();
  }

  /**
   * Processes splash screen touch events
   */
  @Override
  public boolean onTouchEvent(MotionEvent evt) {
    if (evt.getAction() == MotionEvent.ACTION_DOWN) {
      synchronized (mSplashThread) {
        mSplashThread.notifyAll();
      }
    }
    return true;
  }
}
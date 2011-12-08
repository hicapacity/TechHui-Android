package org.hicapacity.techhui;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * @author Jason Axelson
 * 
 */
public class SongsActivity extends Activity {
  WebView mWebView;

  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.webview);

    mWebView = (WebView) findViewById(R.id.webview);
    System.out.println("webview is: " + mWebView);
    mWebView.getSettings().setJavaScriptEnabled(true);
    mWebView.loadUrl("http://www.techhui.com/page/2011-techhui-conference-schedule");
  }
}

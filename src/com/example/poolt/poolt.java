package com.example.poolt;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.os.Handler;

public class poolt extends Activity
{
	private WebView myWebView;

	private Handler mHandler = new Handler();
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		myWebView = (WebView) findViewById(R.id.webview);
		WebSettings webSettings = myWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		myWebView.setWebViewClient(new WebViewClient());
//     myWebView.setWebChromeClient(new MyWebChromeClient());
    myWebView.addJavascriptInterface(new DemoJavaScriptInterface(), "demo");
		myWebView.loadUrl("file:///android_asset/rc.html");
	}


	final class DemoJavaScriptInterface {

		DemoJavaScriptInterface() {
		}

		/**
		* This is not called on the UI thread. Post a runnable to invoke
		* loadUrl on the UI thread.
		*/
		public void clickOnAndroid1() {
			mHandler.post(new Runnable() {
				public void run() {
					myWebView.loadUrl("javascript:wave(1)");
				}
			});
		}
		public void clickOnAndroid2() {
			mHandler.post(new Runnable() {
				public void run() {
					myWebView.loadUrl("javascript:wave(2)");
				}
			});
		}
	}
}

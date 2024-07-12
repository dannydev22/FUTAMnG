package com.varia.neny;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import android.widget.LinearLayout;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.util.Timer;
import java.util.TimerTask;
import com.narayanacharya.waveview.*;
import com.yangp.ypwaveview.*;
import com.android.volley.*;
import jp.wasabeef.picasso.transformations.*;
import com.facebook.shimmer.*;
import com.skydoves.transformationlayout.*;
import smith.lib.showmoreview.*;
import com.tapadoo.alerter.*;
import com.bachors.wordtospan.*;
import com.aghajari.spannabletext.*;
import com.shobhitpuri.custombuttons.*;
import org.jetbrains.kotlin.*;
import com.github.angads25.filepicker.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class VideoActivity extends AppCompatActivity {
	private Timer _timer = new Timer();
	
	private LinearLayout linear1;
	private WebView webview1;
	
	private RequestNetwork req;
	private RequestNetwork.RequestListener _req_request_listener;
	private AlertDialog.Builder a;
	private ProgressDialog q;
	private TimerTask aaa;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.video);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		webview1 = (WebView) findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		req = new RequestNetwork(this);
		a = new AlertDialog.Builder(this);
		
		webview1.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				
				super.onPageFinished(_param1, _param2);
			}
		});
		
		_req_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		if (SketchwareUtil.isConnected(getApplicationContext())) {
			webview1.loadUrl("data:text/html, <head>\n  <link href=\"https://vjs.zencdn.net/8.6.1/video-js.css\" rel=\"stylesheet\" />\n\n  <!-- If you'd like to support IE8 (for Video.js versions prior to v7) -->\n  <!-- <script src=\"https://vjs.zencdn.net/ie8/1.1.2/videojs-ie8.min.js\"></script> -->\n</head>\n\n<style>\n  body, html {\n    margin: 0;\n    padding: 0;\n    width: 100%;\n    height: 100%;\n  }\n\n  .video-js {\n    width: 100% !important;\n    height: 100% !important;\n  }\n</style>\n\n<body>\n  <video\n    id=\"my-video\"\n    class=\"video-js\"\n    controls\n    preload=\"auto\"\n    poster=\"MY_VIDEO_POSTER.jpg\"\n    data-setup=\"{}\"\n  >\n    <source src=\"".concat(getIntent().getStringExtra("url").concat("\" type=\"video/mp4\" />\n    <source src=\"".concat(getIntent().getStringExtra("url").concat("\" type=\"video/webm\" />\n    <p class=\"vjs-no-js\">\n      To view this video please enable JavaScript, and consider upgrading to a\n      web browser that\n      <a href=\"https://videojs.com/html5-video-support/\" target=\"_blank\"\n        >supports HTML5 video</a\n      >\n    </p>\n  </video>\n<script src=\"https://vjs.zencdn.net/8.6.1/video.min.js\"></script>\n</body>")))));
			webview1.setWebChromeClient(new CustomWebClient());
			// Ative o suporte a JavaScript no WebView
			webview1.getSettings().setJavaScriptEnabled(true);
			webview1.getSettings().setDomStorageEnabled(true);
			webview1.getSettings().setAllowFileAccessFromFileURLs(true);
			webview1.getSettings().setAllowUniversalAccessFromFileURLs(true);
		}
		else {
			a.setTitle("No Internet");
			a.setMessage("No Internet connection detected, retry?");
			a.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					if (SketchwareUtil.isConnected(getApplicationContext())) {
						webview1.loadUrl("data:text/html, <head>\n  <link href=\"https://vjs.zencdn.net/8.6.1/video-js.css\" rel=\"stylesheet\" />\n\n  <!-- If you'd like to support IE8 (for Video.js versions prior to v7) -->\n  <!-- <script src=\"https://vjs.zencdn.net/ie8/1.1.2/videojs-ie8.min.js\"></script> -->\n</head>\n\n<style>\n  body, html {\n    margin: 0;\n    padding: 0;\n    width: 100%;\n    height: 100%;\n  }\n\n  .video-js {\n    width: 100% !important;\n    height: 100% !important;\n  }\n</style>\n\n<body>\n  <video\n    id=\"my-video\"\n    class=\"video-js\"\n    controls\n    preload=\"auto\"\n    poster=\"MY_VIDEO_POSTER.jpg\"\n    data-setup=\"{}\"\n  >\n    <source src=\"".concat(getIntent().getStringExtra("url").concat("\" type=\"video/mp4\" />\n    <source src=\"".concat(getIntent().getStringExtra("url").concat("\" type=\"video/webm\" />\n    <p class=\"vjs-no-js\">\n      To view this video please enable JavaScript, and consider upgrading to a\n      web browser that\n      <a href=\"https://videojs.com/html5-video-support/\" target=\"_blank\"\n        >supports HTML5 video</a\n      >\n    </p>\n  </video>\n<script src=\"https://vjs.zencdn.net/8.6.1/video.min.js\"></script>\n</body>")))));
						webview1.setWebChromeClient(new CustomWebClient());
						// Ative o suporte a JavaScript no WebView
						webview1.getSettings().setJavaScriptEnabled(true);
						webview1.getSettings().setDomStorageEnabled(true);
						webview1.getSettings().setAllowFileAccessFromFileURLs(true);
						webview1.getSettings().setAllowUniversalAccessFromFileURLs(true);
					}
					else {
						a.setTitle("No Internet");
						a.setMessage("No Internet connection detected, retry?");
						a.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								SketchwareUtil.showMessage(getApplicationContext(), "PLEASE Wait");
								webview1.loadUrl("data:text/html, <head>\n  <link href=\"https://vjs.zencdn.net/8.6.1/video-js.css\" rel=\"stylesheet\" />\n\n  <!-- If you'd like to support IE8 (for Video.js versions prior to v7) -->\n  <!-- <script src=\"https://vjs.zencdn.net/ie8/1.1.2/videojs-ie8.min.js\"></script> -->\n</head>\n\n<style>\n  body, html {\n    margin: 0;\n    padding: 0;\n    width: 100%;\n    height: 100%;\n  }\n\n  .video-js {\n    width: 100% !important;\n    height: 100% !important;\n  }\n</style>\n\n<body>\n  <video\n    id=\"my-video\"\n    class=\"video-js\"\n    controls\n    preload=\"auto\"\n    poster=\"MY_VIDEO_POSTER.jpg\"\n    data-setup=\"{}\"\n  >\n    <source src=\"".concat(getIntent().getStringExtra("url").concat("\" type=\"video/mp4\" />\n    <source src=\"".concat(getIntent().getStringExtra("url").concat("\" type=\"video/webm\" />\n    <p class=\"vjs-no-js\">\n      To view this video please enable JavaScript, and consider upgrading to a\n      web browser that\n      <a href=\"https://videojs.com/html5-video-support/\" target=\"_blank\"\n        >supports HTML5 video</a\n      >\n    </p>\n  </video>\n<script src=\"https://vjs.zencdn.net/8.6.1/video.min.js\"></script>\n</body>")))));
								webview1.setWebChromeClient(new CustomWebClient());
								// Ative o suporte a JavaScript no WebView
								webview1.getSettings().setJavaScriptEnabled(true);
								webview1.getSettings().setDomStorageEnabled(true);
								webview1.getSettings().setAllowFileAccessFromFileURLs(true);
								webview1.getSettings().setAllowUniversalAccessFromFileURLs(true);
							}
						});
						a.setNegativeButton("NO", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								finish();
							}
						});
						a.create().show();
					}
				}
			});
			a.setNegativeButton("NO", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					finish();
				}
			});
			a.create().show();
		}
	}
	 @Override
	public void onUserLeaveHint () {
		    if (true) {
			        enterPictureInPictureModee();
			    }
	}
	 @Override
	public void onPictureInPictureModeChanged (boolean isInPictureInPictureMode, Configuration newConfig) {
		    if (isInPictureInPictureMode) {
			        // Hide the full-screen UI (controls, etc.) while in picture-in-picture mode.
			    } else {
			        // Restore the full-screen UI.
			    }
	}
	public void enterPictureInPictureModee() {
			enterPictureInPictureMode(new PictureInPictureParams.Builder()
			.setAspectRatio(new Rational(9,16))
			.build());
	}
	{
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onStop() {
		super.onStop();
		finishAndRemoveTask();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		finishAndRemoveTask();
	}
	public void _FullScreenLib () {
	}
	
	
	public class CustomWebClient extends WebChromeClient {
		
		private View mCustomView;
		
		private WebChromeClient.CustomViewCallback mCustomViewCallback;
		
		protected FrameLayout frame;
		
		
		// Initially mOriginalOrientation is set to Landscape
		
		private int mOriginalOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
		
		private int mOriginalSystemUiVisibility;
		
		
		// Constructor for CustomWebClient
		
		public CustomWebClient() {}
		
		
		public Bitmap getDefaultVideoPoster() {
			
			if (VideoActivity.this == null) {
				
				return null; }
			
			return BitmapFactory.decodeResource(VideoActivity.this.getApplicationContext().getResources(), 2130837573); }
		
		
		public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback viewCallback) {
			
			if (this.mCustomView != null) {
				
				onHideCustomView();
				
				return; }
			
			this.mCustomView = paramView;
			
			this.mOriginalSystemUiVisibility = VideoActivity.this.getWindow().getDecorView().getSystemUiVisibility();
			
			// When CustomView is shown screen orientation changes to mOriginalOrientation (Landscape).
			
			
			VideoActivity.this.setRequestedOrientation(this.mOriginalOrientation);
			
			
			
			// After that mOriginalOrientation is set to portrait.
			
			this.mOriginalOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
			
			this.mCustomViewCallback = viewCallback; ((FrameLayout)VideoActivity.this.getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1)); VideoActivity.this.getWindow().getDecorView().setSystemUiVisibility(3846);
			
		}
		
		
		public void onHideCustomView() {
			
			((FrameLayout)VideoActivity.this.getWindow().getDecorView()).removeView(this.mCustomView);
			
			this.mCustomView = null;
			
			VideoActivity.this.getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
			
			// When CustomView is hidden, screen orientation is set to mOriginalOrientation (portrait).
			
			
			
			VideoActivity.this.setRequestedOrientation(this.mOriginalOrientation);
			
			// After that mOriginalOrientation is set to landscape.
			
			
			
			this.mOriginalOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE; this.mCustomViewCallback.onCustomViewHidden();
			
			this.mCustomViewCallback = null;
			
		}
		
	}
	
	
	{
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}
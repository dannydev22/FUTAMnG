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
import android.widget.TextView;
import android.widget.ScrollView;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdRequest;
import android.widget.ImageView;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
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


public class AboutActivity extends AppCompatActivity {
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private TextView textview1;
	private ScrollView vscroll2;
	private LinearLayout linear50;
	private LinearLayout main;
	private LinearLayout license;
	private AdView adview1;
	private LinearLayout beta;
	private LinearLayout linear37;
	private LinearLayout v_main;
	private LinearLayout c_main;
	private LinearLayout w_main;
	private TextView title;
	private LinearLayout x;
	private LinearLayout facebook;
	private LinearLayout telegram;
	private LinearLayout WhatsApp;
	private LinearLayout Yotube;
	private ImageView imageview2;
	private LinearLayout linear38;
	private TextView name_app;
	private TextView des_app;
	private ImageView ic_ver;
	private LinearLayout linear40;
	private TextView version;
	private TextView des_ver;
	private ImageView ic_contact;
	private LinearLayout linear42;
	private TextView contact;
	private TextView des_contact;
	private ImageView ic_web;
	private LinearLayout linear44;
	private TextView website;
	private TextView des_website;
	private ImageView ic_twitter;
	private LinearLayout linear67;
	private TextView twitter;
	private TextView textview2;
	private ImageView noy;
	private LinearLayout linear54;
	private TextView m2;
	private TextView des_2;
	private ImageView a11;
	private LinearLayout linear52;
	private TextView m1;
	private TextView des_1;
	private ImageView imageview3;
	private LinearLayout linear68;
	private TextView textview3;
	private TextView textview4;
	private ImageView ic_youtube;
	private TextView youtube;
	private TextView b1;
	private TextView des_b1;
	
	private Intent q = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.about);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		textview1 = (TextView) findViewById(R.id.textview1);
		vscroll2 = (ScrollView) findViewById(R.id.vscroll2);
		linear50 = (LinearLayout) findViewById(R.id.linear50);
		main = (LinearLayout) findViewById(R.id.main);
		license = (LinearLayout) findViewById(R.id.license);
		adview1 = (AdView) findViewById(R.id.adview1);
		beta = (LinearLayout) findViewById(R.id.beta);
		linear37 = (LinearLayout) findViewById(R.id.linear37);
		v_main = (LinearLayout) findViewById(R.id.v_main);
		c_main = (LinearLayout) findViewById(R.id.c_main);
		w_main = (LinearLayout) findViewById(R.id.w_main);
		title = (TextView) findViewById(R.id.title);
		x = (LinearLayout) findViewById(R.id.x);
		facebook = (LinearLayout) findViewById(R.id.facebook);
		telegram = (LinearLayout) findViewById(R.id.telegram);
		WhatsApp = (LinearLayout) findViewById(R.id.WhatsApp);
		Yotube = (LinearLayout) findViewById(R.id.Yotube);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		linear38 = (LinearLayout) findViewById(R.id.linear38);
		name_app = (TextView) findViewById(R.id.name_app);
		des_app = (TextView) findViewById(R.id.des_app);
		ic_ver = (ImageView) findViewById(R.id.ic_ver);
		linear40 = (LinearLayout) findViewById(R.id.linear40);
		version = (TextView) findViewById(R.id.version);
		des_ver = (TextView) findViewById(R.id.des_ver);
		ic_contact = (ImageView) findViewById(R.id.ic_contact);
		linear42 = (LinearLayout) findViewById(R.id.linear42);
		contact = (TextView) findViewById(R.id.contact);
		des_contact = (TextView) findViewById(R.id.des_contact);
		ic_web = (ImageView) findViewById(R.id.ic_web);
		linear44 = (LinearLayout) findViewById(R.id.linear44);
		website = (TextView) findViewById(R.id.website);
		des_website = (TextView) findViewById(R.id.des_website);
		ic_twitter = (ImageView) findViewById(R.id.ic_twitter);
		linear67 = (LinearLayout) findViewById(R.id.linear67);
		twitter = (TextView) findViewById(R.id.twitter);
		textview2 = (TextView) findViewById(R.id.textview2);
		noy = (ImageView) findViewById(R.id.noy);
		linear54 = (LinearLayout) findViewById(R.id.linear54);
		m2 = (TextView) findViewById(R.id.m2);
		des_2 = (TextView) findViewById(R.id.des_2);
		a11 = (ImageView) findViewById(R.id.a11);
		linear52 = (LinearLayout) findViewById(R.id.linear52);
		m1 = (TextView) findViewById(R.id.m1);
		des_1 = (TextView) findViewById(R.id.des_1);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		linear68 = (LinearLayout) findViewById(R.id.linear68);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview4 = (TextView) findViewById(R.id.textview4);
		ic_youtube = (ImageView) findViewById(R.id.ic_youtube);
		youtube = (TextView) findViewById(R.id.youtube);
		b1 = (TextView) findViewById(R.id.b1);
		des_b1 = (TextView) findViewById(R.id.des_b1);
		
		license.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		c_main.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				q.setAction(Intent.ACTION_VIEW);
				q.setData(Uri.parse("mailto:".concat("thessenceafrica@gmail.com")));
				startActivity(q);
			}
		});
		
		w_main.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_open_chrome("https://www.essenceafrica.blogspot.com");
			}
		});
		
		x.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		facebook.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		telegram.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		Yotube.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
	}
	
	private void initializeLogic() {
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
		adview1.loadAd(new AdRequest.Builder().addTestDevice("0AA049AB4EB220E38785E314AF907584")
		.build());
		_Ripples();
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _open_chrome (final String _string) {
		androidx.browser.customtabs.CustomTabsIntent.Builder builder = new androidx.browser.customtabs.CustomTabsIntent.Builder();
		androidx.browser.customtabs.CustomTabsIntent customTabsIntent = builder.build();
		customTabsIntent.launchUrl(getCurrentContext(this), Uri.parse(_string));
		
		
		
	}
	
	public Context getCurrentContext(Context c) {
		    return c;
	}
	public Context getCurrentContext(Fragment c) {
		    return c.getActivity();
	}
	public Context getCurrentContext(DialogFragment c) {
		    return c.getActivity();
	}
	
	
	{
	}
	
	
	public void _ripple (final View _view) {
		_view.setBackground(new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{0xFFB0B0B0}), null, null));
		_view.setClickable(true);
		
		/*Created by Sketchy Designer
You can use this code in More Block*/
	}
	
	
	public void _Ripples () {
		_GradientDrawable(v_main, 20, 1, 10, "#FAFAFA", "#673AB7", true, false, 800);
		_GradientDrawable(c_main, 20, 1, 10, "#FAFAFA", "#673AB7", true, false, 800);
		_GradientDrawable(w_main, 20, 1, 10, "#FAFAFA", "#673AB7", true, false, 800);
		_GradientDrawable(x, 20, 1, 10, "#FAFAFA", "#673AB7", true, false, 800);
		_GradientDrawable(facebook, 20, 1, 10, "#FAFAFA", "#673AB7", true, false, 800);
		_GradientDrawable(telegram, 20, 1, 10, "#FAFAFA", "#673AB7", true, false, 800);
		_GradientDrawable(WhatsApp, 20, 1, 10, "#FAFAFA", "#673AB7", true, false, 800);
		_GradientDrawable(Yotube, 20, 1, 10, "#FAFAFA", "#673AB7", true, false, 800);
		_GradientDrawable(license, 20, 1, 10, "#FAFAFA", "#673AB7", true, false, 800);
	}
	
	
	public void _GradientDrawable (final View _view, final double _radius, final double _stroke, final double _shadow, final String _color, final String _borderColor, final boolean _ripple, final boolean _clickAnim, final double _animDuration) {
		if (_ripple) {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			gd.setStroke((int)_stroke,Color.parseColor(_borderColor));
			if (Build.VERSION.SDK_INT >= 21){
				_view.setElevation((int)_shadow);}
			android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor("#9e9e9e")});
			android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , gd, null);
			_view.setClickable(true);
			_view.setBackground(ripdrb);
		}
		else {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			gd.setStroke((int)_stroke,Color.parseColor(_borderColor));
			_view.setBackground(gd);
			if (Build.VERSION.SDK_INT >= 21){
				_view.setElevation((int)_shadow);}
		}
		if (_clickAnim) {
			_view.setOnTouchListener(new View.OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					switch (event.getAction()){
						case MotionEvent.ACTION_DOWN:{
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(_view);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues(0.9f);
							scaleX.setDuration((int)_animDuration);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(_view);
							scaleY.setPropertyName("scaleY");
							scaleY.setFloatValues(0.9f);
							scaleY.setDuration((int)_animDuration);
							scaleY.start();
							break;
						}
						case MotionEvent.ACTION_UP:{
							
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(_view);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues((float)1);
							scaleX.setDuration((int)_animDuration);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(_view);
							scaleY.setPropertyName("scaleY");
							scaleY.setFloatValues((float)1);
							scaleY.setDuration((int)_animDuration);
							scaleY.start();
							
							break;
						}
					}
					return false;
				}
			});
		}
		_view.setClipToOutline(true);
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
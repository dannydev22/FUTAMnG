package com.varia.neny;

import com.varia.neny.IntroActivity;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Timer;
import java.util.TimerTask;
import android.view.View;
import android.graphics.Typeface;
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
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class MainActivity extends AppCompatActivity {
	private Timer _timer = new Timer();
	
	private String fontName = "";
	private String typeace = "";
	private boolean ifEnabled = false;
	private String success = "";
	
	private LinearLayout toolbar;
	private LinearLayout linear1;
	private LinearLayout linear3;
	private WaveView linear4;
	private ImageView back;
	private TextView textview4;
	private TextView textview7;
	private TextView title;
	private TextView textview8;
	private EditText email;
	private TextView errormessage1;
	private EditText pw;
	private TextView errormessage2;
	private LinearLayout linear2;
	private TextView textview5;
	private TextView signin;
	private LinearLayout linear5;
	private TextView help;
	private TextView textview6;
	private TextView create;
	
	private Intent i = new Intent();
	private FirebaseAuth auth;
	private OnCompleteListener<Void> auth_updateEmailListener;
	private OnCompleteListener<Void> auth_updatePasswordListener;
	private OnCompleteListener<Void> auth_emailVerificationSentListener;
	private OnCompleteListener<Void> auth_deleteUserListener;
	private OnCompleteListener<Void> auth_updateProfileListener;
	private OnCompleteListener<AuthResult> auth_phoneAuthListener;
	private OnCompleteListener<AuthResult> auth_googleSignInListener;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private TimerTask t;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		}
		else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		toolbar = (LinearLayout) findViewById(R.id.toolbar);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (WaveView) findViewById(R.id.linear4);
		back = (ImageView) findViewById(R.id.back);
		textview4 = (TextView) findViewById(R.id.textview4);
		textview7 = (TextView) findViewById(R.id.textview7);
		title = (TextView) findViewById(R.id.title);
		textview8 = (TextView) findViewById(R.id.textview8);
		email = (EditText) findViewById(R.id.email);
		errormessage1 = (TextView) findViewById(R.id.errormessage1);
		pw = (EditText) findViewById(R.id.pw);
		errormessage2 = (TextView) findViewById(R.id.errormessage2);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		textview5 = (TextView) findViewById(R.id.textview5);
		signin = (TextView) findViewById(R.id.signin);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		help = (TextView) findViewById(R.id.help);
		textview6 = (TextView) findViewById(R.id.textview6);
		create = (TextView) findViewById(R.id.create);
		auth = FirebaseAuth.getInstance();
		
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		signin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
				if (pw.getText().toString().equals("") && email.getText().toString().equals("")) {
					errormessage1.setVisibility(View.VISIBLE);
					errormessage2.setVisibility(View.VISIBLE);
				}
				else {
					_BottomSheet();
					auth.signInWithEmailAndPassword(email.getText().toString(), pw.getText().toString()).addOnCompleteListener(MainActivity.this, _auth_sign_in_listener);
				}
			}
		});
		
		help.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ForgotPasswordActivity.class);
				startActivity(i);
			}
		});
		
		create.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
				i.setClass(getApplicationContext(), SignupActivity.class);
				startActivity(i);
			}
		});
		
		auth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task){
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		auth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task){
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				success = "successful";
				if (_success) {
					i.setClass(getApplicationContext(), HomeActivity.class);
					startActivity(i);
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
				}
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
		email.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)0, 0xFFFFFFFF, 0xFFEEEEEE));
		pw.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)0, 0xFFFFFFFF, 0xFFEEEEEE));
		_GradientDrawable(signin, 50, 0, 0, "#673AB7", "#FFFFFF", true, false, 0);
		_ICC(back, "#FF9800", "#FF9800");
		email.setSingleLine(true);
		pw.setSingleLine(true);
		pw.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
		errormessage1.setVisibility(View.GONE);
		errormessage2.setVisibility(View.GONE);
		_ShortcutBlocks();
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
	public void onBackPressed() {
		finishAffinity();
	}
	public void _ICC (final ImageView _img, final String _c1, final String _c2) {
		_img.setImageTintList(new android.content.res.ColorStateList(new int[][] {{-android.R.attr.state_pressed},{android.R.attr.state_pressed}},new int[]{Color.parseColor(_c1), Color.parseColor(_c2)}));
	}
	
	
	public void _GradientDrawable (final View _view, final double _radius, final double _stroke, final double _shadow, final String _color, final String _borderColor, final boolean _ripple, final boolean _clickAnim, final double _animDuration) {
		if (_ripple) {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			gd.setStroke((int)_stroke,Color.parseColor(_borderColor));
			if (Build.VERSION.SDK_INT >= 21){
				_view.setElevation((int)_shadow);}
			android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor("#9E9E9E")});
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
	}
	
	
	public void _Custom_Loading (final boolean _ifShow) {
		if (_ifShow) {
			if (coreprog == null){
				coreprog = new ProgressDialog(this);
				coreprog.setCancelable(true);
				
				coreprog.requestWindowFeature(Window.FEATURE_NO_TITLE);  coreprog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
				
			}
			coreprog.setMessage(null);
			coreprog.show();
			// custom view name here 
			View _view = getLayoutInflater().inflate(R.layout.loading, null);
			// define linear_loading
			LinearLayout linear_loading = (LinearLayout) _view.findViewById(R.id.linear_loading);
			// set corner radius and color for linear_loading
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor("#FFFFFF"));
			gd.setCornerRadius(50);
			linear_loading.setBackground(gd);
			coreprog.setContentView(_view);
		}
		else {
			if (coreprog != null){
				coreprog.dismiss();
			}
		}
	}
	private ProgressDialog coreprog;
	{
	}
	
	
	public void _setBackground (final View _view, final double _radius, final double _shadow, final String _color, final boolean _ripple) {
		if (_ripple) {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			_view.setElevation((int)_shadow);
			android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor("#E0E0E0")});
			android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , gd, null);
			_view.setClickable(true);
			_view.setBackground(ripdrb);
		}
		else {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			_view.setBackground(gd);
			_view.setElevation((int)_shadow);
		}
	}
	
	
	public void _setTranslationZ (final View _view, final double _value) {
		_view.setTranslationZ((float)_value);
	}
	
	
	public void _BottomSheet () {
		final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(MainActivity.this);
		
		View bottomSheetView; bottomSheetView = getLayoutInflater().inflate(R.layout.custom,null );
		bottomSheetDialog.setContentView(bottomSheetView);
		
		bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);
		LinearLayout linear1 = (LinearLayout) bottomSheetView.findViewById(R.id.linear1);
		
		TextView textview1 = (TextView)bottomSheetView.findViewById(R.id.textview1);
		
		linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)54, 0xFFECEFF1));
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gbemiga.ttf"), 0);
		bottomSheetDialog.setCancelable(false);
		bottomSheetDialog.show();
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (success.equals("successful")) {
							bottomSheetDialog.cancel();
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(t, (int)(000), (int)(3000));
	}
	
	
	public void _ShortcutBlocks () {
		android.content.pm.ShortcutManager shortcutManager = null;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
				shortcutManager = getSystemService(android.content.pm.ShortcutManager.class);
		}
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
				if (shortcutManager != null) {
				android.content.pm.ShortcutInfo var1 = new android.content.pm.ShortcutInfo.Builder(MainActivity.this, "Materials")
											.setShortLabel("Materials")
											.setLongLabel("Download PDFs")
											.setRank(1)
											.setIntent(new android.content.Intent(android.content.Intent.ACTION_VIEW, null, MainActivity.this, PdfdownloadActivity.class))
											.setIcon(android.graphics.drawable.Icon.createWithResource(MainActivity.this, R.drawable.app_icon))
											.build();
				android.content.pm.ShortcutInfo var2 = new android.content.pm.ShortcutInfo.Builder(MainActivity.this, "Solve Assignments")
											.setShortLabel("Solve Assignments")
											.setLongLabel("AI Assistant")
											.setRank(2)
											.setIntent(new android.content.Intent(android.content.Intent.ACTION_VIEW, null, MainActivity.this, AichatActivity.class))
											.setIcon(android.graphics.drawable.Icon.createWithResource(MainActivity.this, R.drawable.app_icon))
											.build();
				android.content.pm.ShortcutInfo var3 = new android.content.pm.ShortcutInfo.Builder(MainActivity.this, "Upload Videos")
											.setShortLabel("Upload Videos")
											.setLongLabel("Upload Videos")
											.setRank(3)
											.setIntent(new android.content.Intent(android.content.Intent.ACTION_VIEW, null, MainActivity.this, YoutubevideouploadActivity.class))
											.setIcon(android.graphics.drawable.Icon.createWithResource(MainActivity.this, R.drawable.app_icon))
											.build();
				android.content.pm.ShortcutInfo var4 = new android.content.pm.ShortcutInfo.Builder(MainActivity.this, "Watch TV Shows")
											.setShortLabel("Watch TV Shows")
											.setLongLabel("TV Channels")
											.setRank(4)
											.setIntent(new android.content.Intent(android.content.Intent.ACTION_VIEW, null, MainActivity.this, TvListsActivity.class))
											.setIcon(android.graphics.drawable.Icon.createWithResource(MainActivity.this, R.drawable.app_icon))
											.build();
				android.content.pm.ShortcutInfo var5 = new android.content.pm.ShortcutInfo.Builder(MainActivity.this, "Download Tutorials")
											.setShortLabel("Download Tutorials")
											.setLongLabel("Tutorials")
											.setRank(5)
											.setIntent(new android.content.Intent(android.content.Intent.ACTION_VIEW, null, MainActivity.this, YoutubevideodownloadActivity.class))
											.setIcon(android.graphics.drawable.Icon.createWithResource(MainActivity.this, R.drawable.app_icon))
											.build();
				shortcutManager.setDynamicShortcuts(java.util.Arrays.asList(var1,var2,var3,var4,var5));
				}
		}
		else {
				Toast.makeText(getApplicationContext(), "Pinned shortcuts are not supported!", Toast.LENGTH_SHORT).show();
		}
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
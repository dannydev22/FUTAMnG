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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.android.gms.tasks.OnCompleteListener;
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
import com.shobhitpuri.custombuttons.GoogleSignInButton;

public class SignupActivity extends AppCompatActivity {
	public final int REQ_CD_FGLL = 101;
	private Timer _timer = new Timer();
	
	private String fontName = "";
	private String typeace = "";
	private  GoogleSignInOptions gso;
	private  FirebaseUser users;
	private String success = "";
	
	private LinearLayout toolbar;
	private LinearLayout linear1;
	private LinearLayout linear3;
	private WaveView linear5;
	private ImageView back;
	private TextView textview4;
	private TextView textview7;
	private LinearLayout linear7;
	private TextView title;
	private TextView textview9;
	private EditText email;
	private EditText pw;
	private EditText confpw;
	private TextView passworderror;
	private LinearLayout linear2;
	private LinearLayout linear4;
	private GoogleSignInButton button1;
	private LinearLayout linear6;
	private TextView textview10;
	private TextView help;
	private TextView signin;
	private TextView textview5;
	private LinearLayout line5;
	private TextView textview8;
	private LinearLayout line6;
	private TextView textview6;
	private TextView create;
	
	private Intent i = new Intent();
	private GoogleSignInClient fgll;
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
	private RequestNetwork req;
	private RequestNetwork.RequestListener _req_request_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.signup);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
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
		linear5 = (WaveView) findViewById(R.id.linear5);
		back = (ImageView) findViewById(R.id.back);
		textview4 = (TextView) findViewById(R.id.textview4);
		textview7 = (TextView) findViewById(R.id.textview7);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		title = (TextView) findViewById(R.id.title);
		textview9 = (TextView) findViewById(R.id.textview9);
		email = (EditText) findViewById(R.id.email);
		pw = (EditText) findViewById(R.id.pw);
		confpw = (EditText) findViewById(R.id.confpw);
		passworderror = (TextView) findViewById(R.id.passworderror);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		button1 = (GoogleSignInButton) findViewById(R.id.button1);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		textview10 = (TextView) findViewById(R.id.textview10);
		help = (TextView) findViewById(R.id.help);
		signin = (TextView) findViewById(R.id.signin);
		textview5 = (TextView) findViewById(R.id.textview5);
		line5 = (LinearLayout) findViewById(R.id.line5);
		textview8 = (TextView) findViewById(R.id.textview8);
		line6 = (LinearLayout) findViewById(R.id.line6);
		textview6 = (TextView) findViewById(R.id.textview6);
		create = (TextView) findViewById(R.id.create);
		auth = FirebaseAuth.getInstance();
		req = new RequestNetwork(this);
		
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), MainActivity.class);
				startActivity(i);
				finishAffinity();
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent signInIntent = fgll.getSignInIntent();
				
				startActivityForResult(signInIntent, REQ_CD_FGLL);
			}
		});
		
		help.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), FblayoutActivity.class);
				startActivity(i);
			}
		});
		
		signin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (true) {
					
				}
				else {
					i.setAction(Intent.ACTION_VIEW);
					i.setClass(getApplicationContext(), AllowfilesActivity.class);
					startActivity(i);
				}
				if (SketchwareUtil.isConnected(getApplicationContext())) {
					if (!pw.getText().toString().equals(confpw.getText().toString())) {
						passworderror.setVisibility(View.VISIBLE);
					}
					else {
						passworderror.setVisibility(View.GONE);
						if (email.getText().toString().equals("") && pw.getText().toString().equals("")) {
							passworderror.setText("Fill in email address or/and password!");
							passworderror.setVisibility(View.VISIBLE);
						}
						else {
							_BottomSheetDialog();
							passworderror.setVisibility(View.GONE);
							t = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											auth.createUserWithEmailAndPassword(email.getText().toString(), pw.getText().toString()).addOnCompleteListener(SignupActivity.this, _auth_create_user_listener);
										}
									});
								}
							};
							_timer.schedule(t, (int)(6000));
						}
					}
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "No Internet Detected!");
				}
			}
		});
		
		create.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), MainActivity.class);
				startActivity(i);
				finishAffinity();
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
				success = "successful";
				if (_success) {
					FirebaseAuth.getInstance().getCurrentUser().sendEmailVerification().addOnCompleteListener(auth_emailVerificationSentListener);
					i.setClass(getApplicationContext(), CompleteprofileActivity.class);
					startActivity(i);
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
				}
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				if (_success) {
					SketchwareUtil.showMessage(getApplicationContext(), "Successfully Sent. Check Email");
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Error! Check Internet Connection");
				}
			}
		};
	}
	
	private void initializeLogic() {
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
		pw.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)0, 0xFFFFFFFF, 0xFFEEEEEE));
		email.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)0, 0xFFFFFFFF, 0xFFEEEEEE));
		confpw.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)0, 0xFFFFFFFF, 0xFFEEEEEE));
		_GradientDrawable(signin, 20, 0, 8, "#673AB7", "#FFFFFF", true, false, 0);
		_ICC(back, "#FF9800", "#FF9800");
		passworderror.setVisibility(View.GONE);
		pw.setSingleLine(true);
		confpw.setSingleLine(true);
		email.setSingleLine(true);
		GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken("195658055773-idfmchalqq0rqg1hkfn80erujgl3a608.apps.googleusercontent.com").requestEmail().build();
		fgll = GoogleSignIn.getClient(this, gso);
		auth = FirebaseAuth.getInstance();
		pw.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
		confpw.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			case REQ_CD_FGLL:
			if (_resultCode == Activity.RESULT_OK) {
				Task<GoogleSignInAccount> _task = GoogleSignIn.getSignedInAccountFromIntent(_data);
				
				try {
					                // Google Sign In was successful, authenticate with Firebase
					                GoogleSignInAccount account = _task.getResult(ApiException.class);
					                
					                firebaseAuthWithGoogle(account.getIdToken());
					            } catch (ApiException e) {
					                //On Fiailure
					                final String ErrorOnResultSign = e.getMessage();
					                SketchwareUtil.showMessage(getApplicationContext(), ErrorOnResultSign);
					            }
			}
			else {
				
			}
			break;
			default:
			break;
		}
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
	
	
	public void _GoogleSignupComplete () {
	}
	private void firebaseAuthWithGoogle(String idToken) {
		AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
		auth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
			
			@Override
			public void onComplete(@NonNull Task<AuthResult> task) {
				if (task.isSuccessful()) {
					i.setClass(getApplicationContext(), CompleteprofileActivity.class);
					startActivity(i);
					finish();
				} else {
					SketchwareUtil.showMessage(getApplicationContext(), "Something Wrong ");
				}
			}
		});
	}
	//[END auth_with_google]
	{
	}
	
	
	public void _BottomSheetDialog () {
		final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(SignupActivity.this);
		
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
		_timer.scheduleAtFixedRate(t, (int)(0), (int)(3000));
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
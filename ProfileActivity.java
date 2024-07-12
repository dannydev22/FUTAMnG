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
import android.widget.ScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import de.hdodenhof.circleimageview.*;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import java.util.HashMap;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import com.bumptech.glide.Glide;
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
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdView;

public class ProfileActivity extends AppCompatActivity {
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String fontName = "";
	private String typeace = "";
	
	private LinearLayout linear4;
	private ScrollView vscroll1;
	private ImageView imageview1;
	private TextView textview1;
	private LinearLayout bg_hevo;
	private LinearLayout linear26;
	private LinearLayout b_hevo_4;
	private LinearLayout linear27;
	private CircleImageView circleimageview1;
	private LinearLayout linear24;
	private LinearLayout linear20;
	private LinearLayout linear21;
	private TextView email;
	private ShimmerFrameLayout shimmerprofile;
	private ShimmerFrameLayout linear29;
	private ShimmerFrameLayout linear28;
	private ImageView imageview2;
	private TextView name;
	private ImageView ic_verified;
	private TextView levelandfaculty;
	private TextView matricno;
	private LinearLayout bg_hevo_2;
	private LinearLayout bt_hevo_1;
	private LinearLayout bt_hevo_4;
	private LinearLayout bt_hevo_5;
	private LinearLayout bt_hevo_2;
	private LinearLayout linear1;
	private LinearLayout bt_hevo_6;
	private LinearLayout linear25;
	private LinearLayout bt_hevo_3;
	private TextView textview3;
	private ImageView image_hevo5;
	private TextView text_hevo3;
	private ImageView image_hevo_bt1;
	private ImageView image_hevo8;
	private TextView text_hevo6;
	private ImageView image_hevo_bt4;
	private ImageView image_hevo9;
	private TextView text_hevo7;
	private ImageView image_hevo_bt5;
	private ImageView image_hevo6;
	private TextView text_hevo4;
	private ImageView image_hevo_bt2;
	private ImageView image_hevo10;
	private TextView text_hevo8;
	private ImageView imageview3;
	private TextView textview2;
	private ImageView imageview4;
	private ImageView image_hevo7;
	private TextView text_hevo5;
	
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
	private Intent i = new Intent();
	private DatabaseReference firedb = _firebase.getReference("FUTAMnG/Userdetails");
	private ChildEventListener _firedb_child_listener;
	private SharedPreferences sharedpref;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.profile);
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
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		bg_hevo = (LinearLayout) findViewById(R.id.bg_hevo);
		linear26 = (LinearLayout) findViewById(R.id.linear26);
		b_hevo_4 = (LinearLayout) findViewById(R.id.b_hevo_4);
		linear27 = (LinearLayout) findViewById(R.id.linear27);
		circleimageview1 = (CircleImageView) findViewById(R.id.circleimageview1);
		linear24 = (LinearLayout) findViewById(R.id.linear24);
		linear20 = (LinearLayout) findViewById(R.id.linear20);
		linear21 = (LinearLayout) findViewById(R.id.linear21);
		email = (TextView) findViewById(R.id.email);
		shimmerprofile = (ShimmerFrameLayout) findViewById(R.id.shimmerprofile);
		linear29 = (ShimmerFrameLayout) findViewById(R.id.linear29);
		linear28 = (ShimmerFrameLayout) findViewById(R.id.linear28);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		name = (TextView) findViewById(R.id.name);
		ic_verified = (ImageView) findViewById(R.id.ic_verified);
		levelandfaculty = (TextView) findViewById(R.id.levelandfaculty);
		matricno = (TextView) findViewById(R.id.matricno);
		bg_hevo_2 = (LinearLayout) findViewById(R.id.bg_hevo_2);
		bt_hevo_1 = (LinearLayout) findViewById(R.id.bt_hevo_1);
		bt_hevo_4 = (LinearLayout) findViewById(R.id.bt_hevo_4);
		bt_hevo_5 = (LinearLayout) findViewById(R.id.bt_hevo_5);
		bt_hevo_2 = (LinearLayout) findViewById(R.id.bt_hevo_2);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		bt_hevo_6 = (LinearLayout) findViewById(R.id.bt_hevo_6);
		linear25 = (LinearLayout) findViewById(R.id.linear25);
		bt_hevo_3 = (LinearLayout) findViewById(R.id.bt_hevo_3);
		textview3 = (TextView) findViewById(R.id.textview3);
		image_hevo5 = (ImageView) findViewById(R.id.image_hevo5);
		text_hevo3 = (TextView) findViewById(R.id.text_hevo3);
		image_hevo_bt1 = (ImageView) findViewById(R.id.image_hevo_bt1);
		image_hevo8 = (ImageView) findViewById(R.id.image_hevo8);
		text_hevo6 = (TextView) findViewById(R.id.text_hevo6);
		image_hevo_bt4 = (ImageView) findViewById(R.id.image_hevo_bt4);
		image_hevo9 = (ImageView) findViewById(R.id.image_hevo9);
		text_hevo7 = (TextView) findViewById(R.id.text_hevo7);
		image_hevo_bt5 = (ImageView) findViewById(R.id.image_hevo_bt5);
		image_hevo6 = (ImageView) findViewById(R.id.image_hevo6);
		text_hevo4 = (TextView) findViewById(R.id.text_hevo4);
		image_hevo_bt2 = (ImageView) findViewById(R.id.image_hevo_bt2);
		image_hevo10 = (ImageView) findViewById(R.id.image_hevo10);
		text_hevo8 = (TextView) findViewById(R.id.text_hevo8);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		textview2 = (TextView) findViewById(R.id.textview2);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		image_hevo7 = (ImageView) findViewById(R.id.image_hevo7);
		text_hevo5 = (TextView) findViewById(R.id.text_hevo5);
		auth = FirebaseAuth.getInstance();
		sharedpref = getSharedPreferences("Profile", Activity.MODE_PRIVATE);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), HomeActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		circleimageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(ProfileActivity.this);
				
				View bottomSheetView; bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet,null );
				bottomSheetDialog.setContentView(bottomSheetView);
				
				bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);
				LinearLayout bg = (LinearLayout) bottomSheetView.findViewById(R.id.bg);
				
				LinearLayout horiz = (LinearLayout) bottomSheetView.findViewById(R.id.horiz);
				
				TextView t1 = (TextView)bottomSheetView.findViewById(R.id.t1);
				
				TextView t2 = (TextView)bottomSheetView.findViewById(R.id.t2);
				
				horiz.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)54, 0xFFECEFF1));
				bg.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)50, 0xFFBDBDBD));
				t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_medium.ttf"), 0);
				t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_medium.ttf"), 0);
				bottomSheetDialog.setCancelable(true);
				bottomSheetDialog.show();
				t1.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						i.setClass(getApplicationContext(), FutamapActivity.class);
						startActivity(i);
						SketchwareUtil.showMessage(getApplicationContext(), "click");
						bottomSheetDialog.dismiss();
					}
				});
				t2.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						i.setClass(getApplicationContext(), ProfileActivity.class);
						startActivity(i);
						SketchwareUtil.showMessage(getApplicationContext(), "click");
						bottomSheetDialog.dismiss();
					}
				});
				bottomSheetDialog.setCancelable(true);
			}
		});
		
		linear24.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), EditprofileActivity.class);
				startActivity(i);
			}
		});
		
		bt_hevo_1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		bt_hevo_4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		bt_hevo_5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_TEXT, "Join Me on Varia and let's study together ❤️"); startActivity(Intent.createChooser(i,"Invite via"));
			}
		});
		
		bt_hevo_2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		bt_hevo_6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		linear25.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), DeleteaccountActivity.class);
				startActivity(i);
			}
		});
		
		bt_hevo_3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		_firedb_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					linear27.setVisibility(View.GONE);
					circleimageview1.setVisibility(View.VISIBLE);
					linear24.setVisibility(View.VISIBLE);
					linear20.setVisibility(View.VISIBLE);
					linear21.setVisibility(View.VISIBLE);
					email.setVisibility(View.VISIBLE);
					if (_childValue.get("profileurl").toString().equals("")) {
						circleimageview1.setImageResource(R.drawable.icon_user);
					}
					else {
						sharedpref.edit().putString("imageurl", _childValue.get("profileurl").toString()).commit();
						Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("profileurl").toString())).into(circleimageview1);
					}
					if (_childValue.get("matricno").toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "Please update your profile");
					}
					else {
						matricno.setText(_childValue.get("matricno").toString());
						sharedpref.edit().putString("matric", _childValue.get("matricno").toString()).commit();
					}
					if (_childValue.get("name").toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "No data corresponding to this user!");
					}
					else {
						sharedpref.edit().putString("fullname", _childValue.get("name").toString()).commit();
						name.setText(_childValue.get("name").toString());
					}
					if (_childValue.get("level").toString().concat(" ".concat(_childValue.get("department").toString()).concat(", ".concat(_childValue.get("faculty").toString()))).equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "Update your profile!");
					}
					else {
						sharedpref.edit().putString("levels", _childValue.get("level").toString().concat(" ".concat(_childValue.get("department").toString()).concat(", ".concat(_childValue.get("faculty").toString())))).commit();
						levelandfaculty.setText(_childValue.get("level").toString().concat(" ".concat(_childValue.get("department").toString()).concat(", ".concat(_childValue.get("faculty").toString()))));
					}
				}
				else {
					
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		firedb.addChildEventListener(_firedb_child_listener);
		
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
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w =ProfileActivity.this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFF673AB7);
		}
		_removeScollBar(vscroll1);
		email.setText("Email Address: ".concat(FirebaseAuth.getInstance().getCurrentUser().getEmail()));
		_LoadNativeAd();
		_Try_Catch();
		_ICC(image_hevo8, "#673AB7", "#2196F3");
		_ICC(image_hevo9, "#673AB7", "#2196F3");
		_ICC(image_hevo6, "#673AB7", "#2196F3");
		_GradientDrawable(linear24, 360, 0, 15, "#FFFFFF", "#FFFFFF", true, true, 800);
		_Round(0, 0, 25, 25, "#673AB7", linear26);
		_GradientDrawable(bt_hevo_2, 15, 0, 15, "#E8EAF6", "#FFFFFF", true, false, 800);
		_GradientDrawable(bt_hevo_1, 15, 0, 15, "#E8EAF6", "#FFFFFF", true, false, 800);
		_GradientDrawable(bt_hevo_4, 15, 0, 15, "#E8EAF6", "#FFFFFF", true, false, 800);
		_GradientDrawable(bt_hevo_5, 15, 0, 15, "#E8EAF6", "#FFFFFF", true, false, 800);
		_GradientDrawable(bt_hevo_6, 15, 0, 15, "#E8EAF6", "#FFFFFF", true, false, 800);
		_GradientDrawable(bt_hevo_3, 15, 0, 15, "#E8EAF6", "#FFFFFF", true, false, 800);
		_GradientDrawable(linear25, 15, 0, 15, "#E8EAF6", "#FFFFFF", true, false, 800);
		shimmerprofile.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)360, 0xFFCFD8DC));
		ShimmerFrameLayout container = (ShimmerFrameLayout) findViewById(R.id.shimmerprofile); container.startShimmer();
		linear28.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)15, 0xFFCFD8DC));
		ShimmerFrameLayout container1 = (ShimmerFrameLayout) findViewById(R.id.linear28); container1.startShimmer();
		linear29.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)15, 0xFFCFD8DC));
		ShimmerFrameLayout container2 = (ShimmerFrameLayout) findViewById(R.id.linear29); container2.startShimmer();
		circleimageview1.setVisibility(View.GONE);
		linear24.setVisibility(View.GONE);
		linear20.setVisibility(View.GONE);
		linear21.setVisibility(View.GONE);
		email.setVisibility(View.GONE);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _removeScollBar (final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
	}
	
	
	public void _ripple (final View _view) {
		_view.setBackground(new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{0xFFB0B0B0}), null, null));
		_view.setClickable(true);
		
		/*Created by Sketchy Designer
You can use this code in More Block*/
	}
	
	
	public void _ICC (final ImageView _img, final String _c1, final String _c2) {
		_img.setImageTintList(new android.content.res.ColorStateList(new int[][] {{-android.R.attr.state_pressed},{android.R.attr.state_pressed}},new int[]{Color.parseColor(_c1), Color.parseColor(_c2)}));
	}
	
	
	public void _LoadNativeAd () {
		AdLoader.Builder builder = new AdLoader.Builder(ProfileActivity.this, "ca-app-pub-8081781380472232/8284217808");
		builder.withAdListener(new AdListener() {
			              @Override
			              public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
				                    super.onAdFailedToLoad(loadAdError);
				SketchwareUtil.showMessage(getApplicationContext(), "error");
				
				 }
		});
		builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
			 
			 @Override
			 public void onNativeAdLoaded(@NonNull NativeAd nativeAd) {
				NativeAdView adView = (NativeAdView) getLayoutInflater().inflate(R.layout.nat, null);
				//Define Widgets
				adView.setIconView(adView.findViewById(R.id.imageview1));
				adView.setHeadlineView(adView.findViewById(R.id.textview1));
				adView.setAdvertiserView(adView.findViewById(R.id.textview2));
				adView.setStarRatingView(adView.findViewById(R.id.ratingbar1));
				adView.setBodyView(adView.findViewById(R.id.textview3));
				adView.setMediaView((MediaView) adView.findViewById(R.id.linear2));
				adView.setPriceView(adView.findViewById(R.id.textview4));
				adView.setStoreView(adView.findViewById(R.id.textview5));
				adView.setCallToActionView(adView.findViewById(R.id.button1));
				((TextView) Objects.requireNonNull(adView.getHeadlineView())).setText(nativeAd.getHeadline());
				Objects.requireNonNull(adView.getMediaView()).setMediaContent(Objects.requireNonNull(nativeAd.getMediaContent()));
				
				
				if (nativeAd.getBody() == null) {
					 Objects.requireNonNull(adView.getBodyView()).setVisibility(View.INVISIBLE);
					 
				} else {
					 adView.getBodyView().setVisibility(View.VISIBLE);
					 ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
				}
				if (nativeAd.getCallToAction() == null) {
					 Objects.requireNonNull(adView.getCallToActionView()).setVisibility(View.INVISIBLE);
				} else {
					 Objects.requireNonNull(adView.getCallToActionView()).setVisibility(View.VISIBLE);
					 ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
				}
				if (nativeAd.getIcon() == null) {
					 Objects.requireNonNull(adView.getIconView()).setVisibility(View.GONE);
				} else {
					 ((ImageView) Objects.requireNonNull(adView.getIconView())).setImageDrawable(nativeAd.getIcon().getDrawable());
					 adView.getIconView().setVisibility(View.VISIBLE);
				}
				
				if (nativeAd.getPrice() == null) {
					 Objects.requireNonNull(adView.getPriceView()).setVisibility(View.INVISIBLE);
					 
				} else {
					 Objects.requireNonNull(adView.getPriceView()).setVisibility(View.VISIBLE);
					 ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
				}
				if (nativeAd.getStore() == null) {
					 Objects.requireNonNull(adView.getStoreView()).setVisibility(View.INVISIBLE);
				} else {
					 Objects.requireNonNull(adView.getStoreView()).setVisibility(View.VISIBLE);
					 ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
				}
				if (nativeAd.getStarRating() == null) {
					 Objects.requireNonNull(adView.getStarRatingView()).setVisibility(View.INVISIBLE);
				} else {
					 ((RatingBar) Objects.requireNonNull(adView.getStarRatingView())).setRating(nativeAd.getStarRating().floatValue());
					 adView.getStarRatingView().setVisibility(View.VISIBLE);
				}
				
				if (nativeAd.getAdvertiser() == null) {
					 Objects.requireNonNull(adView.getAdvertiserView()).setVisibility(View.INVISIBLE);
				} else
				((TextView) Objects.requireNonNull(adView.getAdvertiserView())).setText(nativeAd.getAdvertiser());
				adView.getAdvertiserView().setVisibility(View.VISIBLE);
				
				
				adView.setNativeAd(nativeAd);
				_setProperties(adView.findViewById(R.id.button1), 10, 0, "#000000", "#1A73E8");
				_GradientDrawable(linear1, 20, 0, 20, "#FFFFFF", "#EEEEEE", false, false, 300);
				linear1.removeAllViews();
				linear1.addView(adView);
			}
		}).build();
		NativeAdOptions adOptions = new NativeAdOptions.Builder().build();
		builder.withNativeAdOptions(adOptions);
		AdLoader adLoader = builder.withAdListener(new AdListener() {
			 public void onAdFailedToLoad(int i) {
				_LoadNativeAd();
			}
		}).build();
		
		adLoader.loadAd(new AdRequest.Builder().build());
	}
	
	
	public void _setProperties (final View _view, final double _radius, final double _stroke, final String _strokeColor, final String _bgColor) {
		_view.setBackground(new android.graphics.drawable.GradientDrawable() {
			
			public android.graphics.drawable.GradientDrawable getIns(int a, int b, int c, int d) {
				
				this.setCornerRadius(a);
				this.setStroke(b, c);
				this.setColor(d);
				return this;
			}
			 }
		.getIns((int)_radius, (int)_stroke, Color.parseColor(_strokeColor), Color.parseColor(_bgColor)));
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
	
	
	public void _Try_Catch () {
		try{
			circleimageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath("/storage/emulated/0/Android/data/com.varia.neny/.profileuploads/".concat(sharedpref.getString("lastsegmentpath", "")), 1024, 1024));
			if (sharedpref.getString("lastsegmentpath", "").equals("")) {
				circleimageview1.setImageResource(R.drawable.icon_user);
			}
			else {
				
			}
		}catch(Exception e){
			SketchwareUtil.showMessage(getApplicationContext(), "Error");
		}
	}
	
	
	public void _Round (final double _one, final double _two, final double _three, final double _four, final String _color, final View _view) {
		Double left_top = _one;
		Double right_top = _two;
		Double left_bottom = _three;
		Double right_bottom = _four;
		android.graphics.drawable.GradientDrawable s = new android.graphics.drawable.GradientDrawable();
		s.setShape(android.graphics.drawable.GradientDrawable.RECTANGLE);
		s.setCornerRadii(new float[] {left_top.floatValue(),left_top.floatValue(), right_top.floatValue(),right_top.floatValue(), left_bottom.floatValue(),left_bottom.floatValue(), right_bottom.floatValue(),right_bottom.floatValue()});
		s.setColor(Color.parseColor(_color));
		_view.setBackground(s);
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
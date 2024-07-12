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
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.view.View;
import android.text.Editable;
import android.text.TextWatcher;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.graphics.Typeface;
import com.bumptech.glide.Glide;
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

public class YoutubevideodownloadActivity extends AppCompatActivity {
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String data = "";
	private double transition = 0;
	private double length = 0;
	private double num = 0;
	private String value = "";
	private double adshow = 0;
	
	private ArrayList<HashMap<String, Object>> maps = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private TextView textview1;
	private LinearLayout linear3;
	private ImageView imageview1;
	private LinearLayout linear_search;
	private LinearLayout shimmerlayout;
	private ListView listview1;
	private EditText email;
	private ImageView imageview2;
	private ShimmerFrameLayout linear6;
	private ShimmerFrameLayout linear5;
	private ShimmerFrameLayout linear7;
	
	private DatabaseReference database = _firebase.getReference("FUTAMnG/UserVideos");
	private ChildEventListener _database_child_listener;
	private Intent intent = new Intent();
	
	private OnCompleteListener fcm_onCompleteListener;
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
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.youtubevideodownload);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		textview1 = (TextView) findViewById(R.id.textview1);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		linear_search = (LinearLayout) findViewById(R.id.linear_search);
		shimmerlayout = (LinearLayout) findViewById(R.id.shimmerlayout);
		listview1 = (ListView) findViewById(R.id.listview1);
		email = (EditText) findViewById(R.id.email);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		linear6 = (ShimmerFrameLayout) findViewById(R.id.linear6);
		linear5 = (ShimmerFrameLayout) findViewById(R.id.linear5);
		linear7 = (ShimmerFrameLayout) findViewById(R.id.linear7);
		auth = FirebaseAuth.getInstance();
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				transition++;
				if (transition == 1) {
					_TransitionManager(linear2, 800);
					linear_search.setVisibility(View.VISIBLE);
				}
				else {
					imageview1.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View _view) {
							_TransitionManager(linear2, 800);
							linear_search.setVisibility(View.GONE);
							transition = 0;
						}
					});
				}
			}
		});
		
		email.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				maps = new Gson().fromJson(data, new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
				if (_charSeq.length() > 0) {
					length = maps.size();
					num = length - 1;
					for(int _repeat21 = 0; _repeat21 < (int)(length); _repeat21++) {
						value = maps.get((int)num).get("videotitle").toString();
						if (!value.toLowerCase().contains(_charSeq.toLowerCase())) {
							maps.remove((int)(num));
						}
						num--;
					}
				}
				listview1.setAdapter(new Listview1Adapter(maps));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		_database_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				database.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						maps = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								maps.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						data = new Gson().toJson(maps);
						listview1.setAdapter(new Listview1Adapter(maps));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						Collections.shuffle(maps);
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
				shimmerlayout.setVisibility(View.GONE);
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				database.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						maps = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								maps.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						data = new Gson().toJson(maps);
						listview1.setAdapter(new Listview1Adapter(maps));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						Collections.shuffle(maps);
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
				shimmerlayout.setVisibility(View.GONE);
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				database.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						maps = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								maps.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						listview1.setAdapter(new Listview1Adapter(maps));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						data = new Gson().toJson(maps);
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
				shimmerlayout.setVisibility(View.GONE);
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		database.addChildEventListener(_database_child_listener);
		
		fcm_onCompleteListener = new OnCompleteListener<InstanceIdResult>() {
			@Override
			public void onComplete(Task<InstanceIdResult> task) {
				final boolean _success = task.isSuccessful();
				final String _token = task.getResult().getToken();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
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
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
		linear_search.setVisibility(View.GONE);
		email.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF9E9E9E));
		_ICC(imageview2, "#673AB7", "#E0E0E0");
		_ShimmerLibrary();
		_removeScollBar(listview1);
		if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
			
		}
		else {
			intent.setClass(getApplicationContext(), MainActivity.class);
			startActivity(intent);
			SketchwareUtil.showMessage(getApplicationContext(), "Kindly Login");
		}
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _TransitionManager (final View _view, final double _duration) {
		LinearLayout viewgroup =(LinearLayout) _view;
		
		android.transition.AutoTransition autoTransition = new android.transition.AutoTransition(); autoTransition.setDuration((long)_duration); android.transition.TransitionManager.beginDelayedTransition(viewgroup, autoTransition);
	}
	
	
	public void _ICC (final ImageView _img, final String _c1, final String _c2) {
		_img.setImageTintList(new android.content.res.ColorStateList(new int[][] {{-android.R.attr.state_pressed},{android.R.attr.state_pressed}},new int[]{Color.parseColor(_c1), Color.parseColor(_c2)}));
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
	
	
	public void _ShimmerLibrary () {
		ShimmerFrameLayout container4 = (ShimmerFrameLayout) findViewById(R.id.linear5); container4.startShimmer();
		linear5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFCFD8DC));
		ShimmerFrameLayout container1 = (ShimmerFrameLayout) findViewById(R.id.linear7); container1.startShimmer();
		linear7.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFCFD8DC));
		ShimmerFrameLayout container2 = (ShimmerFrameLayout) findViewById(R.id.linear6); container2.startShimmer();
		linear6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)15, 0xFFCFD8DC));
	}
	
	
	public void _removeScollBar (final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
	}
	
	
	public class Listview1Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.videolists, null);
			}
			
			final LinearLayout linear = (LinearLayout) _view.findViewById(R.id.linear);
			final androidx.cardview.widget.CardView cardview1 = (androidx.cardview.widget.CardView) _view.findViewById(R.id.cardview1);
			final TextView title = (TextView) _view.findViewById(R.id.title);
			final TextView Videodescription = (TextView) _view.findViewById(R.id.Videodescription);
			final LinearLayout linear2 = (LinearLayout) _view.findViewById(R.id.linear2);
			final TextView SEEMORE = (TextView) _view.findViewById(R.id.SEEMORE);
			final FrameLayout linear1 = (FrameLayout) _view.findViewById(R.id.linear1);
			final ImageView thumbnail = (ImageView) _view.findViewById(R.id.thumbnail);
			final TextView uploadername = (TextView) _view.findViewById(R.id.uploadername);
			final TextView time = (TextView) _view.findViewById(R.id.time);
			
			title.setText(_data.get((int)_position).get("videotitle").toString());
			title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gbemiga.ttf"), 0);
			Videodescription.setText(_data.get((int)_position).get("videodescription").toString());
			Videodescription.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gbemiga.ttf"), 0);
			time.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gbemiga.ttf"), 0);
			uploadername.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gbemiga.ttf"), 0);
			time.setText(_data.get((int)_position).get("time").toString());
			if (_data.get((int)_position).get("uploader").toString().equals("")) {
				uploadername.setText("Unknown");
			}
			else {
				uploadername.setText("Uploaded by: ".concat(_data.get((int)_position).get("uploader").toString()));
				SEEMORE.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gbemiga.ttf"), 0);
			}
			cardview1.setRadius((float)15);
			Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("thumbnailURL").toString())).into(thumbnail);
			AdLoader.Builder builder = new AdLoader.Builder(YoutubevideodownloadActivity.this, "ca-app-pub-8081781380472232/8284217808");
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
				}
			}).build();
			
			adLoader.loadAd(new AdRequest.Builder().build());
			adshow = 6;
			if (((_position % adshow) == 0) && (_position > 1)) {
				linear1.setVisibility(View.VISIBLE);
			}
			else {
				linear1.setVisibility(View.GONE);
			}
			SEEMORE.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					intent.setClass(getApplicationContext(), YoutubevideoviewActivity.class);
					intent.putExtra("id", _data.get((int)_position).get("videoID").toString());
					intent.putExtra("title", _data.get((int)_position).get("videotitle").toString());
					intent.putExtra("description", _data.get((int)_position).get("videodescription").toString());
					startActivity(intent);
				}
			});
			uploadername.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					SketchwareUtil.showMessage(getApplicationContext(), "Feature coming soon");
				}
			});
			
			return _view;
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
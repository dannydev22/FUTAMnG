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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;
import android.widget.TextView;
import com.airbnb.lottie.*;
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
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
import android.text.Editable;
import android.text.TextWatcher;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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

public class TvListsActivity extends AppCompatActivity {
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String fontName = "";
	private String typeace = "";
	private String json = "";
	private double adshow = 0;
	private String data = "";
	private double length = 0;
	private double num = 0;
	private String value = "";
	
	private ArrayList<HashMap<String, Object>> mapp = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> sub_cat_map = new ArrayList<>();
	
	private LinearLayout linear1;
	private SwipeRefreshLayout swiperefreshlayout1;
	private TextView textview1;
	private LinearLayout linear19;
	private LinearLayout no_internet;
	private LinearLayout linear18;
	private LottieAnimationView lottie1;
	private TextView textview3;
	private TextView textview2;
	private TextView textview4;
	private LinearLayout linear17;
	private RecyclerView recyclerview1;
	private LinearLayout linear15;
	private EditText edittext1;
	private LinearLayout countsep;
	private TextView textview5;
	
	private DatabaseReference fdd = _firebase.getReference("users/futa");
	private ChildEventListener _fdd_child_listener;
	private Intent i = new Intent();
	private Notification dft;
	private RequestNetwork req;
	private RequestNetwork.RequestListener _req_request_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.tv_lists);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		swiperefreshlayout1 = (SwipeRefreshLayout) findViewById(R.id.swiperefreshlayout1);
		textview1 = (TextView) findViewById(R.id.textview1);
		linear19 = (LinearLayout) findViewById(R.id.linear19);
		no_internet = (LinearLayout) findViewById(R.id.no_internet);
		linear18 = (LinearLayout) findViewById(R.id.linear18);
		lottie1 = (LottieAnimationView) findViewById(R.id.lottie1);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview4 = (TextView) findViewById(R.id.textview4);
		linear17 = (LinearLayout) findViewById(R.id.linear17);
		recyclerview1 = (RecyclerView) findViewById(R.id.recyclerview1);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		countsep = (LinearLayout) findViewById(R.id.countsep);
		textview5 = (TextView) findViewById(R.id.textview5);
		req = new RequestNetwork(this);
		
		swiperefreshlayout1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override 
			public void onRefresh() {
				if (SketchwareUtil.isConnected(getApplicationContext())) {
					no_internet.setVisibility(View.GONE);
					linear18.setVisibility(View.VISIBLE);
					swiperefreshlayout1.setRefreshing(false);
				}
				else {
					no_internet.setVisibility(View.VISIBLE);
					linear18.setVisibility(View.GONE);
					SketchwareUtil.showMessage(getApplicationContext(), "Check Internet Connection!");
					swiperefreshlayout1.setRefreshing(false);
				}
			}
		});
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				sub_cat_map = new Gson().fromJson(data, new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
				if (_charSeq.length() > 0) {
					length = sub_cat_map.size();
					num = length - 5;
					for(int _repeat21 = 0; _repeat21 < (int)(length); _repeat21++) {
						value = sub_cat_map.get((int)num).get("name").toString();
						if (!value.toLowerCase().contains(_charSeq.toLowerCase())) {
							sub_cat_map.remove((int)(num));
						}
						num--;
					}
				}
				recyclerview1.setAdapter(new Recyclerview1Adapter(mapp));
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		_fdd_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("TV_List")) {
					fdd.addListenerForSingleValueEvent(new ValueEventListener() {
						@Override
						public void onDataChange(DataSnapshot _dataSnapshot) {
							mapp = new ArrayList<>();
							try {
								GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
								for (DataSnapshot _data : _dataSnapshot.getChildren()) {
									HashMap<String, Object> _map = _data.getValue(_ind);
									mapp.add(_map);
								}
							}
							catch (Exception _e) {
								_e.printStackTrace();
							}
							
						}
						@Override
						public void onCancelled(DatabaseError _databaseError) {
						}
					});
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
		fdd.addChildEventListener(_fdd_child_listener);
		
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
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
		_jsonFromAsset();
		if (SketchwareUtil.isConnected(getApplicationContext())) {
			no_internet.setVisibility(View.GONE);
			linear18.setVisibility(View.VISIBLE);
		}
		else {
			no_internet.setVisibility(View.VISIBLE);
			linear18.setVisibility(View.GONE);
		}
		linear15.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)1, 0xFF673AB7, 0xFFFFFFFF));
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _ripple (final View _view) {
		_view.setBackground(new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{0xFFB0B0B0}), null, null));
		_view.setClickable(true);
		
		/*Created by Sketchy Designer
You can use this code in More Block*/
	}
	
	
	public void _jsonFromAsset () {
		try {
				
				java.io.InputStream stream = getAssets().open("category" + ".json");
				
				java.io.BufferedReader bfr = new java.io.BufferedReader(new java.io.InputStreamReader(stream));
				
				String nextline = "";
				String allText = "";
				
				while ( (nextline = bfr.readLine()) != null) {
						allText = allText + nextline + "\n";
				}
				
				//textview3.setText(allText);
				json = allText;
		} catch (java.io.IOException e){
				showMessage(e.toString());
		}
		sub_cat_map = new Gson().fromJson(json, new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		recyclerview1.setAdapter(new Recyclerview1Adapter(sub_cat_map));
		recyclerview1.setLayoutManager(new LinearLayoutManager(this));
		data = new Gson().toJson(sub_cat_map);
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
	
	
	public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {
		ArrayList<HashMap<String, Object>> _data;
		public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _v = _inflater.inflate(R.layout.custom_view, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear55 = (LinearLayout) _view.findViewById(R.id.linear55);
			final FrameLayout linear1 = (FrameLayout) _view.findViewById(R.id.linear1);
			final LinearLayout linear53 = (LinearLayout) _view.findViewById(R.id.linear53);
			final androidx.cardview.widget.CardView cardview2 = (androidx.cardview.widget.CardView) _view.findViewById(R.id.cardview2);
			final LinearLayout linear54 = (LinearLayout) _view.findViewById(R.id.linear54);
			final ImageView imageview3 = (ImageView) _view.findViewById(R.id.imageview3);
			final TextView textview41 = (TextView) _view.findViewById(R.id.textview41);
			final TextView textview42 = (TextView) _view.findViewById(R.id.textview42);
			
			textview41.setText(_data.get((int)_position).get("name").toString());
			textview42.setText(_data.get((int)_position).get("id").toString());
			Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("photo").toString())).into(imageview3);
			textview41.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gbemiga.ttf"), 0);
			textview42.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gbemiga.ttf"), 0);
			AdLoader.Builder builder = new AdLoader.Builder(TvListsActivity.this, "ca-app-pub-8081781380472232/8284217808");
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
					SketchwareUtil.showMessage(getApplicationContext(), "loading error");
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
		}
		
		@Override
		public int getItemCount() {
			return _data.size();
		}
		
		public class ViewHolder extends RecyclerView.ViewHolder {
			public ViewHolder(View v) {
				super(v);
			}
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
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
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import de.hdodenhof.circleimageview.*;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdRequest;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import androidx.viewpager.widget.ViewPager.OnAdapterChangeListener;
import com.airbnb.lottie.*;
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import android.widget.ProgressBar;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.webkit.WebView;
import android.webkit.WebSettings;
import com.google.android.material.button.*;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.util.Timer;
import java.util.TimerTask;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import android.app.Activity;
import android.content.SharedPreferences;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdListener;
import android.view.View;
import android.widget.AdapterView;
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
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import com.yangp.ypwaveview.YPWaveView;

public class HomeActivity extends AppCompatActivity {
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String fontName = "";
	private String typeace = "";
	private  FirebaseUser users ;
	private HashMap<String, Object> map = new HashMap<>();
	private String token = "";
	private String serverkey = "";
	private double slidpos = 0;
	private double SAATLng = 0;
	private double SAATlat = 0;
	private double itemcount = 0;
	private double itemcount2 = 0;
	private  GridLayoutManager customrecc;
	private  GridLayoutManager customrecy;
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> liststringg = new ArrayList<>();
	private ArrayList<String> liststring = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> recyclermap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> recyclermap2 = new ArrayList<>();
	
	private LinearLayout toolbar;
	private ScrollView vscroll1;
	private TextView actname;
	private CircleImageView circleimageview1;
	private ImageView notification;
	private ImageView search;
	private LinearLayout linear;
	private LinearLayout linear3;
	private LinearLayout complprof;
	private LinearLayout linear12;
	private LinearLayout shimmerlayout2;
	private CardView cardview1;
	private AdView adview1;
	private CardView cardview4;
	private TextView textview5;
	private TextView textview2;
	private CardView cardview5;
	private LinearLayout linear17;
	private CardView cardview3;
	private LinearLayout marqueenotification;
	private ViewPager viewpager1;
	private TextView textview27;
	private LinearLayout futafbpglayout;
	private LinearLayout shimmerlayout;
	private CardView cardview6;
	private TextView textview3;
	private AdView adview2;
	private TextView textview4;
	private TextView textview43;
	private ImageView imageview5;
	private TextView textview22;
	private ImageView imageview6;
	private TextView timeofday;
	private TextView complementday;
	private ShimmerFrameLayout linear45;
	private ShimmerFrameLayout linear46;
	private ShimmerFrameLayout linear47;
	private LinearLayout linear50;
	private ShimmerFrameLayout linear49;
	private ShimmerFrameLayout linear48;
	private LinearLayout linear7;
	private CardView cardview2;
	private LinearLayout linear13;
	private LinearLayout linear16;
	private LinearLayout linear5;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private LinearLayout linear11;
	private LinearLayout linear20;
	private LinearLayout matricborder;
	private LinearLayout linear19;
	private TextView levelandfaculty;
	private TextView fullname;
	private ImageView verified;
	private TextView textview16;
	private TextView matricno;
	private TextView textview14;
	private TextView textview15;
	private LinearLayout linear15;
	private LinearLayout WaveProgressBar;
	private TextView textview21;
	private TextView progcomplement;
	private LinearLayout countdownlayout;
	private YPWaveView progressbar1;
	private TextView textview23;
	private TextView textview24;
	private LinearLayout linear31;
	private LinearLayout linear27;
	private LinearLayout linear28;
	private TextView textview29;
	private TextView textview30;
	private LinearLayout linear30;
	private LinearLayout linearai;
	private TextView textview31;
	private LottieAnimationView lottie1;
	private LinearLayout materialslayout;
	private LinearLayout linear33;
	private TextView textview37;
	private LinearLayout linear51;
	private TextView textview33;
	private TextView textview38;
	private LinearLayout linear35;
	private TextView textview39;
	private TextView textview32;
	private RecyclerView recyclerview1;
	private ProgressBar progressbar2;
	private RecyclerView recyclerview2;
	private ProgressBar progressbar3;
	private TextView textview25;
	private LinearLayout linear6;
	private MapView mapview1;
	private GoogleMapController _mapview1_controller;
	private LinearLayout linear21;
	private LinearLayout linear22;
	private LinearLayout linear23;
	private LinearLayout linear24;
	private Spinner spinner1;
	private ImageView imageview8;
	private ImageView imageview7;
	private ImageView imageview2;
	private TextView marqueetext;
	private WebView webview1;
	private LinearLayout linear26;
	private TextView textview28;
	private ShimmerFrameLayout linear39;
	private ShimmerFrameLayout linear40;
	private ShimmerFrameLayout linear41;
	private ShimmerFrameLayout linear42;
	private ShimmerFrameLayout linear43;
	private LinearLayout linear53;
	private TextView textview40;
	private TextView textview41;
	private MaterialButton materialbutton1;
	
	private Intent i = new Intent();
	private AlertDialog.Builder q;
	private TimerTask t;
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
	private ProgressDialog ty;
	private DatabaseReference fdb = _firebase.getReference("users/futa");
	private ChildEventListener _fdb_child_listener;
	
	private OnCompleteListener fcm_onCompleteListener;
	private RequestNetwork requestNetwork;
	private RequestNetwork.RequestListener _requestNetwork_request_listener;
	private SharedPreferences sharedpref;
	private DatabaseReference firehouse = _firebase.getReference("FUTAMnG/Userdetails");
	private ChildEventListener _firehouse_child_listener;
	private TimerTask trr;
	private SharedPreferences file;
	private DatabaseReference uservideos = _firebase.getReference("FUTAMnG/UserVideos");
	private ChildEventListener _uservideos_child_listener;
	private InterstitialAd iq;
	private AdListener _iq_ad_listener;
	private DatabaseReference pdfs = _firebase.getReference("FUTAMnG/UserPDFs");
	private ChildEventListener _pdfs_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home);
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
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		actname = (TextView) findViewById(R.id.actname);
		circleimageview1 = (CircleImageView) findViewById(R.id.circleimageview1);
		notification = (ImageView) findViewById(R.id.notification);
		search = (ImageView) findViewById(R.id.search);
		linear = (LinearLayout) findViewById(R.id.linear);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		complprof = (LinearLayout) findViewById(R.id.complprof);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		shimmerlayout2 = (LinearLayout) findViewById(R.id.shimmerlayout2);
		cardview1 = (CardView) findViewById(R.id.cardview1);
		adview1 = (AdView) findViewById(R.id.adview1);
		cardview4 = (CardView) findViewById(R.id.cardview4);
		textview5 = (TextView) findViewById(R.id.textview5);
		textview2 = (TextView) findViewById(R.id.textview2);
		cardview5 = (CardView) findViewById(R.id.cardview5);
		linear17 = (LinearLayout) findViewById(R.id.linear17);
		cardview3 = (CardView) findViewById(R.id.cardview3);
		marqueenotification = (LinearLayout) findViewById(R.id.marqueenotification);
		viewpager1 = (ViewPager) findViewById(R.id.viewpager1);
		textview27 = (TextView) findViewById(R.id.textview27);
		futafbpglayout = (LinearLayout) findViewById(R.id.futafbpglayout);
		shimmerlayout = (LinearLayout) findViewById(R.id.shimmerlayout);
		cardview6 = (CardView) findViewById(R.id.cardview6);
		textview3 = (TextView) findViewById(R.id.textview3);
		adview2 = (AdView) findViewById(R.id.adview2);
		textview4 = (TextView) findViewById(R.id.textview4);
		textview43 = (TextView) findViewById(R.id.textview43);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		textview22 = (TextView) findViewById(R.id.textview22);
		imageview6 = (ImageView) findViewById(R.id.imageview6);
		timeofday = (TextView) findViewById(R.id.timeofday);
		complementday = (TextView) findViewById(R.id.complementday);
		linear45 = (ShimmerFrameLayout) findViewById(R.id.linear45);
		linear46 = (ShimmerFrameLayout) findViewById(R.id.linear46);
		linear47 = (ShimmerFrameLayout) findViewById(R.id.linear47);
		linear50 = (LinearLayout) findViewById(R.id.linear50);
		linear49 = (ShimmerFrameLayout) findViewById(R.id.linear49);
		linear48 = (ShimmerFrameLayout) findViewById(R.id.linear48);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		cardview2 = (CardView) findViewById(R.id.cardview2);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		linear16 = (LinearLayout) findViewById(R.id.linear16);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		linear20 = (LinearLayout) findViewById(R.id.linear20);
		matricborder = (LinearLayout) findViewById(R.id.matricborder);
		linear19 = (LinearLayout) findViewById(R.id.linear19);
		levelandfaculty = (TextView) findViewById(R.id.levelandfaculty);
		fullname = (TextView) findViewById(R.id.fullname);
		verified = (ImageView) findViewById(R.id.verified);
		textview16 = (TextView) findViewById(R.id.textview16);
		matricno = (TextView) findViewById(R.id.matricno);
		textview14 = (TextView) findViewById(R.id.textview14);
		textview15 = (TextView) findViewById(R.id.textview15);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		WaveProgressBar = (LinearLayout) findViewById(R.id.WaveProgressBar);
		textview21 = (TextView) findViewById(R.id.textview21);
		progcomplement = (TextView) findViewById(R.id.progcomplement);
		countdownlayout = (LinearLayout) findViewById(R.id.countdownlayout);
		progressbar1 = (YPWaveView) findViewById(R.id.progressbar1);
		textview23 = (TextView) findViewById(R.id.textview23);
		textview24 = (TextView) findViewById(R.id.textview24);
		linear31 = (LinearLayout) findViewById(R.id.linear31);
		linear27 = (LinearLayout) findViewById(R.id.linear27);
		linear28 = (LinearLayout) findViewById(R.id.linear28);
		textview29 = (TextView) findViewById(R.id.textview29);
		textview30 = (TextView) findViewById(R.id.textview30);
		linear30 = (LinearLayout) findViewById(R.id.linear30);
		linearai = (LinearLayout) findViewById(R.id.linearai);
		textview31 = (TextView) findViewById(R.id.textview31);
		lottie1 = (LottieAnimationView) findViewById(R.id.lottie1);
		materialslayout = (LinearLayout) findViewById(R.id.materialslayout);
		linear33 = (LinearLayout) findViewById(R.id.linear33);
		textview37 = (TextView) findViewById(R.id.textview37);
		linear51 = (LinearLayout) findViewById(R.id.linear51);
		textview33 = (TextView) findViewById(R.id.textview33);
		textview38 = (TextView) findViewById(R.id.textview38);
		linear35 = (LinearLayout) findViewById(R.id.linear35);
		textview39 = (TextView) findViewById(R.id.textview39);
		textview32 = (TextView) findViewById(R.id.textview32);
		recyclerview1 = (RecyclerView) findViewById(R.id.recyclerview1);
		progressbar2 = (ProgressBar) findViewById(R.id.progressbar2);
		recyclerview2 = (RecyclerView) findViewById(R.id.recyclerview2);
		progressbar3 = (ProgressBar) findViewById(R.id.progressbar3);
		textview25 = (TextView) findViewById(R.id.textview25);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		mapview1 = (MapView) findViewById(R.id.mapview1);
		mapview1.onCreate(_savedInstanceState);
		
		linear21 = (LinearLayout) findViewById(R.id.linear21);
		linear22 = (LinearLayout) findViewById(R.id.linear22);
		linear23 = (LinearLayout) findViewById(R.id.linear23);
		linear24 = (LinearLayout) findViewById(R.id.linear24);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		imageview8 = (ImageView) findViewById(R.id.imageview8);
		imageview7 = (ImageView) findViewById(R.id.imageview7);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		marqueetext = (TextView) findViewById(R.id.marqueetext);
		webview1 = (WebView) findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		linear26 = (LinearLayout) findViewById(R.id.linear26);
		textview28 = (TextView) findViewById(R.id.textview28);
		linear39 = (ShimmerFrameLayout) findViewById(R.id.linear39);
		linear40 = (ShimmerFrameLayout) findViewById(R.id.linear40);
		linear41 = (ShimmerFrameLayout) findViewById(R.id.linear41);
		linear42 = (ShimmerFrameLayout) findViewById(R.id.linear42);
		linear43 = (ShimmerFrameLayout) findViewById(R.id.linear43);
		linear53 = (LinearLayout) findViewById(R.id.linear53);
		textview40 = (TextView) findViewById(R.id.textview40);
		textview41 = (TextView) findViewById(R.id.textview41);
		materialbutton1 = (MaterialButton) findViewById(R.id.materialbutton1);
		q = new AlertDialog.Builder(this);
		auth = FirebaseAuth.getInstance();
		requestNetwork = new RequestNetwork(this);
		sharedpref = getSharedPreferences("saved user details ", Activity.MODE_PRIVATE);
		file = getSharedPreferences("lastsegmentimage", Activity.MODE_PRIVATE);
		
		circleimageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ActivityOptionsCompat options5 = ActivityOptionsCompat.makeSceneTransitionAnimation(HomeActivity.this,circleimageview1, ViewCompat.getTransitionName(circleimageview1));
				i.setClass(getApplicationContext(), ProfileActivity.class);
				startActivity(i, options5.toBundle());
			}
		});
		
		notification.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				iq.show();
				i.setClass(getApplicationContext(), NotificationActivity.class);
				startActivity(i);
			}
		});
		
		search.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				View inflatePop = getLayoutInflater().inflate(R.layout.menu, null);
				final PopupWindow inflate = new PopupWindow(inflatePop, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
				
				
				final LinearLayout linear1 =(LinearLayout) inflatePop.findViewById(R.id.linear1);
				final LinearLayout linear2 =(LinearLayout) inflatePop.findViewById(R.id.linear2);
				final LinearLayout linear3 =(LinearLayout) inflatePop.findViewById(R.id.linear3);
				final LinearLayout linear4 =(LinearLayout) inflatePop.findViewById(R.id.linear4);
				final LinearLayout linear7 =(LinearLayout) inflatePop.findViewById(R.id.linear7);
				final LinearLayout linear8 =(LinearLayout) inflatePop.findViewById(R.id.linear8);
				
				final TextView textview1 = (TextView) inflatePop.findViewById(R.id.textview1);
				
				final TextView textview2 = (TextView) inflatePop.findViewById(R.id.textview2);
				
				final TextView textview3 = (TextView) inflatePop.findViewById(R.id.textview3);
				
				final TextView textview6 = (TextView) inflatePop.findViewById(R.id.textview6);
				final TextView textview7 = (TextView) inflatePop.findViewById(R.id.textview7);
				
				
				linear1.setElevation((float)10);
				linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)50, 0xFFFFFFFF));
				
				inflate.setAnimationStyle(android.R.style.Animation_Dialog);
				inflate.showAsDropDown(search, 0,0);
				inflate.setBackgroundDrawable(new BitmapDrawable());
				_GradientDrawable(linear2, 15, 1, 8, "#FFFFFF", "#673AB7", true, true, 1000);
				_GradientDrawable(linear3, 15, 1, 8, "#FFFFFF", "#673AB7", true, true, 1000);
				_GradientDrawable(linear4, 15, 1, 8, "#FFFFFF", "#673AB7", true, true, 1000);
				_GradientDrawable(linear7, 15, 1, 8, "#FFFFFF", "#673AB7", true, true, 1000);
				_GradientDrawable(linear8, 15, 1, 8, "#FFFFFF", "#673AB7", true, true, 1000);
				linear2.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						q.setTitle("Confirmation!");
						q.setMessage("Are you sure you want to log out?");
						q.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								sharedpref.edit().putString("fullname", "").commit();
								sharedpref.edit().putString("levels", "").commit();
								sharedpref.edit().putString("matric", "").commit();
								ty = new ProgressDialog(HomeActivity.this);
								ty.setMessage("Please Wait");
								ty.setProgressStyle(ProgressDialog.STYLE_SPINNER);
								ty.setCancelable(false);
								ty.show();
								t = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												ty.dismiss();
												FirebaseAuth.getInstance().signOut();
												i.setClass(getApplicationContext(), IntroActivity.class);
												startActivity(i);
												finish();
											}
										});
									}
								};
								_timer.schedule(t, (int)(4000));
							}
						});
						q.setNegativeButton("No", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						q.create().show();
					}
				});
				linear3.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						i.setClass(getApplicationContext(), TvListsActivity.class);
						startActivity(i);
					}
				});
				linear8.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						i.setClass(getApplicationContext(), AboutActivity.class);
						startActivity(i);
					}
				});
			}
		});
		
		complprof.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), CompleteprofileActivity.class);
				startActivity(i);
			}
		});
		
		cardview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), AichatActivity.class);
				startActivity(i);
			}
		});
		
		textview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.putExtra("url", "https://cdn.jmvstream.com/w/LVW-10801/LVW10801_Xvg4R0u57n/chunklist.m3u8");
				i.setClass(getApplicationContext(), VideoActivity.class);
				startActivity(i);
			}
		});
		
		linear17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				iq.show();
			}
		});
		
		textview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				map = new HashMap<>();
				map.put("ChannelName", "Important information:");
				map.put("ChannelLink", "FUTA Post UTME Screening results are out! check your results now!");
				fdb.child("TV_List").updateChildren(map);
				map.clear();
			}
		});
		
		textview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), FblayoutActivity.class);
				startActivity(i);
			}
		});
		
		linear16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), CourseActivity.class);
				startActivity(i);
			}
		});
		
		WaveProgressBar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(HomeActivity.this);
				
				View bottomSheetView; bottomSheetView = getLayoutInflater().inflate(R.layout.dorento,null );
				bottomSheetDialog.setContentView(bottomSheetView);
				
				bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);
				
				
				TextView t2 = (TextView) bottomSheetView.findViewById(R.id.t2);
				
				TextView b1 = (TextView) bottomSheetView.findViewById(R.id.b1);
				
				TextView b2 = (TextView) bottomSheetView.findViewById(R.id.b2);
				
				TextView b3 = (TextView) bottomSheetView.findViewById(R.id.b3);
				
				LinearLayout bg = (LinearLayout) bottomSheetView.findViewById(R.id.bg);
				_rippleRoundStroke(bg, "#FFFFFF", "#FFFFFF", 15, 0, "#FFFFFF");
				_rippleRoundStroke(b1, "#FFFFFF", "#FF2196F3", 15, 3, "#FF2196F3");
				_rippleRoundStroke(b2, "#FFFFFF", "#FF2196F3", 15, 3, "#FF2196F3");
				_rippleRoundStroke(b3, "#FFFFFF", "#FF2196F3", 15, 3, "#FF2196F3");
				b3.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						i.setClass(getApplicationContext(), UploadPdfActivity.class);
						startActivity(i);
						bottomSheetDialog.dismiss();
					}
				});
				bottomSheetDialog.setCancelable(false);
				bottomSheetDialog.show();
			}
		});
		
		linearai.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), AichatActivity.class);
				startActivity(i);
				iq.show();
			}
		});
		
		lottie1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				progressbar1.setProgress((int)progressbar1.getProgress() + 10);
			}
		});
		
		textview33.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), YoutubevideodownloadActivity.class);
				startActivity(i);
				iq.show();
			}
		});
		
		textview39.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), PdfdownloadActivity.class);
				startActivity(i);
			}
		});
		
		linear6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), FutamapActivity.class);
				startActivity(i);
			}
		});
		
		_mapview1_controller = new GoogleMapController(mapview1, new OnMapReadyCallback() {
			@Override
			public void onMapReady(GoogleMap _googleMap) {
				_mapview1_controller.setGoogleMap(_googleMap);
				_mapview1_controller.moveCamera(7.300458d, 5.137339d);
				_mapview1_controller.addMarker("T.I Francis Auditorium", 7.300458d, 5.137339d);
				_mapview1_controller.setMarkerColor("T.I Francis Auditorium", BitmapDescriptorFactory.HUE_RED, 1);
				_mapview1_controller.addMarker("makkah", 7.301518d, 5.137979d);
				_mapview1_controller.setMarkerColor("makkah", BitmapDescriptorFactory.HUE_RED, 1);
				_mapview1_controller.addMarker("makkah", 7.304396d, 5.136441d);
				_mapview1_controller.setMarkerColor("makkah", BitmapDescriptorFactory.HUE_RED, 1);
				_mapview1_controller.addMarker("Obafemi Awolowo Auditorium", 7.302209d, 5.133976d);
				_mapview1_controller.setMarkerColor("Obafemi Awolowo Auditorium", BitmapDescriptorFactory.HUE_RED, 1);
			}
		});
		
		_mapview1_controller.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
			@Override
			public boolean onMarkerClick(Marker _param1) {
				final String _id = _param1.getTag().toString();
				SketchwareUtil.showMessage(getApplicationContext(), _id);
				return false;
			}
		});
		
		linear23.setOnLongClickListener(new View.OnLongClickListener() {
			 @Override
				public boolean onLongClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "Zoom Out");
				return true;
				}
			 });
		
		linear23.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_mapview1_controller.zoomOut();
			}
		});
		
		linear24.setOnLongClickListener(new View.OnLongClickListener() {
			 @Override
				public boolean onLongClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "Zoom In");
				return true;
				}
			 });
		
		linear24.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_mapview1_controller.zoomIn();
			}
		});
		
		spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 0) {
					
				}
				if (_position == 1) {
					_mapview1_controller.setMapType(GoogleMap.MAP_TYPE_NONE);
				}
				if (_position == 2) {
					_mapview1_controller.setMapType(GoogleMap.MAP_TYPE_NORMAL);
				}
				if (_position == 3) {
					_mapview1_controller.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
				}
				if (_position == 4) {
					_mapview1_controller.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
				}
				if (_position == 5) {
					_mapview1_controller.setMapType(GoogleMap.MAP_TYPE_HYBRID);
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
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
		
		linear26.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_open_chrome("https://m.facebook.com/futacommunity/");
			}
		});
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				iq.show();
				i.setClass(getApplicationContext(), UploadPdfActivity.class);
				startActivity(i);
			}
		});
		
		_fdb_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("TV_List")) {
					marqueetext.setText(_childValue.get("ChannelName").toString().concat(" ").concat(_childValue.get("ChannelLink").toString()));
					marqueenotification.setVisibility(View.VISIBLE);
				}
				else {
					marqueenotification.setVisibility(View.GONE);
					SketchwareUtil.showMessage(getApplicationContext(), _childKey);
				}
				if (_childKey.equals("TVRegion")) {
					SketchwareUtil.showMessage(getApplicationContext(), "TVRegionPosted Successfully");
				}
				else {
					
				}
				textview4.setText(_childKey.toUpperCase());
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				SketchwareUtil.CustomToast(getApplicationContext(), "Child Changed: ".concat(_childKey), 0xFF000000, 14, 0xFFFFFFFF, 20, SketchwareUtil.TOP);
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
		fdb.addChildEventListener(_fdb_child_listener);
		
		fcm_onCompleteListener = new OnCompleteListener<InstanceIdResult>() {
			@Override
			public void onComplete(Task<InstanceIdResult> task) {
				final boolean _success = task.isSuccessful();
				final String _token = task.getResult().getToken();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_requestNetwork_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				SketchwareUtil.showMessage(getApplicationContext(), _response);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				SketchwareUtil.showMessage(getApplicationContext(), _message);
				SketchwareUtil.CustomToast(getApplicationContext(), _message, 0xFF000000, 14, 0xFFFFFFFF, 20, SketchwareUtil.TOP);
			}
		};
		
		_firehouse_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					cardview1.setVisibility(View.VISIBLE);
					shimmerlayout2.setVisibility(View.GONE);
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
						complprof.setVisibility(View.VISIBLE);
					}
					else {
						sharedpref.edit().putString("fullname", _childValue.get("name").toString()).commit();
						fullname.setText(_childValue.get("name").toString());
					}
					if (_childValue.get("level").toString().concat(" ".concat(_childValue.get("department").toString()).concat(", ".concat(_childValue.get("faculty").toString()))).equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "Update your profile!");
						sharedpref.edit().putString("profilecomplete", "notdone").commit();
					}
					else {
						sharedpref.edit().putString("levels", _childValue.get("level").toString().concat(" ".concat(_childValue.get("department").toString()).concat(", ".concat(_childValue.get("faculty").toString())))).commit();
						levelandfaculty.setText(_childValue.get("level").toString().concat(" ".concat(_childValue.get("department").toString()).concat(", ".concat(_childValue.get("faculty").toString()))));
					}
					sharedpref.edit().putString("profilecomplete", "done").commit();
					complprof.setVisibility(View.GONE);
					if (sharedpref.getString("taptarget", "").equals("")) {
						_taptarget();
						sharedpref.edit().putString("taptarget", "true").commit();
					}
					else {
						sharedpref.edit().putString("taptarget", "true").commit();
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
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					cardview1.setVisibility(View.VISIBLE);
					shimmerlayout2.setVisibility(View.GONE);
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
						complprof.setVisibility(View.VISIBLE);
					}
					else {
						sharedpref.edit().putString("fullname", _childValue.get("name").toString()).commit();
						fullname.setText(_childValue.get("name").toString());
					}
					if (_childValue.get("level").toString().concat(" ".concat(_childValue.get("department").toString()).concat(", ".concat(_childValue.get("faculty").toString()))).equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "Update your profile!");
						sharedpref.edit().putString("profilecomplete", "notdone").commit();
					}
					else {
						sharedpref.edit().putString("levels", _childValue.get("level").toString().concat(" ".concat(_childValue.get("department").toString()).concat(", ".concat(_childValue.get("faculty").toString())))).commit();
						levelandfaculty.setText(_childValue.get("level").toString().concat(" ".concat(_childValue.get("department").toString()).concat(", ".concat(_childValue.get("faculty").toString()))));
					}
					sharedpref.edit().putString("profilecomplete", "done").commit();
					complprof.setVisibility(View.GONE);
				}
				else {
					
				}
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
		firehouse.addChildEventListener(_firehouse_child_listener);
		
		_uservideos_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				recyclermap.add(_childValue);
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				recyclermap.add(_childValue);
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
		uservideos.addChildEventListener(_uservideos_child_listener);
		
		_pdfs_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				recyclermap2.add(_childValue);
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
		pdfs.addChildEventListener(_pdfs_child_listener);
		
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
		
		_iq_ad_listener = new AdListener() {
			@Override
			public void onAdLoaded() {
				
			}
			
			@Override
			public void onAdFailedToLoad(int _param1) {
				final int _errorCode = _param1;
				SketchwareUtil.showMessage(getApplicationContext(), String.valueOf((long)(_errorCode)));
			}
			
			@Override
			public void onAdOpened() {
				
			}
			
			@Override
			public void onAdClosed() {
				iq = new InterstitialAd(getApplicationContext());
				iq.setAdListener(_iq_ad_listener);
				iq.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
				iq.loadAd(new AdRequest.Builder().addTestDevice("0AA049AB4EB220E38785E314AF907584")
				.build());
			}
		};
	}
	
	private void initializeLogic() {
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
		marqueetext.setEllipsize(TextUtils.TruncateAt.MARQUEE);
		marqueetext.setMarqueeRepeatLimit(-2);
		marqueetext.setSingleLine(true);
		marqueetext.setSelected(true);
		marqueenotification.setVisibility(View.GONE);
		_removeScollBar(vscroll1);
		marqueenotification.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)2, 0xFFF44336, Color.TRANSPARENT));
		BadgeFactory.create(this)
		    .setTextColor(Color.parseColor("#FFFFFF"))
		    .setWidthAndHeight(15,15)
		    .setBadgeBackground(Color.parseColor("#F44336"))
		    .setTextSize(8)
		    .setBadgeGravity(Gravity.RIGHT|Gravity.TOP)
		    .setShape(BadgeView.SHAPE_CIRCLE)
		    .setSpace(0,0)
		.setBadgeCount((int)slidpos)
		    .bind(notification);
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("a", "b");
			listmap.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("c", "d");
			listmap.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("e", "f");
			listmap.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("g", "h");
			listmap.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("i", "j");
			listmap.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("k", "l");
			listmap.add(_item);
		}
		
		viewpager1.setAdapter(new Viewpager1Adapter(listmap));
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						slidpos = viewpager1.getCurrentItem() + 1;
						if (slidpos > 4) {
							slidpos = 0;
							viewpager1.setCurrentItem((int)slidpos);
						}
						else {
							viewpager1.setCurrentItem((int)slidpos);
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(t, (int)(4000), (int)(4000));
		liststring.add("Select Map View Type");
		liststring.add("None");
		liststring.add("Normal View");
		liststring.add("Satellite View");
		liststring.add("Terrain View");
		liststring.add("Hybrid View");
		spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, liststring));
		((ArrayAdapter)spinner1.getAdapter()).notifyDataSetChanged();
		cardview1.setVisibility(View.GONE);
		complprof.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)1, 0xFFF44336, 0xFFFFFFFF));
		_ICC(verified, "#2196F3", "#2196F3");
		_CardViews();
		_Timeofday();
		_Try_Catch();
		_ShimmerLibrary();
		uservideos.removeEventListener(_uservideos_child_listener);
		itemcount = 5;
		recyclerview1.setLayoutManager(customrecc);
		recyclerview1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
		recyclerview1.setHasFixedSize(true);
		uservideos.limitToFirst((int)itemcount).addValueEventListener(data);
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
		i.setAction(Intent.ACTION_VIEW);
		i.setClass(getApplicationContext(), QuitActivity.class);
		startActivity(i);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		mapview1.onDestroy();
	}
	
	@Override
	public void onPause() {
		super.onPause();
		mapview1.onPause();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		mapview1.onResume();
	}
	
	@Override
	public void onStop() {
		super.onStop();
		mapview1.onStop();
	}
	public void _ripple (final View _view) {
		_view.setBackground(new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{0xFFB0B0B0}), null, null));
		_view.setClickable(true);
		
		/*Created by Sketchy Designer
You can use this code in More Block*/
	}
	
	
	public void _profile_image () {
		
	}
	
	
	public void _glideFromURL (final String _url, final ImageView _imageview) {
		
		Glide.with(getApplicationContext())
		.load(_url)
		.diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.ALL)
		.error(R.drawable.app_icon)
		.into(_imageview);
	}
	
	
	public void _removeScollBar (final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
	}
	
	
	public void _BagdeLib () {
		
	}
	public static class BadgeFactory {
		    public static BadgeView createDot(Context context){
				        return  new BadgeView(context).setWidthAndHeight(10,10).setTextSize(0).setBadgeGravity(Gravity.RIGHT| Gravity.TOP).setShape(BadgeView.SHAPE_CIRCLE);
				    }
		    public static BadgeView createCircle(Context context){
				        return  new BadgeView(context).setWidthAndHeight(20,20).setTextSize(12).setBadgeGravity(Gravity.RIGHT| Gravity.TOP).setShape(BadgeView.SHAPE_CIRCLE);
				    }
		    public static BadgeView createRectangle(Context context){
				        return  new BadgeView(context).setWidthAndHeight(25,20).setTextSize(12).setBadgeGravity(Gravity.RIGHT| Gravity.TOP).setShape(BadgeView.SHAPE_RECTANGLE);
				    }
		    public static BadgeView createOval(Context context){
				        return  new BadgeView(context).setWidthAndHeight(25,20).setTextSize(12).setBadgeGravity(Gravity.RIGHT| Gravity.TOP).setShape(BadgeView.SHAPE_OVAL);
				    }
		    public static BadgeView createSquare(Context context){
				        return  new BadgeView(context).setWidthAndHeight(20,20).setTextSize(12).setBadgeGravity(Gravity.RIGHT| Gravity.TOP).setShape(BadgeView.SHAPE_SQUARE);
				    }
		    public static BadgeView createRoundRect(Context context){
				        return  new BadgeView(context).setWidthAndHeight(25,20).setTextSize(12).setBadgeGravity(Gravity.RIGHT| Gravity.TOP).setShape(BadgeView.SHAPTE_ROUND_RECTANGLE);
				    }
		    public static BadgeView create(Context context){
				        return  new BadgeView(context);
				    }
		
	}
	
	public static class BadgeView extends View {
		    private Paint numberPaint;
		    private Paint backgroundPaint;
		    public static final int SHAPE_CIRCLE = 1;
		    public static final int SHAPE_RECTANGLE = 2;
		    public static final int SHAPE_OVAL = 3;
		    public static final int SHAPTE_ROUND_RECTANGLE = 4;
		    public static final int SHAPE_SQUARE = 5;
		    private int currentShape = SHAPE_CIRCLE;
		    private int defaultTextColor = Color.WHITE;
		    private int defaultTextSize;
		    private int defaultBackgroundColor = Color.RED;
		    private String showText = "";
		    private int badgeGravity = Gravity.RIGHT | Gravity.TOP;
		    private int leftMargin = 0;
		    private int topMargin = 0;
		    private int bottomMargin = 0;
		    private int rightMargin = 0;
		    private boolean hasBind=false;
		    private int horiontalSpace=0;
		    private int verticalSpace=0;
		    public BadgeView(Context context) {
				        super(context);
				        init(context);
				    }
		    public BadgeView(Context context, AttributeSet attrs) {
				        super(context, attrs);
				        init(context);
				    }
		    public BadgeView(Context context, AttributeSet attrs, int defStyleAttr) {
				        super(context, attrs, defStyleAttr);
				        init(context);
				    }
		    public BadgeView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
				        super(context, attrs, defStyleAttr, defStyleRes);
				        init(context);
				    }
		    private void init(Context context) {
				        defaultTextSize = dip2px(context, 1);
				        numberPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
				        numberPaint.setColor(defaultTextColor);
				        numberPaint.setStyle(Paint.Style.FILL);
				        numberPaint.setTextSize(defaultTextSize);
				        numberPaint.setTextAlign(Paint.Align.CENTER);
				        backgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
				        backgroundPaint.setColor(defaultBackgroundColor);
				        backgroundPaint.setStyle(Paint.Style.FILL);
				        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
				        params.gravity = badgeGravity;
				        setLayoutParams(params);
				    }
		    @Override
		    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
				        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
				    }
		    @Override
		    protected void onDraw(Canvas canvas) {
				        super.onDraw(canvas);
				        RectF rectF = new RectF(0, 0, getMeasuredWidth(), getMeasuredHeight());
				        Paint.FontMetrics fontMetrics = numberPaint.getFontMetrics();
				        float textH = fontMetrics.descent - fontMetrics.ascent;
				        switch (currentShape) {
						            case SHAPE_CIRCLE:
						                canvas.drawCircle(getMeasuredWidth() / 2f, getMeasuredHeight() / 2f, getMeasuredWidth() / 2, backgroundPaint);
						                canvas.drawText(showText, getMeasuredWidth() / 2f, getMeasuredHeight() / 2f + (textH / 2f - fontMetrics.descent), numberPaint);
						                break;
						            case SHAPE_OVAL:
						
						                canvas.drawOval(rectF, backgroundPaint);
						                canvas.drawText(showText, getMeasuredWidth() / 2f, getMeasuredHeight() / 2f + (textH / 2f - fontMetrics.descent), numberPaint);
						                break;
						            case SHAPE_RECTANGLE:
						                canvas.drawRect(rectF, backgroundPaint);
						                canvas.drawText(showText, getMeasuredWidth() / 2f, getMeasuredHeight() / 2f + (textH / 2f - fontMetrics.descent), numberPaint);
						                break;
						            case SHAPE_SQUARE:
						                int sideLength = Math.min(getMeasuredHeight(), getMeasuredWidth());
						                RectF squareF = new RectF(0, 0, sideLength, sideLength);
						                canvas.drawRect(squareF, backgroundPaint);
						                canvas.drawText(showText, sideLength / 2f, sideLength / 2f + (textH / 2f - fontMetrics.descent), numberPaint);
						                break;
						            case SHAPTE_ROUND_RECTANGLE:
						                canvas.drawRoundRect(rectF, dip2px(getContext(), 5), dip2px(getContext(), 5), backgroundPaint);
						                canvas.drawText(showText, getMeasuredWidth() / 2f, getMeasuredHeight() / 2f + (textH / 2f - fontMetrics.descent), numberPaint);
						                break;
						        }
				
				    }
		    private int dip2px(Context context, int dip) {
				        return (int) (dip * getContext().getResources().getDisplayMetrics().density + 0.5f);
				    }
		    private int sp2px(Context context, float spValue) {
				        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
				        return (int) (spValue * fontScale + 0.5f);
				    }
		    public BadgeView setShape(int shape) {
				        currentShape = shape;
				        invalidate();
				        return this;
				    }
		    public BadgeView setWidthAndHeight(int w, int h) {
				        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) getLayoutParams();
				        params.width = dip2px(getContext(), w);
				        params.height = dip2px(getContext(), h);
				        setLayoutParams(params);
				        return this;
				    }
		    public BadgeView setWidth(int sp) {
				        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) getLayoutParams();
				        params.width = dip2px(getContext(), sp);
				        setLayoutParams(params);
				        return this;
				
				    }
		    public BadgeView setHeight(int sp) {
				        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) getLayoutParams();
				        params.height = dip2px(getContext(), sp);
				        setLayoutParams(params);
				        return this;
				    }
		    @Deprecated
		    public BadgeView setMargin(int left, int top, int right, int bottom) {
				        leftMargin = dip2px(getContext(), left);
				        bottomMargin = dip2px(getContext(), bottom);
				        topMargin = dip2px(getContext(), top);
				        rightMargin = dip2px(getContext(), right);
				        invalidate();
				        return this;
				    }
		    public BadgeView setSpace(int horitontal, int vertical){
				        horiontalSpace=dip2px(getContext(), horitontal);
				        verticalSpace=dip2px(getContext(), vertical);
				        invalidate();
				        return  this;
				    }
		    public BadgeView setTextSize(int sp) {
				        defaultTextSize = sp2px(getContext(), sp);
				        numberPaint.setTextSize(sp2px(getContext(), sp));
				        invalidate();
				        return this;
				    }
		    public BadgeView setTextColor(int color) {
				        defaultTextColor = color;
				        numberPaint.setColor(color);
				        invalidate();
				        return this;
				    }
		    public BadgeView setBadgeBackground(int color) {
				        defaultBackgroundColor = color;
				        backgroundPaint.setColor(color);
				        invalidate();
				        return this;
				    }
		    public BadgeView setBadgeCount(int count) {
				        showText = String.valueOf(count);
				        invalidate();
				        return this;
				    }
		    public BadgeView setBadgeCount(String count) {
				        showText = count;
				        invalidate();
				        return this;
				    }
		    public BadgeView setBadgeGravity(int gravity) {
				        badgeGravity = gravity;
				        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) getLayoutParams();
				        params.gravity = gravity;
				        setLayoutParams(params);
				        return this;
				    }
		    public BadgeView bind(View view) {
				        if (getParent() != null)
				            ((ViewGroup) getParent()).removeView(this);
				        if (view == null)
				            return this;
				        if ((view.getParent() instanceof FrameLayout)&&hasBind==true) {
						            ((FrameLayout) view.getParent()).addView(this);
						            return this;
						        } else if (view.getParent() instanceof ViewGroup) {
						            ViewGroup parentContainer = (ViewGroup) view.getParent();
						            int viewIndex = ((ViewGroup) view.getParent()).indexOfChild(view);
						            ((ViewGroup) view.getParent()).removeView(view);
						            FrameLayout container = new FrameLayout(getContext());
						            ViewGroup.LayoutParams containerParams = view.getLayoutParams();
						            int origionHeight=containerParams.height;
						            int origionWidth=containerParams.width;
						            FrameLayout.LayoutParams viewLayoutParams =new FrameLayout.LayoutParams( origionWidth, origionHeight);
						            if(origionHeight==ViewGroup.LayoutParams.WRAP_CONTENT){
								                containerParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
								                viewLayoutParams.topMargin=topMargin;
								                viewLayoutParams.bottomMargin=bottomMargin;
								            }else{
								                containerParams.height =origionHeight+topMargin+bottomMargin+verticalSpace;
								            }
						            if(origionWidth==ViewGroup.LayoutParams.WRAP_CONTENT){
								                containerParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
								                viewLayoutParams.leftMargin=leftMargin;
								                viewLayoutParams.rightMargin=rightMargin;
								            }else{
								                containerParams.width=origionWidth+rightMargin+horiontalSpace+leftMargin;
								            }
						            container.setLayoutParams(containerParams);
						            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) getLayoutParams();
						            if(params.gravity==(Gravity.RIGHT|Gravity.TOP)||params.gravity==Gravity.RIGHT||params.gravity==Gravity.TOP){
								                view.setPadding(0,verticalSpace,horiontalSpace,0);
								                viewLayoutParams.gravity=Gravity.LEFT|Gravity.BOTTOM;
								            }else if(params.gravity==(Gravity.LEFT|Gravity.TOP)||params.gravity==Gravity.LEFT||params.gravity==Gravity.TOP){
								                view.setPadding(horiontalSpace,verticalSpace,0,0);
								                viewLayoutParams.gravity=Gravity.RIGHT|Gravity.BOTTOM;
								            }else if(params.gravity==(Gravity.LEFT|Gravity.BOTTOM)){
								                view.setPadding(horiontalSpace,0,0,verticalSpace);
								                viewLayoutParams.gravity=Gravity.RIGHT|Gravity.TOP;
								            }else if(params.gravity==(Gravity.RIGHT|Gravity.BOTTOM)){
								                view.setPadding(0,0,horiontalSpace,verticalSpace);
								                viewLayoutParams.gravity=Gravity.LEFT|Gravity.TOP;
								            }else{
								                view.setPadding(0,verticalSpace,horiontalSpace,0);
								                viewLayoutParams.gravity=Gravity.LEFT|Gravity.BOTTOM;
								            }
						            view.setLayoutParams(viewLayoutParams);
						            container.setId(view.getId());
						            container.addView(view);
						            container.addView(this);
						            parentContainer.addView(container, viewIndex);
						            hasBind=true;
						        } else if (view.getParent() == null) {
						            Log.e("badgeview", "View must have a parent");
						        }
				        return this;
				    }
		    public boolean unbind() {
				        if (getParent() != null) {
								((ViewGroup) getParent()).removeView(this);
						            return true;
						        }
				        return false;
				    }
		    public String getBadgeCount() {
				        return showText;
				    }
	}
	
	{
		
	}
	
	
	public void _material_ripple () {
		
	}
	public static class MaterialRippleLayout extends FrameLayout {
		    private static final int     DEFAULT_DURATION        = 350;
		    private static final int     DEFAULT_FADE_DURATION   = 75;
		    private static final float   DEFAULT_DIAMETER_DP     = 35;
		    private static final float   DEFAULT_ALPHA           = 0.2f;
		    private static final int     DEFAULT_COLOR           = Color.BLACK;
		    private static final int     DEFAULT_BACKGROUND      = Color.TRANSPARENT;
		    private static final boolean DEFAULT_HOVER           = true;
		    private static final boolean DEFAULT_DELAY_CLICK     = true;
		    private static final boolean DEFAULT_PERSISTENT      = false;
		    private static final boolean DEFAULT_SEARCH_ADAPTER  = false;
		    private static final boolean DEFAULT_RIPPLE_OVERLAY  = false;
		    private static final int     DEFAULT_ROUNDED_CORNERS = 0;
		    private static final int  FADE_EXTRA_DELAY = 50;
		    private static final long HOVER_DURATION   = 2500;
		    private final Paint paint  = new Paint(Paint.ANTI_ALIAS_FLAG);
		    private final Rect  bounds = new Rect();
		    private int      rippleColor;
		    private boolean  rippleOverlay;
		    private boolean  rippleHover;
		    private int      rippleDiameter;
		    private int      rippleDuration;
		    private int      rippleAlpha;
		    private boolean  rippleDelayClick;
		    private int      rippleFadeDuration;
		    private boolean  ripplePersistent;
		    private android.graphics.drawable.Drawable rippleBackground;
		    private boolean  rippleInAdapter;
		    private float    rippleRoundedCorners;
		    private float radius;
		    private AdapterView parentAdapter;
		    private View childView;
		    private AnimatorSet    rippleAnimator;
		    private ObjectAnimator hoverAnimator;
		    private Point currentCoords  = new Point();
		    private Point previousCoords = new Point();
		    private int layerType;
		    private boolean eventCancelled;
		    private boolean prepressed;
		    private int     positionInAdapter;
		    private GestureDetector   gestureDetector;
		    private PerformClickEvent pendingClickEvent;
		    private PressedEvent      pendingPressEvent;
		    public static RippleBuilder on(View view) {
			        return new RippleBuilder(view);
			    }
		    public MaterialRippleLayout(Context context) {
			        this(context, null, 0);
			    }
		    public MaterialRippleLayout(Context context, AttributeSet attrs) {
			        this(context, attrs, 0);
			    }
		    public MaterialRippleLayout(Context context, AttributeSet attrs, int defStyle) {
			        super(context, attrs, defStyle);
			        setWillNotDraw(false);
			        gestureDetector = new GestureDetector(context, longClickListener);
			        
			        rippleColor = DEFAULT_COLOR;
			        rippleDiameter =  (int) dpToPx(getResources(), DEFAULT_DIAMETER_DP);
			        rippleOverlay = DEFAULT_RIPPLE_OVERLAY;
			        rippleHover = DEFAULT_HOVER;
			        rippleDuration = DEFAULT_DURATION;
			        rippleAlpha = (int) (255 * DEFAULT_ALPHA);
			        rippleDelayClick = DEFAULT_DELAY_CLICK;
			        rippleFadeDuration = DEFAULT_FADE_DURATION;
			        rippleBackground = new android.graphics.drawable.ColorDrawable(DEFAULT_BACKGROUND);
			        ripplePersistent = DEFAULT_PERSISTENT;
			        rippleInAdapter = DEFAULT_SEARCH_ADAPTER;
			        rippleRoundedCorners = DEFAULT_ROUNDED_CORNERS;
			
			        paint.setColor(rippleColor);
			        paint.setAlpha(rippleAlpha);
			        enableClipPathSupportIfNecessary();
			    }
		    @SuppressWarnings("unchecked")
		    public <T extends View> T getChildView() {
			        return (T) childView;
			    }
		    @Override
		    public final void addView(View child, int index, ViewGroup.LayoutParams params) {
			        if (getChildCount() > 0) {
				            throw new IllegalStateException("MaterialRippleLayout can host only one child");
				        }
			        childView = child;
			        super.addView(child, index, params);
			    }
		    @Override
		    public void setOnClickListener(OnClickListener onClickListener) {
			        if (childView == null) {
				            throw new IllegalStateException("MaterialRippleLayout must have a child view to handle clicks");
				        }
			        childView.setOnClickListener(onClickListener);
			    }
		    @Override
		    public void setOnLongClickListener(OnLongClickListener onClickListener) {
			        if (childView == null) {
				            throw new IllegalStateException("MaterialRippleLayout must have a child view to handle clicks");
				        }
			        childView.setOnLongClickListener(onClickListener);
			    }
		    @Override
		    public boolean onInterceptTouchEvent(MotionEvent event) {
			        return !findClickableViewInChild(childView, (int) event.getX(), (int) event.getY());
			    }
		    @Override
		    public boolean onTouchEvent(MotionEvent event) {
			        boolean superOnTouchEvent = super.onTouchEvent(event);
			        if (!isEnabled() || !childView.isEnabled()) return superOnTouchEvent;
			        boolean isEventInBounds = bounds.contains((int) event.getX(), (int) event.getY());
			        if (isEventInBounds) {
				            previousCoords.set(currentCoords.x, currentCoords.y);
				            currentCoords.set((int) event.getX(), (int) event.getY());
				        }
			        boolean gestureResult = gestureDetector.onTouchEvent(event);
			        if (gestureResult || hasPerformedLongPress) {
				            return true;
				        } else {
				            int action = event.getActionMasked();
				            switch (action) {
					                case MotionEvent.ACTION_UP:
					                    pendingClickEvent = new PerformClickEvent();
					                    if (prepressed) {
						                        childView.setPressed(true);
						                        postDelayed(
						                            new Runnable() {
							                                @Override public void run() {
								                                    childView.setPressed(false);
								                                }
							                            }, ViewConfiguration.getPressedStateDuration());
						                    }
					                    if (isEventInBounds) {
						                        startRipple(pendingClickEvent);
						                    } else if (!rippleHover) {
						                        setRadius(0);
						                    }
					                    if (!rippleDelayClick && isEventInBounds) {
						                        pendingClickEvent.run();
						                    }
					                    cancelPressedEvent();
					                    break;
					                case MotionEvent.ACTION_DOWN:
					                    setPositionInAdapter();
					                    eventCancelled = false;
					                    pendingPressEvent = new PressedEvent(event);
					                    if (isInScrollingContainer()) {
						                        cancelPressedEvent();
						                        prepressed = true;
						                        postDelayed(pendingPressEvent, ViewConfiguration.getTapTimeout());
						                    } else {
						                        pendingPressEvent.run();
						                    }
					                    break;
					                case MotionEvent.ACTION_CANCEL:
					                    if (rippleInAdapter) {
						                        currentCoords.set(previousCoords.x, previousCoords.y);
						                        previousCoords = new Point();
						                    }
					                    childView.onTouchEvent(event);
					                    if (rippleHover) {
						                        if (!prepressed) {
							                            startRipple(null);
							                        }
						                    } else {
						                        childView.setPressed(false);
						                    }
					                    cancelPressedEvent();
					                    break;
					                case MotionEvent.ACTION_MOVE:
					                    if (rippleHover) {
						                        if (isEventInBounds && !eventCancelled) {
							                            invalidate();
							                        } else if (!isEventInBounds) {
							                            startRipple(null);
							                        }
						                    }
					                    if (!isEventInBounds) {
						                        cancelPressedEvent();
						                        if (hoverAnimator != null) {
							                            hoverAnimator.cancel();
							                        }
						                        childView.onTouchEvent(event);
						                        eventCancelled = true;
						                    }
					                    break;
					            }
				            return true;
				        }
			    }
		    private void cancelPressedEvent() {
			        if (pendingPressEvent != null) {
				            removeCallbacks(pendingPressEvent);
				            prepressed = false;
				        }
			    }
		    private boolean hasPerformedLongPress;
		    private android.view.GestureDetector.SimpleOnGestureListener longClickListener = new GestureDetector.SimpleOnGestureListener() {
			        public void onLongPress(MotionEvent e) {
				            hasPerformedLongPress = childView.performLongClick();
				            if (hasPerformedLongPress) {
					                if (rippleHover) {
						                    startRipple(null);
						                }
					                cancelPressedEvent();
					            }
				        }
			        @Override
			        public boolean onDown(MotionEvent e) {
				            hasPerformedLongPress = false;
				            return super.onDown(e);
				        }
			    };
		    private void startHover() {
			        if (eventCancelled) return;
			        if (hoverAnimator != null) {
				            hoverAnimator.cancel();
				        }
			        final float radius = (float) (Math.sqrt(Math.pow(getWidth(), 2) + Math.pow(getHeight(), 2)) * 1.2f);
			        hoverAnimator = ObjectAnimator.ofFloat(this, radiusProperty, rippleDiameter, radius)
			            .setDuration(HOVER_DURATION);
			        hoverAnimator.setInterpolator(new android.view.animation.LinearInterpolator());
			        hoverAnimator.start();
			    }
		    private void startRipple(final Runnable animationEndRunnable) {
			        if (eventCancelled) return;
			        float endRadius = getEndRadius();
			        cancelAnimations();
			        rippleAnimator = new AnimatorSet();
			        rippleAnimator.addListener(new AnimatorListenerAdapter() {
				            @Override public void onAnimationEnd(Animator animation) {
					                if (!ripplePersistent) {
						                    setRadius(0);
						                    setRippleAlpha(rippleAlpha);
						                }
					                if (animationEndRunnable != null && rippleDelayClick) {
						                    animationEndRunnable.run();
						                }
					                childView.setPressed(false);
					            }
				        });
			        ObjectAnimator ripple = ObjectAnimator.ofFloat(this, radiusProperty, radius, endRadius);
			        ripple.setDuration(rippleDuration);
			        ripple.setInterpolator(new android.view.animation.DecelerateInterpolator());
			        ObjectAnimator fade = ObjectAnimator.ofInt(this, circleAlphaProperty, rippleAlpha, 0);
			        fade.setDuration(rippleFadeDuration);
			        fade.setInterpolator(new android.view.animation.AccelerateInterpolator());
			        fade.setStartDelay(rippleDuration - rippleFadeDuration - FADE_EXTRA_DELAY);
			        if (ripplePersistent) {
				            rippleAnimator.play(ripple);
				        } else if (getRadius() > endRadius) {
				            fade.setStartDelay(0);
				            rippleAnimator.play(fade);
				        } else {
				            rippleAnimator.playTogether(ripple, fade);
				        }
			        rippleAnimator.start();
			    }
		    private void cancelAnimations() {
			        if (rippleAnimator != null) {
				            rippleAnimator.cancel();
				            rippleAnimator.removeAllListeners();
				        }
			        if (hoverAnimator != null) {
				            hoverAnimator.cancel();
				        }
			    }
		    private float getEndRadius() {
			        final int width = getWidth();
			        final int height = getHeight();
			        final int halfWidth = width / 2;
			        final int halfHeight = height / 2;
			        final float radiusX = halfWidth > currentCoords.x ? width - currentCoords.x : currentCoords.x;
			        final float radiusY = halfHeight > currentCoords.y ? height - currentCoords.y : currentCoords.y;
			        return (float) Math.sqrt(Math.pow(radiusX, 2) + Math.pow(radiusY, 2)) * 1.2f;
			    }
		    private boolean isInScrollingContainer() {
			        ViewParent p = getParent();
			        while (p != null && p instanceof ViewGroup) {
				            if (((ViewGroup) p).shouldDelayChildPressedState()) {
					                return true;
					            }
				            p = p.getParent();
				        }
			        return false;
			    }
		    private AdapterView findParentAdapterView() {
			        if (parentAdapter != null) {
				            return parentAdapter;
				        }
			        ViewParent current = getParent();
			        while (true) {
				            if (current instanceof AdapterView) {
					                parentAdapter = (AdapterView) current;
					                return parentAdapter;
					            } else {
					                try {
						                    current = current.getParent();
						                } catch (NullPointerException npe) {
						                    throw new RuntimeException("Could not find a parent AdapterView");
						                }
					            }
				        }
			    }
		    private void setPositionInAdapter() {
			        if (rippleInAdapter) {
				            positionInAdapter = findParentAdapterView().getPositionForView(MaterialRippleLayout.this);
				        }
			    }
		    private boolean adapterPositionChanged() {
			        if (rippleInAdapter) {
				            int newPosition = findParentAdapterView().getPositionForView(MaterialRippleLayout.this);
				            final boolean changed = newPosition != positionInAdapter;
				            positionInAdapter = newPosition;
				            if (changed) {
					                cancelPressedEvent();
					                cancelAnimations();
					                childView.setPressed(false);
					                setRadius(0);
					            }
				            return changed;
				        }
			        return false;
			    }
		    private boolean findClickableViewInChild(View view, int x, int y) {
			        if (view instanceof ViewGroup) {
				            ViewGroup viewGroup = (ViewGroup) view;
				            for (int i = 0; i < viewGroup.getChildCount(); i++) {
					                View child = viewGroup.getChildAt(i);
					                final Rect rect = new Rect();
					                child.getHitRect(rect);
					                final boolean contains = rect.contains(x, y);
					                if (contains) {
						                    return findClickableViewInChild(child, x - rect.left, y - rect.top);
						                }
					            }
				        } else if (view != childView) {
				            return (view.isEnabled() && (view.isClickable() || view.isLongClickable() || view.isFocusableInTouchMode()));
				        }
			        return view.isFocusableInTouchMode();
			    }
		    @Override
		    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
			        super.onSizeChanged(w, h, oldw, oldh);
			        bounds.set(0, 0, w, h);
			        rippleBackground.setBounds(bounds);
			    }
		    @Override
		    public boolean isInEditMode() {
			        return true;
			    }
		    @Override
		    public void draw(Canvas canvas) {
			        final boolean positionChanged = adapterPositionChanged();
			        if (rippleOverlay) {
				            if (!positionChanged) {
					                rippleBackground.draw(canvas);
					            }
				            super.draw(canvas);
				            if (!positionChanged) {
					                if (rippleRoundedCorners != 0) {
						                    Path clipPath = new Path();
						                    RectF rect = new RectF(0, 0, canvas.getWidth(), canvas.getHeight());
						                    clipPath.addRoundRect(rect, rippleRoundedCorners, rippleRoundedCorners, Path.Direction.CW);
						                    canvas.clipPath(clipPath);
						                }
					                canvas.drawCircle(currentCoords.x, currentCoords.y, radius, paint);
					            }
				        } else {
				            if (!positionChanged) {
					                rippleBackground.draw(canvas);
					                canvas.drawCircle(currentCoords.x, currentCoords.y, radius, paint);
					            }
				            super.draw(canvas);
				        }
			    }
		    private Property<MaterialRippleLayout, Float> radiusProperty
		        = new Property<MaterialRippleLayout, Float>(Float.class, "radius") {
			        @Override
			        public Float get(MaterialRippleLayout object) {
				            return object.getRadius();
				        }
			        @Override
			        public void set(MaterialRippleLayout object, Float value) {
				            object.setRadius(value);
				        }
			    };
		    private float getRadius() {
			        return radius;
			    }
		    public void setRadius(float radius) {
			        this.radius = radius;
			        invalidate();
			    }
		    private Property<MaterialRippleLayout, Integer> circleAlphaProperty
		        = new Property<MaterialRippleLayout, Integer>(Integer.class, "rippleAlpha") {
			        @Override
			        public Integer get(MaterialRippleLayout object) {
				            return object.getRippleAlpha();
				        }
			        @Override
			        public void set(MaterialRippleLayout object, Integer value) {
				            object.setRippleAlpha(value);
				        }
			    };
		    public int getRippleAlpha() {
			        return paint.getAlpha();
			    }
		    public void setRippleAlpha(Integer rippleAlpha) {
			        paint.setAlpha(rippleAlpha);
			        invalidate();
			    }
		    public void setRippleColor(int rippleColor) {
			        this.rippleColor = rippleColor;
			        paint.setColor(rippleColor);
			        paint.setAlpha(rippleAlpha);
			        invalidate();
			    }
		    public void setRippleOverlay(boolean rippleOverlay) {
			        this.rippleOverlay = rippleOverlay;
			    }
		    public void setRippleDiameter(int rippleDiameter) {
			        this.rippleDiameter = rippleDiameter;
			    }
		    public void setRippleDuration(int rippleDuration) {
			        this.rippleDuration = rippleDuration;
			    }
		    public void setRippleBackground(int color) {
			        rippleBackground = new android.graphics.drawable.ColorDrawable(color);
			        rippleBackground.setBounds(bounds);
			        invalidate();
			    }
		    public void setRippleHover(boolean rippleHover) {
			        this.rippleHover = rippleHover;
			    }
		    public void setRippleDelayClick(boolean rippleDelayClick) {
			        this.rippleDelayClick = rippleDelayClick;
			    }
		    public void setRippleFadeDuration(int rippleFadeDuration) {
			        this.rippleFadeDuration = rippleFadeDuration;
			    }
		    public void setRipplePersistent(boolean ripplePersistent) {
			        this.ripplePersistent = ripplePersistent;
			    }
		    public void setRippleInAdapter(boolean rippleInAdapter) {
			        this.rippleInAdapter = rippleInAdapter;
			    }
		    public void setRippleRoundedCorners(int rippleRoundedCorner) {
			        this.rippleRoundedCorners = rippleRoundedCorner;
			        enableClipPathSupportIfNecessary();
			    }
		    public void setDefaultRippleAlpha(float alpha) {
			        this.rippleAlpha = (int) (255 * alpha);
			        paint.setAlpha(rippleAlpha);
			        invalidate();
			    }
		    public void performRipple() {
			        currentCoords = new Point(getWidth() / 2, getHeight() / 2);
			        startRipple(null);
			    }
		    public void performRipple(Point anchor) {
			        currentCoords = new Point(anchor.x, anchor.y);
			        startRipple(null);
			    }
		    private void enableClipPathSupportIfNecessary() {
			        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.JELLY_BEAN_MR1) {
				            if (rippleRoundedCorners != 0) {
					                layerType = getLayerType();
					                setLayerType(LAYER_TYPE_SOFTWARE, null);
					            } else {
					                setLayerType(layerType, null);
					            }
				        }
			    }
		    private class PerformClickEvent implements Runnable {
			        @Override public void run() {
				            if (hasPerformedLongPress) return;
				            if (getParent() instanceof AdapterView) {
					                if (!childView.performClick())
					                    clickAdapterView((AdapterView) getParent());
					            } else if (rippleInAdapter) {
					                clickAdapterView(findParentAdapterView());
					            } else {
					                childView.performClick();
					            }
				        }
			        private void clickAdapterView(AdapterView parent) {
				            final int position = parent.getPositionForView(MaterialRippleLayout.this);
				            final long itemId = parent.getAdapter() != null
				                ? parent.getAdapter().getItemId(position)
				                : 0;
				            if (position != AdapterView.INVALID_POSITION) {
					                parent.performItemClick(MaterialRippleLayout.this, position, itemId);
					            }
				        }
			    }
		    private final class PressedEvent implements Runnable {
			        private final MotionEvent event;
			        public PressedEvent(MotionEvent event) {
				            this.event = event;
				        }
			        @Override
			        public void run() {
				            prepressed = false;
				            childView.setLongClickable(false);
				            childView.onTouchEvent(event);
				            childView.setPressed(true);
				            if (rippleHover) {
					                startHover();
					            }
				        }
			    }
		    static float dpToPx(android.content.res.Resources resources, float dp) {
			        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
			    }
		    public static class RippleBuilder {
			        private final Context context;
			        private final View    child;
			        private int     rippleColor         = DEFAULT_COLOR;
			        private boolean rippleOverlay       = DEFAULT_RIPPLE_OVERLAY;
			        private boolean rippleHover         = DEFAULT_HOVER;
			        private float   rippleDiameter      = DEFAULT_DIAMETER_DP;
			        private int     rippleDuration      = DEFAULT_DURATION;
			        private float   rippleAlpha         = DEFAULT_ALPHA;
			        private boolean rippleDelayClick    = DEFAULT_DELAY_CLICK;
			        private int     rippleFadeDuration  = DEFAULT_FADE_DURATION;
			        private boolean ripplePersistent    = DEFAULT_PERSISTENT;
			        private int     rippleBackground    = DEFAULT_BACKGROUND;
			        private boolean rippleSearchAdapter = DEFAULT_SEARCH_ADAPTER;
			        private float   rippleRoundedCorner = DEFAULT_ROUNDED_CORNERS;
			        public RippleBuilder(View child) {
				            this.child = child;
				            this.context = child.getContext();
				        }
			        public RippleBuilder rippleColor(int color) {
				            this.rippleColor = color;
				            return this;
				        }
			        public RippleBuilder rippleOverlay(boolean overlay) {
				            this.rippleOverlay = overlay;
				            return this;
				        }
			        public RippleBuilder rippleHover(boolean hover) {
				            this.rippleHover = hover;
				            return this;
				        }
			        public RippleBuilder rippleDiameterDp(int diameterDp) {
				            this.rippleDiameter = diameterDp;
				            return this;
				        }
			        public RippleBuilder rippleDuration(int duration) {
				            this.rippleDuration = duration;
				            return this;
				        }
			        public RippleBuilder rippleAlpha(float alpha) {
				            this.rippleAlpha = alpha;
				            return this;
				        }
			        public RippleBuilder rippleDelayClick(boolean delayClick) {
				            this.rippleDelayClick = delayClick;
				            return this;
				        }
			        public RippleBuilder rippleFadeDuration(int fadeDuration) {
				            this.rippleFadeDuration = fadeDuration;
				            return this;
				        }
			        public RippleBuilder ripplePersistent(boolean persistent) {
				            this.ripplePersistent = persistent;
				            return this;
				        }
			        public RippleBuilder rippleBackground(int color) {
				            this.rippleBackground = color;
				            return this;
				        }
			        public RippleBuilder rippleInAdapter(boolean inAdapter) {
				            this.rippleSearchAdapter = inAdapter;
				            return this;
				        }
			        public RippleBuilder rippleRoundedCorners(int radiusDp) {
				            this.rippleRoundedCorner = radiusDp;
				            return this;
				        }
			        public MaterialRippleLayout create() {
				            MaterialRippleLayout layout = new MaterialRippleLayout(context);
				            layout.setRippleColor(rippleColor);
				            layout.setDefaultRippleAlpha(rippleAlpha);
				            layout.setRippleDelayClick(rippleDelayClick);
				            layout.setRippleDiameter((int) dpToPx(context.getResources(), rippleDiameter));
				            layout.setRippleDuration(rippleDuration);
				            layout.setRippleFadeDuration(rippleFadeDuration);
				            layout.setRippleHover(rippleHover);
				            layout.setRipplePersistent(ripplePersistent);
				            layout.setRippleOverlay(rippleOverlay);
				            layout.setRippleBackground(rippleBackground);
				            layout.setRippleInAdapter(rippleSearchAdapter);
				            layout.setRippleRoundedCorners((int) dpToPx(context.getResources(), rippleRoundedCorner));
				            ViewGroup.LayoutParams params = child.getLayoutParams();
				            ViewGroup parent = (ViewGroup) child.getParent();
				            int index = 0;
				            if (parent != null && parent instanceof MaterialRippleLayout) {
					                throw new IllegalStateException("MaterialRippleLayout could not be created: parent of the view already is a MaterialRippleLayout");
					            }
				            if (parent != null) {
					                index = parent.indexOfChild(child);
					                parent.removeView(child);
					            }
				            layout.addView(child, new ViewGroup.LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT, android.view.ViewGroup.LayoutParams.MATCH_PARENT));
				            if (parent != null) {
					                parent.addView(layout, index, params);
					            }
				            return layout;
				        }
			    }
	}
	{
	}
	
	
	public void _Tap_Target_Library () {
	}
	static class UiUtil {
		    UiUtil() {
				    }
		    static int dp(Context context, int val) {
				        return (int) TypedValue.applyDimension(
				                TypedValue.COMPLEX_UNIT_DIP, val, context.getResources().getDisplayMetrics());
				    }
		    static int sp(Context context, int val) {
				        return (int) TypedValue.applyDimension(
				                TypedValue.COMPLEX_UNIT_SP, val, context.getResources().getDisplayMetrics());
				    }
		    static int themeIntAttr(Context context, String attr) {
				        final android.content.res.Resources.Theme theme = context.getTheme();
				        if (theme == null) {
						            return -1;
						        }
				        final TypedValue value = new TypedValue();
				        final int id = context.getResources().getIdentifier(attr, "attr", context.getPackageName());
				
				        if (id == 0) {
						            // Not found
						            return -1;
						        }
				        theme.resolveAttribute(id, value, true);
				        return value.data;
				    }
		    static int setAlpha(int argb, float alpha) {
				        if (alpha > 1.0f) {
						            alpha = 1.0f;
						        } else if (alpha <= 0.0f) {
						            alpha = 0.0f;
						        }
				        return ((int) ((argb >>> 24) * alpha) << 24) | (argb & 0x00FFFFFF);
				    }
	}
	static class FloatValueAnimatorBuilder {
		
		    private final ValueAnimator animator;
		
		    private EndListener endListener;
		
		    interface UpdateListener {
				        void onUpdate(float lerpTime);
				    }
		    interface EndListener {
				        void onEnd();
				    }
		    protected FloatValueAnimatorBuilder() {
				        this(false);
				    }
		    FloatValueAnimatorBuilder(boolean reverse) {
				        if (reverse) {
						            this.animator = ValueAnimator.ofFloat(1.0f, 0.0f);
						        } else {
						            this.animator = ValueAnimator.ofFloat(0.0f, 1.0f);
						        }
				    }
		    public FloatValueAnimatorBuilder delayBy(long millis) {
				        animator.setStartDelay(millis);
				        return this;
				    }
		    public FloatValueAnimatorBuilder duration(long millis) {
				        animator.setDuration(millis);
				        return this;
				    }
		    public FloatValueAnimatorBuilder interpolator(TimeInterpolator lerper) {
				        animator.setInterpolator(lerper);
				        return this;
				    }
		    public FloatValueAnimatorBuilder repeat(int times) {
				        animator.setRepeatCount(times);
				        return this;
				    }
		    public FloatValueAnimatorBuilder onUpdate(final UpdateListener listener) {
				        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
						            @Override
						            public void onAnimationUpdate(ValueAnimator animation) {
								                listener.onUpdate((float) animation.getAnimatedValue());
								            }
						        });
				        return this;
				    }
		    public FloatValueAnimatorBuilder onEnd(final EndListener listener) {
				        this.endListener = listener;
				        return this;
				    }
		    public ValueAnimator build() {
				        if (endListener != null) {
						            animator.addListener(new AnimatorListenerAdapter() {
								                @Override
								                public void onAnimationEnd(Animator animation) {
										                    endListener.onEnd();
										                }
								            });
						        }
				        return animator;
				    }
	}
	
	static class ReflectUtil {
		    ReflectUtil() {
				    }
		    static Object getPrivateField(Object source, String fieldName)
		            throws NoSuchFieldException, IllegalAccessException {
				        final java.lang.reflect.Field objectField = source.getClass().getDeclaredField(fieldName);
				        objectField.setAccessible(true);
				        return objectField.get(source);
				    }
	}
	static class TapTarget extends Activity {
		    final CharSequence title;
		    final CharSequence description;
		    float outerCircleAlpha = 0.96f;
		    int targetRadius = 44;
		    Rect bounds;
		    android.graphics.drawable.Drawable icon;
		    Typeface titleTypeface;
		    Typeface descriptionTypeface;
		
		
		    private int outerCircleColorRes = -1;
		    private int targetCircleColorRes = -1;
		    private int dimColorRes = -1;
		    private int titleTextColorRes = -1;
		    private int descriptionTextColorRes = -1;
		
		    private Integer outerCircleColor = null;
		    private Integer targetCircleColor = null;
		    private Integer dimColor = null;
		    private Integer titleTextColor = null;
		    private Integer descriptionTextColor = null;
		
		    private int titleTextDimen = -1;
		    private int descriptionTextDimen = -1;
		    private int titleTextSize = 20;
		    private int descriptionTextSize = 18;
		    int id = -1;
		    boolean drawShadow = false;
		    boolean cancelable = true;
		    boolean tintTarget = true;
		    boolean transparentTarget = false;
		    float titleTextAlpha = 1f;
		    float descriptionTextAlpha = 0.54f;
		public static TapTarget forView(View view, CharSequence title) {
				        return forView(view, title, null);
				    }
		    public static TapTarget forView(View view, CharSequence title, CharSequence description) {
				        return new ViewTapTarget(view, title, description);
				    }
		    public static TapTarget forBounds(Rect bounds, CharSequence title) {
				        return forBounds(bounds, title, null);
				    }
		    public static TapTarget forBounds(Rect bounds, CharSequence title,  CharSequence description) {
				        return new TapTarget(bounds, title, description);
				    }
		    protected TapTarget(Rect bounds, CharSequence title,  CharSequence description) {
				        this(title, description);
				        if (bounds == null) {
						            throw new IllegalArgumentException("Cannot pass null bounds or title");
						        }
				        this.bounds = bounds;
				    }
		    protected TapTarget(CharSequence title,  CharSequence description) {
				        if (title == null) {
						            throw new IllegalArgumentException("Cannot pass null title");
						        }
				        this.title = title;
				        this.description = description;
				    }
		    public TapTarget transparentTarget(boolean transparent) {
				        this.transparentTarget = transparent;
				        return this;
				    }
		    public TapTarget outerCircleColor( int color) {
				        this.outerCircleColorRes = color;
				        return this;
				    }
		    public TapTarget outerCircleColorInt( int color) {
				        this.outerCircleColor = color;
				        return this;
				    }
		    public TapTarget outerCircleAlpha(float alpha) {
				        if (alpha < 0.0f || alpha > 1.0f) {
						            throw new IllegalArgumentException("Given an invalid alpha value: " + alpha);
						        }
				        this.outerCircleAlpha = alpha;
				        return this;
				    }
		    public TapTarget targetCircleColor( int color) {
				        this.targetCircleColorRes = color;
				        return this;
				    }
		    public TapTarget targetCircleColorInt( int color) {
				        this.targetCircleColor = color;
				        return this;
				    }
		    public TapTarget textColor( int color) {
				        this.titleTextColorRes = color;
				        this.descriptionTextColorRes = color;
				        return this;
				    }
		    public TapTarget textColorInt( int color) {
				        this.titleTextColor = color;
				        this.descriptionTextColor = color;
				        return this;
				    }
		    public TapTarget titleTextColor( int color) {
				        this.titleTextColorRes = color;
				        return this;
				    }
		    public TapTarget titleTextColorInt( int color) {
				        this.titleTextColor = color;
				        return this;
				    }
		    public TapTarget descriptionTextColor( int color) {
				        this.descriptionTextColorRes = color;
				        return this;
				    }
		    public TapTarget descriptionTextColorInt( int color) {
				        this.descriptionTextColor = color;
				        return this;
				    }
		    public TapTarget textTypeface(Typeface typeface) {
				        if (typeface == null) throw new IllegalArgumentException("Cannot use a null typeface");
				        titleTypeface = typeface;
				        descriptionTypeface = typeface;
				        return this;
				    }
		    public TapTarget titleTypeface(Typeface titleTypeface) {
				        if (titleTypeface == null) throw new IllegalArgumentException("Cannot use a null typeface");
				        this.titleTypeface = titleTypeface;
				        return this;
				    }
		    public TapTarget descriptionTypeface(Typeface descriptionTypeface) {
				        if (descriptionTypeface == null) throw new IllegalArgumentException("Cannot use a null typeface");
				        this.descriptionTypeface = descriptionTypeface;
				        return this;
				    }
		    public TapTarget textSize(int sp) {
				        if (sp < 0) throw new IllegalArgumentException("Given negative text size");
				        this.titleTextSize = sp;
				        this.descriptionTextSize = sp;
				        return this;
				    }
		    public TapTarget titleTextSize(int sp) {
				        if (sp < 0) throw new IllegalArgumentException("Given negative text size");
				        this.titleTextSize = sp;
				        return this;
				    }
		    public TapTarget descriptionTextSize(int sp) {
				        if (sp < 0) throw new IllegalArgumentException("Given negative text size");
				        this.descriptionTextSize = sp;
				        return this;
				    }
		    public TapTarget titleTextDimen( int dimen) {
				        this.titleTextDimen = dimen;
				        return this;
				    }
		    public TapTarget textAlpha(float alpha) {
				        if (alpha < 0 || alpha > 1f) {
						            throw new IllegalArgumentException("Given an invalid alpha value: " + alpha);
						        }
				        this.titleTextAlpha = alpha;
				        this.descriptionTextAlpha = alpha;
				        return this;
				    }
		    public TapTarget titleTextAlpha(float alpha) {
				        if (alpha < 0 || alpha > 1f) {
						            throw new IllegalArgumentException("Given an invalid alpha value: " + alpha);
						        }
				        this.titleTextAlpha = alpha;
				        return this;
				    }
		    public TapTarget descriptionTextAlpha(float alpha) {
				        if (alpha < 0 || alpha > 1f) {
						            throw new IllegalArgumentException("Given an invalid alpha value: " + alpha);
						        }
				        this.descriptionTextAlpha = alpha;
				        return this;
				    }
		    public TapTarget descriptionTextDimen( int dimen) {
				        this.descriptionTextDimen = dimen;
				        return this;
				    }
		    public TapTarget dimColor( int color) {
				        this.dimColorRes = color;
				        return this;
				    }
		    public TapTarget dimColorInt( int color) {
				        this.dimColor = color;
				        return this;
				    }
		    public TapTarget drawShadow(boolean draw) {
				        this.drawShadow = draw;
				        return this;
				    }
		    public TapTarget cancelable(boolean status) {
				        this.cancelable = status;
				        return this;
				    }
		    public TapTarget tintTarget(boolean tint) {
				        this.tintTarget = tint;
				        return this;
				    }
		    public TapTarget icon(android.graphics.drawable.Drawable icon) {
				        return icon(icon, false);
				    }
		    public TapTarget icon(android.graphics.drawable.Drawable icon, boolean hasSetBounds) {
				        if (icon == null) throw new IllegalArgumentException("Cannot use null drawable");
				        this.icon = icon;
				        if (!hasSetBounds) {
						            this.icon.setBounds(new Rect(0, 0, this.icon.getIntrinsicWidth(), this.icon.getIntrinsicHeight()));
						        }
				        return this;
				    }
		    public TapTarget id(int id) {
				        this.id = id;
				        return this;
				    }
		    public TapTarget targetRadius(int targetRadius) {
				        this.targetRadius = targetRadius;
				        return this;
				    }
		    public int id() {
				        return id;
				    }
		    public void onReady(Runnable runnable) {
				        runnable.run();
				    }
		    public Rect bounds() {
				        if (bounds == null) {
						            throw new IllegalStateException("Requesting bounds that are not set! Make sure your target is ready");
						        }
				        return bounds;
				    }
		    Integer outerCircleColorInt(Context context) {
				        return colorResOrInt(context, outerCircleColor, outerCircleColorRes);
				    }
		    Integer targetCircleColorInt(Context context) {
				        return colorResOrInt(context, targetCircleColor, targetCircleColorRes);
				    }
		    Integer dimColorInt(Context context) {
				        return colorResOrInt(context, dimColor, dimColorRes);
				    }
		    Integer titleTextColorInt(Context context) {
				        return colorResOrInt(context, titleTextColor, titleTextColorRes);
				    }
		
		    Integer descriptionTextColorInt(Context context) {
				        return colorResOrInt(context, descriptionTextColor, descriptionTextColorRes);
				    }
		    int titleTextSizePx(Context context) {
				        return dimenOrSize(context, titleTextSize, titleTextDimen);
				    }
		    int descriptionTextSizePx(Context context) {
				        return dimenOrSize(context, descriptionTextSize, descriptionTextDimen);
				    }
		
		    private Integer colorResOrInt(Context context, Integer value,  int resource) {
				        if (resource != -1) {
						            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
								                return context.getColor(resource);
								            }
						        }
				        return value;
				    }
		    private int dimenOrSize(Context context, int size,  int dimen) {
				        if (dimen != -1) {
						            return context.getResources().getDimensionPixelSize(dimen);
						        }
				        return UiUtil.sp(context, size);
				    }
	}
	static class TapTargetView extends View {
		    private boolean isDismissed = false;
		    private boolean isDismissing = false;
		    private boolean isInteractable = true;
		
		    final int TARGET_PADDING;
		    final int TARGET_RADIUS;
		    final int TARGET_PULSE_RADIUS;
		    final int TEXT_PADDING;
		    final int TEXT_SPACING;
		    final int TEXT_MAX_WIDTH;
		    final int TEXT_POSITIONING_BIAS;
		    final int CIRCLE_PADDING;
		    final int GUTTER_DIM;
		    final int SHADOW_DIM;
		    final int SHADOW_JITTER_DIM;
		
		
		    final ViewGroup boundingParent;
		    final ViewManager parent;
		    final TapTarget target;
		    final Rect targetBounds;
		
		    final TextPaint titlePaint;
		    final TextPaint descriptionPaint;
		    final Paint outerCirclePaint;
		    final Paint outerCircleShadowPaint;
		    final Paint targetCirclePaint;
		    final Paint targetCirclePulsePaint;
		
		    CharSequence title;
		
		    StaticLayout titleLayout;
		
		    CharSequence description;
		
		    StaticLayout descriptionLayout;
		    boolean isDark;
		    boolean debug;
		    boolean shouldTintTarget;
		    boolean shouldDrawShadow;
		    boolean cancelable;
		    boolean visible;
		
		    // Debug related variables
		
		    SpannableStringBuilder debugStringBuilder;
		
		    DynamicLayout debugLayout;
		
		    TextPaint debugTextPaint;
		
		    Paint debugPaint;
		
		    // Drawing properties
		    Rect drawingBounds;
		    Rect textBounds;
		
		    Path outerCirclePath;
		    float outerCircleRadius;
		    int calculatedOuterCircleRadius;
		    int[] outerCircleCenter;
		    int outerCircleAlpha;
		
		    float targetCirclePulseRadius;
		    int targetCirclePulseAlpha;
		
		    float targetCircleRadius;
		    int targetCircleAlpha;
		
		    int textAlpha;
		    int dimColor;
		
		    float lastTouchX;
		    float lastTouchY;
		
		    int topBoundary;
		    int bottomBoundary;
		
		    Bitmap tintedTarget;
		
		    Listener listener;
		
		
		    ViewOutlineProvider outlineProvider;
		
		    public static TapTargetView showFor(Activity activity, TapTarget target) {
				        return showFor(activity, target, null);
				    }
		
		    public static TapTargetView showFor(Activity activity, TapTarget target, Listener listener) {
				        if (activity == null) throw new IllegalArgumentException("Activity is null");
				
				        final ViewGroup decor = (ViewGroup) activity.getWindow().getDecorView();
				        final ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
				                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
				        final ViewGroup content = (ViewGroup) decor.findViewById(android.R.id.content);
				        final TapTargetView tapTargetView = new TapTargetView(activity, decor, content, target, listener);
				        decor.addView(tapTargetView, layoutParams);
				
				        return tapTargetView;
				    }
		
		    public static TapTargetView showFor(Dialog dialog, TapTarget target) {
				        return showFor(dialog, target, null);
				    }
		
		    public static TapTargetView showFor(Dialog dialog, TapTarget target, Listener listener) {
				        if (dialog == null) throw new IllegalArgumentException("Dialog is null");
				
				        final Context context = dialog.getContext();
				        final WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
				        final WindowManager.LayoutParams params = new WindowManager.LayoutParams();
				        params.type = WindowManager.LayoutParams.TYPE_APPLICATION;
				        params.format = PixelFormat.RGBA_8888;
				        params.flags = 0;
				        params.gravity = Gravity.START | Gravity.TOP;
				        params.x = 0;
				        params.y = 0;
				        params.width = WindowManager.LayoutParams.MATCH_PARENT;
				        params.height = WindowManager.LayoutParams.MATCH_PARENT;
				
				        final TapTargetView tapTargetView = new TapTargetView(context, windowManager, null, target, listener);
				        windowManager.addView(tapTargetView, params);
				
				        return tapTargetView;
				    }
		public static class Listener {
				        /** Signals that the user has clicked inside of the target **/
				        public void onTargetClick(TapTargetView view) {
						            view.dismiss(true);
						        }
				
				        /** Signals that the user has long clicked inside of the target **/
				        public void onTargetLongClick(TapTargetView view) {
						            onTargetClick(view);
						        }
				
				        /** If cancelable, signals that the user has clicked outside of the outer circle **/
				        public void onTargetCancel(TapTargetView view) {
						            view.dismiss(false);
						        }
				
				        /** Signals that the user clicked on the outer circle portion of the tap target **/
				        public void onOuterCircleClick(TapTargetView view) {
						            // no-op as default
						        }
				
				        /**
         * Signals that the tap target has been dismissed
         * @param userInitiated Whether the user caused this action
         *
         *
         */
				        public void onTargetDismissed(TapTargetView view, boolean userInitiated) {
						        }
				    }
		
		    final FloatValueAnimatorBuilder.UpdateListener expandContractUpdateListener = new FloatValueAnimatorBuilder.UpdateListener() {
				        @Override
				        public void onUpdate(float lerpTime) {
						            final float newOuterCircleRadius = calculatedOuterCircleRadius * lerpTime;
						            final boolean expanding = newOuterCircleRadius > outerCircleRadius;
						            if (!expanding) {
								                // When contracting we need to invalidate the old drawing bounds. Otherwise
								                // you will see artifacts as the circle gets smaller
								                calculateDrawingBounds();
								            }
						
						            final float targetAlpha = target.outerCircleAlpha * 255;
						            outerCircleRadius = newOuterCircleRadius;
						            outerCircleAlpha = (int) Math.min(targetAlpha, (lerpTime * 1.5f * targetAlpha));
						            outerCirclePath.reset();
						            outerCirclePath.addCircle(outerCircleCenter[0], outerCircleCenter[1], outerCircleRadius, Path.Direction.CW);
						
						            targetCircleAlpha = (int) Math.min(255.0f, (lerpTime * 1.5f * 255.0f));
						
						            if (expanding) {
								                targetCircleRadius = TARGET_RADIUS * Math.min(1.0f, lerpTime * 1.5f);
								            } else {
								                targetCircleRadius = TARGET_RADIUS * lerpTime;
								                targetCirclePulseRadius *= lerpTime;
								            }
						
						            textAlpha = (int) (delayedLerp(lerpTime, 0.7f) * 255);
						
						            if (expanding) {
								                calculateDrawingBounds();
								            }
						
						            invalidateViewAndOutline(drawingBounds);
						        }
				    };
		
		    final ValueAnimator expandAnimation = new FloatValueAnimatorBuilder()
		            .duration(250)
		            .delayBy(250)
		            .interpolator(new AccelerateDecelerateInterpolator())
		            .onUpdate(new FloatValueAnimatorBuilder.UpdateListener() {
				                @Override
				                public void onUpdate(float lerpTime) {
						                    expandContractUpdateListener.onUpdate(lerpTime);
						                }
				            })
		            .onEnd(new FloatValueAnimatorBuilder.EndListener() {
				                @Override
				                public void onEnd() {
						                    pulseAnimation.start();
						                    isInteractable = true;
						                }
				            })
		            .build();
		
		    final ValueAnimator pulseAnimation = new FloatValueAnimatorBuilder()
		            .duration(1000)
		            .repeat(ValueAnimator.INFINITE)
		            .interpolator(new AccelerateDecelerateInterpolator())
		            .onUpdate(new FloatValueAnimatorBuilder.UpdateListener() {
				                @Override
				                public void onUpdate(float lerpTime) {
						                    final float pulseLerp = delayedLerp(lerpTime, 0.5f);
						                    targetCirclePulseRadius = (1.0f + pulseLerp) * TARGET_RADIUS;
						                    targetCirclePulseAlpha = (int) ((1.0f - pulseLerp) * 255);
						                    targetCircleRadius = TARGET_RADIUS + halfwayLerp(lerpTime) * TARGET_PULSE_RADIUS;
						
						                    if (outerCircleRadius != calculatedOuterCircleRadius) {
								                        outerCircleRadius = calculatedOuterCircleRadius;
								                    }
						
						                    calculateDrawingBounds();
						                    invalidateViewAndOutline(drawingBounds);
						                }
				            })
		            .build();
		
		    final ValueAnimator dismissAnimation = new FloatValueAnimatorBuilder(true)
		            .duration(250)
		            .interpolator(new AccelerateDecelerateInterpolator())
		            .onUpdate(new FloatValueAnimatorBuilder.UpdateListener() {
				                @Override
				                public void onUpdate(float lerpTime) {
						                    expandContractUpdateListener.onUpdate(lerpTime);
						                }
				            })
		            .onEnd(new FloatValueAnimatorBuilder.EndListener() {
				                @Override
				                public void onEnd() {
						                    onDismiss(true);
						                    ViewUtil.removeView(parent, TapTargetView.this);
						                }
				            })
		            .build();
		
		    private final ValueAnimator dismissConfirmAnimation = new FloatValueAnimatorBuilder()
		            .duration(250)
		            .interpolator(new AccelerateDecelerateInterpolator())
		            .onUpdate(new FloatValueAnimatorBuilder.UpdateListener() {
				                @Override
				                public void onUpdate(float lerpTime) {
						                    final float spedUpLerp = Math.min(1.0f, lerpTime * 2.0f);
						                    outerCircleRadius = calculatedOuterCircleRadius * (1.0f + (spedUpLerp * 0.2f));
						                    outerCircleAlpha = (int) ((1.0f - spedUpLerp) * target.outerCircleAlpha * 255.0f);
						                    outerCirclePath.reset();
						                    outerCirclePath.addCircle(outerCircleCenter[0], outerCircleCenter[1], outerCircleRadius, Path.Direction.CW);
						                    targetCircleRadius = (1.0f - lerpTime) * TARGET_RADIUS;
						                    targetCircleAlpha = (int) ((1.0f - lerpTime) * 255.0f);
						                    targetCirclePulseRadius = (1.0f + lerpTime) * TARGET_RADIUS;
						                    targetCirclePulseAlpha = (int) ((1.0f - lerpTime) * targetCirclePulseAlpha);
						                    textAlpha = (int) ((1.0f - spedUpLerp) * 255.0f);
						                    calculateDrawingBounds();
						                    invalidateViewAndOutline(drawingBounds);
						                }
				            })
		            .onEnd(new FloatValueAnimatorBuilder.EndListener() {
				                @Override
				                public void onEnd() {
						                    onDismiss(true);
						                    ViewUtil.removeView(parent, TapTargetView.this);
						                }
				            })
		            .build();
		
		    private ValueAnimator[] animators = new ValueAnimator[]
		            {expandAnimation, pulseAnimation, dismissConfirmAnimation, dismissAnimation};
		
		    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
		    public TapTargetView(final Context context,
		                         final ViewManager parent,
		                          final ViewGroup boundingParent,
		                         final TapTarget target,
		                          final Listener userListener) {
				        super(context);
				        if (target == null) throw new IllegalArgumentException("Target cannot be null");
				
				        this.target = target;
				        this.parent = parent;
				        this.boundingParent = boundingParent;
				        this.listener = userListener != null ? userListener : new Listener();
				        this.title = target.title;
				        this.description = target.description;
				
				        TARGET_PADDING = UiUtil.dp(context, 20);
				        CIRCLE_PADDING = UiUtil.dp(context, 40);
				        TARGET_RADIUS = UiUtil.dp(context, target.targetRadius);
				        TEXT_PADDING = UiUtil.dp(context, 40);
				        TEXT_SPACING = UiUtil.dp(context, 8);
				        TEXT_MAX_WIDTH = UiUtil.dp(context, 360);
				        TEXT_POSITIONING_BIAS = UiUtil.dp(context, 20);
				        GUTTER_DIM = UiUtil.dp(context, 88);
				        SHADOW_DIM = UiUtil.dp(context, 8);
				        SHADOW_JITTER_DIM = UiUtil.dp(context, 1);
				        TARGET_PULSE_RADIUS = (int) (0.1f * TARGET_RADIUS);
				
				        outerCirclePath = new Path();
				        targetBounds = new Rect();
				        drawingBounds = new Rect();
				
				        titlePaint = new TextPaint();
				        titlePaint.setTextSize(target.titleTextSizePx(context));
				        titlePaint.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
				        titlePaint.setAntiAlias(true);
				
				        descriptionPaint = new TextPaint();
				        descriptionPaint.setTextSize(target.descriptionTextSizePx(context));
				        descriptionPaint.setTypeface(Typeface.create(Typeface.SANS_SERIF, Typeface.NORMAL));
				        descriptionPaint.setAntiAlias(true);
				        descriptionPaint.setAlpha((int) (0.54f * 255.0f));
				
				        outerCirclePaint = new Paint();
				        outerCirclePaint.setAntiAlias(true);
				        outerCirclePaint.setAlpha((int) (target.outerCircleAlpha * 255.0f));
				
				        outerCircleShadowPaint = new Paint();
				        outerCircleShadowPaint.setAntiAlias(true);
				        outerCircleShadowPaint.setAlpha(50);
				        outerCircleShadowPaint.setStyle(Paint.Style.STROKE);
				        outerCircleShadowPaint.setStrokeWidth(SHADOW_JITTER_DIM);
				        outerCircleShadowPaint.setColor(Color.BLACK);
				
				        targetCirclePaint = new Paint();
				        targetCirclePaint.setAntiAlias(true);
				
				        targetCirclePulsePaint = new Paint();
				        targetCirclePulsePaint.setAntiAlias(true);
				
				        applyTargetOptions(context);
				
				        globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
						            @Override
						            public void onGlobalLayout() {
								                if (isDismissing) {
										                    return;
										                }
								                updateTextLayouts();
								                target.onReady(new Runnable() {
										                    @Override
										                    public void run() {
												                        final int[] offset = new int[2];
												
												                        targetBounds.set(target.bounds());
												
												                        getLocationOnScreen(offset);
												                        targetBounds.offset(-offset[0], -offset[1]);
												
												                        if (boundingParent != null) {
														                            final WindowManager windowManager
														                                    = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
														                            final DisplayMetrics displayMetrics = new DisplayMetrics();
														                            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
														
														                            final Rect rect = new Rect();
														                            boundingParent.getWindowVisibleDisplayFrame(rect);
														
														                            // We bound the boundaries to be within the screen's coordinates to
														                            // handle the case where the layout bounds do not match
														                            // (like when FLAG_LAYOUT_NO_LIMITS is specified)
														                            topBoundary = Math.max(0, rect.top);
														                            bottomBoundary = Math.min(rect.bottom, displayMetrics.heightPixels);
														                        }
												
												                        drawTintedTarget();
												                        requestFocus();
												                        calculateDimensions();
												
												                        startExpandAnimation();
												                    }
										                });
								            }
						        };
				
				        getViewTreeObserver().addOnGlobalLayoutListener(globalLayoutListener);
				
				        setFocusableInTouchMode(true);
				        setClickable(true);
				        setOnClickListener(new OnClickListener() {
						            @Override
						            public void onClick(View v) {
								                if (listener == null || outerCircleCenter == null || !isInteractable) return;
								
								                final boolean clickedInTarget =
								                        distance(targetBounds.centerX(), targetBounds.centerY(), (int) lastTouchX, (int) lastTouchY) <= targetCircleRadius;
								                final double distanceToOuterCircleCenter = distance(outerCircleCenter[0], outerCircleCenter[1],
								                        (int) lastTouchX, (int) lastTouchY);
								                final boolean clickedInsideOfOuterCircle = distanceToOuterCircleCenter <= outerCircleRadius;
								
								                if (clickedInTarget) {
										                    isInteractable = false;
										                    listener.onTargetClick(TapTargetView.this);
										                } else if (clickedInsideOfOuterCircle) {
										                    listener.onOuterCircleClick(TapTargetView.this);
										                } else if (cancelable) {
										                    isInteractable = false;
										                    listener.onTargetCancel(TapTargetView.this);
										                }
								            }
						        });
				
				        setOnLongClickListener(new OnLongClickListener() {
						            @Override
						            public boolean onLongClick(View v) {
								                if (listener == null) return false;
								
								                if (targetBounds.contains((int) lastTouchX, (int) lastTouchY)) {
										                    listener.onTargetLongClick(TapTargetView.this);
										                    return true;
										                }
								
								                return false;
								            }
						        });
				    }
		
		    private void startExpandAnimation() {
				        if (!visible) {
						            isInteractable = false;
						            expandAnimation.start();
						            visible = true;
						        }
				    }
		
		    protected void applyTargetOptions(Context context) {
				        shouldTintTarget = target.tintTarget;
				        shouldDrawShadow = target.drawShadow;
				        cancelable = target.cancelable;
				
				        // We can't clip out portions of a view outline, so if the user specified a transparent
				        // target, we need to fallback to drawing a jittered shadow approximation
				        if (shouldDrawShadow && Build.VERSION.SDK_INT >= 21 && !target.transparentTarget) {
						            outlineProvider = new ViewOutlineProvider() {
								                @Override
								                public void getOutline(View view, Outline outline) {
										                    if (outerCircleCenter == null) return;
										                    outline.setOval(
										                            (int) (outerCircleCenter[0] - outerCircleRadius), (int) (outerCircleCenter[1] - outerCircleRadius),
										                            (int) (outerCircleCenter[0] + outerCircleRadius), (int) (outerCircleCenter[1] + outerCircleRadius));
										                    outline.setAlpha(outerCircleAlpha / 255.0f);
										                    if (Build.VERSION.SDK_INT >= 22) {
												                        outline.offset(0, SHADOW_DIM);
												                    }
										                }
								            };
						
						            setOutlineProvider(outlineProvider);
						            setElevation(SHADOW_DIM);
						        }
				
				        if (shouldDrawShadow && outlineProvider == null && Build.VERSION.SDK_INT < 18) {
						            setLayerType(LAYER_TYPE_SOFTWARE, null);
						        } else {
						            setLayerType(LAYER_TYPE_HARDWARE, null);
						        }
				
				        final android.content.res.Resources.Theme theme = context.getTheme();
				        isDark = UiUtil.themeIntAttr(context, "isLightTheme") == 0;
				
				        final Integer outerCircleColor = target.outerCircleColorInt(context);
				        if (outerCircleColor != null) {
						            outerCirclePaint.setColor(outerCircleColor);
						        } else if (theme != null) {
						            outerCirclePaint.setColor(UiUtil.themeIntAttr(context, "colorPrimary"));
						        } else {
						            outerCirclePaint.setColor(Color.WHITE);
						        }
				
				        final Integer targetCircleColor = target.targetCircleColorInt(context);
				        if (targetCircleColor != null) {
						            targetCirclePaint.setColor(targetCircleColor);
						        } else {
						            targetCirclePaint.setColor(isDark ? Color.BLACK : Color.WHITE);
						        }
				
				        if (target.transparentTarget) {
						            targetCirclePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
						        }
				
				        targetCirclePulsePaint.setColor(targetCirclePaint.getColor());
				
				        final Integer targetDimColor = target.dimColorInt(context);
				        if (targetDimColor != null) {
						            dimColor = UiUtil.setAlpha(targetDimColor, 0.3f);
						        } else {
						            dimColor = -1;
						        }
				
				        final Integer titleTextColor = target.titleTextColorInt(context);
				        if (titleTextColor != null) {
						            titlePaint.setColor(titleTextColor);
						        } else {
						            titlePaint.setColor(isDark ? Color.BLACK : Color.WHITE);
						        }
				
				        final Integer descriptionTextColor = target.descriptionTextColorInt(context);
				        if (descriptionTextColor != null) {
						            descriptionPaint.setColor(descriptionTextColor);
						        } else {
						            descriptionPaint.setColor(titlePaint.getColor());
						        }
				
				        if (target.titleTypeface != null) {
						            titlePaint.setTypeface(target.titleTypeface);
						        }
				
				        if (target.descriptionTypeface != null) {
						            descriptionPaint.setTypeface(target.descriptionTypeface);
						        }
				    }
		
		    @Override
		    protected void onDetachedFromWindow() {
				        super.onDetachedFromWindow();
				        onDismiss(false);
				    }
		
		    void onDismiss(boolean userInitiated) {
				        if (isDismissed) return;
				
				        isDismissing = false;
				        isDismissed = true;
				
				        for (final ValueAnimator animator : animators) {
						            animator.cancel();
						            animator.removeAllUpdateListeners();
						        }
				        ViewUtil.removeOnGlobalLayoutListener(getViewTreeObserver(), globalLayoutListener);
				        visible = false;
				
				        if (listener != null) {
						            listener.onTargetDismissed(this, userInitiated);
						        }
				    }
		
		    @Override
		    protected void onDraw(Canvas c) {
				        if (isDismissed || outerCircleCenter == null) return;
				
				        if (topBoundary > 0 && bottomBoundary > 0) {
						            c.clipRect(0, topBoundary, getWidth(), bottomBoundary);
						        }
				
				        if (dimColor != -1) {
						            c.drawColor(dimColor);
						        }
				
				        int saveCount;
				        outerCirclePaint.setAlpha(outerCircleAlpha);
				        if (shouldDrawShadow && outlineProvider == null) {
						            saveCount = c.save();
						            {
								                c.clipPath(outerCirclePath, Region.Op.DIFFERENCE);
								                drawJitteredShadow(c);
								            }
						            c.restoreToCount(saveCount);
						        }
				        c.drawCircle(outerCircleCenter[0], outerCircleCenter[1], outerCircleRadius, outerCirclePaint);
				
				        targetCirclePaint.setAlpha(targetCircleAlpha);
				        if (targetCirclePulseAlpha > 0) {
						            targetCirclePulsePaint.setAlpha(targetCirclePulseAlpha);
						            c.drawCircle(targetBounds.centerX(), targetBounds.centerY(),
						                    targetCirclePulseRadius, targetCirclePulsePaint);
						        }
				        c.drawCircle(targetBounds.centerX(), targetBounds.centerY(),
				                targetCircleRadius, targetCirclePaint);
				
				        saveCount = c.save();
				        {
						            c.translate(textBounds.left, textBounds.top);
						            titlePaint.setAlpha(textAlpha);
						            if (titleLayout != null) {
								                titleLayout.draw(c);
								            }
						
						            if (descriptionLayout != null && titleLayout != null) {
								                c.translate(0, titleLayout.getHeight() + TEXT_SPACING);
								                descriptionPaint.setAlpha((int) (target.descriptionTextAlpha * textAlpha));
								                descriptionLayout.draw(c);
								            }
						        }
				        c.restoreToCount(saveCount);
				
				        saveCount = c.save();
				        {
						            if (tintedTarget != null) {
								                c.translate(targetBounds.centerX() - tintedTarget.getWidth() / 2,
								                        targetBounds.centerY() - tintedTarget.getHeight() / 2);
								                c.drawBitmap(tintedTarget, 0, 0, targetCirclePaint);
								            } else if (target.icon != null) {
								                c.translate(targetBounds.centerX() - target.icon.getBounds().width() / 2,
								                        targetBounds.centerY() - target.icon.getBounds().height() / 2);
								                target.icon.setAlpha(targetCirclePaint.getAlpha());
								                target.icon.draw(c);
								            }
						        }
				        c.restoreToCount(saveCount);
				
				        if (debug) {
						            drawDebugInformation(c);
						        }
				    }
		
		    @Override
		    public boolean onTouchEvent(MotionEvent e) {
				        lastTouchX = e.getX();
				        lastTouchY = e.getY();
				        return super.onTouchEvent(e);
				    }
		
		    @Override
		    public boolean onKeyDown(int keyCode, KeyEvent event) {
				        if (isVisible() && cancelable && keyCode == KeyEvent.KEYCODE_BACK) {
						            event.startTracking();
						            return true;
						        }
				
				        return false;
				    }
		
		    @Override
		    public boolean onKeyUp(int keyCode, KeyEvent event) {
				        if (isVisible() && isInteractable && cancelable
				                && keyCode == KeyEvent.KEYCODE_BACK && event.isTracking() && !event.isCanceled()) {
						            isInteractable = false;
						
						            if (listener != null) {
								                listener.onTargetCancel(this);
								            } else {
								                new Listener().onTargetCancel(this);
								            }
						
						            return true;
						        }
				
				        return false;
				    }
		
		    /**
     * Dismiss this view
     * @param tappedTarget If the user tapped the target or not
     *                     (results in different dismiss animations)
     */
		    public void dismiss(boolean tappedTarget) {
				        isDismissing = true;
				        pulseAnimation.cancel();
				        expandAnimation.cancel();
				        if (tappedTarget) {
						            dismissConfirmAnimation.start();
						        } else {
						            dismissAnimation.start();
						        }
				    }
		
		    /** Specify whether to draw a wireframe around the view, useful for debugging **/
		    public void setDrawDebug(boolean status) {
				        if (debug != status) {
						            debug = status;
						            postInvalidate();
						        }
				    }
		
		    /** Returns whether this view is visible or not **/
		    public boolean isVisible() {
				        return !isDismissed && visible;
				    }
		
		    void drawJitteredShadow(Canvas c) {
				        final float baseAlpha = 0.20f * outerCircleAlpha;
				        outerCircleShadowPaint.setStyle(Paint.Style.FILL_AND_STROKE);
				        outerCircleShadowPaint.setAlpha((int) baseAlpha);
				        c.drawCircle(outerCircleCenter[0], outerCircleCenter[1] + SHADOW_DIM, outerCircleRadius, outerCircleShadowPaint);
				        outerCircleShadowPaint.setStyle(Paint.Style.STROKE);
				        final int numJitters = 7;
				        for (int i = numJitters - 1; i > 0; --i) {
						            outerCircleShadowPaint.setAlpha((int) ((i / (float) numJitters) * baseAlpha));
						            c.drawCircle(outerCircleCenter[0], outerCircleCenter[1] + SHADOW_DIM ,
						                    outerCircleRadius + (numJitters - i) * SHADOW_JITTER_DIM , outerCircleShadowPaint);
						        }
				    }
		
		    void drawDebugInformation(Canvas c) {
				        if (debugPaint == null) {
						            debugPaint = new Paint();
						            debugPaint.setARGB(255, 255, 0, 0);
						            debugPaint.setStyle(Paint.Style.STROKE);
						            debugPaint.setStrokeWidth(UiUtil.dp(getContext(), 1));
						        }
				
				        if (debugTextPaint == null) {
						            debugTextPaint = new TextPaint();
						            debugTextPaint.setColor(0xFFFF0000);
						            debugTextPaint.setTextSize(UiUtil.sp(getContext(), 16));
						        }
				
				        // Draw wireframe
				        debugPaint.setStyle(Paint.Style.STROKE);
				        c.drawRect(textBounds, debugPaint);
				        c.drawRect(targetBounds, debugPaint);
				        c.drawCircle(outerCircleCenter[0], outerCircleCenter[1], 10, debugPaint);
				        c.drawCircle(outerCircleCenter[0], outerCircleCenter[1], calculatedOuterCircleRadius - CIRCLE_PADDING, debugPaint);
				        c.drawCircle(targetBounds.centerX(), targetBounds.centerY(), TARGET_RADIUS + TARGET_PADDING, debugPaint);
				
				        // Draw positions and dimensions
				        debugPaint.setStyle(Paint.Style.FILL);
				        final String debugText =
				                "Text bounds: " + textBounds.toShortString() + "\n" + "Target bounds: " + targetBounds.toShortString() + "\n" + "Center: " + outerCircleCenter[0] + " " + outerCircleCenter[1] + "\n" + "View size: " + getWidth() + " " + getHeight() + "\n" + "Target bounds: " + targetBounds.toShortString();
				
				        if (debugStringBuilder == null) {
						            debugStringBuilder = new SpannableStringBuilder(debugText);
						        } else {
						            debugStringBuilder.clear();
						            debugStringBuilder.append(debugText);
						        }
				
				        if (debugLayout == null) {
						            debugLayout = new DynamicLayout(debugText, debugTextPaint, getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
						        }
				
				        final int saveCount = c.save();
				        {
						            debugPaint.setARGB(220, 0, 0, 0);
						            c.translate(0.0f, topBoundary);
						            c.drawRect(0.0f, 0.0f, debugLayout.getWidth(), debugLayout.getHeight(), debugPaint);
						            debugPaint.setARGB(255, 255, 0, 0);
						            debugLayout.draw(c);
						        }
				        c.restoreToCount(saveCount);
				    }
		
		    void drawTintedTarget() {
				        final android.graphics.drawable.Drawable icon = target.icon;
				        if (!shouldTintTarget || icon == null) {
						            tintedTarget = null;
						            return;
						        }
				
				        if (tintedTarget != null) return;
				
				        tintedTarget = Bitmap.createBitmap(icon.getIntrinsicWidth(), icon.getIntrinsicHeight(),
				                Bitmap.Config.ARGB_8888);
				        final Canvas canvas = new Canvas(tintedTarget);
				        icon.setColorFilter(new PorterDuffColorFilter(
				                outerCirclePaint.getColor(), PorterDuff.Mode.SRC_ATOP));
				        icon.draw(canvas);
				        icon.setColorFilter(null);
				    }
		
		    void updateTextLayouts() {
				        final int textWidth = Math.min(getWidth(), TEXT_MAX_WIDTH) - TEXT_PADDING * 2;
				        if (textWidth <= 0) {
						            return;
						        }
				
				        titleLayout = new StaticLayout(title, titlePaint, textWidth,
				                Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
				
				        if (description != null) {
						            descriptionLayout = new StaticLayout(description, descriptionPaint, textWidth,
						                    Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
						        } else {
						            descriptionLayout = null;
						        }
				    }
		
		    float halfwayLerp(float lerp) {
				        if (lerp < 0.5f) {
						            return lerp / 0.5f;
						        }
				
				        return (1.0f - lerp) / 0.5f;
				    }
		
		    float delayedLerp(float lerp, float threshold) {
				        if (lerp < threshold) {
						            return 0.0f;
						        }
				
				        return (lerp - threshold) / (1.0f - threshold);
				    }
		
		    void calculateDimensions() {
				        textBounds = getTextBounds();
				        outerCircleCenter = getOuterCircleCenterPoint();
				        calculatedOuterCircleRadius = getOuterCircleRadius(outerCircleCenter[0], outerCircleCenter[1], textBounds, targetBounds);
				    }
		
		    void calculateDrawingBounds() {
				        if (outerCircleCenter == null) {
						            // Called dismiss before we got a chance to display the tap target
						            // So we have no center -> cant determine the drawing bounds
						            return;
						        }
				        drawingBounds.left = (int) Math.max(0, outerCircleCenter[0] - outerCircleRadius);
				        drawingBounds.top = (int) Math.min(0, outerCircleCenter[1] - outerCircleRadius);
				        drawingBounds.right = (int) Math.min(getWidth(),
				                outerCircleCenter[0] + outerCircleRadius + CIRCLE_PADDING);
				        drawingBounds.bottom = (int) Math.min(getHeight(),
				                outerCircleCenter[1] + outerCircleRadius + CIRCLE_PADDING);
				    }
		
		    int getOuterCircleRadius(int centerX, int centerY, Rect textBounds, Rect targetBounds) {
				        final int targetCenterX = targetBounds.centerX();
				        final int targetCenterY = targetBounds.centerY();
				        final int expandedRadius = (int) (1.1f * TARGET_RADIUS);
				        final Rect expandedBounds = new Rect(targetCenterX, targetCenterY, targetCenterX, targetCenterY);
				        expandedBounds.inset(-expandedRadius, -expandedRadius);
				
				        final int textRadius = maxDistanceToPoints(centerX, centerY, textBounds);
				        final int targetRadius = maxDistanceToPoints(centerX, centerY, expandedBounds);
				        return Math.max(textRadius, targetRadius) + CIRCLE_PADDING;
				    }
		
		    Rect getTextBounds() {
				        final int totalTextHeight = getTotalTextHeight();
				        final int totalTextWidth = getTotalTextWidth();
				
				        final int possibleTop = targetBounds.centerY() - TARGET_RADIUS - TARGET_PADDING - totalTextHeight;
				        final int top;
				        if (possibleTop > topBoundary) {
						            top = possibleTop;
						        } else {
						            top = targetBounds.centerY() + TARGET_RADIUS + TARGET_PADDING;
						        }
				
				        final int relativeCenterDistance = (getWidth() / 2) - targetBounds.centerX();
				        final int bias = relativeCenterDistance < 0 ? -TEXT_POSITIONING_BIAS : TEXT_POSITIONING_BIAS;
				        final int left = Math.max(TEXT_PADDING, targetBounds.centerX() - bias - totalTextWidth);
				        final int right = Math.min(getWidth() - TEXT_PADDING, left + totalTextWidth);
				        return new Rect(left, top, right, top + totalTextHeight);
				    }
		
		    int[] getOuterCircleCenterPoint() {
				        if (inGutter(targetBounds.centerY())) {
						            return new int[]{targetBounds.centerX(), targetBounds.centerY()};
						        }
				
				        final int targetRadius = Math.max(targetBounds.width(), targetBounds.height()) / 2 + TARGET_PADDING;
				        final int totalTextHeight = getTotalTextHeight();
				
				        final boolean onTop = targetBounds.centerY() - TARGET_RADIUS - TARGET_PADDING - totalTextHeight > 0;
				
				        final int left = Math.min(textBounds.left, targetBounds.left - targetRadius);
				        final int right = Math.max(textBounds.right, targetBounds.right + targetRadius);
				        final int titleHeight = titleLayout == null ? 0 : titleLayout.getHeight();
				        final int centerY = onTop ?
				                targetBounds.centerY() - TARGET_RADIUS - TARGET_PADDING - totalTextHeight + titleHeight
				                :
				                targetBounds.centerY() + TARGET_RADIUS + TARGET_PADDING + titleHeight;
				
				        return new int[] { (left + right) / 2, centerY };
				    }
		
		    int getTotalTextHeight() {
				        if (titleLayout == null) {
						            return 0;
						        }
				
				        if (descriptionLayout == null) {
						            return titleLayout.getHeight() + TEXT_SPACING;
						        }
				
				        return titleLayout.getHeight() + descriptionLayout.getHeight() + TEXT_SPACING;
				    }
		
		    int getTotalTextWidth() {
				        if (titleLayout == null) {
						            return 0;
						        }
				
				        if (descriptionLayout == null) {
						            return titleLayout.getWidth();
						        }
				
				        return Math.max(titleLayout.getWidth(), descriptionLayout.getWidth());
				    }
		    boolean inGutter(int y) {
				        if (bottomBoundary > 0) {
						            return y < GUTTER_DIM || y > bottomBoundary - GUTTER_DIM;
						        } else {
						            return y < GUTTER_DIM || y > getHeight() - GUTTER_DIM;
						        }
				    }
		    int maxDistanceToPoints(int x1, int y1, Rect bounds) {
				        final double tl = distance(x1, y1, bounds.left, bounds.top);
				        final double tr = distance(x1, y1, bounds.right, bounds.top);
				        final double bl = distance(x1, y1, bounds.left, bounds.bottom);
				        final double br = distance(x1, y1, bounds.right, bounds.bottom);
				        return (int) Math.max(tl, Math.max(tr, Math.max(bl, br)));
				    }
		    double distance(int x1, int y1, int x2, int y2) {
				        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
				    }
		    void invalidateViewAndOutline(Rect bounds) {
				        invalidate(bounds);
				        if (outlineProvider != null && Build.VERSION.SDK_INT >= 21) {
						            invalidateOutline();
						        }
				    }
	}
	
	static class ViewUtil {
		
		    ViewUtil() {}
		
		    private static boolean isLaidOut(View view) {
				        return true;
				    }
		    static void onLaidOut(final View view, final Runnable runnable) {
				        if (isLaidOut(view)) {
						            runnable.run();
						            return;
						        }
				        final ViewTreeObserver observer = view.getViewTreeObserver();
				        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
						            @Override
						            public void onGlobalLayout() {
								                final ViewTreeObserver trueObserver;
								                if (observer.isAlive()) {
										                    trueObserver = observer;
										                } else {
										                    trueObserver = view.getViewTreeObserver();
										                }
								                removeOnGlobalLayoutListener(trueObserver, this);
								                runnable.run();
								            }
						        });
				    }
		    @SuppressWarnings("deprecation")
		    static void removeOnGlobalLayoutListener(ViewTreeObserver observer,
		                                             ViewTreeObserver.OnGlobalLayoutListener listener) {
				        if (Build.VERSION.SDK_INT >= 16) {
						            observer.removeOnGlobalLayoutListener(listener);
						        } else {
						            observer.removeGlobalOnLayoutListener(listener);
						        }
				    }
		    static void removeView(ViewManager parent, View child) {
				        if (parent == null || child == null) {
						            return;
						        }
				        try {
						            parent.removeView(child);
						        } catch (Exception ignored) {
						        }
				    }
	}
	
	static class ViewTapTarget extends TapTarget {
		    final View view;
		
		    ViewTapTarget(View view, CharSequence title,  CharSequence description) {
				        super(title, description);
				        if (view == null) {
						            throw new IllegalArgumentException("Given null view to target");
						        }
				        this.view = view;
				    }
		
		    @Override
		    public void onReady(final Runnable runnable) {
				        ViewUtil.onLaidOut(view, new Runnable() {
						            @Override
						            public void run() {
								                // Cache bounds
								                final int[] location = new int[2];
								                view.getLocationOnScreen(location);
								                bounds = new Rect(location[0], location[1],
								                        location[0] + view.getWidth(), location[1] + view.getHeight());
								
								                if (icon == null && view.getWidth() > 0 && view.getHeight() > 0) {
										                    final Bitmap viewBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
										                    final Canvas canvas = new Canvas(viewBitmap);
										                    view.draw(canvas);
										                    icon = new android.graphics.drawable.BitmapDrawable(view.getContext().getResources(), viewBitmap);
										                    icon.setBounds(0, 0, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
										                }
								
								                runnable.run();
								            }
						        });
				    }
	}
	
	
	public void _taptarget () {
		TapTargetView.showFor(HomeActivity.this,
		TapTarget.forView(circleimageview1, "Profile", "Click to view your profile and settings")
		.transparentTarget(true)
		.outerCircleColorInt(0xFF2196F3)
		.outerCircleAlpha((float) 1)
		.targetCircleColorInt(Color.TRANSPARENT)
		.textColorInt(0xFFFFFFFF)
		.titleTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_medium.ttf"))
		.descriptionTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_regular.ttf"))
		.titleTextSize(20)
		.descriptionTextSize(16)
		.titleTextAlpha((float) 1)
		.descriptionTextAlpha((float) 0.7d)
		.drawShadow(false)
		.cancelable(true)
		.tintTarget(true)
		.id((int) 1027)
		.targetRadius((int) 30),
		new TapTargetView.Listener() {
				@Override
				public void onTargetClick(TapTargetView view) {
					  	super.onTargetClick(view);
				}
				@Override
				public void onTargetLongClick(TapTargetView view) {
					  	 
				}
				@Override
				public void onTargetCancel(TapTargetView view) {
					  	super.onTargetClick(view);
				SketchwareUtil.showMessage(getApplicationContext(), "Menu target cancelled");
				}
				@Override
				public void onOuterCircleClick(TapTargetView view) {
					  	 
				}
				@Override
				public void onTargetDismissed(TapTargetView view, boolean userInitiated) {
				       TapTargetView.showFor(HomeActivity.this,
				TapTarget.forView(notification, "Notification", "Click notification icon to read update log")
				.transparentTarget(true)
				.outerCircleColorInt(0xFF2196F3)
				.outerCircleAlpha((float) 1)
				.targetCircleColorInt(Color.TRANSPARENT)
				.textColorInt(0xFFFFFFFF)
				.titleTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_medium.ttf"))
				.descriptionTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_regular.ttf"))
				.titleTextSize(20)
				.descriptionTextSize(16)
				.titleTextAlpha((float) 1)
				.descriptionTextAlpha((float) 0.7d)
				.drawShadow(false)
				.cancelable(true)
				.tintTarget(true)
				.id((int) 1028)
				.targetRadius((int) 30),
				new TapTargetView.Listener() {
						@Override
						public void onTargetClick(TapTargetView view) {
							  	super.onTargetClick(view);
						}
						@Override
						public void onTargetLongClick(TapTargetView view) {
							  	 
						}
						@Override
						public void onTargetCancel(TapTargetView view) {
							  	super.onTargetClick(view);
						SketchwareUtil.showMessage(getApplicationContext(), "Notification target cancelled");
						}
						@Override
						public void onOuterCircleClick(TapTargetView view) {
							  	 
						}
						@Override
						public void onTargetDismissed(TapTargetView view, boolean userInitiated) {
						       TapTargetView.showFor(HomeActivity.this,
						TapTarget.forView(search, "Menu", "Click menu icon to find other options")
						.transparentTarget(true)
						.outerCircleColorInt(0xFF2196F3)
						.outerCircleAlpha((float) 1)
						.targetCircleColorInt(Color.TRANSPARENT)
						.textColorInt(0xFFFFFFFF)
						.titleTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_medium.ttf"))
						.descriptionTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_regular.ttf"))
						.titleTextSize(20)
						.descriptionTextSize(16)
						.titleTextAlpha((float) 1)
						.descriptionTextAlpha((float) 0.7d)
						.drawShadow(false)
						.cancelable(true)
						.tintTarget(true)
						.id((int) 1029)
						.targetRadius((int) 30),
						new TapTargetView.Listener() {
								@Override
								public void onTargetClick(TapTargetView view) {
									  	super.onTargetClick(view);
								}
								@Override
								public void onTargetLongClick(TapTargetView view) {
									  	 
								}
								@Override
								public void onTargetCancel(TapTargetView view) {
									  	super.onTargetClick(view);
								SketchwareUtil.showMessage(getApplicationContext(), "Search target cancelled");
								}
								@Override
								public void onOuterCircleClick(TapTargetView view) {
									  	 
								}
								@Override
								public void onTargetDismissed(TapTargetView view, boolean userInitiated) {
								       TapTargetView.showFor(HomeActivity.this,
								TapTarget.forView(WaveProgressBar, "Learning Progress", "See and view details of your learning progress on the app!")
								.transparentTarget(true)
								.outerCircleColorInt(0xFF2196F3)
								.outerCircleAlpha((float) 1)
								.targetCircleColorInt(Color.TRANSPARENT)
								.textColorInt(0xFFFFFFFF)
								.titleTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_medium.ttf"))
								.descriptionTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_regular.ttf"))
								.titleTextSize(20)
								.descriptionTextSize(16)
								.titleTextAlpha((float) 1)
								.descriptionTextAlpha((float) 0.7d)
								.drawShadow(false)
								.cancelable(true)
								.tintTarget(true)
								.id((int) 1029)
								.targetRadius((int) 30),
								new TapTargetView.Listener() {
										@Override
										public void onTargetClick(TapTargetView view) {
											  	super.onTargetClick(view);
										}
										@Override
										public void onTargetDismissed(TapTargetView view, boolean userInitiated) {
										       SketchwareUtil.showMessage(getApplicationContext(), "Tutorial finished, thank you.");
										  }
								});
								  }
						});
						  }
				});
				  }
		});
	}
	
	
	public void _rippleRoundStroke (final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public void _Timeofday () {
		Calendar c = Calendar.getInstance();
		int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
		if (timeOfDay >= 0 && timeOfDay < 12) {
			  timeofday.setText("Good Morning 🌅");
			complementday.setText("Start your day with a headstart!");
		}
		if (timeOfDay >= 12 && timeOfDay < 16) {
			timeofday.setText("Good Afternoon ☀️");
			complementday.setText("You're a champion!");
		}
		if(timeOfDay >= 16 && timeOfDay < 20){
			timeofday.setText("Good Evening 🌆");
			complementday.setText("Hope you had a wonderful day?");
		}
		if (timeOfDay >= 20 && timeOfDay < 24) {
			timeofday.setText("Good Night 🌃");
			complementday.setText("Have a wonderful night rest!");
		}
		if (SketchwareUtil.isConnected(getApplicationContext())) {
			webview1.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
			webview1.loadUrl("https://www.facebook.com/plugins/page.php?href=https%3A%2F%2Fwww.facebook.com%2Ffutacommunity&tabs=timeline&width=340&height=500&small_header=false&adapt_container_width=true&hide_cover=false&show_facepile=true&appId=1756620554606188");
		}
		else {
			futafbpglayout.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					webview1.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
					webview1.loadUrl("https://www.facebook.com/plugins/page.php?href=https%3A%2F%2Fwww.facebook.com%2Ffutacommunity&tabs=timeline&width=340&height=500&small_header=false&adapt_container_width=true&hide_cover=false&show_facepile=true&appId=1756620554606188");
				}
			});
		}
		_rippleRoundStroke(linearai, "#673AB7", "#E0E0E0", 15, 0, "#000000");
		_mapview1_controller.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
		webview1.setEnabled(false);
		iq = new InterstitialAd(getApplicationContext());
		iq.setAdListener(_iq_ad_listener);
		iq.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
		iq.loadAd(new AdRequest.Builder().addTestDevice("0AA049AB4EB220E38785E314AF907584")
		.build());
		if (FirebaseAuth.getInstance().getCurrentUser().isEmailVerified()) {
			complprof.setVisibility(View.GONE);
		}
		else {
			complprof.setVisibility(View.VISIBLE);
		}
		adview2.loadAd(new AdRequest.Builder().addTestDevice("0AA049AB4EB220E38785E314AF907584")
		.build());
		adview1.loadAd(new AdRequest.Builder().addTestDevice("0AA049AB4EB220E38785E314AF907584")
		.build());
	}
	
	
	public void _ICC (final ImageView _img, final String _c1, final String _c2) {
		_img.setImageTintList(new android.content.res.ColorStateList(new int[][] {{-android.R.attr.state_pressed},{android.R.attr.state_pressed}},new int[]{Color.parseColor(_c1), Color.parseColor(_c2)}));
	}
	
	
	public void _CardViews () {
		cardview2.setRadius((float)15);
		cardview1.setRadius((float)15);
		cardview5.setRadius((float)15);
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
			circleimageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath("/storage/emulated/0/Android/data/com.varia.neny/.profileuploads/".concat(file.getString("lastsegmentpath", "")), 1024, 1024));
			if (file.getString("lastsegmentpath", "").equals("")) {
				circleimageview1.setImageResource(R.drawable.icon_user);
			}
		}catch(Exception e){
			SketchwareUtil.showMessage(getApplicationContext(), "Error");
		}
	}
	
	
	public void _ShimmerLibrary () {
		ShimmerFrameLayout container = (ShimmerFrameLayout) findViewById(R.id.linear39); container.startShimmer();
		linear39.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)15, 0xFFCFD8DC));
		ShimmerFrameLayout container4 = (ShimmerFrameLayout) findViewById(R.id.linear40); container4.startShimmer();
		linear40.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFCFD8DC));
		ShimmerFrameLayout container1 = (ShimmerFrameLayout) findViewById(R.id.linear41); container1.startShimmer();
		linear41.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFCFD8DC));
		ShimmerFrameLayout container2 = (ShimmerFrameLayout) findViewById(R.id.linear42); container2.startShimmer();
		linear42.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)15, 0xFFCFD8DC));
		ShimmerFrameLayout container3 = (ShimmerFrameLayout) findViewById(R.id.linear43); container3.startShimmer();
		linear43.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFCFD8DC));
		ShimmerFrameLayout container5 = (ShimmerFrameLayout) findViewById(R.id.linear45); container5.startShimmer();
		linear45.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFCFD8DC));
		ShimmerFrameLayout container6 = (ShimmerFrameLayout) findViewById(R.id.linear46); container6.startShimmer();
		linear46.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFCFD8DC));
		ShimmerFrameLayout container7 = (ShimmerFrameLayout) findViewById(R.id.linear47); container7.startShimmer();
		linear47.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFCFD8DC));
		ShimmerFrameLayout container8 = (ShimmerFrameLayout) findViewById(R.id.linear48); container8.startShimmer();
		linear48.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFCFD8DC));
		ShimmerFrameLayout container9 = (ShimmerFrameLayout) findViewById(R.id.linear49); container9.startShimmer();
		linear49.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFCFD8DC));
	}
	
	
	public void _extra () {
	}
	ValueEventListener data =new ValueEventListener(){
			@Override
			public void onDataChange(DataSnapshot _dataSnapshot) {
				//	recyclermap= new ArrayList<>();
					
			recyclermap.clear();
			try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
									HashMap<String, Object> _map = _data.getValue(_ind);
									
					recyclermap.add(_map);
				}
				progressbar2.setVisibility(View.GONE);
				recyclerview1.setAdapter(new Recyclerview1Adapter(recyclermap));
				recyclerview1.smoothScrollToPosition((int)itemcount);
				}
					catch (Exception _e) {
							_e.printStackTrace();
					}
					
			}
			@Override
			public void onCancelled(DatabaseError _databaseError) {
			}
	};{
	}
	
	
	public class Viewpager1Adapter extends PagerAdapter {
		Context _context;
		ArrayList<HashMap<String, Object>> _data;
		public Viewpager1Adapter(Context _ctx, ArrayList<HashMap<String, Object>> _arr) {
			_context = _ctx;
			_data = _arr;
		}
		
		public Viewpager1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_context = getApplicationContext();
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public boolean isViewFromObject(View _view, Object _object) {
			return _view == _object;
		}
		
		@Override
		public void destroyItem(ViewGroup _container, int _position, Object _object) {
			_container.removeView((View) _object);
		}
		
		@Override
		public int getItemPosition(Object _object) {
			return super.getItemPosition(_object);
		}
		
		@Override
		public CharSequence getPageTitle(int pos) {
			// use the activitiy event (onTabLayoutNewTabAdded) in order to use this method
			return "page " + String.valueOf(pos);
		}
		
		@Override
		public Object instantiateItem(ViewGroup _container,  final int _position) {
			View _view = LayoutInflater.from(_context).inflate(R.layout.slidd, _container, false);
			
			final androidx.cardview.widget.CardView cardview1 = (androidx.cardview.widget.CardView) _view.findViewById(R.id.cardview1);
			final ImageView imageview1 = (ImageView) _view.findViewById(R.id.imageview1);
			
			cardview1.setRadius((float)20);
			if (_position == 0) {
				imageview1.setImageResource(R.drawable.banner);
			}
			if (_position == 1) {
				imageview1.setImageResource(R.drawable.banner2);
			}
			if (_position == 2) {
				imageview1.setImageResource(R.drawable.banner3);
			}
			if (_position == 3) {
				imageview1.setImageResource(R.drawable.banner4);
			}
			if (_position == 4) {
				imageview1.setImageResource(R.drawable.banner5);
			}
			if (_position == 5) {
				imageview1.setImageResource(R.drawable.banner6);
			}
			
			_container.addView(_view);
			return _view;
		}
	}
	
	public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {
		ArrayList<HashMap<String, Object>> _data;
		public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _v = _inflater.inflate(R.layout.customrec, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final androidx.cardview.widget.CardView cardview1 = (androidx.cardview.widget.CardView) _view.findViewById(R.id.cardview1);
			final LinearLayout linear1 = (LinearLayout) _view.findViewById(R.id.linear1);
			final LinearLayout linear3 = (LinearLayout) _view.findViewById(R.id.linear3);
			final LinearLayout linear2 = (LinearLayout) _view.findViewById(R.id.linear2);
			final TextView textview3 = (TextView) _view.findViewById(R.id.textview3);
			final ImageView imageview1 = (ImageView) _view.findViewById(R.id.imageview1);
			final TextView textview2 = (TextView) _view.findViewById(R.id.textview2);
			final TextView textview1 = (TextView) _view.findViewById(R.id.textview1);
			
			textview2.setText(recyclermap.get((int)_position).get("videotitle").toString());
			textview1.setText(recyclermap.get((int)_position).get("videodescription").toString());
			Glide.with(getApplicationContext()).load(Uri.parse(recyclermap.get((int)_position).get("thumbnailURL").toString())).into(imageview1);
			cardview1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					i.setClass(getApplicationContext(), YoutubevideodownloadActivity.class);
					startActivity(i);
				}
			});
			if (recyclermap.get((int)_position).get("uploader").toString().equals("")) {
				
			}
			else {
				textview3.setText("Uploaded by: ".concat(recyclermap.get((int)_position).get("uploader").toString().concat(recyclermap.get((int)_position).get("time").toString())));
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
	
	public class Recyclerview2Adapter extends RecyclerView.Adapter<Recyclerview2Adapter.ViewHolder> {
		ArrayList<HashMap<String, Object>> _data;
		public Recyclerview2Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _v = _inflater.inflate(R.layout.pdfcustomview, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final androidx.cardview.widget.CardView cardview1 = (androidx.cardview.widget.CardView) _view.findViewById(R.id.cardview1);
			final LinearLayout linear6 = (LinearLayout) _view.findViewById(R.id.linear6);
			final LinearLayout linear1 = (LinearLayout) _view.findViewById(R.id.linear1);
			final LinearLayout linear3 = (LinearLayout) _view.findViewById(R.id.linear3);
			final ImageView imageview1 = (ImageView) _view.findViewById(R.id.imageview1);
			final LinearLayout linear2 = (LinearLayout) _view.findViewById(R.id.linear2);
			final TextView PDFtitle = (TextView) _view.findViewById(R.id.PDFtitle);
			final TextView departments = (TextView) _view.findViewById(R.id.departments);
			final LinearLayout levellinear7 = (LinearLayout) _view.findViewById(R.id.levellinear7);
			final TextView level = (TextView) _view.findViewById(R.id.level);
			final LinearLayout downloadshowlayout = (LinearLayout) _view.findViewById(R.id.downloadshowlayout);
			final ImageView download = (ImageView) _view.findViewById(R.id.download);
			final LinearLayout linear4 = (LinearLayout) _view.findViewById(R.id.linear4);
			final ProgressBar progressbar1 = (ProgressBar) _view.findViewById(R.id.progressbar1);
			final TextView progress = (TextView) _view.findViewById(R.id.progress);
			final TextView downloadesc = (TextView) _view.findViewById(R.id.downloadesc);
			
			linear3.setVisibility(View.GONE);
			cardview1.setRadius((float)15);
			cardview1.setCardBackgroundColor(0xFFF5F5F5);
			PDFtitle.setText(recyclermap2.get((int)_position).get("pdfname").toString());
			departments.setText(recyclermap2.get((int)_position).get("pdfdepartment").toString().concat(", ".concat(recyclermap2.get((int)_position).get("pdffaculty").toString())));
			level.setText(recyclermap2.get((int)_position).get("pdflevel").toString());
			imageview1.setImageResource(R.drawable.hidisk_icon_pdf);
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
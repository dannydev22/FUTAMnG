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
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.CheckBox;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.app.Activity;
import android.content.SharedPreferences;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import android.view.View;
import android.widget.CompoundButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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

public class YoutubevideouploadActivity extends AppCompatActivity {
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String str = "";
	private HashMap<String, Object> mm = new HashMap<>();
	private String thumbnailurl = "";
	private HashMap<String, Object> mapp = new HashMap<>();
	
	private LinearLayout linear;
	private ScrollView vscroll1;
	private TextView textview1;
	private LinearLayout linear2;
	private CardView cardview1;
	private ShimmerFrameLayout linear7;
	private TextView textview2;
	private EditText email;
	private LinearLayout generate;
	private TextView textview3;
	private EditText title;
	private LinearLayout linear6;
	private TextView textview4;
	private EditText description;
	private LinearLayout linear3;
	private FrameLayout linear1;
	private LinearLayout upload;
	private ImageView imageview1;
	private TextView textview6;
	private TextView textview7;
	private TextView videoid;
	private CheckBox checkbox1;
	private TextView textview5;
	
	private RequestNetwork h;
	private RequestNetwork.RequestListener _h_request_listener;
	private DatabaseReference fdb = _firebase.getReference("FUTAMnG/UserVideos");
	private ChildEventListener _fdb_child_listener;
	private SharedPreferences sharedpref;
	
	private OnCompleteListener fcm_onCompleteListener;
	private Notification notification;
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
	private DatabaseReference database = _firebase.getReference("FUTAMnG/Userdetails");
	private ChildEventListener _database_child_listener;
	private Calendar cal = Calendar.getInstance();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.youtubevideoupload);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear = (LinearLayout) findViewById(R.id.linear);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		textview1 = (TextView) findViewById(R.id.textview1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		cardview1 = (CardView) findViewById(R.id.cardview1);
		linear7 = (ShimmerFrameLayout) findViewById(R.id.linear7);
		textview2 = (TextView) findViewById(R.id.textview2);
		email = (EditText) findViewById(R.id.email);
		generate = (LinearLayout) findViewById(R.id.generate);
		textview3 = (TextView) findViewById(R.id.textview3);
		title = (EditText) findViewById(R.id.title);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		textview4 = (TextView) findViewById(R.id.textview4);
		description = (EditText) findViewById(R.id.description);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear1 = (FrameLayout) findViewById(R.id.linear1);
		upload = (LinearLayout) findViewById(R.id.upload);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview6 = (TextView) findViewById(R.id.textview6);
		textview7 = (TextView) findViewById(R.id.textview7);
		videoid = (TextView) findViewById(R.id.videoid);
		checkbox1 = (CheckBox) findViewById(R.id.checkbox1);
		textview5 = (TextView) findViewById(R.id.textview5);
		h = new RequestNetwork(this);
		sharedpref = getSharedPreferences("Usernames", Activity.MODE_PRIVATE);
		auth = FirebaseAuth.getInstance();
		
		generate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!((email.getText().toString().contains("http://youtu.be/") || email.getText().toString().contains("https://youtu.be/")) || (email.getText().toString().contains("www.youtube.com") || email.getText().toString().contains("https://yout.ube")))) {
					((EditText)email).setError("Please Enter Video Url! ");
					SketchwareUtil.showMessage(getApplicationContext(), "Enter a valid YouTube video Link");
				}
				else {
					if (email.getText().toString().equals("")) {
						((EditText)email).setError("Please Enter Video Url! ");
					}
					else {
						if (email.getText().toString().length() > 1) {
							_setVideoIdFromLink(email.getText().toString(), videoid);
							Glide.with(getApplicationContext()).load(Uri.parse("https://img.youtube.com/vi/".concat(videoid.getText().toString().concat("/maxresdefault.jpg")))).into(imageview1);
							thumbnailurl = "https://img.youtube.com/vi/".concat(videoid.getText().toString().concat("/maxresdefault.jpg"));
							try{
								h.startRequestNetwork(RequestNetworkController.GET, email.getText().toString(), "", _h_request_listener);
							}catch(Exception e){
								SketchwareUtil.showMessage(getApplicationContext(), "ERROR :- ".concat(e.getMessage()));
							}
							if (videoid.getText().toString().length() > 4) {
								
							}
							else {
								SketchwareUtil.showMessage(getApplicationContext(), "No id found");
							}
						}
						else {
							SketchwareUtil.showMessage(getApplicationContext(), "Please type any link and then continue");
						}
					}
				}
			}
		});
		
		upload.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (title.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Please Generate Video Details");
				}
				else {
					cal = Calendar.getInstance();
					mapp.put("videotitle", title.getText().toString().trim());
					mapp.put("videodescription", description.getText().toString().trim());
					mapp.put("thumbnailURL", thumbnailurl);
					mapp.put("videoID", videoid.getText().toString());
					mapp.put("uploader", FirebaseAuth.getInstance().getCurrentUser().getEmail());
					mapp.put("time", new SimpleDateFormat("hh : mm dd / MM / YY").format(cal.getTime()));
					fdb.push().updateChildren(mapp);
					mapp.clear();
					email.setText("");
					description.setText("");
					videoid.setText("Loading...");
				}
			}
		});
		
		checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					checkbox1.setChecked(true);
				}
				else {
					checkbox1.setChecked(false);
				}
			}
		});
		
		_h_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				try{
					title.setText(_response.substring((int)(_response.indexOf("<title>") + 7), (int)(_response.indexOf("</title>"))));
					str = _response.substring((int)(_response.indexOf("\"description\":")), (int)(_response.lastIndexOf(",\"lengthSeconds\":")));
					str = str.replaceFirst("\"description\":", "");
					mm = new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>(){}.getType());
					description.setText(mm.get("simpleText").toString());
					cardview1.setVisibility(View.VISIBLE);
					linear7.setVisibility(View.GONE);
				}catch(Exception e){
					SketchwareUtil.showMessage(getApplicationContext(), "ERROR :- ".concat(e.getMessage()));
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_fdb_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.get("videotitle").toString().equals(title.getText().toString())) {
					int notifyId = 004;
					   
					androidx.core.app.NotificationCompat.BigTextStyle btStyle = new androidx.core.app.NotificationCompat.BigTextStyle(); 
					
					btStyle.bigText("New video added. click to view");
					
					Intent intent = new Intent(YoutubevideouploadActivity.this, YoutubevideodownloadActivity.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
					PendingIntent pendingIntent = PendingIntent.getActivity(YoutubevideouploadActivity.this, 0, intent, 0);
					
					     androidx.core.app.NotificationCompat.Builder mBuilder = new androidx.core.app.NotificationCompat.Builder(YoutubevideouploadActivity.this,"id 2") 
					                .setSmallIcon(R.drawable.notification_icon) 
					                .setContentTitle("Tutorial Update")        
					                  .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.notification_icon))
					                 .setStyle(btStyle)
					.setContentIntent(pendingIntent)
					                 .setContentText("New video added. click to view"); 
					 
					        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE); 
					
					       
					            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { 
							            String channelId2 = "2"; 
							            String channelName2 = "Notifications"; 
							 
							            NotificationChannel channel = new NotificationChannel(channelId2, channelName2, NotificationManager.IMPORTANCE_MAX); 
							 
							            channel.enableLights(true); 
							            channel.setLightColor(Color.RED); 
							            channel.setShowBadge(true); 
							            channel.enableVibration(false); 
							 
							            mBuilder.setChannelId(channelId2); 
							 
							            if (notificationManager != null) { 
									                notificationManager.createNotificationChannel(channel); 
							}
							        } else { 
							         mBuilder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS); 
							        } 
					 
					        if (notificationManager != null) { 
							            notificationManager.notify(notifyId, mBuilder.build()); 
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
				if (_childKey.equals("Tutorials")) {
					if (_childValue.get("videotitle").toString().equals(title.getText().toString())) {
						int notifyId = 004;
						   
						androidx.core.app.NotificationCompat.BigTextStyle btStyle = new androidx.core.app.NotificationCompat.BigTextStyle(); 
						
						btStyle.bigText("New video added. click to view");
						
						Intent intent = new Intent(YoutubevideouploadActivity.this, YoutubevideodownloadActivity.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
						PendingIntent pendingIntent = PendingIntent.getActivity(YoutubevideouploadActivity.this, 0, intent, 0);
						
						     androidx.core.app.NotificationCompat.Builder mBuilder = new androidx.core.app.NotificationCompat.Builder(YoutubevideouploadActivity.this,"id 2") 
						                .setSmallIcon(R.drawable.notification_icon) 
						                .setContentTitle("New Update!")        
						                  .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.notification_icon))
						                 .setStyle(btStyle)
						.setContentIntent(pendingIntent)
						                 .setContentText("New video added. click to view"); 
						 
						        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE); 
						
						       
						            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { 
								            String channelId2 = "2"; 
								            String channelName2 = "Notifications"; 
								 
								            NotificationChannel channel = new NotificationChannel(channelId2, channelName2, NotificationManager.IMPORTANCE_MAX); 
								 
								            channel.enableLights(true); 
								            channel.setLightColor(Color.RED); 
								            channel.setShowBadge(true); 
								            channel.enableVibration(false); 
								 
								            mBuilder.setChannelId(channelId2); 
								 
								            if (notificationManager != null) { 
										                notificationManager.createNotificationChannel(channel); 
								}
								        } else { 
								         mBuilder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS); 
								        } 
						 
						        if (notificationManager != null) { 
								            notificationManager.notify(notifyId, mBuilder.build()); 
								        } 
						 
					}
					else {
						
					}
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), _childKey);
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
		fdb.addChildEventListener(_fdb_child_listener);
		
		fcm_onCompleteListener = new OnCompleteListener<InstanceIdResult>() {
			@Override
			public void onComplete(Task<InstanceIdResult> task) {
				final boolean _success = task.isSuccessful();
				final String _token = task.getResult().getToken();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_database_child_listener = new ChildEventListener() {
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
		database.addChildEventListener(_database_child_listener);
		
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
		email.setSingleLine(true);
		_rippleRoundStroke(generate, "#673AB7", "#E0E0E0", 20, 0, "#000000");
		_rippleRoundStroke(upload, "#673AB7", "#E0E0E0", 20, 0, "#000000");
		title.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)15, 0xFFE0E0E0));
		email.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)15, 0xFFE0E0E0));
		description.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)15, 0xFFE0E0E0));
		_removeScollBar(vscroll1);
		_LoadNativeAd();
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
				CharSequence name = "Cloud Notifications";
				String description = "VideoMessages";
				int importance = NotificationManager.IMPORTANCE_HIGH;
				NotificationChannel channel = new NotificationChannel("id 1", name, importance);
				channel.setDescription(description);
				
				NotificationManager notificationManager = getSystemService(NotificationManager.class);
				notificationManager.createNotificationChannel(channel);
				
		}
		ShimmerFrameLayout container = (ShimmerFrameLayout) findViewById(R.id.linear7); container.startShimmer();
		linear7.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)15, 0xFFCFD8DC));
		cardview1.setVisibility(View.GONE);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _setVideoIdFromLink (final String _link, final TextView _textview) {
		String videoId = "";
		String regex = "http(?:s)?:\\/\\/(?:m.)?(?:www\\.)?youtu(?:\\.be\\/|be\\.com\\/(?:watch\\?(?:feature=youtu.be\\&)?v=|v\\/|embed\\/|user\\/(?:[\\w#]+\\/)+))([^&#?\\n]+)";
		java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex, java.util.regex.Pattern.CASE_INSENSITIVE);
		java.util.regex.Matcher matcher = pattern.matcher(_link);
		if(matcher.find()){
				videoId = matcher.group(1);
		}
		_textview.setText(videoId);
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
	
	
	public void _removeScollBar (final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
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
	
	
	public void _LoadNativeAd () {
		AdLoader.Builder builder = new AdLoader.Builder(YoutubevideouploadActivity.this, "ca-app-pub-8081781380472232/8284217808");
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
				_GradientDrawable(linear1, 20, 0, 10, "#FFFFFF", "#EEEEEE", false, false, 300);
				linear1.removeAllViews();
				linear1.addView(adView);
			}
		}).build();
		NativeAdOptions adOptions = new NativeAdOptions.Builder().build();
		builder.withNativeAdOptions(adOptions);
		AdLoader adLoader = builder.withAdListener(new AdListener() {
			 public void onAdFailedToLoad(int i) {
				SketchwareUtil.showMessage(getApplicationContext(), "loding error");
			}
		}).build();
		
		adLoader.loadAd(new AdRequest.Builder().build());
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
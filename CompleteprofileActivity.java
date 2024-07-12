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
import android.widget.TextView;
import android.widget.SeekBar;
import android.widget.ScrollView;
import android.widget.EditText;
import de.hdodenhof.circleimageview.*;
import android.widget.ProgressBar;
import android.widget.ImageView;
import android.content.Intent;
import android.content.ClipData;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.os.Bundle;
import java.io.InputStream;
import android.net.Uri;
import java.util.Timer;
import java.util.TimerTask;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.firebase.storage.OnProgressListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Continuation;
import java.io.File;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
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
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import com.google.android.material.slider.Slider;
import com.google.android.material.slider.RangeSlider;

public class CompleteprofileActivity extends AppCompatActivity {
	public final int REQ_CD_FP = 101;
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private String fontName = "";
	private String typeace = "";
	private HashMap<String, Object> ussrmap = new HashMap<>();
	private String filepath = "";
	private HashMap<String, Object> prflmap = new HashMap<>();
	private String childvalue = "";
	private String success = "";
	private String googleurl = "";
	
	private ArrayList<HashMap<String, Object>> listmapt = new ArrayList<>();
	
	private LinearLayout linear3;
	private LinearLayout linear13;
	private LinearLayout linear1;
	private TextView textview1;
	private TextView textview10;
	private SeekBar seekbar2;
	private ScrollView vscroll1;
	private LinearLayout linear2;
	private LinearLayout prflinear;
	private TextView textview14;
	private EditText email;
	private TextView textview13;
	private EditText fullname;
	private TextView error1;
	private LinearLayout linear11;
	private TextView textview4;
	private EditText matricno;
	private TextView error2;
	private LinearLayout linear5;
	private TextView textview5;
	private EditText faculty;
	private TextView error3;
	private LinearLayout linear6;
	private TextView textview6;
	private EditText department;
	private TextView error4;
	private LinearLayout linear7;
	private TextView textview7;
	private TextView wordcount;
	private EditText bio;
	private LinearLayout linear12;
	private LinearLayout linear8;
	private TextView textview8;
	private EditText level;
	private TextView error6;
	private LinearLayout linear10;
	private TextView textview9;
	private EditText politics;
	private LinearLayout linear9;
	private LinearLayout linear14;
	private CircleImageView circleimageview1;
	private ProgressBar progressbar1;
	private TextView textview2;
	private TextView textview3;
	private TextView error5;
	private LinearLayout linear16;
	private TextView textview12;
	private ImageView imageview1;
	private LinearLayout linear15;
	private TextView textview15;
	
	private Intent fp = new Intent(Intent.ACTION_GET_CONTENT);
	private Calendar cal = Calendar.getInstance();
	private RequestNetwork req;
	private RequestNetwork.RequestListener _req_request_listener;
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
	private TimerTask t;
	private DatabaseReference fdblop = _firebase.getReference("FUTAMnG/Userdetails");
	private ChildEventListener _fdblop_child_listener;
	private StorageReference firestore = _firebase_storage.getReference("FUTAMnG/Userimage");
	private OnCompleteListener<Uri> _firestore_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _firestore_download_success_listener;
	private OnSuccessListener _firestore_delete_success_listener;
	private OnProgressListener _firestore_upload_progress_listener;
	private OnProgressListener _firestore_download_progress_listener;
	private OnFailureListener _firestore_failure_listener;
	private TimerTask tre;
	private SharedPreferences file;
	private SharedPreferences profile;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.completeprofile);
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
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview10 = (TextView) findViewById(R.id.textview10);
		seekbar2 = (SeekBar) findViewById(R.id.seekbar2);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		prflinear = (LinearLayout) findViewById(R.id.prflinear);
		textview14 = (TextView) findViewById(R.id.textview14);
		email = (EditText) findViewById(R.id.email);
		textview13 = (TextView) findViewById(R.id.textview13);
		fullname = (EditText) findViewById(R.id.fullname);
		error1 = (TextView) findViewById(R.id.error1);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		textview4 = (TextView) findViewById(R.id.textview4);
		matricno = (EditText) findViewById(R.id.matricno);
		error2 = (TextView) findViewById(R.id.error2);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		textview5 = (TextView) findViewById(R.id.textview5);
		faculty = (EditText) findViewById(R.id.faculty);
		error3 = (TextView) findViewById(R.id.error3);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		textview6 = (TextView) findViewById(R.id.textview6);
		department = (EditText) findViewById(R.id.department);
		error4 = (TextView) findViewById(R.id.error4);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		textview7 = (TextView) findViewById(R.id.textview7);
		wordcount = (TextView) findViewById(R.id.wordcount);
		bio = (EditText) findViewById(R.id.bio);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		textview8 = (TextView) findViewById(R.id.textview8);
		level = (EditText) findViewById(R.id.level);
		error6 = (TextView) findViewById(R.id.error6);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		textview9 = (TextView) findViewById(R.id.textview9);
		politics = (EditText) findViewById(R.id.politics);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		circleimageview1 = (CircleImageView) findViewById(R.id.circleimageview1);
		progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview3 = (TextView) findViewById(R.id.textview3);
		error5 = (TextView) findViewById(R.id.error5);
		linear16 = (LinearLayout) findViewById(R.id.linear16);
		textview12 = (TextView) findViewById(R.id.textview12);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		textview15 = (TextView) findViewById(R.id.textview15);
		fp.setType("image/*");
		fp.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		req = new RequestNetwork(this);
		auth = FirebaseAuth.getInstance();
		file = getSharedPreferences("lastsegmentpath", Activity.MODE_PRIVATE);
		profile = getSharedPreferences("Preferred", Activity.MODE_PRIVATE);
		
		circleimageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(fp, REQ_CD_FP);
			}
		});
		
		linear16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (SketchwareUtil.isConnected(getApplicationContext())) {
					if (fullname.getText().toString().equals("")) {
						error1.setVisibility(View.VISIBLE);
					}
					else {
						if (matricno.getText().toString().equals("")) {
							error2.setVisibility(View.VISIBLE);
						}
						else {
							if (faculty.getText().toString().equals("")) {
								error3.setVisibility(View.VISIBLE);
							}
							else {
								if (department.getText().toString().equals("")) {
									error4.setVisibility(View.VISIBLE);
								}
								else {
									if (bio.getText().toString().equals("")) {
										error5.setVisibility(View.VISIBLE);
									}
									else {
										if (level.getText().toString().equals("")) {
											error6.setVisibility(View.VISIBLE);
										}
										else {
											_BottomSheetDialog();
											ussrmap = new HashMap<>();
											ussrmap.put("level", level.getText().toString().trim());
											ussrmap.put("department", department.getText().toString().trim());
											ussrmap.put("name", fullname.getText().toString().trim());
											ussrmap.put("faculty", faculty.getText().toString().trim().toUpperCase());
											ussrmap.put("matricno", matricno.getText().toString().trim());
											ussrmap.put("bio", bio.getText().toString().trim());
											ussrmap.put("profileurl", profile.getString("prfurl", ""));
											fdblop.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(ussrmap);
											ussrmap.clear();
										}
									}
								}
							}
						}
					}
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "No Internet Connection");
				}
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
		
		_fdblop_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					if (_childValue.get("profileurl").toString().equals("")) {
						
					}
					else {
						if (_childValue.get("matricno").toString().equals("")) {
							
						}
						else {
							if (_childValue.get("name").toString().equals("")) {
								
							}
							else {
								if (_childValue.get("level").toString().concat(" ".concat(_childValue.get("department").toString()).concat(", ".concat(_childValue.get("faculty").toString()))).equals("")) {
									
								}
								else {
									success = "successful";
									Intent CompleteprofileActivityintent = new Intent(CompleteprofileActivity.this, VerifyemailActivity.class);
									CompleteprofileActivityintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
									PendingIntent pendingIntent = PendingIntent.getActivity(CompleteprofileActivity.this, 0, CompleteprofileActivityintent, 0);
									
									androidx.core.app.NotificationCompat.Builder builder = new androidx.core.app.NotificationCompat.Builder(CompleteprofileActivity.this, "id 1")
									.setSmallIcon(R.drawable.notification_icon)
									.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
									.setContentTitle("Welcome 🤗")
									.setContentText("You have successfully created your account 🥳")
									.setPriority(androidx.core.app.NotificationCompat.PRIORITY_MAX)
									.setContentIntent(pendingIntent)
									.setAutoCancel(true);
									
									androidx.core.app.NotificationManagerCompat notificationManager = androidx.core.app.NotificationManagerCompat.from(CompleteprofileActivity.this);
									notificationManager.notify(1, builder.build());
								}
							}
						}
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
				SketchwareUtil.showMessage(getApplicationContext(), _errorMessage.concat(". error code: ".concat(String.valueOf((long)(_errorCode)))));
			}
		};
		fdblop.addChildEventListener(_fdblop_child_listener);
		
		_firestore_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				SketchwareUtil.showMessage(getApplicationContext(), "Uploading Image. Please Wait");
			}
		};
		
		_firestore_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_firestore_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				Glide.with(getApplicationContext()).load(Uri.parse(_downloadUrl)).into(circleimageview1);
				progressbar1.setVisibility(View.INVISIBLE);
				SketchwareUtil.showMessage(getApplicationContext(), "Successfully Uploaded!");
				if (_downloadUrl.equals("")) {
					
				}
				else {
					profile.edit().putString("prfurl", _downloadUrl).commit();
				}
			}
		};
		
		_firestore_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_firestore_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				SketchwareUtil.showMessage(getApplicationContext(), "Deleted");
			}
		};
		
		_firestore_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				SketchwareUtil.showMessage(getApplicationContext(), _message);
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
		_removeScollBar(vscroll1);
		bio.setFilters(new InputFilter[]{new InputFilter.LengthFilter((int) 250)});
		progressbar1.setVisibility(View.INVISIBLE);
		error1.setVisibility(View.INVISIBLE);
		error3.setVisibility(View.INVISIBLE);
		error2.setVisibility(View.INVISIBLE);
		error4.setVisibility(View.INVISIBLE);
		error5.setVisibility(View.INVISIBLE);
		error6.setVisibility(View.INVISIBLE);
		matricno.setSingleLine(true);
		fullname.setSingleLine(true);
		faculty.setSingleLine(true);
		department.setSingleLine(true);
		level.setSingleLine(true);
		politics.setSingleLine(true);
		seekbar2.setEnabled(false);
		email.setEnabled(false);
		email.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
		linear16.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)0, 0xFF673AB7, 0xFF673AB7));
		fullname.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)1, 0xFF673AB7, 0xFFFFFFFF));
		matricno.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)1, 0xFF673AB7, 0xFFFFFFFF));
		faculty.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)1, 0xFF673AB7, 0xFFFFFFFF));
		department.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)1, 0xFF673AB7, 0xFFFFFFFF));
		email.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)1, 0xFF673AB7, 0xFFFFFFFF));
		level.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)1, 0xFF673AB7, 0xFFFFFFFF));
		politics.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)1, 0xFF673AB7, 0xFFFFFFFF));
		prflinear.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)2, 0xFF673AB7, 0xFFFFFFFF));
		bio.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)1, 0xFF673AB7, 0xFFFFFFFF));
		bio.setRawInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
		department.setRawInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
		level.setRawInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
		fullname.setRawInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
		try{
			if (FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl().toString().equals("")) {
				
			}
			else {
				googleurl = FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl().toString();
				profile.edit().putString("prfurl", FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl().toString()).commit();
				Glide.with(getApplicationContext()).load(Uri.parse(FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl().toString())).into(circleimageview1);
			}
		}catch(Exception e){
			 
		}
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			case REQ_CD_FP:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				filepath = _filePath.get((int)(0));
				progressbar1.setVisibility(View.VISIBLE);
				if (SketchwareUtil.isConnected(getApplicationContext())) {
					firestore.child(email.getText().toString().concat("'s dp")).putFile(Uri.fromFile(new File(filepath))).addOnFailureListener(_firestore_failure_listener).addOnProgressListener(_firestore_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
						@Override
						public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
							return firestore.child(email.getText().toString().concat("'s dp")).getDownloadUrl();
						}}).addOnCompleteListener(_firestore_upload_success_listener);
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Internet needed for upload!");
				}
				file.edit().putString("lastsegmentpath", Uri.parse(_filePath.get((int)(0))).getLastPathSegment()).commit();
				try{
					FileUtil.copyFile(_filePath.get((int)(0)), "/storage/emulated/0/Android/data/com.varia.neny/.profileuploads/".concat(Uri.parse(_filePath.get((int)(0))).getLastPathSegment()));
				}catch(Exception e){
					SketchwareUtil.showMessage(getApplicationContext(), "Error");
				}
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	public void _removeScollBar (final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
	}
	
	
	public void _BottomSheetDialog () {
		final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(CompleteprofileActivity.this);
		
		View bottomSheetView; bottomSheetView = getLayoutInflater().inflate(R.layout.custom,null );
		bottomSheetDialog.setContentView(bottomSheetView);
		
		bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);
		LinearLayout linear1 = (LinearLayout) bottomSheetView.findViewById(R.id.linear1);
		
		TextView textview1 = (TextView)bottomSheetView.findViewById(R.id.textview1);
		
		linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)54, 0xFFECEFF1));
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gbemiga.ttf"), 0);
		textview1.setText("Creating your profile...please wait");
		bottomSheetDialog.setCancelable(false);
		bottomSheetDialog.show();
		tre = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (success.equals("successful")) {
							bottomSheetDialog.dismiss();
							i.setClass(getApplicationContext(), VerifyemailActivity.class);
							startActivity(i);
							tre.cancel();
						}
						else {
							
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(tre, (int)(000), (int)(300));
	}
	
	
	public void _Pick_Department_Dialog (final String _Title, final String _Text) {
		final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(CompleteprofileActivity.this);
		
		View bottomSheetView; bottomSheetView = getLayoutInflater().inflate(R.layout.material_dialog,null );
		bottomSheetDialog.setContentView(bottomSheetView);
		
		bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);
		TextView t1 = (TextView) bottomSheetView.findViewById(R.id.t1);
		
		TextView t2 = (TextView) bottomSheetView.findViewById(R.id.t2);
		
		TextView title = (TextView) bottomSheetView.findViewById(R.id.title);
		
		TextView t3 = (TextView) bottomSheetView.findViewById(R.id.t3);
		
		TextView t4 = (TextView) bottomSheetView.findViewById(R.id.t4);
		
		TextView t5 = (TextView) bottomSheetView.findViewById(R.id.t5);
		
		TextView t6 = (TextView) bottomSheetView.findViewById(R.id.t6);
		
		TextView t7 = (TextView) bottomSheetView.findViewById(R.id.t7);
		
		TextView t8 = (TextView) bottomSheetView.findViewById(R.id.t8);
		
		TextView t9 = (TextView) bottomSheetView.findViewById(R.id.t9);
		
		LinearLayout bg = (LinearLayout) bottomSheetView.findViewById(R.id.bg);
		
		LinearLayout horiz = (LinearLayout) bottomSheetView.findViewById(R.id.horiz);
		title.setText(_Title);
		t1.setText(_Text);
		t2.setText("SBMS");
		t3.setText("SLIT");
		t4.setText("SOC");
		t5.setText("SAAT");
		t6.setText("SPS");
		t7.setText("SEET");
		t8.setText("SET");
		t9.setText("SEMS");
		_rippleRoundStroke(bg, "#FFFFFF", "#FFFFFF", 15, 0, "#FFFFFF");
		_rippleRoundStroke(t1, "#FFFFFF", "#FF2196F3", 15, 1, "#FF2196F3");
		_rippleRoundStroke(t2, "#FFFFFF", "#FF2196F3", 15, 1, "#FF2196F3");
		_rippleRoundStroke(t3, "#FFFFFF", "#FF2196F3", 15, 1, "#FF2196F3");
		_rippleRoundStroke(t4, "#FFFFFF", "#FF2196F3", 15, 1, "#FF2196F3");
		_rippleRoundStroke(t5, "#FFFFFF", "#FF2196F3", 15, 1, "#FF2196F3");
		_rippleRoundStroke(t6, "#FFFFFF", "#FF2196F3", 15, 1, "#FF2196F3");
		_rippleRoundStroke(t7, "#FFFFFF", "#FF2196F3", 15, 1, "#FF2196F3");
		_rippleRoundStroke(t8, "#FFFFFF", "#FF2196F3", 15, 1, "#FF2196F3");
		_rippleRoundStroke(t9, "#FFFFFF", "#FF2196F3", 15, 1, "#FF2196F3");
		_rippleRoundStroke(title, "#FFFFFF", "#FF2196F3", 15, 1, "#FF2196F3");
		bottomSheetDialog.setCancelable(true);
		bottomSheetDialog.show();
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
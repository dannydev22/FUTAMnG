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
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import de.hdodenhof.circleimageview.*;
import android.widget.ProgressBar;
import android.widget.EditText;
import java.util.Timer;
import java.util.TimerTask;
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
import android.content.ClipData;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.OnProgressListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Continuation;
import java.io.File;
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


public class EditprofileActivity extends AppCompatActivity {
	public final int REQ_CD_FP = 101;
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private String success = "";
	private HashMap<String, Object> ussrmap = new HashMap<>();
	private HashMap<String, Object> all_months = new HashMap<>();
	private boolean isDOBChoosed = false;
	
	private LinearLayout linear1;
	private ScrollView vscroll1;
	private ImageView imageview2;
	private TextView textview1;
	private ImageView imageview3;
	private LinearLayout linear2;
	private CardView cardview1;
	private LinearLayout linear4;
	private LinearLayout linear3;
	private LinearLayout prflinear;
	private CircleImageView circleimageview1;
	private ProgressBar progressbar1;
	private TextView textview2;
	private TextView textview3;
	private TextView textview14;
	private EditText email;
	private TextView textview13;
	private EditText fullname;
	private LinearLayout linear11;
	private TextView textview4;
	private EditText matricno;
	private LinearLayout linear5;
	private TextView textview5;
	private EditText faculty;
	private LinearLayout linear6;
	private TextView textview6;
	private EditText department;
	private LinearLayout linear7;
	private TextView textview7;
	private TextView wordcount;
	private EditText bio;
	private LinearLayout linear12;
	private LinearLayout linear8;
	private TextView textview8;
	private EditText level;
	private LinearLayout linear10;
	private TextView textview9;
	private LinearLayout dob_wrapper;
	private LinearLayout linear14;
	private LinearLayout date_field;
	private LinearLayout month_field;
	private LinearLayout year_field;
	private TextView date_text;
	private LinearLayout date_base;
	private TextView month_text;
	private LinearLayout month_base;
	private TextView year_text;
	private LinearLayout year_base;
	private ImageView imageview4;
	private LinearLayout linear15;
	private TextView textview15;
	
	private TimerTask t;
	private DatabaseReference fdblop = _firebase.getReference("FUTAMnG/Userdetails");
	private ChildEventListener _fdblop_child_listener;
	private TimerTask i;
	private Intent intent = new Intent();
	private Intent fp = new Intent(Intent.ACTION_GET_CONTENT);
	private StorageReference storage = _firebase_storage.getReference("FUTAMnG/Userimage");
	private OnCompleteListener<Uri> _storage_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _storage_download_success_listener;
	private OnSuccessListener _storage_delete_success_listener;
	private OnProgressListener _storage_upload_progress_listener;
	private OnProgressListener _storage_download_progress_listener;
	private OnFailureListener _storage_failure_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.editprofile);
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
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		textview1 = (TextView) findViewById(R.id.textview1);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		cardview1 = (CardView) findViewById(R.id.cardview1);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		prflinear = (LinearLayout) findViewById(R.id.prflinear);
		circleimageview1 = (CircleImageView) findViewById(R.id.circleimageview1);
		progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview14 = (TextView) findViewById(R.id.textview14);
		email = (EditText) findViewById(R.id.email);
		textview13 = (TextView) findViewById(R.id.textview13);
		fullname = (EditText) findViewById(R.id.fullname);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		textview4 = (TextView) findViewById(R.id.textview4);
		matricno = (EditText) findViewById(R.id.matricno);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		textview5 = (TextView) findViewById(R.id.textview5);
		faculty = (EditText) findViewById(R.id.faculty);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		textview6 = (TextView) findViewById(R.id.textview6);
		department = (EditText) findViewById(R.id.department);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		textview7 = (TextView) findViewById(R.id.textview7);
		wordcount = (TextView) findViewById(R.id.wordcount);
		bio = (EditText) findViewById(R.id.bio);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		textview8 = (TextView) findViewById(R.id.textview8);
		level = (EditText) findViewById(R.id.level);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		textview9 = (TextView) findViewById(R.id.textview9);
		dob_wrapper = (LinearLayout) findViewById(R.id.dob_wrapper);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		date_field = (LinearLayout) findViewById(R.id.date_field);
		month_field = (LinearLayout) findViewById(R.id.month_field);
		year_field = (LinearLayout) findViewById(R.id.year_field);
		date_text = (TextView) findViewById(R.id.date_text);
		date_base = (LinearLayout) findViewById(R.id.date_base);
		month_text = (TextView) findViewById(R.id.month_text);
		month_base = (LinearLayout) findViewById(R.id.month_base);
		year_text = (TextView) findViewById(R.id.year_text);
		year_base = (LinearLayout) findViewById(R.id.year_base);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		textview15 = (TextView) findViewById(R.id.textview15);
		fp.setType("image/*");
		fp.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (SketchwareUtil.isConnected(getApplicationContext())) {
					ussrmap = new HashMap<>();
					if (fullname.getText().toString().equals("")) {
						
					}
					else {
						ussrmap.put("name", fullname.getText().toString().trim());
						if (matricno.getText().toString().equals("")) {
							
						}
						else {
							ussrmap.put("matricno", matricno.getText().toString().trim());
							if (faculty.getText().toString().equals("")) {
								
							}
							else {
								ussrmap.put("faculty", faculty.getText().toString().trim());
								if (department.getText().toString().equals("")) {
									
								}
								else {
									ussrmap.put("department", department.getText().toString().trim());
									if (bio.getText().toString().equals("")) {
										
									}
									else {
										ussrmap.put("bio", bio.getText().toString().trim());
										if (level.getText().toString().equals("")) {
											
										}
										else {
											ussrmap.put("level", level.getText().toString().trim());
											_BottomSheetDialog();
											fdblop.child("").updateChildren(ussrmap);
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
		
		circleimageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(fp, REQ_CD_FP);
			}
		});
		
		date_text.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_datePicker(date_text, month_text, year_text);
			}
		});
		
		month_text.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_datePicker(date_text, month_text, year_text);
			}
		});
		
		year_text.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_datePicker(date_text, month_text, year_text);
			}
		});
		
		_fdblop_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("")) {
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
				
			}
		};
		fdblop.addChildEventListener(_fdblop_child_listener);
		
		_storage_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_storage_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_storage_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				
			}
		};
		
		_storage_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_storage_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_storage_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
	}
	
	private void initializeLogic() {
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
		_ICC(imageview3, "#673AB7", "#E0E0E0");
		bio.setRawInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
		department.setRawInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
		level.setRawInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
		fullname.setRawInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
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
	
	
	public void _BottomSheetDialog () {
		final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(EditprofileActivity.this);
		
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
							t.cancel();
							intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
							intent.setClass(getApplicationContext(), HomeActivity.class);
							startActivity(intent);
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(t, (int)(0), (int)(3000));
	}
	
	
	public void _datePicker (final TextView _day, final TextView _mon, final TextView _year) {
		in_tv_dateDay = _day;
		in_tv_dateMon = _mon;
		in_tv_dateYear = _year;
		showDatePickerDialog();
	}
	
	private TextView in_tv_dateDay;
	private TextView in_tv_dateMon;
	private TextView in_tv_dateYear;
	
	public void showDatePickerDialog() {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int mon = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		
		DatePickerDialog mDP;
		mDP = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
			@Override
			public void onDateSet(DatePicker datePicker, int year, int month, int day) {
				int mon = month + 1;
				isDOBChoosed = true;
				in_tv_dateDay.setText(String.format("%02d",day));
				in_tv_dateMon.setText(all_months.get(String.format("%02d",mon)).toString());
				in_tv_dateYear.setText(String.format("%04d",year));
			}
		}, year, mon, day);
		
		mDP.setTitle("Date");
		mDP.show();
	}
	
	
	public void _add_months () {
		all_months = new HashMap<>();
		all_months.put("01", "January");
		all_months.put("02", "February");
		all_months.put("03", "March");
		all_months.put("04", "April");
		all_months.put("05", "May");
		all_months.put("06", "June");
		all_months.put("07", "July");
		all_months.put("08", "August");
		all_months.put("09", "September");
		all_months.put("10", "October");
		all_months.put("11", "November");
		all_months.put("12", "December");
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
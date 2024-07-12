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
import android.widget.EditText;
import androidx.cardview.widget.CardView;
import com.google.android.material.chip.*;
import android.widget.ProgressBar;
import com.airbnb.lottie.*;
import android.content.Intent;
import android.content.ClipData;
import android.os.Bundle;
import java.io.InputStream;
import android.net.Uri;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import com.github.angads25.filepicker.controller.DialogSelectionListener ;
import com.github.angads25.filepicker.model.DialogConfigs;
import com.github.angads25.filepicker.model.DialogProperties;
import com.github.angads25.filepicker.view.FilePickerDialog;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdListener;
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
import com.google.android.material.chip.Chip; import com.google.android.material.chip.ChipGroup;

public class UploadPdfActivity extends AppCompatActivity {
	public final int REQ_CD_FILE = 101;
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private String fontName = "";
	private String typeace = "";
	private String filepath = "";
	private String text = "";
	private String checkedText = "";
	private double setChecked = 0;
	private HashMap<String, Object> map = new HashMap<>();
	private String url = "";
	private String copiedfp = "";
	
	private ArrayList<String> str = new ArrayList<>();
	
	private LinearLayout linear;
	private ScrollView vscroll1;
	private TextView textview15;
	private TextView textview16;
	private LinearLayout linear2;
	private LinearLayout pdffilepicklayout;
	private TextView pdfname;
	private TextView textview4;
	private EditText edittext2;
	private TextView textview5;
	private ChipGroup linear37;
	private TextView textview6;
	private EditText email;
	private TextView textview7;
	private EditText edittext3;
	private LinearLayout linear45;
	private LinearLayout linear3;
	private CardView cardview1;
	private LinearLayout linear4;
	private TextView pdffilepicktext;
	private Chip linear38;
	private Chip linear40;
	private Chip linear39;
	private Chip linear44;
	private Chip linear43;
	private TextView textview21;
	private ProgressBar progressbar1;
	private TextView textview14;
	private LinearLayout linear6;
	private TextView textview18;
	private LinearLayout linear7;
	private LinearLayout linear9;
	private LinearLayout linear8;
	private TextView textview19;
	private LottieAnimationView lottie1;
	private TextView textview20;
	private FrameLayout linear1;
	
	private Intent file = new Intent(Intent.ACTION_GET_CONTENT);
	private Intent intent = new Intent();
	private DatabaseReference database = _firebase.getReference("FUTAMnG/UserPDFs");
	private ChildEventListener _database_child_listener;
	private FilePickerDialog FilePickerDialogu;
	private InterstitialAd ia;
	private AdListener _ia_ad_listener;
	private StorageReference storage = _firebase_storage.getReference("FUTAMnG/UserPdfs");
	private OnCompleteListener<Uri> _storage_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _storage_download_success_listener;
	private OnSuccessListener _storage_delete_success_listener;
	private OnProgressListener _storage_upload_progress_listener;
	private OnProgressListener _storage_download_progress_listener;
	private OnFailureListener _storage_failure_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.upload_pdf);
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
		linear = (LinearLayout) findViewById(R.id.linear);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		textview15 = (TextView) findViewById(R.id.textview15);
		textview16 = (TextView) findViewById(R.id.textview16);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		pdffilepicklayout = (LinearLayout) findViewById(R.id.pdffilepicklayout);
		pdfname = (TextView) findViewById(R.id.pdfname);
		textview4 = (TextView) findViewById(R.id.textview4);
		edittext2 = (EditText) findViewById(R.id.edittext2);
		textview5 = (TextView) findViewById(R.id.textview5);
		linear37 = (ChipGroup) findViewById(R.id.linear37);
		textview6 = (TextView) findViewById(R.id.textview6);
		email = (EditText) findViewById(R.id.email);
		textview7 = (TextView) findViewById(R.id.textview7);
		edittext3 = (EditText) findViewById(R.id.edittext3);
		linear45 = (LinearLayout) findViewById(R.id.linear45);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		cardview1 = (CardView) findViewById(R.id.cardview1);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		pdffilepicktext = (TextView) findViewById(R.id.pdffilepicktext);
		linear38 = (Chip) findViewById(R.id.linear38);
		linear40 = (Chip) findViewById(R.id.linear40);
		linear39 = (Chip) findViewById(R.id.linear39);
		linear44 = (Chip) findViewById(R.id.linear44);
		linear43 = (Chip) findViewById(R.id.linear43);
		textview21 = (TextView) findViewById(R.id.textview21);
		progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
		textview14 = (TextView) findViewById(R.id.textview14);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		textview18 = (TextView) findViewById(R.id.textview18);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		textview19 = (TextView) findViewById(R.id.textview19);
		lottie1 = (LottieAnimationView) findViewById(R.id.lottie1);
		textview20 = (TextView) findViewById(R.id.textview20);
		linear1 = (FrameLayout) findViewById(R.id.linear1);
		file.setType("*/*");
		file.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		
		linear3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ia.show();
				if (checkedText.equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Please select level option");
				}
				else {
					if (edittext2.getText().toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "Please enter document name");
					}
					else {
						if (email.getText().toString().equals("")) {
							SketchwareUtil.showMessage(getApplicationContext(), "Please select department");
						}
						else {
							if (edittext3.getText().toString().equals("")) {
								SketchwareUtil.showMessage(getApplicationContext(), "Please select faculty");
							}
							else {
								SketchwareUtil.showMessage(getApplicationContext(), "Uploading...");
								storage.child(edittext2.getText().toString()).putFile(Uri.fromFile(new File(filepath))).addOnFailureListener(_storage_failure_listener).addOnProgressListener(_storage_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
									@Override
									public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
										return storage.child(edittext2.getText().toString()).getDownloadUrl();
									}}).addOnCompleteListener(_storage_upload_success_listener);
							}
						}
					}
				}
			}
		});
		
		pdffilepicktext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				DialogProperties FilePickerDialogup = new DialogProperties();
				FilePickerDialogup.selection_mode = DialogConfigs.SINGLE_MODE;
				FilePickerDialogup.selection_type = DialogConfigs.FILE_SELECT;
				FilePickerDialogup.root = new java.io.File(FileUtil.getExternalStorageDir());
				FilePickerDialogup.error_dir = new java.io.File(FileUtil.getExternalStorageDir());
				FilePickerDialogup.offset = new java.io.File(FileUtil.getExternalStorageDir());
				FilePickerDialogup.extensions = null;
				FilePickerDialogu = new FilePickerDialog(UploadPdfActivity.this,FilePickerDialogup);
				FilePickerDialogu.setTitle("Select A Document");
				FilePickerDialogu.setDialogSelectionListener(new DialogSelectionListener() {
					@Override public void onSelectedFilePaths(String[] files) {
						edittext2.setText(Uri.parse(Arrays.asList(files).get((int) 0).toString()).getLastPathSegment());
						filepath = Arrays.asList(files).get((int) 0).toString();
						FileUtil.copyFile(Arrays.asList(files).get((int) 0).toString(), copiedfp);
					} 
				});
				FilePickerDialogu.setPositiveBtnName("SELECT");
				FilePickerDialogu.setNegativeBtnName("CANCEL");
				FilePickerDialogu.show();
			}
		});
		
		linear38.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				setChecked++;
				if (setChecked == 1) {
					checkedText = linear38.getText().toString();
					setChecked = 0;
				}
				else {
					checkedText = "";
					setChecked = 0;
				}
			}
		});
		
		linear40.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				setChecked++;
				if (setChecked == 1) {
					checkedText = linear40.getText().toString();
					setChecked = 0;
				}
				else {
					checkedText = "";
					setChecked = 0;
				}
			}
		});
		
		linear39.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				setChecked++;
				if (setChecked == 1) {
					checkedText = linear39.getText().toString();
					setChecked = 0;
				}
				else {
					checkedText = "";
					setChecked = 0;
				}
			}
		});
		
		linear44.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				setChecked++;
				if (setChecked == 1) {
					checkedText = linear44.getText().toString();
					setChecked = 0;
				}
				else {
					checkedText = "";
					setChecked = 0;
				}
			}
		});
		
		linear43.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				setChecked++;
				if (setChecked == 1) {
					checkedText = linear43.getText().toString();
					setChecked = 0;
				}
				else {
					checkedText = "";
					setChecked = 0;
				}
			}
		});
		
		linear8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), YoutubevideouploadActivity.class);
				startActivity(intent);
			}
		});
		
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
		
		_storage_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				linear45.setVisibility(View.VISIBLE);
				textview21.setText("Uploading: ".concat(String.valueOf((long)(_progressValue)).concat("%")));
				progressbar1.setProgress((int)_progressValue);
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
				map = new HashMap<>();
				map.put("pdfurl", _downloadUrl);
				map.put("pdffaculty", edittext3.getText().toString());
				map.put("pdfname", edittext2.getText().toString());
				map.put("pdfdepartment", email.getText().toString());
				map.put("pdflevel", checkedText);
				database.push().updateChildren(map);
				map.clear();
				SketchwareUtil.showMessage(getApplicationContext(), "Upload Complete");
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
				SketchwareUtil.showMessage(getApplicationContext(), _message);
			}
		};
		
		_ia_ad_listener = new AdListener() {
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
				ia = new InterstitialAd(getApplicationContext());
				ia.setAdListener(_ia_ad_listener);
				ia.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
				ia.loadAd(new AdRequest.Builder().addTestDevice("0AA049AB4EB220E38785E314AF907584")
				.build());
			}
		};
	}
	
	private void initializeLogic() {
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
		
		FileUtil.makeDir("/storage/emulated/0/Android/data/com.varia.neny/.pdfs".concat("/"));
		_rippleRoundStroke(linear3, "#673AB7", "#E0E0E0", 15, 0, "#000000");
		_rippleRoundStroke(linear8, "#673AB7", "#E0E0E0", 15, 0, "#000000");
		_LoadNativeAd();
		_Chip_View();
		linear45.setVisibility(View.GONE);
		pdffilepicklayout.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFF2D5FF));
		edittext2.setRawInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
		email.setRawInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
		edittext3.setRawInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
		copiedfp = "/storage/emulated/0/Android/data/com.varia.neny/.pdfs".concat("/");
		ia = new InterstitialAd(getApplicationContext());
		ia.setAdListener(_ia_ad_listener);
		ia.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
		ia.loadAd(new AdRequest.Builder().addTestDevice("0AA049AB4EB220E38785E314AF907584")
		.build());
		_removeScollBar(vscroll1);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			case REQ_CD_FILE:
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
				pdfname.setText(filepath);
				FileUtil.copyFile(_filePath.get((int)(0)), copiedfp);
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	
	@Override
	public void onStart() {
		super.onStart();
		linear45.setVisibility(View.GONE);
	}
	public void _dotsProgress (final View _view, final String _color1, final String _color2, final double _count, final double _size, final double _scale, final double _growth, final double _spacing) {
		bar = new DilatingDotsProgressBar(this);
		bar.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.WRAP_CONTENT, android.widget.LinearLayout.LayoutParams.WRAP_CONTENT));
		/*dots size here*/
		bar.setDotRadius((float)_size);
		/* dots color here*/
		bar.setDotColors(Color.parseColor(_color2), Color.parseColor(_color2));
		/*total dots here*/
		bar.setNumberOfDots((int)_count);
		bar.setDotScaleMultiplier((float)_scale);
		/*Set animation speed here*/
		bar.setGrowthSpeed((int)_growth);
		/* dot spacing between dots here*/
		bar.setDotSpacing((float)_spacing);
		((LinearLayout)_view).removeAllViews();
		((LinearLayout)_view).addView(bar, 0);
		if (bar == null) {
			
		}
	}
	DilatingDotsProgressBar bar;
	
	public static class DilatingDotDrawable extends android.graphics.drawable.Drawable {
		    private static final String TAG = DilatingDotDrawable.class.getSimpleName();
		    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		    private float radius;
		    private float maxRadius;
		    final Rect mDirtyBounds = new Rect(0, 0, 0, 0);
		
		    public DilatingDotDrawable(final int color, final float radius, final float maxRadius) {
			        mPaint.setColor(color);
			        mPaint.setStyle(Paint.Style.FILL);
			        mPaint.setStrokeCap(Paint.Cap.ROUND);
			        mPaint.setStrokeJoin(Paint.Join.ROUND);
			
			        this.radius = radius;
			        setMaxRadius(maxRadius);
			    }
		
		    @Override
		    public void draw(Canvas canvas) {
			        final Rect bounds = getBounds();
			        canvas.drawCircle(bounds.centerX(), bounds.centerY(), radius - 1, mPaint);
			    }
		
		    @Override
		    public void setAlpha(int alpha) {
			        if (alpha != mPaint.getAlpha()) {
				            mPaint.setAlpha(alpha);
				            invalidateSelf();
				        }
			    }
		
		    @Override
		    public void setColorFilter(ColorFilter colorFilter) {
			        mPaint.setColorFilter(colorFilter);
			        invalidateSelf();
			    }
		
		    @Override
		    public int getOpacity() {
			        return PixelFormat.TRANSLUCENT;
			    }
		
		    public void setColor(int color) {
			        mPaint.setColor(color);
			        invalidateSelf();
			    }
		
		    public void setRadius(float radius) {
			        this.radius = radius;
			        invalidateSelf();
			    }
		
		    public float getRadius() {
			        return radius;
			    }
		
		    @Override
		    public int getIntrinsicWidth() {
			        return (int) (maxRadius * 2) + 2;
			    }
		
		    @Override
		    public int getIntrinsicHeight() {
			        return (int) (maxRadius * 2) + 2;
			    }
		
		    public void setMaxRadius(final float maxRadius) {
			        this.maxRadius = maxRadius;
			        mDirtyBounds.bottom = (int) (maxRadius * 2) + 2;
			        mDirtyBounds.right = (int) (maxRadius * 2) + 2;
			    }
		
		    @Override
		    public Rect getDirtyBounds() {
			        return mDirtyBounds;
			    }
		
		    @Override
		    protected void onBoundsChange(final Rect bounds) {
			        super.onBoundsChange(bounds);
			        mDirtyBounds.offsetTo(bounds.left, bounds.top);
			    }
	}
	
	
	public static class DilatingDotsProgressBar extends View {
		    public static final String TAG = DilatingDotsProgressBar.class.getSimpleName();
		    public static final double START_DELAY_FACTOR = 0.35;
		    private static final float DEFAULT_GROWTH_MULTIPLIER = 1.75f;
		    private static final int MIN_SHOW_TIME = 500; // ms
		    private static final int MIN_DELAY = 500; // ms
		    private int mDotColor;
		    private int mDotEndColor;
		    private int mAnimationDuration;
		    private int mWidthBetweenDotCenters;
		    private int mNumberDots;
		    private float mDotRadius;
		    private float mDotScaleMultiplier;
		    private float mDotMaxRadius;
		    private float mHorizontalSpacing;
		    private long mStartTime = -1;
		    private boolean mShouldAnimate;
		    private boolean mDismissed = false;
		    private boolean mIsRunning = false;
		    private boolean mAnimateColors = false;
		    private ArrayList<DilatingDotDrawable> mDrawables = new ArrayList<>();
		    private final List<android.animation.Animator> mAnimations = new ArrayList<>();
		    /** delayed runnable to stop the progress */
		    private final Runnable mDelayedHide = new Runnable() {
			        @Override
			        public void run() {
				            mStartTime = -1;
				            mIsRunning = false;
				            setVisibility(View.GONE);
				            stopAnimations();
				        }
			    };
		
		    /** delayed runnable to start the progress */
		    private final Runnable mDelayedShow = new Runnable() {
			        @Override
			        public void run() {
				            if (!mDismissed) {
					                mStartTime = System.currentTimeMillis();
					                setVisibility(View.VISIBLE);
					                startAnimations();
					            }
				        }
			    };
		
		    public DilatingDotsProgressBar(Context context) {
			        this(context, null);
			    }
		
		    public DilatingDotsProgressBar(Context context, AttributeSet attrs) {
			        this(context, attrs, 0);
			    }
		
		    public DilatingDotsProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
			        super(context, attrs, defStyleAttr);
			        init(attrs);
			    }
		
		    private void init(AttributeSet attrs) {
			        //TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.DilatingDotsProgressBar);
			        //mNumberDots = a.getInt(R.styleable.DilatingDotsProgressBar_dd_numDots, 3);
			        //mDotRadius = a.getDimension(R.styleable.DilatingDotsProgressBar_android_radius, 8);
			        //mDotColor = a.getColor(R.styleable.DilatingDotsProgressBar_android_color, 0xff9c27b0);
			        //mDotEndColor = a.getColor(R.styleable.DilatingDotsProgressBar_dd_endColor, mDotColor);
			        //mDotScaleMultiplier = a.getFloat(R.styleable.DilatingDotsProgressBar_dd_scaleMultiplier, DEFAULT_GROWTH_MULTIPLIER);
			        //mAnimationDuration = a.getInt(R.styleable.DilatingDotsProgressBar_dd_animationDuration, 300);
			        //mHorizontalSpacing = a.getDimension(R.styleable.DilatingDotsProgressBar_dd_horizontalSpacing, 12);
			        //a.recycle();
			
			
			        mNumberDots = 3;
			        mDotRadius = 8;
			        mDotColor = Color.RED;
			        mDotEndColor = mDotColor;
			        mDotScaleMultiplier = DEFAULT_GROWTH_MULTIPLIER;
			        mAnimationDuration = 300;
			        mHorizontalSpacing = 12;
			
			
			
			        mShouldAnimate = false;
			        mAnimateColors = mDotColor != mDotEndColor;
			        calculateMaxRadius();
			        calculateWidthBetweenDotCenters();
			
			        initDots();
			        updateDots();
			    }
		
		    @Override
		    protected void onSizeChanged(final int w, final int h, final int oldw, final int oldh) {
			        super.onSizeChanged(w, h, oldw, oldh);
			        if (computeMaxHeight() != h || w != computeMaxWidth()) {
				            updateDots();
				        }
			    }
		
		    @Override
		    public void onDetachedFromWindow() {
			        super.onDetachedFromWindow();
			        removeCallbacks();
			    }
		
		    private void removeCallbacks() {
			        removeCallbacks(mDelayedHide);
			        removeCallbacks(mDelayedShow);
			    }
		
		    public void reset() {
			        hideNow();
			    }
		
		    @SuppressWarnings ("unused")
		    public void hide() {
			        hide(MIN_SHOW_TIME);
			    }
		
		    public void hide(int delay) {
			        mDismissed = true;
			        removeCallbacks(mDelayedShow);
			        long diff = System.currentTimeMillis() - mStartTime;
			        if ((diff >= delay) || (mStartTime == -1)) {
				            mDelayedHide.run();
				        } else {
				            if ((delay - diff) <= 0) {
					                mDelayedHide.run();
					            } else {
					                postDelayed(mDelayedHide, delay - diff);
					            }
				        }
			    }
		
		    @SuppressWarnings("unused")
		    public void show() {
			        show(MIN_DELAY);
			    }
		
		    @SuppressWarnings("unused")
		    public void showNow() {
			        show(0);
			    }
		
		    @SuppressWarnings("unused")
		    public void hideNow() {
			        hide(0);
			    }
		
		    public void show(int delay) {
			        if (mIsRunning) {
				            return;
				        }
			
			        mIsRunning = true;
			
			        mStartTime = -1;
			        mDismissed = false;
			        removeCallbacks(mDelayedHide);
			
			        if (delay == 0) {
				            mDelayedShow.run();
				        } else {
				            postDelayed(mDelayedShow, delay);
				        }
			    }
		
		    @Override
		    protected void onDraw(Canvas canvas) {
			        if (shouldAnimate()) {
				            for (DilatingDotDrawable dot : mDrawables) {
					                dot.draw(canvas);
					            }
				        }
			    }
		
		    @Override
		    protected boolean verifyDrawable(final android.graphics.drawable.Drawable who) {
			        if (shouldAnimate()) {
				            return mDrawables.contains(who);
				        }
			        return super.verifyDrawable(who);
			    }
		
		    @Override
		    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
			        setMeasuredDimension((int) computeMaxWidth(), (int) computeMaxHeight());
			    }
		
		    private float computeMaxHeight() {
			        return mDotMaxRadius * 2;
			    }
		
		    private float computeMaxWidth() {
			        return computeWidth() + ((mDotMaxRadius - mDotRadius) * 2);
			    }
		
		    private float computeWidth() {
			        return (((mDotRadius * 2) + mHorizontalSpacing) * mDrawables.size()) - mHorizontalSpacing;
			    }
		
		    private void calculateMaxRadius() {
			        mDotMaxRadius = mDotRadius * mDotScaleMultiplier;
			    }
		
		    private void calculateWidthBetweenDotCenters() {
			        mWidthBetweenDotCenters = (int) (mDotRadius * 2) + (int) mHorizontalSpacing;
			    }
		
		    private void initDots() {
			        mDrawables.clear();
			        mAnimations.clear();
			        for (int i = 1; i <= mNumberDots; i++) {
				            final DilatingDotDrawable dot = new DilatingDotDrawable(mDotColor, mDotRadius, mDotMaxRadius);
				            dot.setCallback(this);
				            mDrawables.add(dot);
				
				            final long startDelay = (i - 1) * (int) (START_DELAY_FACTOR * mAnimationDuration);
				
				            // Sizing
				            android.animation.ValueAnimator growAnimator = android.animation.ObjectAnimator.ofFloat(dot, "radius", mDotRadius, mDotMaxRadius, mDotRadius);
				            growAnimator.setDuration(mAnimationDuration);
				            growAnimator.setInterpolator(new android.view.animation.AccelerateDecelerateInterpolator());
				            if (i == mNumberDots) {
					                growAnimator.addListener(new android.animation.AnimatorListenerAdapter() {
						                    @Override
						                    public void onAnimationEnd(android.animation.Animator animation) {
							                        if (shouldAnimate()) {
								                            startAnimations();
								                        }
							                    }
						                });
					            }
				            growAnimator.setStartDelay(startDelay);
				
				            mAnimations.add(growAnimator);
				
				            if (mAnimateColors) {
					                // Gradient
					                android.animation.ValueAnimator colorAnimator = android.animation.ValueAnimator.ofInt(mDotEndColor, mDotColor);
					                colorAnimator.setDuration(mAnimationDuration);
					                colorAnimator.setEvaluator(new android.animation.ArgbEvaluator());
					                colorAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {
						
						                    @Override
						                    public void onAnimationUpdate(android.animation.ValueAnimator animator) {
							                        dot.setColor((int) animator.getAnimatedValue());
							                    }
						
						                });
					                if (i == mNumberDots) {
						                    colorAnimator.addListener(new android.animation.AnimatorListenerAdapter() {
							                        @Override
							                        public void onAnimationEnd(android.animation.Animator animation) {
								                            if (shouldAnimate()) {
									                                startAnimations();
									                            }
								                        }
							                    });
						                }
					                colorAnimator.setStartDelay(startDelay);
					
					                mAnimations.add(colorAnimator);
					            }
				        }
			    }
		
		    private void updateDots() {
			        if (mDotRadius <= 0) {
				            mDotRadius = getHeight() / 2 / mDotScaleMultiplier;
				        }
			
			        int left = (int) (mDotMaxRadius - mDotRadius);
			        int right = (int) (left + mDotRadius * 2) + 2;
			        int top = 0;
			        int bottom = (int) (mDotMaxRadius * 2) + 2;
			
			        for (int i = 0; i < mDrawables.size(); i++) {
				            final DilatingDotDrawable dot = mDrawables.get(i);
				            dot.setRadius(mDotRadius);
				            dot.setBounds(left, top, right, bottom);
				            android.animation.ValueAnimator growAnimator = (android.animation.ValueAnimator) mAnimations.get(i);
				            growAnimator.setFloatValues(mDotRadius, mDotRadius * mDotScaleMultiplier, mDotRadius);
				
				            left += mWidthBetweenDotCenters;
				            right += mWidthBetweenDotCenters;
				        }
			    }
		
		    protected void startAnimations() {
			        mShouldAnimate = true;
			        for (android.animation.Animator anim : mAnimations) {
				            anim.start();
				        }
			    }
		
		    protected void stopAnimations() {
			        mShouldAnimate = false;
			        removeCallbacks();
			        for (android.animation.Animator anim : mAnimations) {
				            anim.cancel();
				        }
			    }
		
		    protected boolean shouldAnimate() {
			        return mShouldAnimate;
			    }
		
		    public void setDotRadius(float radius) {
			        reset();
			        mDotRadius = radius;
			        calculateMaxRadius();
			        calculateWidthBetweenDotCenters();
			        setupDots();
			    }
		
		    public void setDotSpacing(float horizontalSpacing) {
			        reset();
			        mHorizontalSpacing = horizontalSpacing;
			        calculateWidthBetweenDotCenters();
			        setupDots();
			    }
		
		    public void setGrowthSpeed(int growthSpeed) {
			        reset();
			        mAnimationDuration = growthSpeed;
			        setupDots();
			    }
		
		    public void setNumberOfDots(int numDots) {
			        reset();
			        mNumberDots = numDots;
			        setupDots();
			    }
		
		    public void setDotScaleMultiplier(float multiplier) {
			        reset();
			        mDotScaleMultiplier = multiplier;
			        calculateMaxRadius();
			        setupDots();
			    }
		
		    public void setDotColor(int color) {
			        if (color != mDotColor) {
				            if (mAnimateColors) {
					                // Cancel previous animations
					                reset();
					                mDotColor = color;
					                mDotEndColor = color;
					                mAnimateColors = false;
					
					                setupDots();
					
					            } else {
					                mDotColor = color;
					                for (DilatingDotDrawable dot : mDrawables) {
						                    dot.setColor(mDotColor);
						                }
					            }
				        }
			    }
		
		    public void setDotColors(int startColor, int endColor) {
			        if (mDotColor != startColor || mDotEndColor != endColor) {
				            if (mAnimateColors) {
					                reset();
					            }
				            mDotColor = startColor;
				            mDotEndColor = endColor;
				
				            mAnimateColors = mDotColor != mDotEndColor;
				
				            setupDots();
				        }
			    }
		
		    private void setupDots() {
			        initDots();
			        updateDots();
			        showNow();
			    }
		
		    public int getDotGrowthSpeed() {
			        return mAnimationDuration;
			    }
		
		    public float getDotRadius() {
			        return mDotRadius;
			    }
		
		    public float getHorizontalSpacing() {
			        return mHorizontalSpacing;
			    }
		
		    public int getNumberOfDots() {
			        return mNumberDots;
			    }
		
		    public float getDotScaleMultiplier() {
			        return mDotScaleMultiplier;
			    }
	}
	
	public class CustomTypefaceSpan extends TypefaceSpan {
			
			private final Typeface newType;
			
			public CustomTypefaceSpan(String family, Typeface type) {
					super(family);
					newType = type;
			}
			
			@Override
			public void updateDrawState(TextPaint ds) {
					applyCustomTypeFace(ds, newType);
			}
			
			@Override
			public void updateMeasureState(TextPaint paint) {
					applyCustomTypeFace(paint, newType);
			}
			
			private void applyCustomTypeFace(Paint paint, Typeface tf) {
					int oldStyle;
					Typeface old = paint.getTypeface();
					if (old == null) {
							oldStyle = 0;
					} else {
							oldStyle = old.getStyle();
					}
					
					int fake = oldStyle & ~tf.getStyle();
					if ((fake & Typeface.BOLD) != 0) {
							paint.setFakeBoldText(true);
					}
					
					if ((fake & Typeface.ITALIC) != 0) {
							paint.setTextSkewX(-0.25f);
					}
					
					paint.setTypeface(tf);
			}
	}
	{
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
		AdLoader.Builder builder = new AdLoader.Builder(UploadPdfActivity.this, "ca-app-pub-8081781380472232/9847359722");
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
	
	
	public void _Chip_View () {
		
	}
	
	
	public void _removeScollBar (final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
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
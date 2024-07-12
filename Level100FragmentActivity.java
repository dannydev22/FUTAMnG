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
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdRequest;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.OnProgressListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Continuation;
import android.net.Uri;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import android.text.Editable;
import android.text.TextWatcher;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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


public class Level100FragmentActivity extends Fragment {
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private String data = "";
	private double num = 0;
	private double length = 0;
	private String value = "";
	private double downloadvar = 0;
	private String filepath = "";
	private double progressvalue = 0;
	private String success = "";
	
	private ArrayList<HashMap<String, Object>> maplist = new ArrayList<>();
	
	private LinearLayout linear2;
	private ListView listview1;
	private AdView adview1;
	private LinearLayout linear_search;
	private EditText email;
	private ImageView imageview2;
	
	private DatabaseReference fdb = _firebase.getReference("FUTAMnG/UserPDFs");
	private ChildEventListener _fdb_child_listener;
	private StorageReference storage = _firebase_storage.getReference("FUTAMnG/UserPDFs");
	private OnCompleteListener<Uri> _storage_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _storage_download_success_listener;
	private OnSuccessListener _storage_delete_success_listener;
	private OnProgressListener _storage_upload_progress_listener;
	private OnProgressListener _storage_download_progress_listener;
	private OnFailureListener _storage_failure_listener;
	private TimerTask t;
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.level100_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		com.google.firebase.FirebaseApp.initializeApp(getContext());
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		linear2 = (LinearLayout) _view.findViewById(R.id.linear2);
		listview1 = (ListView) _view.findViewById(R.id.listview1);
		adview1 = (AdView) _view.findViewById(R.id.adview1);
		linear_search = (LinearLayout) _view.findViewById(R.id.linear_search);
		email = (EditText) _view.findViewById(R.id.email);
		imageview2 = (ImageView) _view.findViewById(R.id.imageview2);
		
		email.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				maplist = new Gson().fromJson(data, new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
				length = maplist.size();
				num = length - 1;
				for(int _repeat53 = 0; _repeat53 < (int)(length); _repeat53++) {
					value = maplist.get((int)num).get("pdfname").toString();
					if (!(_charSeq.length() > value.length()) && value.toLowerCase().contains(_charSeq.toLowerCase())) {
						
					}
					else {
						maplist.remove((int)(num));
						listview1.setAdapter(new Listview1Adapter(maplist));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
					num--;
				}
				listview1.setAdapter(new Listview1Adapter(maplist));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		_fdb_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				fdb.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						maplist = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								maplist.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						Collections.shuffle(maplist);
						listview1.setAdapter(new Listview1Adapter(maplist));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						data = new Gson().toJson(_childValue);
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
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
		fdb.addChildEventListener(_fdb_child_listener);
		
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
				SketchwareUtil.showMessage(getContext(), "Download");
				t = new TimerTask() {
					@Override
					public void run() {
						getActivity().runOnUiThread(new Runnable() {
							@Override
							public void run() {
								progressvalue = _progressValue;
							}
						});
					}
				};
				_timer.scheduleAtFixedRate(t, (int)(000), (int)(1));
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
				success = "successful";
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
				SketchwareUtil.showMessage(getContext(), _message);
			}
		};
	}
	
	private void initializeLogic() {
		adview1.loadAd(new AdRequest.Builder().addTestDevice("0AA049AB4EB220E38785E314AF907584")
		.build());
		filepath = "/storage/emulated/0/Android/data/com.varia.neny/.pdfs/";
		_removeScollBar(listview1);
	}
	
	@Override
	public void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _ICC (final ImageView _img, final String _c1, final String _c2) {
		_img.setImageTintList(new android.content.res.ColorStateList(new int[][] {{-android.R.attr.state_pressed},{android.R.attr.state_pressed}},new int[]{Color.parseColor(_c1), Color.parseColor(_c2)}));
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
			LayoutInflater _inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.pdfcustomview, null);
			}
			
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
			
			downloadshowlayout.setVisibility(View.GONE);
			_ICC(download, "#673AB7", "#E0E0E0");
			PDFtitle.setText(_data.get((int)_position).get("pdfname").toString());
			level.setText(_data.get((int)_position).get("pdflevel").toString());
			departments.setText(_data.get((int)_position).get("pdfdepartment").toString().concat(", ".concat(_data.get((int)_position).get("pdffaculty").toString())));
			PDFtitle.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/gbemiga.ttf"), 0);
			progress.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/gbemiga.ttf"), 0);
			downloadesc.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/gbemiga.ttf"), 0);
			imageview1.setImageResource(R.drawable.hidisk_icon_pdf);
			download.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					downloadvar++;
					if (downloadvar == 1) {
						downloadshowlayout.setVisibility(View.VISIBLE);
						_firebase_storage.getReferenceFromUrl(_data.get((int)_position).get("pdfurl").toString()).getFile(new File(filepath)).addOnSuccessListener(_storage_download_success_listener).addOnFailureListener(_storage_failure_listener).addOnProgressListener(_storage_download_progress_listener);
						t = new TimerTask() {
							@Override
							public void run() {
								getActivity().runOnUiThread(new Runnable() {
									@Override
									public void run() {
										progressbar1.setProgress((int)progressvalue);
										progress.setText(String.valueOf((long)(progressvalue)).concat("%"));
										if (success.equals("successful")) {
											download.setImageResource(R.drawable.icon_done);
											t.cancel();
										}
									}
								});
							}
						};
						_timer.scheduleAtFixedRate(t, (int)(000), (int)(1));
					}
					else {
						downloadvar = 0;
						progress.setText("");
						downloadshowlayout.setVisibility(View.GONE);
					}
				}
			});
			level.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/gbemiga.ttf"), 0);
			levellinear7.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF673AB7));
			
			return _view;
		}
	}
}
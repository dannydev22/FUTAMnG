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
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import android.widget.TextView;
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


public class CourseActivity extends AppCompatActivity {
	
	private String json = "";
	private String fontName = "";
	private String typeace = "";
	private double adshow = 0;
	private double variablenumber = 0;
	private double length = 0;
	private double num = 0;
	private String data = "";
	private String value = "";
	
	private ArrayList<HashMap<String, Object>> sub_cat_map = new ArrayList<>();
	
	private LinearLayout linear1;
	private SearchView searchview1;
	private RecyclerView recyclerview1;
	private LinearLayout linear2;
	private TextView textview1;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.course);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		searchview1 = (SearchView) findViewById(R.id.searchview1);
		recyclerview1 = (RecyclerView) findViewById(R.id.recyclerview1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		textview1 = (TextView) findViewById(R.id.textview1);
		
		searchview1.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
			@Override
			public boolean onQueryTextSubmit(String _charSeq){
				
				return true;
			}
			
			@Override
			public boolean onQueryTextChange(String _charSeq){
				sub_cat_map = new Gson().fromJson(data, new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
				if (_charSeq.length() > 0) {
					length = sub_cat_map.size();
					num = length - 1;
					for(int _repeat21 = 0; _repeat21 < (int)(length); _repeat21++) {
						value = sub_cat_map.get((int)num).get("name").toString();
						if (!value.toLowerCase().contains(_charSeq.toLowerCase())) {
							sub_cat_map.remove((int)(num));
						}
						num--;
					}
				}
				recyclerview1.setAdapter(new Recyclerview1Adapter(sub_cat_map));
				return true;
			}
		});
	}
	
	private void initializeLogic() {
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
		_jsonFromAsset();
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _jsonFromAsset () {
		try {
				
				java.io.InputStream stream = getAssets().open("categories" + ".json");
				
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
	
	
	public void _TransitionManager (final View _view, final double _duration) {
		LinearLayout viewgroup =(LinearLayout) _view;
		
		android.transition.AutoTransition autoTransition = new android.transition.AutoTransition(); autoTransition.setDuration((long)_duration); android.transition.TransitionManager.beginDelayedTransition(viewgroup, autoTransition);
	}
	
	
	public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {
		ArrayList<HashMap<String, Object>> _data;
		public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _v = _inflater.inflate(R.layout.customt, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear1 = (LinearLayout) _view.findViewById(R.id.linear1);
			final LinearLayout linear24 = (LinearLayout) _view.findViewById(R.id.linear24);
			final LinearLayout linear3 = (LinearLayout) _view.findViewById(R.id.linear3);
			final LinearLayout linear2 = (LinearLayout) _view.findViewById(R.id.linear2);
			final TextView textview3 = (TextView) _view.findViewById(R.id.textview3);
			final TextView textview1 = (TextView) _view.findViewById(R.id.textview1);
			final ImageView menu = (ImageView) _view.findViewById(R.id.menu);
			final FrameLayout native_adview = (FrameLayout) _view.findViewById(R.id.native_adview);
			
			textview1.setText(_data.get((int)_position).get("name").toString());
			textview3.setText(_data.get((int)_position).get("id").toString());
			textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gbemiga.ttf"), 0);
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gbemiga.ttf"), 0);
			variablenumber = 0;
			menu.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					variablenumber++;
					_TransitionManager(linear1, 600);
					if (variablenumber == 1) {
						SketchwareUtil.showMessage(getApplicationContext(), "Added to favourites");
						menu.setImageResource(R.drawable.ic_favorite_black);
					}
					else {
						variablenumber = 0;
						menu.setImageResource(R.drawable.ic_favorite_outline_black);
						SketchwareUtil.showMessage(getApplicationContext(), "Removed from favourites");
					}
				}
			});
			adshow = 10;
			if (((_position % adshow) == 0) && (_position > 1)) {
				linear24.setVisibility(View.VISIBLE);
			}
			else {
				linear24.setVisibility(View.GONE);
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
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
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.*;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerUtils;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdRequest;
import android.widget.TextView;
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


public class YoutubevideoviewActivity extends AppCompatActivity {
	
	private YouTubePlayerView youtube1;
	private ScrollView vscroll1;
	private LinearLayout linear2;
	private LinearLayout linear1;
	private ShowMoreView textview1;
	private CardView cardview1;
	private AdView adview1;
	private LinearLayout linear3;
	private TextView textview2;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.youtubevideoview);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		youtube1 = (YouTubePlayerView) findViewById(R.id.youtube1);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		textview1 = (ShowMoreView) findViewById(R.id.textview1);
		cardview1 = (CardView) findViewById(R.id.cardview1);
		adview1 = (AdView) findViewById(R.id.adview1);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		textview2 = (TextView) findViewById(R.id.textview2);
	}
	
	private void initializeLogic() {
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
		try{
			youtube1.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
				  @Override
				  public void onReady(@NonNull YouTubePlayer youTubePlayer) {
					    String videoId = getIntent().getStringExtra("id");
					    youTubePlayer.cueVideo(videoId, 0);
					     
					  }
			});
			textview2.setText(getIntent().getStringExtra("title"));
			textview1.setText(getIntent().getStringExtra("description"));
		}catch(Exception e){
			 
		}
		adview1.loadAd(new AdRequest.Builder().addTestDevice("0AA049AB4EB220E38785E314AF907584")
		.build());
		textview1.setOnShowTextClickedListener(new OnShowTextClicked() {
				@Override
				public void onTextClicked() {
						showMessage(textview1.getOriginalText());
				}
				
				@Override
				public void onTextLongClicked() {
						showMessage(textview1.getOriginalText());
				}
		});
		
		final ShowMoreView moreText = new ShowMoreView(this);
		moreText.setMaxTextLength(100);
		moreText.setShowMoreColor(Color.parseColor("#45FaFd"));
		moreText.setShowMoreText("More", "Less");
		moreText.setContentText(textview1.getText().toString());
		moreText.expandText(true);
		moreText.setOnShowTextClickedListener(new OnShowTextClicked(){
				@Override
				public void onTextClicked() {
						showMessage(moreText.getOriginalText());
				}
				
				@Override
				public void onTextLongClicked() {
						showMessage(moreText.getOriginalText());
				}
		});
		
		linear1.addView(moreText);
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
		finish();
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
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
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.EditText;
import android.view.View;
import android.content.ClipData;
import android.content.ClipboardManager;
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
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.DynamicDrawableSpan;
import android.text.method.LinkMovementMethod;
import android.content.Context; // Needed for getResources() in BlurringSpan

//
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

public class AichatActivity extends AppCompatActivity {
	
	private String fontName = "";
	private String typeace = "";
	private HashMap<String, Object> smap = new HashMap<>();
	private double adshow = 0;
	private String str = "";
	private String message = "";
	
	private ArrayList<HashMap<String, Object>> map = new ArrayList<>();
	
	private LinearLayout linear3;
	private LinearLayout linear4;
	private TextView textview8;
	private TextView textview9;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private LinearLayout greetingsLayout;
	private ListView listview1;
	private LinearLayout linear9;
	private LinearLayout greetings1;
	private LinearLayout greetings2;
	private LinearLayout greetings3;
	private ImageView imageview1;
	private TextView rand1;
	private TextView rand2;
	private TextView rand3;
	private LinearLayout loading;
	private LinearLayout linear10;
	private TextView textview7;
	private LinearLayout linear12;
	private LinearLayout message_column;
	private LinearLayout send;
	private EditText edittext2;
	private ImageView imageview2;
	
	private RequestNetwork drum;
	private RequestNetwork.RequestListener _drum_request_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.aichat);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		textview8 = (TextView) findViewById(R.id.textview8);
		textview9 = (TextView) findViewById(R.id.textview9);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		greetingsLayout = (LinearLayout) findViewById(R.id.greetingsLayout);
		listview1 = (ListView) findViewById(R.id.listview1);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		greetings1 = (LinearLayout) findViewById(R.id.greetings1);
		greetings2 = (LinearLayout) findViewById(R.id.greetings2);
		greetings3 = (LinearLayout) findViewById(R.id.greetings3);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		rand1 = (TextView) findViewById(R.id.rand1);
		rand2 = (TextView) findViewById(R.id.rand2);
		rand3 = (TextView) findViewById(R.id.rand3);
		loading = (LinearLayout) findViewById(R.id.loading);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		textview7 = (TextView) findViewById(R.id.textview7);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		message_column = (LinearLayout) findViewById(R.id.message_column);
		send = (LinearLayout) findViewById(R.id.send);
		edittext2 = (EditText) findViewById(R.id.edittext2);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		drum = new RequestNetwork(this);
		
		greetings1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (SketchwareUtil.isConnected(getApplicationContext())) {
					greetingsLayout.setVisibility(View.GONE);
					drum.startRequestNetwork(RequestNetworkController.GET, "https://dev-the-dark-lord.pantheonsite.io/wp-admin/js/Apis/Gemini.php?message=".concat(rand1.getText().toString()), "so", _drum_request_listener);
					smap = new HashMap<>();
					smap.put("metext", rand1.getText().toString());
					smap.put("user", "Me");
					map.add(smap);
					_RefreshListView();
					loading.setVisibility(View.VISIBLE);
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "No Internet detected");
				}
			}
		});
		
		greetings2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (SketchwareUtil.isConnected(getApplicationContext())) {
					drum.startRequestNetwork(RequestNetworkController.GET, "https://dev-the-dark-lord.pantheonsite.io/wp-admin/js/Apis/Gemini.php?message=".concat(rand2.getText().toString()), "so", _drum_request_listener);
					loading.setVisibility(View.VISIBLE);
					smap = new HashMap<>();
					smap.put("metext", rand2.getText().toString());
					smap.put("user", "Me");
					map.add(smap);
					_RefreshListView();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "No Internet detected");
				}
			}
		});
		
		greetings3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (SketchwareUtil.isConnected(getApplicationContext())) {
					drum.startRequestNetwork(RequestNetworkController.GET, "https://dev-the-dark-lord.pantheonsite.io/wp-admin/js/Apis/Gemini.php?message=".concat(rand3.getText().toString()), "so", _drum_request_listener);
					loading.setVisibility(View.VISIBLE);
					smap = new HashMap<>();
					smap.put("metext", rand3.getText().toString());
					smap.put("user", "Me");
					map.add(smap);
					_RefreshListView();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "No Internet detected");
				}
			}
		});
		
		send.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (SketchwareUtil.isConnected(getApplicationContext())) {
					if (edittext2.getText().toString().equals("")) {
						edittext2.requestFocus();
					}
					else {
						drum.startRequestNetwork(RequestNetworkController.GET, "https://dev-the-dark-lord.pantheonsite.io/wp-admin/js/Apis/Gemini.php?message=".concat(edittext2.getText().toString()), "so", _drum_request_listener);
						loading.setVisibility(View.VISIBLE);
						greetingsLayout.setVisibility(View.GONE);
						smap = new HashMap<>();
						smap.put("metext", edittext2.getText().toString());
						smap.put("user", "Me");
						map.add(smap);
						edittext2.setText("");
						_RefreshListView();
					}
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Not Connected to Internet!");
				}
			}
		});
		
		_drum_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				loading.setVisibility(View.GONE);
				greetingsLayout.setVisibility(View.GONE);
				smap = new HashMap<>();
				smap.put("user", "AI");
				smap.put("AItext", _response);
				map.add(smap);
				_RefreshListView();
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				loading.setVisibility(View.GONE);
				smap = new HashMap<>();
				smap.put("user", "AI");
				smap.put("AItext", _message);
				map.add(smap);
				_RefreshListView();
			}
		};
	}
	
	private void initializeLogic() {
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
		_rippleRoundStroke(linear9, "#673AB7", "#E0E0E0", 50, 0, "#000000");
		_rippleRoundStroke(greetings1, "#673AB7", "#E0E0E0", 15, 0, "#000000");
		_rippleRoundStroke(greetings2, "#673AB7", "#E0E0E0", 15, 0, "#000000");
		_rippleRoundStroke(greetings3, "#673AB7", "#E0E0E0", 15, 0, "#000000");
		_rippleRoundStroke(message_column, "#BDBDBD", "#E0E0E0", 15, 0, "#000000");
		_rippleRoundStroke(send, "#EEEEEE", "#E0E0E0", 15, 020, "#2196F3");
		loading.setVisibility(View.GONE);
		_dotsProgress(loading, "#FFFFFF", "#FFFFFF", 3, 10, 1.4d, 900, 15);
		_ICC(imageview1, "#FFFFFF", "#E0E0E0");
		_Round(10, 10, 0, 0, "#673AB7", linear7);
		edittext2.setRawInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _setBackground (final View _view, final double _radius, final double _shadow, final String _color, final boolean _ripple) {
		if (_ripple) {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			_view.setElevation((int)_shadow);
			android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor("#E0E0E0")});
			android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , gd, null);
			_view.setClickable(true);
			_view.setBackground(ripdrb);
		}
		else {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			_view.setBackground(gd);
			_view.setElevation((int)_shadow);
		}
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
	
	
	public void _Picassolibrary () {
		
	}
	
	
	public void _ICC (final ImageView _img, final String _c1, final String _c2) {
		_img.setImageTintList(new android.content.res.ColorStateList(new int[][] {{-android.R.attr.state_pressed},{android.R.attr.state_pressed}},new int[]{Color.parseColor(_c1), Color.parseColor(_c2)}));
	}
	
	
	public void _Round (final double _one, final double _two, final double _three, final double _four, final String _color, final View _view) {
		Double left_top = _one;
		Double right_top = _two;
		Double left_bottom = _three;
		Double right_bottom = _four;
		android.graphics.drawable.GradientDrawable s = new android.graphics.drawable.GradientDrawable();
		s.setShape(android.graphics.drawable.GradientDrawable.RECTANGLE);
		s.setCornerRadii(new float[] {left_top.floatValue(),left_top.floatValue(), right_top.floatValue(),right_top.floatValue(), left_bottom.floatValue(),left_bottom.floatValue(), right_bottom.floatValue(),right_bottom.floatValue()});
		s.setColor(Color.parseColor(_color));
		_view.setBackground(s);
	}
	
	
	public void _RefreshListView () {
		listview1.setAdapter(new Listview1Adapter(map));
		((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
		listview1.smoothScrollToPosition((int)(map.size() + map.size()));
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
				_view = _inflater.inflate(R.layout.aicustom, null);
			}
			
			final LinearLayout me = (LinearLayout) _view.findViewById(R.id.me);
			final LinearLayout llama = (LinearLayout) _view.findViewById(R.id.llama);
			final LinearLayout me_message_layout = (LinearLayout) _view.findViewById(R.id.me_message_layout);
			final LinearLayout profile_me = (LinearLayout) _view.findViewById(R.id.profile_me);
			final TextView me_text = (TextView) _view.findViewById(R.id.me_text);
			final ImageView imageview3 = (ImageView) _view.findViewById(R.id.imageview3);
			final TextView textview2 = (TextView) _view.findViewById(R.id.textview2);
			final LinearLayout profile_llama = (LinearLayout) _view.findViewById(R.id.profile_llama);
			final LinearLayout llama_message_layout = (LinearLayout) _view.findViewById(R.id.llama_message_layout);
			final FrameLayout linear1 = (FrameLayout) _view.findViewById(R.id.linear1);
			final ImageView imageview2 = (ImageView) _view.findViewById(R.id.imageview2);
			final TextView llama_text = (TextView) _view.findViewById(R.id.llama_text);
			final ImageView imageview4 = (ImageView) _view.findViewById(R.id.imageview4);
			
			_ICC(imageview2, "#FFFFFF", "#E0E0E0");
			llama_text.setTextIsSelectable(true);
			me_text.setTextIsSelectable(true);
			if (map.get((int)_position).get("user").toString().equals("Me")) {
				Picasso.with(getApplicationContext())
				.load("https://firebasestorage.googleapis.com/v0/b/magfi-573f3.appspot.com/o/categories%2Feglence.jpg?alt\\u003dmedia\\u0026token\\u003d634b728f-e859-4b78-8d1a-1ae2ce602a2f")
				.error(R.drawable.ic_account_circle_white)
				.into(imageview3);
				// Credit for this moreblocks goes to
				//https://web.sketchub.in/u/MeDoZ
				profile_me.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)360, 0xFFFF9800));
				me_message_layout.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)13, 0xFFFF9800));
				me_text.setText(map.get((int)_position).get("metext").toString());
				llama.setVisibility(View.GONE);
				me.setVisibility(View.VISIBLE);
			}
			else {
				if (map.get((int)_position).get("user").toString().equals("AI")) {
					llama_message_layout.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)13, 0xFF673AB7));
					profile_llama.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)360, 0xFF673AB7));
					// Credit for this moreblocks goes to
					//https://web.sketchub.in/u/MeDoZ
					//Do not remove
					//MADE BY PETER ESSYEN
					//Give me credit if you decide to use, //share this codes or project
					message = map.get((int)_position).get("AItext").toString();
					Pattern p = Pattern.compile("(\\*\\*)(.*?)(\\*\\*)");
					    Matcher matcher = p.matcher(message);
					
					    SpannableStringBuilder spannable = new SpannableStringBuilder(message);
					    List<StyleSpan> spans = new ArrayList<>();
					    //for making text bold
					    while (matcher.find()) {
						        StyleSpan span = new StyleSpan(Typeface.BOLD);
						        spannable.setSpan(span, matcher.start(), matcher.end(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
						        spans.add(span);
						    }
					    //for removing ** text
					    for (StyleSpan span : spans) {
						        spannable.replace(spannable.getSpanStart(span), spannable.getSpanStart(span) + 2, "");
						        spannable.replace(spannable.getSpanEnd(span) - 2, spannable.getSpanEnd(span), "");
						    }
						
					llama_text.setText(spannable);
					llama.setVisibility(View.VISIBLE);
					me.setVisibility(View.GONE);
					imageview2.setImageResource(R.drawable.ic_llama);
					imageview4.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View _view) {
							((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", llama_text.getText().toString()));
							SketchwareUtil.showMessage(getApplicationContext(), "Copied");
						}
					});
				}
				else {
					imageview2.setImageResource(R.drawable.ic_favorite_outline_black);
				}
			}
			me_text.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gbemiga.ttf"), 0);
			textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gbemiga.ttf"), 0);
			llama_text.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gbemiga.ttf"), 0);
			adshow = 5;
			if (((_position % adshow) == 0) && (_position > 1)) {
				linear1.setVisibility(View.VISIBLE);
			}
			else {
				linear1.setVisibility(View.GONE);
			}
			AdLoader.Builder builder = new AdLoader.Builder(AichatActivity.this, "ca-app-pub-8081781380472232/8284217808");
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
					AdLoader.Builder builder = new AdLoader.Builder(AichatActivity.this, "ca-app-pub-8081781380472232/8284217808");
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
				}
			}).build();
			
			adLoader.loadAd(new AdRequest.Builder().build());
			
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
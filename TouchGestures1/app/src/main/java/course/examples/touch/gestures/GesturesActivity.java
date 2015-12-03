package course.examples.touch.gestures;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.gesture.Prediction;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class GesturesActivity extends Activity implements
		OnGesturePerformedListener {
	private static final String NO = "No";
	private static final String YES = "Yes";
	private static final String PREV = "Prev";
	private static final String NEXT = "Next";
	private GestureLibrary mLibrary;
	private int mBgImg = 1;
	private int mFirstColor, mStartBgColor = Color.GRAY;
	private FrameLayout mFrame;
	private RelativeLayout mLayout;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mFrame = (FrameLayout) findViewById(R.id.frame);


		mFrame.setBackgroundResource(R.drawable.b1);

		mLayout = (RelativeLayout) findViewById(R.id.main);
		mLayout.setBackgroundColor(mStartBgColor);

		mLibrary = GestureLibraries.fromRawResource(this, R.raw.gestures);
		if (!mLibrary.load()) {
			finish();
		}

		// Make this the target of gesture detection callbacks
		GestureOverlayView gestureView = (GestureOverlayView) findViewById(R.id.gestures_overlay);
		gestureView.addOnGesturePerformedListener(this);

	}

	public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {

		// Get gesture predictions
		ArrayList<Prediction> predictions = mLibrary.recognize(gesture);

		// Get highest-ranked prediction
		if (predictions.size() > 0) {
			Prediction prediction = predictions.get(0);

			// Ignore weak predictions

			if (prediction.score > 2.0) {
				if (prediction.name.equals(PREV)) {

					mBgImg -= 1;
					if(mBgImg < 1)
						mBgImg = 14;
					setBackgroundImg(1,mBgImg);

				} else if (prediction.name.equals(NEXT)) {

					mBgImg += 1;
					if(mBgImg > 14)
						mBgImg = 1;
					setBackgroundImg(1,mBgImg);
				
				} else if (prediction.name.equals(YES)) {
					mFrame.setBackgroundDrawable(null);
					setBackgroundImg(2,mBgImg);
				
				} else if (prediction.name.equals(NO)) {
				
					mLayout.setBackgroundColor(mStartBgColor);
					mFrame.setBackgroundResource(R.drawable.b1);
				
				} else {
					Toast.makeText(this, prediction.name, Toast.LENGTH_SHORT)
							.show();

				}
			} else {
				Toast.makeText(this, "No prediction", Toast.LENGTH_SHORT)
						.show();
			}
		}
	}
	public void setBackgroundImg(int typeLayout, int img){
		if(typeLayout == 1) {
			if (img == 1) {
				mFrame.setBackgroundResource(R.drawable.b1);
			} else if (img == 2)
				mFrame.setBackgroundResource(R.drawable.b2);
			else if (img == 3)
				mFrame.setBackgroundResource(R.drawable.b3);
			else if (img == 4)
				mFrame.setBackgroundResource(R.drawable.b4);
			else if (img == 5)
				mFrame.setBackgroundResource(R.drawable.b5);
			else if (img == 6)
				mFrame.setBackgroundResource(R.drawable.b6);
			else if (img == 7)
				mFrame.setBackgroundResource(R.drawable.b7);
			else if (img == 8)
				mFrame.setBackgroundResource(R.drawable.b8);
			else if (img == 9)
				mFrame.setBackgroundResource(R.drawable.b9);
			else if (img == 10)
				mFrame.setBackgroundResource(R.drawable.b10);
			else if (img == 11)
				mFrame.setBackgroundResource(R.drawable.b11);
			else if (img == 12)
				mFrame.setBackgroundResource(R.drawable.b12);
			else if (img == 13)
				mFrame.setBackgroundResource(R.drawable.b13);
			else
				mFrame.setBackgroundResource(R.drawable.b14);
		}else{
			if (img == 1) {
				mLayout.setBackgroundResource(R.drawable.b1);
			} else if (img == 2)
				mLayout.setBackgroundResource(R.drawable.b2);
			else if (img == 3)
				mLayout.setBackgroundResource(R.drawable.b3);
			else if (img == 4)
				mLayout.setBackgroundResource(R.drawable.b4);
			else if (img == 5)
				mLayout.setBackgroundResource(R.drawable.b5);
			else if (img == 6)
				mLayout.setBackgroundResource(R.drawable.b6);
			else if (img == 7)
				mLayout.setBackgroundResource(R.drawable.b7);
			else if (img == 8)
				mLayout.setBackgroundResource(R.drawable.b8);
			else if (img == 9)
				mLayout.setBackgroundResource(R.drawable.b9);
			else if (img == 10)
				mLayout.setBackgroundResource(R.drawable.b10);
			else if (img == 11)
				mLayout.setBackgroundResource(R.drawable.b11);
			else if (img == 12)
				mLayout.setBackgroundResource(R.drawable.b12);
			else if (img == 13)
				mLayout.setBackgroundResource(R.drawable.b13);
			else
				mLayout.setBackgroundResource(R.drawable.b14);
		}
	}
}
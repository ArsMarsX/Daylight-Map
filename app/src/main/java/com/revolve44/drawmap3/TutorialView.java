package com.revolve44.drawmap3;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class TutorialView extends FrameLayout {
    private static final float RADIUS = 200;

    private Paint mBackgroundPaint;
    private float mCx = -1;
    private float mCy = -1;
    private Paint p = new Paint();

    private int mTutorialColor = Color.parseColor("#D20E0F02");

    public TutorialView(Context context) {
        super(context);
        init();
    }

    public TutorialView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TutorialView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TutorialView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        setWillNotDraw(false);
        setLayerType(LAYER_TYPE_HARDWARE, null);

        mBackgroundPaint = new Paint();
        mBackgroundPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mCx = event.getX();
        mCy = event.getY();
        invalidate();
        return true;
    }


    @Override
    protected void onDraw(Canvas canvas) {

        Bitmap original = BitmapFactory.decodeResource(getContext().getResources(),R.drawable.trapechg);
        Bitmap resized = Bitmap.createScaledBitmap(original, 300, 400, true);

        Bitmap original2 = BitmapFactory.decodeResource(getContext().getResources(),R.drawable.trapechg);
        Bitmap resized2 = Bitmap.createScaledBitmap(original, 300, 400, true);

        Bitmap resized3 = Bitmap.createScaledBitmap(original, 300, 400, true);
//        bitmap = Bitmap.createBitmap(parentWidth, parentHeight, Bitmap.Config.ARGB_8888);
//        cnvs = new Canvas(bitmap);
//        cnvs.drawRect(0, 0, cnvs.getWidth(), cnvs.getHeight(), semiTransparentPaint);
//        cnvs.drawCircle(parentWidth / 2, parentHeight / 2, radius, transparentPaint);
        canvas.drawColor(mTutorialColor);
        canvas.drawBitmap(resized, mCx,mCy,mBackgroundPaint);

        canvas.drawBitmap(resized2, mCx-850,mCy,mBackgroundPaint);
        canvas.drawBitmap(resized3, mCx+650,mCy,mBackgroundPaint);

//        TranslateAnimation animation1 = new TranslateAnimation(-220, 100,250, 200 );
//        animation1.setDuration(3000);
//        //animation1.setFillAfter(true);
//
//        original.startAnimation(animation1);
//        canvas.drawColor(mTutorialColor);
//        if (mCx >= 0 && mCy >= 0) {
////            Resources res = getResources();
////            @SuppressLint("DrawAllocation") Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.cloud9);
//            canvas.drawCircle(mCx, mCy, RADIUS, mBackgroundPaint);
//        }
//            Bitmap original = BitmapFactory.decodeResource(getContext().getResources(),R.drawable.original_image);
//            Bitmap mask = BitmapFactory.decodeResource(getContext().getResources(),R.drawable.mask_image);
//
//            //You can change original image here and draw anything you want to be masked on it.
//
//            Bitmap result = Bitmap.createBitmap(mask.getWidth(), mask.getHeight(), Bitmap.Config.ARGB_8888);
//            Canvas tempCanvas = new Canvas(result);
//            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
//            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
//            tempCanvas.drawBitmap(original, 0, 0, null);
//            tempCanvas.drawBitmap(mask, 0, 0, paint);
//            paint.setXfermode(null);
//
//            //Draw result after performing masking
//            canvas.drawBitmap(result, 0, 0, new Paint());



    }
}
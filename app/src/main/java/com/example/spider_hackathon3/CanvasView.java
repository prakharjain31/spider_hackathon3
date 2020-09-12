package com.example.spider_hackathon3;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class CanvasView extends View {

    public boolean misinit;
    float x1 = 500,y1 = 1500;
    public Path path;
    Bitmap carbitmap;
    Paint carpaint;
    Paint pathpaint;
    Path animpath;
    PathMeasure pathMeasure;
    float pathlength;
    Matrix matrix;
    float distance,step;
    int bmoffsetx,bmoffsety;
    float[] pos;
    float[] tan;
    boolean bol1=true,bol2=false;

    ImageView imageView;


//    Matrix matrix;
//    PathMeasure pathMeasure;
//    int currentStep = 0;




    public CanvasView(Context context) {
        super(context);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    public void init()
    {
        path=new Path();
        carbitmap= BitmapFactory.decodeResource(getResources(), R.drawable.car_image);

        carpaint=new Paint();
        pathpaint=new Paint();
        distance=0;
        step=0;
        bmoffsetx=carbitmap.getWidth()/2;
        bmoffsety=carbitmap.getHeight()/2;

        carpaint.setColor(Color.GREEN);
        pathpaint.setAntiAlias(true);
        pathpaint.setColor(Color.RED);
        pathpaint.setStrokeJoin(Paint.Join.ROUND);
        pathpaint.setStyle(Paint.Style.STROKE);
        pathpaint.setStrokeWidth(5f);
        pos=new float[2];
        tan=new float[2];

//
//        View v = LayoutInflater.from(getContext()).inflate(R.layout.activity_main , (ViewGroup) getRootView(), false);
//
//        imageView = v.findViewById(R.id.img);
//        matrix = new Matrix();
//        pathMeasure = new PathMeasure(path , false);


        misinit=true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(!misinit)
        {
            init();
        }



//        float animLen = pathMeasure.getLength() /20;
//        if (currentStep <= 20) {
//            pathMeasure.getMatrix(animLen * currentStep , matrix , PathMeasure.POSITION_MATRIX_FLAG + PathMeasure.TANGENT_MATRIX_FLAG);
//            canvas.drawBitmap(carbitmap , matrix , null);
//            currentStep++;
//            invalidate();
//        } else {
//            currentStep = 0;
//        }




        canvas.drawBitmap(carbitmap,x1,y1,carpaint);
//
//        Path path1 = new Path();
//        path1.arcTo(0f , 0f , 1000f , 1000f , 270f , -180f , true);
//        ObjectAnimator pathAnimator = ObjectAnimator.ofFloat(imageView  ,View.X , View.Y , path1);
//        pathAnimator.setDuration(2000);
//        pathAnimator.start();



        canvas.drawPath(path,pathpaint);

//        else{
//            canvas.drawPath(animpath,pathpaint);
//        }
//        invalidate();
//        if(distance<pathlength)
//        {
//            animpath=path;
//            pathMeasure=new PathMeasure(animpath,false);
//            pathlength=pathMeasure.getLength();
//            Toast.makeText(getContext(), "pathlength"+pathlength, Toast.LENGTH_SHORT).show();
//            matrix=new Matrix();
//            pathMeasure.getPosTan(distance,pos,tan);
//            matrix.reset();
//            float degrees =(float)(Math.atan2(tan[1],tan[0])*180/Math
//            .PI);
//            matrix.postRotate(degrees,bmoffsetx,bmoffsety);
//            matrix.postTranslate(pos[0]-bmoffsetx,pos[1]-bmoffsety);
//            canvas.drawBitmap(carbitmap,matrix,null);
//            distance +=step;
//
//        }
//        else{
//            distance=0;
//        }
//        invalidate();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);

        float x = event.getX();
        float y = event.getY();


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                postInvalidate();

                return true;

            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                x1 = x;
                y1 = y;
                invalidate();

                break;

            case MotionEvent.ACTION_UP:

                bol2=true;
//                Path path1 = new Path();
//                path1.arcTo(0f , 0f , 1000f , 1000f , 270f , -180f , true);
//                ObjectAnimator pathAnimator = ObjectAnimator.ofFloat(imageView  ,View.X , View.Y , path1);
//                pathAnimator.setDuration(2000);
//                pathAnimator.start();

//                pathAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    float[] point = new float[2];
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                        float val = valueAnimator.getAnimatedFraction();
//                        PathMeasure pathMeasure = new PathMeasure(path , true);
//                        pathMeasure.getPosTan(pathMeasure.getLength() * val, point , null );
//                        imageView.setX(point[0]);
//                        imageView.setY(point[1]);
//                    }
//                });


                return false;


        }
//
        postInvalidate();
//
        return true;
    }


}

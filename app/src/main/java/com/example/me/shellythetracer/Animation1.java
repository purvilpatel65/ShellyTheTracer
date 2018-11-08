package com.example.me.shellythetracer;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.security.KeyStore;

public class Animation1 extends View {

    Paint paintbrush;
    Path triangle;
    Bitmap flagImg;
    int wid, height;


    int arrow_x ;
    int arrow_y ;
    int x_dir, y_dir = 1;

    public Animation1(Context context) {
        super(context);

        init(null);
    }

   public Animation1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public Animation1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(@Nullable AttributeSet atr) {

         arrow_x = (getWidth()/2)+75;
         arrow_y = (getHeight()/2)+75;
    }


    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);



        paintbrush = new Paint();
        paintbrush.setColor(Color.LTGRAY);
        paintbrush.setStyle(Paint.Style.STROKE);
        paintbrush.setStrokeWidth(30);


        canvas.drawRect(100,100,400,400, paintbrush);




    }
}

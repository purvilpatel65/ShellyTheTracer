package com.example.me.shellythetracer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Animation2 extends View {

    Paint paintbrush;
    Path path;

    public Animation2(Context context) {
        super(context);
    }

    public Animation2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Animation2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paintbrush = new Paint();
        paintbrush.setColor(Color.LTGRAY);
        paintbrush.setStyle(Paint.Style.STROKE);
        paintbrush.setStrokeWidth(40);

        path = new Path();

        path.moveTo(100,100);
        path.lineTo(100,250);
        path.moveTo(80,250);
        path.lineTo(250,250);
        path.moveTo(250,230);
        path.lineTo(250,400);
        path.moveTo(230,400);
        path.lineTo(400,400);

        canvas.drawPath(path,paintbrush);
    }
}

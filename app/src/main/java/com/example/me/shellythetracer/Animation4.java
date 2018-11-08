package com.example.me.shellythetracer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Animation4 extends View {

    Paint paintbrush;
    Path path;
    public Animation4(Context context) {
        super(context);
    }

    public Animation4(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Animation4(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paintbrush = new Paint();
        paintbrush.setColor(Color.LTGRAY);
        paintbrush.setStyle(Paint.Style.STROKE);
        paintbrush.setStrokeWidth(30);

        path = new Path();

        path.moveTo(30,300);
        path.lineTo(30,100);
        path.moveTo(28,115);
        path.lineTo(130,115);
        path.moveTo(115,115);
        path.lineTo(115,300);
        path.moveTo(110,285);
        path.lineTo(215,285);
        path.moveTo(200,285);
        path.lineTo(200,100);
        path.moveTo(200,115);
        path.lineTo(300,115);
        path.moveTo(285,115);
        path.lineTo(285,300);
        path.moveTo(285,285);
        path.lineTo(385,285);
        path.moveTo(370,285);
        path.lineTo(370,105);

        canvas.drawPath(path,paintbrush);
    }
}

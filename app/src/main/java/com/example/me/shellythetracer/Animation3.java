package com.example.me.shellythetracer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Animation3 extends View {
    Paint paintbrush, textPaint;
    Path path1, path2;

    public Animation3(Context context) {
        super(context);
    }

    public Animation3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Animation3(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paintbrush = new Paint();
        paintbrush.setColor(Color.LTGRAY);
        paintbrush.setStyle(Paint.Style.STROKE);
        paintbrush.setStrokeWidth(30);

        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setStyle(Paint.Style.FILL);

        path1 = new Path();
        path2 = new Path();

        path1.moveTo(30,100);
        path1.lineTo(150,100);
        path1.moveTo(141,98);
        path1.lineTo(338,306);
        path1.moveTo(330,300);
        path1.lineTo(450,300);

        path2.moveTo(30,300);
        path2.lineTo(150,300);
        path2.moveTo(141,303);
        path2.lineTo(341,98);
        path2.moveTo(330,100);
        path2.lineTo(450,100);

        canvas.drawPath(path1,paintbrush);
        canvas.drawPath(path2,paintbrush);

        canvas.drawText("Arrow-1", 30,70,textPaint);
        canvas.drawText("Arrow-2", 400,70,textPaint);
    }
}

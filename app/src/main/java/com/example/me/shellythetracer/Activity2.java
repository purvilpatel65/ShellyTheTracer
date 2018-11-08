package com.example.me.shellythetracer;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    MyStartDragingListener2 mStartDrag2;
    MyDragListener2 mDrag2;
    boolean check1=false, check2=false, check3=false, check4=false;
    Button run, playAgain;
    ImageView img, flagImg;
    TextView nextLevel, score;
    LinearLayout lv;
    int scoreNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        setLayouts();

    }

    public void onRun(View view) {
        onAnimation();
        score.setText("Score: " + scoreNum);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                MediaPlayer media = MediaPlayer.create(getApplicationContext(), R.raw.clap);
                media.start();

                run.setEnabled(false);
                nextLevel.setVisibility(View.VISIBLE);
                playAgain.setVisibility(View.VISIBLE);
                score.setVisibility(View.VISIBLE);
            }
        }, 11000);


    }
    public void onAnimation()
    {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(img, "translationY",220f);
        animator1.setDuration(2000);

        ObjectAnimator rotationAnimator1 = ObjectAnimator.ofFloat(img, "rotation", 90f);
        rotationAnimator1.setDuration(1000);

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(img, "translationX",220f);
        animator2.setDuration(2000);

        ObjectAnimator rotationAnimator2 = ObjectAnimator.ofFloat(img, "rotation", 180f);
        rotationAnimator2.setDuration(1000);

        ObjectAnimator animator3 = ObjectAnimator.ofFloat(img, "translationY",375f);
        animator3.setDuration(2000);

        ObjectAnimator rotationAnimator3 = ObjectAnimator.ofFloat(img, "rotation", 90f);
        rotationAnimator3.setDuration(1000);

        ObjectAnimator animator4 = ObjectAnimator.ofFloat(img, "translationX",375f);
        animator4.setDuration(2000);
//
//        ObjectAnimator rotationAnimator4 = ObjectAnimator.ofFloat(img, "rotation", 0f);
//        rotationAnimator4.setDuration(1000);
//
        AnimatorSet set  = new AnimatorSet();
        set.playSequentially(animator1, rotationAnimator1, animator2, rotationAnimator2, animator3, rotationAnimator3, animator4);
        set.start();

    }

    public void onPlayAgain(View view)
    {
        setContentView(R.layout.activity_2);
        setLayouts();

    }


    private class MyStartDragingListener2 implements View.OnLongClickListener{

        @Override
        public boolean onLongClick(View view) {

            withDragShadow2 shadow = new withDragShadow2(view);
            ClipData data = ClipData.newPlainText("","");
            view.startDrag(data,shadow,view,0);

            return false;
        }
    }

    private class MyDragListener2 implements View.OnDragListener{

        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {

            View v = (View)dragEvent.getLocalState();

            if(dragEvent.getAction()==DragEvent.ACTION_DROP){

                if((v.getId() == R.id.downBtn || v.getId() == R.id.downBtn2) && view.getId() == R.id.Btn1)
                {
                    ((Button)view).setBackground(
                            ((Button)dragEvent.getLocalState()).getBackground());
                    v.setVisibility(View.GONE);
                    check1=true;
                    scoreNum = scoreNum+2;
                    Toast.makeText(getApplicationContext(),"Good Job!\nPoints: +2",Toast.LENGTH_SHORT).show();
                }
                else if((v.getId() == R.id.downBtn || v.getId() == R.id.downBtn2) && view.getId() == R.id.Btn3)
                {
                    ((Button)view).setBackground(
                            ((Button)dragEvent.getLocalState()).getBackground());
                    v.setVisibility(View.GONE);
                    check3=true;
                    scoreNum = scoreNum+2;
                    Toast.makeText(getApplicationContext(),"Good Job!\nPoints: +2",Toast.LENGTH_SHORT).show();
                }
                else if((v.getId() == R.id.rightBtn || v.getId() == R.id.rightBtn2) && view.getId() == R.id.Btn2)
                {
                    ((Button)view).setBackground(
                            ((Button)dragEvent.getLocalState()).getBackground());
                    v.setVisibility(View.GONE);
                    check2=true;
                    scoreNum = scoreNum+2;
                    Toast.makeText(getApplicationContext(),"Good Job!\nPoints: +2",Toast.LENGTH_SHORT).show();
                }
                else if((v.getId() == R.id.rightBtn || v.getId() == R.id.rightBtn2) && view.getId() == R.id.Btn4)
                {
                    ((Button)view).setBackground(
                            ((Button)dragEvent.getLocalState()).getBackground());
                    v.setVisibility(View.GONE);
                    check4=true;
                    scoreNum = scoreNum+2;
                    Toast.makeText(getApplicationContext(),"Good Job!\nPoints: +2",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    scoreNum = scoreNum-1;
                    Toast.makeText(getApplicationContext(),"Wrong position. Try again!\n             Points: -1",Toast.LENGTH_SHORT).show();
                }

                if(check1 && check2 && check3 && check4) run.setEnabled(true);

            }
            return true;
        }
    }

    private class withDragShadow2  extends View.DragShadowBuilder

    {
        public withDragShadow2(View v)
        {
            super(v);
        }

        @Override
        public void onDrawShadow(Canvas canvas) {
            super.onDrawShadow(canvas);
        }

        @Override
        public void onProvideShadowMetrics(Point outShadowSize, Point outShadowTouchPoint) {
            super.onProvideShadowMetrics(outShadowSize, outShadowTouchPoint);
        }
    }

    public void setLayouts()
    {
        mStartDrag2 = new MyStartDragingListener2();
        mDrag2 = new MyDragListener2();

        findViewById(R.id.downBtn).setOnLongClickListener(mStartDrag2);
        findViewById(R.id.downBtn2).setOnLongClickListener(mStartDrag2);
        findViewById(R.id.rightBtn2).setOnLongClickListener(mStartDrag2);
        findViewById(R.id.rightBtn).setOnLongClickListener(mStartDrag2);

        findViewById(R.id.Btn1).setOnDragListener(mDrag2);
        findViewById(R.id.Btn2).setOnDragListener(mDrag2);
        findViewById(R.id.Btn3).setOnDragListener(mDrag2);
        findViewById(R.id.Btn4).setOnDragListener(mDrag2);

        run = (Button)findViewById(R.id.runBtn);
        run.setEnabled(false);
        playAgain = (Button)findViewById(R.id.playAgain);
        playAgain.setVisibility(View.INVISIBLE);
        nextLevel = (TextView)findViewById(R.id.nxtLevel);
        nextLevel.setVisibility(View.INVISIBLE);
        lv = (LinearLayout)findViewById(R.id.layout1);
        score = (TextView)findViewById(R.id.scoreTxt);
        score.setVisibility(View.INVISIBLE);
        scoreNum=0;

        img = (ImageView)findViewById(R.id.image);
        flagImg = (ImageView)findViewById(R.id.flagimage);

        img.setX(73);
        img.setY(90);
        img.setRotation(180);

        flagImg.setX(370);
        flagImg.setY(385);

        nextLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity3.class);
                startActivity(intent);
                finish();
            }
        });
    }


}



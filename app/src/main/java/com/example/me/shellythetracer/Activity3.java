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

public class Activity3 extends AppCompatActivity {

    MyStartDragingListener3 mStartDrag3;
    MyDragListener3 mDrag3;
    boolean check1=false, check2=false, check3=false, check4=false, check5=false, check6=false;
    Button run, playAgain;
    ImageView img1, img2, flagImg1, flagImg2;
    TextView nextLevel, score;
    int scoreNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
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
        }, 8000);
    }

    public void onPlayAgain(View view) {
        setContentView(R.layout.activity_3);
        setLayouts();
    }

    public void onAnimation()
    {
        //Image-1 Anim
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(img1, "translationX",117f);
        animator1.setDuration(2000);

        ObjectAnimator rotationAnimator1 = ObjectAnimator.ofFloat(img1, "rotation", 135f);
        rotationAnimator1.setDuration(1000);

        ObjectAnimator animator21 = ObjectAnimator.ofFloat(img1, "translationX",315f);
        ObjectAnimator animator22 = ObjectAnimator.ofFloat(img1, "translationY",276f);

        AnimatorSet set2  = new AnimatorSet();
        set2.playTogether(animator21,animator22);
        set2.setDuration(2000);

        ObjectAnimator rotationAnimator2 = ObjectAnimator.ofFloat(img1, "rotation", 90f);
        rotationAnimator1.setDuration(1000);

        ObjectAnimator animator3 = ObjectAnimator.ofFloat(img1, "translationX",430f);
        animator3.setDuration(2000);

        AnimatorSet set1  = new AnimatorSet();
        set1.playSequentially(animator1, rotationAnimator1, set2, rotationAnimator2, animator3);
        //set1.start();

   //Image-2 Anim
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(img2, "translationX",315f);
        animator4.setDuration(2000);

        ObjectAnimator rotationAnimator3 = ObjectAnimator.ofFloat(img2, "rotation", -135f);
        rotationAnimator3.setDuration(1000);

        ObjectAnimator animator41 = ObjectAnimator.ofFloat(img2, "translationX",117f);
        ObjectAnimator animator42 = ObjectAnimator.ofFloat(img2, "translationY",276f);

        AnimatorSet set4  = new AnimatorSet();
        set4.playTogether(animator41,animator42);
        set4.setDuration(2000);

        ObjectAnimator rotationAnimator4 = ObjectAnimator.ofFloat(img2, "rotation", -90f);
        rotationAnimator4.setDuration(1000);

        ObjectAnimator animator5 = ObjectAnimator.ofFloat(img2, "translationX",2f);
        animator5.setDuration(2000);

        AnimatorSet set3  = new AnimatorSet();
        set3.playSequentially(animator4,rotationAnimator3, set4, rotationAnimator4, animator5);
        //set3.start();

        AnimatorSet set  = new AnimatorSet();
        set.playTogether(set1, set3);
        set.start();
    }

    private class MyStartDragingListener3 implements View.OnLongClickListener{

        @Override
        public boolean onLongClick(View view) {

            withDragShadow3 shadow = new withDragShadow3(view);
            ClipData data = ClipData.newPlainText("","");
            view.startDrag(data,shadow,view,0);

            return false;
        }
    }

    private class MyDragListener3 implements View.OnDragListener{

        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {

            View v = (View)dragEvent.getLocalState();

            if(dragEvent.getAction()==DragEvent.ACTION_DROP){

                if((v.getId() == R.id.A1rightBtn1 || v.getId() == R.id.A1rightBtn2) && view.getId() == R.id.A1Btn1)
                {
                    ((Button)view).setBackground(
                            ((Button)dragEvent.getLocalState()).getBackground());
                    v.setVisibility(View.GONE);
                    ((Button) view).setText("");
                    check1=true;
                    scoreNum = scoreNum+2;
                    Toast.makeText(getApplicationContext(),"Good Job!\nPoints: +2",Toast.LENGTH_SHORT).show();
                }
                else if((v.getId() == R.id.A1rightBtn1 || v.getId() == R.id.A1rightBtn2) && view.getId() == R.id.A1Btn3)
                {
                    ((Button)view).setBackground(
                            ((Button)dragEvent.getLocalState()).getBackground());
                    v.setVisibility(View.GONE);
                    ((Button) view).setText("");
                    check3=true;
                    scoreNum = scoreNum+2;
                    Toast.makeText(getApplicationContext(),"Good Job!\nPoints: +2",Toast.LENGTH_SHORT).show();
                }
                else if(v.getId() == R.id.A1slantBtn && view.getId() == R.id.A1Btn2)
                {
                    ((Button)view).setBackground(
                            ((Button)dragEvent.getLocalState()).getBackground());
                    v.setVisibility(View.GONE);
                    ((Button) view).setText("");
                    check2=true;
                    scoreNum = scoreNum+2;
                    Toast.makeText(getApplicationContext(),"Good Job!\nPoints: +2",Toast.LENGTH_SHORT).show();
                }
                else if((v.getId() == R.id.A2leftBtn1 || v.getId() == R.id.A2leftBtn2) && view.getId() == R.id.A2Btn1)
                {
                    ((Button)view).setBackground(
                            ((Button)dragEvent.getLocalState()).getBackground());
                    v.setVisibility(View.GONE);
                    ((Button) view).setText("");
                    check4=true;
                    scoreNum = scoreNum+2;
                    Toast.makeText(getApplicationContext(),"Good Job!\nPoints: +2",Toast.LENGTH_SHORT).show();
                }
                else if(v.getId() == R.id.A2slantBtn && view.getId() == R.id.A2Btn2)
                {
                    ((Button)view).setBackground(
                            ((Button)dragEvent.getLocalState()).getBackground());
                    v.setVisibility(View.GONE);
                    ((Button) view).setText("");
                    check5=true;
                    scoreNum = scoreNum+2;
                    Toast.makeText(getApplicationContext(),"Good Job!\nPoints: +2",Toast.LENGTH_SHORT).show();
                }
                else if((v.getId() == R.id.A2leftBtn1 || v.getId() == R.id.A2leftBtn2) && view.getId() == R.id.A2Btn3) {
                    ((Button) view).setBackground(
                            ((Button) dragEvent.getLocalState()).getBackground());
                    v.setVisibility(View.GONE);
                    ((Button) view).setText("");
                    check6 = true;
                    scoreNum = scoreNum+2;
                    Toast.makeText(getApplicationContext(),"Good Job!\nPoints: +2",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    scoreNum = scoreNum-1;
                    Toast.makeText(getApplicationContext(),"Wrong position. Try again!\n             Points: -1",Toast.LENGTH_SHORT).show();
                }

                if(check1 && check2 && check3 && check4 && check5 && check6) run.setEnabled(true);

            }
            return true;
        }
    }

    private class withDragShadow3  extends View.DragShadowBuilder

    {
        public withDragShadow3(View v)
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
        mStartDrag3 = new MyStartDragingListener3();
        mDrag3 = new MyDragListener3();

        findViewById(R.id.A1rightBtn1).setOnLongClickListener(mStartDrag3);
        findViewById(R.id.A1rightBtn2).setOnLongClickListener(mStartDrag3);
        findViewById(R.id.A2leftBtn1).setOnLongClickListener(mStartDrag3);
        findViewById(R.id.A2leftBtn2).setOnLongClickListener(mStartDrag3);
        findViewById(R.id.A1slantBtn).setOnLongClickListener(mStartDrag3);
        findViewById(R.id.A2slantBtn).setOnLongClickListener(mStartDrag3);

        findViewById(R.id.A1Btn1).setOnDragListener(mDrag3);
        findViewById(R.id.A1Btn2).setOnDragListener(mDrag3);
        findViewById(R.id.A1Btn3).setOnDragListener(mDrag3);
        findViewById(R.id.A2Btn1).setOnDragListener(mDrag3);
        findViewById(R.id.A2Btn2).setOnDragListener(mDrag3);
        findViewById(R.id.A2Btn3).setOnDragListener(mDrag3);

        run = (Button)findViewById(R.id.runBtn);
        run.setEnabled(false);
        playAgain = (Button)findViewById(R.id.playAgain);
        playAgain.setVisibility(View.INVISIBLE);
        nextLevel = (TextView)findViewById(R.id.nxtLevel);
        nextLevel.setVisibility(View.INVISIBLE);
        score = (TextView)findViewById(R.id.scoreTxt);
        score.setVisibility(View.INVISIBLE);
        scoreNum=0;


        img1 = (ImageView)findViewById(R.id.A1img);
        img2 = (ImageView)findViewById(R.id.A2img);
        flagImg1 = (ImageView)findViewById(R.id.flagimage1);
        flagImg2 = (ImageView)findViewById(R.id.flagimage2);


        img1.setX(16);
        img1.setY(73);
        img1.setRotation(90);

        img2.setX(410);
        img2.setY(73);
        img2.setRotation(-90);

        flagImg1.setX(420f);
        flagImg1.setY(285f);

        flagImg2.setX(32f);
        flagImg2.setY(283f);

        nextLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity4.class);
                startActivity(intent);
                finish();
            }
        });

    }


}

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
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyStartDragingListener mStartDrag;
    MyDragListener mDrag;
    Animation1 animate;
    Button run, playAgain;
    ImageView img, flagImage;
    TextView nextLevel, score;
    boolean check1=false, check2=false, check3=false, check4=false;
    int scoreNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setLayout();
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
        }, 13000);


    }

    public void onPlayAgain(View view)
    {
        setContentView(R.layout.activity_main);
        setLayout();

    }

    public void onAnimation()
    {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(img, "translationY",75f);
        animator1.setDuration(2000);

        ObjectAnimator rotationAnimator1 = ObjectAnimator.ofFloat(img, "rotation", -90f);
        rotationAnimator1.setDuration(1000);

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(img, "translationX",75f);
        animator2.setDuration(2000);

        ObjectAnimator rotationAnimator2 = ObjectAnimator.ofFloat(img, "rotation", -180f);
        rotationAnimator2.setDuration(1000);

        ObjectAnimator animator3 = ObjectAnimator.ofFloat(img, "translationY",375f);
        animator3.setDuration(2000);

        ObjectAnimator rotationAnimator3 = ObjectAnimator.ofFloat(img, "rotation", -270f);
        rotationAnimator3.setDuration(1000);

        ObjectAnimator animator4 = ObjectAnimator.ofFloat(img, "translationX",370f);
        animator4.setDuration(2000);

        ObjectAnimator rotationAnimator4 = ObjectAnimator.ofFloat(img, "rotation", 0f);
        rotationAnimator4.setDuration(1000);

        AnimatorSet set  = new AnimatorSet();
        set.playSequentially(animator1, rotationAnimator1, animator2, rotationAnimator2, animator3, rotationAnimator3, animator4, rotationAnimator4);
        set.start();

    }


    private class MyStartDragingListener implements View.OnLongClickListener{

        @Override
        public boolean onLongClick(View view) {

            withDragShadow shadow = new withDragShadow(view);
            ClipData data = ClipData.newPlainText("","");
            view.startDrag(data,shadow,view,0);

            return false;
        }
    }

    private class MyDragListener implements View.OnDragListener{

        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {

            View v = (View)dragEvent.getLocalState();

            if(dragEvent.getAction()==DragEvent.ACTION_DROP){

                if(v.getId() == R.id.upBtn && view.getId() == R.id.Btn1)
                {
                    ((Button)view).setBackground(
                       ((Button)dragEvent.getLocalState()).getBackground());
                   v.setVisibility(View.GONE);
                   check1=true;
                   scoreNum = scoreNum+2;
                   Toast.makeText(getApplicationContext(),"Good Job!\nPoints: +2",Toast.LENGTH_SHORT).show();
                }
                else if(v.getId() == R.id.downBtn && view.getId() == R.id.Btn3)
                {
                    ((Button)view).setBackground(
                            ((Button)dragEvent.getLocalState()).getBackground());
                    v.setVisibility(View.GONE);
                    check3=true;
                    scoreNum = scoreNum+2;
                    Toast.makeText(getApplicationContext(),"Good Job!\nPoints: +2",Toast.LENGTH_SHORT).show();
                }
               else if(v.getId() == R.id.leftBtn && view.getId() == R.id.Btn2)
                {
                    ((Button)view).setBackground(
                            ((Button)dragEvent.getLocalState()).getBackground());
                    v.setVisibility(View.GONE);
                    check2=true;
                    scoreNum = scoreNum+2;
                    Toast.makeText(getApplicationContext(),"Good Job!\nPoints: +2",Toast.LENGTH_SHORT).show();
                }
                else if(v.getId() == R.id.rightBtn && view.getId() == R.id.Btn4)
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

    private class withDragShadow  extends View.DragShadowBuilder

    {
        public withDragShadow(View v)
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

    public void setLayout()
    {
        mStartDrag = new MyStartDragingListener();
        mDrag = new MyDragListener();
        img = (ImageView) findViewById(R.id.image) ;
        playAgain = (Button)findViewById(R.id.playAgain);
        playAgain.setVisibility(View.INVISIBLE);
        nextLevel = (TextView)findViewById(R.id.nxtLevel);
        nextLevel.setVisibility(View.INVISIBLE);
        score = (TextView)findViewById(R.id.scoreTxt);
        score.setVisibility(View.INVISIBLE);
        scoreNum=0;

        flagImage = (ImageView) findViewById(R.id.flagimage) ;
        findViewById(R.id.upBtn).setOnLongClickListener(mStartDrag);
        findViewById(R.id.downBtn).setOnLongClickListener(mStartDrag);
        findViewById(R.id.leftBtn).setOnLongClickListener(mStartDrag);
        findViewById(R.id.rightBtn).setOnLongClickListener(mStartDrag);

        findViewById(R.id.Btn1).setOnDragListener(mDrag);
        findViewById(R.id.Btn2).setOnDragListener(mDrag);
        findViewById(R.id.Btn3).setOnDragListener(mDrag);
        findViewById(R.id.Btn4).setOnDragListener(mDrag);

        run = (Button)findViewById(R.id.runBtn);
        run.setEnabled(false);

        img.setX(373);
        img.setY(350);

        flagImage.setX(362);
        flagImage.setY(385);

        nextLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity2.class);
                startActivity(intent);
                finish();
            }
        });
    }


}


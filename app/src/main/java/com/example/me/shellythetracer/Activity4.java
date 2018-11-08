package com.example.me.shellythetracer;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Activity4 extends AppCompatActivity {

    MyStartDragingListener4 mStartDrag4;
    MyDragListener4 mDrag4;
    boolean check1=false, check2=false, check3=false, check4=false, check5=false, check6=false, check7=false, check8 =false;
    Button run, playAgain;
    ImageView img1, flagImg1;
    TextView nextLevel, score;
    int scoreNum;

    Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDialog = new Dialog(this);
        setContentView(R.layout.activity_4);
        setLayouts();

        rulesDialog();
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
        }, 25000);
    }

    public void onPlayAgain(View view) {
        setContentView(R.layout.activity_4);
        setLayouts();
    }

    public void rulesDialog()
    {
        TextView cancel, rules;
        mDialog.setContentView(R.layout.rules_layout);
        cancel = (TextView)mDialog.findViewById(R.id.cancelBtn);
        rules = (TextView)mDialog.findViewById(R.id.rulesTxt);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.dismiss();
            }
        });

        rules.setText("1) In this stage, there will be more paths than the number of commands available. Hence you have to use \"repeat\" command.\n\n"+
                      "2) If you want to repeat certain commands, use \"repeat\" command -> then open braces command \"<\" -> then put the commands you want to repeat -> then close braces command \">\"" );

        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mDialog.show();
    }



    private class MyStartDragingListener4 implements View.OnLongClickListener{

        @Override
        public boolean onLongClick(View view) {

            withDragShadow4 shadow = new withDragShadow4(view);
            ClipData data = ClipData.newPlainText("","");
            view.startDrag(data,shadow,view,0);

            return false;
        }
    }

    private class MyDragListener4 implements View.OnDragListener{

        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {

            View v = (View)dragEvent.getLocalState();

            if(dragEvent.getAction()==DragEvent.ACTION_DROP){

                if((v.getId() == R.id.upBtn1 || v.getId() == R.id.upBtn2) && view.getId() == R.id.Btn1)
                {
                    ((Button)view).setBackground(
                            ((Button)dragEvent.getLocalState()).getBackground());
                    v.setVisibility(View.GONE);
                    ((Button) view).setText("");
                    check1=true;
                    scoreNum = scoreNum+2;
                    Toast.makeText(getApplicationContext(),"Good Job!\nPoints: +2",Toast.LENGTH_SHORT).show();
                }
                else if(v.getId() == R.id.repeatBtn && view.getId() == R.id.Btn2)
                {
                    ((Button)view).setBackground(
                            ((Button)dragEvent.getLocalState()).getBackground());
                    v.setVisibility(View.GONE);
                    ((Button) view).setText("");
                    check3=true;
                    scoreNum = scoreNum+2;
                    Toast.makeText(getApplicationContext(),"Good Job!\nPoints: +2",Toast.LENGTH_SHORT).show();
                }
                else if(v.getId() == R.id.leftBracket && view.getId() == R.id.Btn3)
                {
                    ((Button)view).setBackground(
                            ((Button)dragEvent.getLocalState()).getBackground());
                    v.setVisibility(View.GONE);
                    ((Button) view).setText("");
                    check2=true;
                    scoreNum = scoreNum+2;
                    Toast.makeText(getApplicationContext(),"Good Job!\nPoints: +2",Toast.LENGTH_SHORT).show();
                }
                else if((v.getId() == R.id.forwardBtn1 ||  v.getId() == R.id.forwardBtn2) && view.getId() == R.id.Btn4)
                {
                    ((Button)view).setBackground(
                            ((Button)dragEvent.getLocalState()).getBackground());
                    v.setVisibility(View.GONE);
                    ((Button) view).setText("");
                    check4=true;
                    scoreNum = scoreNum+2;
                    Toast.makeText(getApplicationContext(),"Good Job!\nPoints: +2",Toast.LENGTH_SHORT).show();
                }
                else if(v.getId() == R.id.downBtn && view.getId() == R.id.Btn5)
                {
                    ((Button)view).setBackground(
                            ((Button)dragEvent.getLocalState()).getBackground());
                    v.setVisibility(View.GONE);
                    ((Button) view).setText("");
                    check5=true;
                    scoreNum = scoreNum+2;
                    Toast.makeText(getApplicationContext(),"Good Job!\nPoints: +2",Toast.LENGTH_SHORT).show();
                }
                else if((v.getId() == R.id.forwardBtn1 || v.getId() == R.id.forwardBtn2) && view.getId() == R.id.Btn6) {
                    ((Button) view).setBackground(
                            ((Button) dragEvent.getLocalState()).getBackground());
                    v.setVisibility(View.GONE);
                    ((Button) view).setText("");
                    check6 = true;
                    scoreNum = scoreNum+2;
                    Toast.makeText(getApplicationContext(),"Good Job!\nPoints: +2",Toast.LENGTH_SHORT).show();
                }
                else if((v.getId() == R.id.upBtn1 || v.getId() == R.id.upBtn2) && view.getId() == R.id.Btn7) {
                    ((Button) view).setBackground(
                            ((Button) dragEvent.getLocalState()).getBackground());
                    v.setVisibility(View.GONE);
                    ((Button) view).setText("");
                    check7 = true;
                    scoreNum = scoreNum+2;
                    Toast.makeText(getApplicationContext(),"Good Job!\nPoints: +2",Toast.LENGTH_SHORT).show();
                }
                else if(v.getId() == R.id.rightBracket && view.getId() == R.id.Btn8) {
                    ((Button) view).setBackground(
                            ((Button) dragEvent.getLocalState()).getBackground());
                    v.setVisibility(View.GONE);
                    ((Button) view).setText("");
                    check8 = true;
                    scoreNum = scoreNum+2;
                    Toast.makeText(getApplicationContext(),"Good Job!\nPoints: +2",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    scoreNum = scoreNum-1;
                    Toast.makeText(getApplicationContext(),"Wrong position. Try again!\n             Points: -1",Toast.LENGTH_SHORT).show();
                }

                if(check1 && check2 && check3 && check4 && check5 && check6 && check7 && check8) run.setEnabled(true);

            }
            return true;
        }
    }

    private class withDragShadow4  extends View.DragShadowBuilder

    {
        public withDragShadow4(View v)
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

    public void onAnimation()
    {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(img1, "translationY",90f);
        animator1.setDuration(2000);

        ObjectAnimator rotationAnimator1 = ObjectAnimator.ofFloat(img1, "rotation", 90f);
        rotationAnimator1.setDuration(1000);

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(img1, "translationX",85f);
        animator2.setDuration(2000);

        ObjectAnimator rotationAnimator2 = ObjectAnimator.ofFloat(img1, "rotation", 180f);
        rotationAnimator2.setDuration(1000);

        ObjectAnimator animator3 = ObjectAnimator.ofFloat(img1, "translationY",260f);
        animator3.setDuration(2000);

        ObjectAnimator rotationAnimator3 = ObjectAnimator.ofFloat(img1, "rotation", 90f);
        rotationAnimator3.setDuration(1000);

        ObjectAnimator animator4 = ObjectAnimator.ofFloat(img1, "translationX",170f);
        animator4.setDuration(2000);

        ObjectAnimator rotationAnimator4 = ObjectAnimator.ofFloat(img1, "rotation", 0f);
        rotationAnimator4.setDuration(1000);

        ObjectAnimator animator5 = ObjectAnimator.ofFloat(img1, "translationY",90f);
        animator5.setDuration(2000);

        ObjectAnimator rotationAnimator5 = ObjectAnimator.ofFloat(img1, "rotation", 90f);
        rotationAnimator5.setDuration(1000);

        ObjectAnimator animator6 = ObjectAnimator.ofFloat(img1, "translationX",260f);
        animator6.setDuration(2000);

        ObjectAnimator rotationAnimator6 = ObjectAnimator.ofFloat(img1, "rotation", 180f);
        rotationAnimator6.setDuration(1000);

        ObjectAnimator animator7 = ObjectAnimator.ofFloat(img1, "translationY",260f);
        animator7.setDuration(2000);

        ObjectAnimator rotationAnimator7 = ObjectAnimator.ofFloat(img1, "rotation", 90f);
        rotationAnimator7.setDuration(1000);

        ObjectAnimator animator8 = ObjectAnimator.ofFloat(img1, "translationX",345f);
        animator8.setDuration(2000);

        ObjectAnimator rotationAnimator8 = ObjectAnimator.ofFloat(img1, "rotation", 0f);
        rotationAnimator8.setDuration(1000);

        ObjectAnimator animator9 = ObjectAnimator.ofFloat(img1, "translationY",90f);
        animator9.setDuration(2000);

        AnimatorSet set  = new AnimatorSet();
        set.playSequentially(animator1, rotationAnimator1, animator2, rotationAnimator2, animator3, rotationAnimator3, animator4, rotationAnimator4, animator5, rotationAnimator5, animator6, rotationAnimator6, animator7, rotationAnimator7, animator8, rotationAnimator8, animator9);
        set.start();
    }
    public void setLayouts()
    {
        mStartDrag4 = new MyStartDragingListener4();
        mDrag4 = new MyDragListener4();

        findViewById(R.id.upBtn1).setOnLongClickListener(mStartDrag4);
        findViewById(R.id.upBtn2).setOnLongClickListener(mStartDrag4);
        findViewById(R.id.forwardBtn1).setOnLongClickListener(mStartDrag4);
        findViewById(R.id.forwardBtn2).setOnLongClickListener(mStartDrag4);
        findViewById(R.id.repeatBtn).setOnLongClickListener(mStartDrag4);
        findViewById(R.id.rightBracket).setOnLongClickListener(mStartDrag4);
        findViewById(R.id.downBtn).setOnLongClickListener(mStartDrag4);
        findViewById(R.id.leftBracket).setOnLongClickListener(mStartDrag4);

        findViewById(R.id.Btn1).setOnDragListener(mDrag4);
        findViewById(R.id.Btn2).setOnDragListener(mDrag4);
        findViewById(R.id.Btn3).setOnDragListener(mDrag4);
        findViewById(R.id.Btn4).setOnDragListener(mDrag4);
        findViewById(R.id.Btn5).setOnDragListener(mDrag4);
        findViewById(R.id.Btn6).setOnDragListener(mDrag4);
        findViewById(R.id.Btn7).setOnDragListener(mDrag4);
        findViewById(R.id.Btn8).setOnDragListener(mDrag4);

        run = (Button)findViewById(R.id.runBtn);
        run.setEnabled(false);
        playAgain = (Button)findViewById(R.id.playAgain);
        playAgain.setVisibility(View.INVISIBLE);
        nextLevel = (TextView)findViewById(R.id.nxtLevel);
        nextLevel.setVisibility(View.INVISIBLE);
        score = (TextView)findViewById(R.id.scoreTxt);
        score.setVisibility(View.INVISIBLE);
        scoreNum=0;

        img1 = (ImageView)findViewById(R.id.img);
        flagImg1 = (ImageView)findViewById(R.id.flagimage1);

        img1.setX(5);
        img1.setY(260);

        flagImg1.setX(357f);
        flagImg1.setY(105f);

        nextLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}

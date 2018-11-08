package com.example.me.shellythetracer;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    Button startButton;
    Dialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        startButton = (Button)findViewById(R.id.startBtn);
        myDialog = new Dialog(this);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                levelPopUp();
            }
        });
    }


    public void levelPopUp()
    {
        TextView cancelAction;
        Button easy, hard;
        myDialog.setContentView(R.layout.level_layout);
        cancelAction = (TextView)myDialog.findViewById(R.id.cancelBtn);
        easy = (Button) myDialog.findViewById(R.id.easyBtn);
        hard = (Button) myDialog.findViewById(R.id.hardBtn);

        cancelAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stage1PopUp();
            }
        });

        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             stage2PopUp();
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

    }

    public void stage1PopUp()
    {
        TextView cancelAction;
        Button easyStage1, easyStage2;
        myDialog.setContentView(R.layout.stage_layout);
        cancelAction = (TextView)myDialog.findViewById(R.id.cancelBtn);
        easyStage1 = (Button) myDialog.findViewById(R.id.easystage1Btn);
        easyStage2 = (Button) myDialog.findViewById(R.id.easystage2Btn);

        cancelAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        easyStage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        easyStage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Activity2.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void stage2PopUp()
    {
        TextView cancelAction;
        Button hardStage1, hardStage2;
        myDialog.setContentView(R.layout.stage2_layout);
        cancelAction = (TextView)myDialog.findViewById(R.id.cancelBtn);
        hardStage1 = (Button) myDialog.findViewById(R.id.hardstage1Btn);
        hardStage2 = (Button) myDialog.findViewById(R.id.hardstage2Btn);

        cancelAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        hardStage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Activity3.class);
                startActivity(intent);
                finish();
            }
        });

        hardStage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Activity4.class);
                startActivity(intent);
                finish();
            }
        });

    }

}

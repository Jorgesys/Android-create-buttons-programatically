package com.jorgesys.createbuttons;

import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final LinearLayout linear = (LinearLayout)findViewById(R.id.my_layout);
        LinearLayout.LayoutParams sublparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams childparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams imageparams = new LinearLayout.LayoutParams(300, 300);
        linear.setOrientation(LinearLayout.VERTICAL);




        for(int i = 0; i < 10 ; i++){
            LinearLayout sublinear = new LinearLayout(this);
            Button btn = new Button(this);
            final ImageView img = new ImageView(this);
            TextView txt = new TextView(this);
            img.setImageResource(R.drawable.android);
            txt.setText("Android " + (i+1));
            btn.setBackgroundColor(Color.parseColor("#00FF00"));
            btn.setText("rotate Android "+ (i+1));
            btn.setElevation(25);
            txt.setLayoutParams(childparams);
            btn.setLayoutParams(imageparams);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    RotateAnimation anim = new RotateAnimation(0f, 350f, 15f, 15f);
                    anim.setInterpolator(new LinearInterpolator());
                    anim.setRepeatCount(Animation.INFINITE);
                    anim.setDuration(700);
                    // Start animating the image
                    img.startAnimation(anim);
                }
            });
            img.setLayoutParams(imageparams);
            linear.addView(txt);
            sublinear.addView(img);
            sublinear.addView(btn);
            linear.addView(sublinear, sublparams);
        }


        // Initialize a new RadioGroup
        RadioGroup radioGroup = new RadioGroup(getApplicationContext());
        //set padding
        radioGroup.setPadding(10,50,10,10); //left, top, rigth, bottom.
        //radioGroup.setOrientation(RadioGroup.HORIZONTAL);
        //create several radiobuttons
        for(int i=0; i<10; i++) {

            RadioButton radioButton = new RadioButton(getApplicationContext());
            radioButton.setText("RadioButton " + i);
            radioButton.setId(i);
            radioButton.setWidth(500);
            radioButton.setTextSize(14);
            radioButton.setTextColor(Color.parseColor("#0000FF")); //Blue color.
            radioButton.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            radioGroup.addView(radioButton);
        }

        linear.addView(radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int index) {
                for (int j = 0; j < radioGroup.getChildCount(); j++) {
                    if(j != index) {//Change other radiobuttons to default properties
                        RadioButton view = (RadioButton) radioGroup.getChildAt(j);
                        view.setTextSize(14);
                        view.setTextColor(Color.parseColor("#0000FF"));
                    }else{
                        //Change radiobutton properties on click.
                        RadioButton radiobutton = (RadioButton) findViewById(j);
                        radiobutton.setTextSize(24);
                        radiobutton.setTextColor(Color.parseColor("#FF0000"));
                    }
                }

            }
        });

    }
}

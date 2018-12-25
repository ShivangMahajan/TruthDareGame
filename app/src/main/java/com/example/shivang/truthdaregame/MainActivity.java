package com.example.shivang.truthdaregame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Random random=new Random();
    private int lastDirection=0;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=findViewById(R.id.bottle);
        button=findViewById(R.id.spinbtn);
    }

    public void spin(View view)
    {
        int newDirection=random.nextInt(361)+random.nextInt(1801);
        if(newDirection<lastDirection)
            newDirection+=lastDirection;
        float pivotx=imageView.getWidth()/2;
        float pivoty=imageView.getHeight()/2;
        RotateAnimation rotate=new RotateAnimation(lastDirection,newDirection,pivotx,pivoty);
        rotate.setDuration(2000);
        imageView.startAnimation(rotate);
        rotate.setFillAfter(true);
        lastDirection=newDirection;
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

                button.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                button.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


}

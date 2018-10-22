package com.example.tween;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity  implements View.OnClickListener{
ImageView image;
//Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        image= (ImageView) findViewById(R.id.image);
//        button= (Button) findViewById(R.id.button);
        image.setOnClickListener(this);

    }

    public void myClick(View view) {
//        overridePendingTransition(R.anim.anim_enlarge,R.anim.anim_enlarge);
      /*  overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

        //通过加载XML动画设置文件来创建一个Animation对象；
        Animation animation= AnimationUtils.loadAnimation(this, R.anim.anim_enlarge);

        image.setAnimation(animation);*/
    }

    @Override
    public void onClick(View v) {
//                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        //通过加载XML动画设置文件来创建一个Animation对象；
        Animation animation= AnimationUtils.loadAnimation(Main2Activity.this, R.anim.anim_enlarge);
        animation.setFillAfter(true);
        image.startAnimation(animation);
    }
}

package com.example.property;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * 属性动画
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView= (ImageView) findViewById(R.id.mImageView);
        mImageView.setOnClickListener(this);
    }

    /**
     * 平移
     * @param view
     */
    public void ButtonTranslate(View view) {
      /*  //加载动画文件
        Animator animator= AnimatorInflater.loadAnimator();
        ObjectAnimator objectAnimator= (ObjectAnimator) animator;
        objectAnimator.setTarget(mImageView);//设置执行动画的目标
        objectAnimator.start();//启动动画*/
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mImageView, "translationY", 0, 100);
        objectAnimator=ObjectAnimator.ofPropertyValuesHolder(mImageView,PropertyValuesHolder.ofFloat("translationY",0,100),
                PropertyValuesHolder.ofFloat("translationX",0,100));
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this,"我被点击了",Toast.LENGTH_SHORT).show();
    }

    /**
     * 缩放动画
     * @param view
     */
    public void ButtonScale(View view) {
        /*Animator animator = AnimatorInflater.loadAnimator();
        animator.setTarget(mImageView);
        animator.start();*/
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mImageView, "scaleY", 1, 2);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }

    /**
     * 动画集合
     * @param view
     */
    public void ButtonAll(View view) {
        AnimatorSet set=new AnimatorSet();
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(mImageView, "scaleY", 1, 2);
        objectAnimator1.setDuration(2000);

        ObjectAnimator objectAnimator2=ObjectAnimator.ofPropertyValuesHolder(mImageView,PropertyValuesHolder.ofFloat("translationY",0,100),
                PropertyValuesHolder.ofFloat("translationX",0,100));
        objectAnimator2.setDuration(2000);
        set.playTogether(objectAnimator1,objectAnimator2);//动画集合一起执行
//        set.playSequentially(objectAnimator1,objectAnimator2);//动画集合按先后顺序执行
        set.start();
    }
}

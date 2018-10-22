package com.example.administrator.android18;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * 帧动画
 */
public class MainActivity extends AppCompatActivity {
    private ImageView mImageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageview= (ImageView) findViewById(R.id.mImageView);
        //获取到控件的背景对象(静态)
        Drawable background = mImageview.getBackground();
        //AnimationDrawable  extends Drawable
        //强制转换为动态背景
        AnimationDrawable drawable= (AnimationDrawable)background;
        //把动态背景给控件
//        mImageview.setBackground(drawable);（可要可不要）
        drawable.start();
    }
}

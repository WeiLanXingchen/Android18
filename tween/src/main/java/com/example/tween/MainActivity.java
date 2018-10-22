package com.example.tween;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * 补间动画
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.mImageView);
        mImageView.setOnClickListener(this);
    }

    //点击平移
    public void ButtonTanslate(View view) {
        //通过动画布局文件
        //通过动画工具类加载布局文件中的动画
       /* Animation animation = AnimationUtils.loadAnimation(this,R.transition.my_translate);
        //动画文件是以translate作为根节点，所以可以转换为平移动画
        TranslateAnimation translateAnimation= (TranslateAnimation) animation;
        //让图片控件执行平移动画
        mImageView.startAnimation(translateAnimation);*/
        /**
         * 第1个参数：起始的x坐标
         * 第2个参数：结束的x坐标
         * 第3个参数：起始的y坐标
         * 第4个参数：结束的y坐标
         *
         */

        TranslateAnimation translateAnimation = new TranslateAnimation(0, 200, 0, 200);
        /**
         * 第1，2个参数：起始的x坐标=控件的宽度/父布局的宽度*第2个参数
         * 第3,4个参数：结束的x坐标起=控件的宽度/父布局的宽度*第4个参数
         * 第5,6个参数：起始的y坐标=控件的宽度/父布局的宽度*第6个参数
         * 第7,8个参数：结束的y坐标=控件的宽度/父布局的宽度*第8个参数
         *Animation.RELATIVE_TO_PARENT：相对于控件父布局
         * RELATIVE_TO_SELF:相对于控件本身
         */
        translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_PARENT, 0.5f,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0);
        translateAnimation.setDuration(2000);//设置动画时间
        translateAnimation.setRepeatCount(Animation.INFINITE);//设置重复次数
        translateAnimation.setRepeatMode(Animation.REVERSE);//设置重复模式

        translateAnimation.setFillAfter(true);//设置保持最后动画效果
        mImageView.startAnimation(translateAnimation);
    }

    /**
     * @param v
     */
    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "我被点击了", Toast.LENGTH_SHORT).show();
        AnimationSet set = new AnimationSet(false);//false表各自展示各自频率的动画
       /* AlphaAnimation alphaAnimation=new AlphaAnimation(1,0);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setRepeatCount(1);*/
        ScaleAnimation scaleAnimation = new ScaleAnimation(1, 2, 1, 2, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setRepeatMode(Animation.RESTART);
        scaleAnimation.setFillAfter(true);
//        RotateAnimation rotateAnimation=new RotateAnimation(0,270,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//        rotateAnimation.setDuration(2000);
//        RotateAnimation rotateAnimation=new RotateAnimation(0,270);
//        rotateAnimation=new RotateAnimation(0,270,mImageView.getWidth()/2,mImageView.getHeight()/2);
//        rotateAnimation=new RotateAnimation(0,270,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        RotateAnimation rotateAnimation = new RotateAnimation(0, 90, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setFillAfter(true);

        set.addAnimation(scaleAnimation);
        set.addAnimation(rotateAnimation);
        mImageView.startAnimation(set);
    }

    /**
     * 点击缩放
     *
     * @param view
     */
    public void ButtonScale(View view) {
       /* Animation animation = AnimationUtils.loadAnimation();
        ScaleAnimation scaleAnimation= (ScaleAnimation) animation;
        mImageView.startAnimation(scaleAnimation);*/
        /**
         * 第1个参数：起始的控件大小=控件本身宽度*第1个参数
         * 第2个参数：结束的控件大小=控件本身宽度*第2个参数
         * 第3个参数：起始的控件大小=控件本身高度*第3个参数
         * 第4个参数：结束的控件大小=控件本身高度*第4个参数
         *第5个参数：缩放中心点的X坐标
         *第6个参数：缩放中心点的Y坐标
         */
        ScaleAnimation scaleAnimation = new ScaleAnimation(1, 2, 1, 2);
        scaleAnimation = new ScaleAnimation(1, 2, 1, 2, mImageView.getWidth() / 2, mImageView.getWidth() / 2);
        /**
         * 第1个参数：起始的控件大小=控件本身宽度*第1个参数
         * 第2个参数：结束的控件大小=控件本身宽度*第2个参数
         * 第3个参数：起始的控件大小=控件本身高度*第3个参数
         * 第4个参数：结束的控件大小=控件本身高度*第4个参数
         *第5,6个参数：缩放中心点的X坐标=控件的宽度*第5个参数
         *第7,8个参数：缩放中心点的Y坐标=控件的高度*第7个参数
         */
        scaleAnimation = new ScaleAnimation(1, 2, 1, 2, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(2000);
        scaleAnimation.setRepeatMode(Animation.RESTART);
        mImageView.startAnimation(scaleAnimation);
    }

    /**
     * 透明度
     *
     * @param view
     */
    public void ButtonAlpha(View view) {
        /*Animation animation=AnimationUtils.loadAnimation();
        AlphaAnimation alphaAnimation= (AlphaAnimation) animation;
        mImageView.startAnimation(alphaAnimation);*/
        AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setRepeatCount(2);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        mImageView.startAnimation(alphaAnimation);
    }

    /**
     * 旋转
     *
     * @param view
     */
    public void ButtonRotate(View view) {
       /* Animation animation=AnimationUtils.loadAnimation();
        RotateAnimation rotateAnimation= (RotateAnimation) animation;
        mImageView.startAnimation(rotateAnimation);*/
        RotateAnimation rotateAnimation = new RotateAnimation(0, 270);
//        rotateAnimation=new RotateAnimation(0,270,mImageView.getWidth()/2,mImageView.getHeight()/2);
//        rotateAnimation=new RotateAnimation(0,270,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation = new RotateAnimation(0, 90, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setFillAfter(true);
        mImageView.startAnimation(rotateAnimation);
        //绑定动画的监听器
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    /**
     * 动画集
     *
     * @param view
     */
    public void ButtonAll(View view) {
        AnimationSet set = new AnimationSet(false);//false表各自展示各自频率的动画
       /* AlphaAnimation alphaAnimation=new AlphaAnimation(1,0);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setRepeatCount(1);*/
        ScaleAnimation scaleAnimation = new ScaleAnimation(1, 2, 1, 2, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setRepeatMode(Animation.RESTART);
        scaleAnimation.setFillAfter(true);
//        RotateAnimation rotateAnimation=new RotateAnimation(0,270,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//        rotateAnimation.setDuration(2000);
//        RotateAnimation rotateAnimation=new RotateAnimation(0,270);
//        rotateAnimation=new RotateAnimation(0,270,mImageView.getWidth()/2,mImageView.getHeight()/2);
//        rotateAnimation=new RotateAnimation(0,270,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        RotateAnimation rotateAnimation = new RotateAnimation(0, 90, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setFillAfter(true);

        set.addAnimation(scaleAnimation);
        set.addAnimation(rotateAnimation);
        mImageView.startAnimation(set);
    }
}

package com.zoltarianie.bazgroszytpainting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Animation btn_in;
    Animation btn_out;
    ImageView sg_btnplay;
    public void efClickBtnPlay(View view) {
        sg_btnplay = (ImageView) findViewById(R.id.sg_btnplay);
        btn_in = AnimationUtils.loadAnimation(this, R.anim.sg_btn_anim_in);
        btn_out = AnimationUtils.loadAnimation(this, R.anim.sg_btn_anim_out);
        sg_btnplay.startAnimation(btn_in);
        btn_in.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation arg0) {
                sg_btnplay.startAnimation(btn_out);
            }
        });
        btn_out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation arg0) {
                Intent intent = new Intent(getApplicationContext(), ChooseCategory.class);
                startActivity(intent);
            }
        });
    }
}

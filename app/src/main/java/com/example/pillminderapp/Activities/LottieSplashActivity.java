package com.example.pillminderapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.example.pillminderapp.Activities.LoginActivity;
import com.example.pillminderapp.Activities.MainActivity;
import com.example.pillminderapp.R;

@SuppressLint("CustomSplashScreen")
public class LottieSplashActivity extends AppCompatActivity {


    private LottieAnimationView lottie_LOTTIE_animation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie_splash);
        findViews();
        lottie_LOTTIE_animation.resumeAnimation();
        lottie_LOTTIE_animation.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(@NonNull Animator animation) {

            }

            @Override
            public void onAnimationEnd(@NonNull Animator animation) {
                TransactToMainActivity();
            }

            @Override
            public void onAnimationCancel(@NonNull Animator animation) {

            }

            @Override
            public void onAnimationRepeat(@NonNull Animator animation) {

            }
        });
    }

    private void findViews() {
        lottie_LOTTIE_animation = findViewById(R.id.lottie_LOTTIE_animation);
    }

    private void TransactToMainActivity() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
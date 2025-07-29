package com.example.randomquotegenerator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Fade-in animation for logo and text
        ImageView logo = findViewById(R.id.splashLogo);
        TextView appName = findViewById(R.id.splashAppName);
        TextView tagline = findViewById(R.id.splashTagline);
        TextView quote = findViewById(R.id.splashQuote);
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(1000);
        ScaleAnimation scale = new ScaleAnimation(
                0.8f, 1.0f, // fromX, toX
                0.8f, 1.0f, // fromY, toY
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(1000);
        logo.startAnimation(fadeIn);
        appName.startAnimation(fadeIn);
        appName.startAnimation(scale);
        tagline.startAnimation(fadeIn);
        // Zoom-in with bounce for quote
        ScaleAnimation zoomBounce = new ScaleAnimation(
                0.7f, 1.0f, // fromX, toX
                0.7f, 1.0f, // fromY, toY
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        zoomBounce.setDuration(1200);
        zoomBounce.setInterpolator(new BounceInterpolator());
        quote.startAnimation(zoomBounce);

        // List of quotes with authors
        String[] quotes = new String[] {
                "The best way to get started is to quit talking and begin doing.\n- Walt Disney",
                "Success is not the key to happiness. Happiness is the key to success.\n- Albert Schweitzer",
                "In the middle of every difficulty lies opportunity.\n- Albert Einstein",
                "Believe you can and you're halfway there.\n- Theodore Roosevelt",
                "The only way to do great work is to love what you do.\n- Steve Jobs",
                "Opportunities don't happen, you create them.\n- Chris Grosser",
                "Strive not to be a success, but rather to be of value.\n- Albert Einstein",
                "Act as if what you do makes a difference. It does.\n- William James",
                "Dream big and dare to fail.\n- Norman Vaughan",
                "You are never too old to set another goal or to dream a new dream.\n- C.S. Lewis"
        };
        java.util.Random random = new java.util.Random();
        String randomQuote = quotes[random.nextInt(quotes.length)];
        quote.setText(randomQuote);

        // Delay and start MainActivity
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }, 1500);
    }
} 
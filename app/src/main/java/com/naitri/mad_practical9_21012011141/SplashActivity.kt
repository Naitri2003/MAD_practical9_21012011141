package com.naitri.mad_practical9_21012011141

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.RotateDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation
import android.widget.ImageView
class SplashActivity : AppCompatActivity(), Animation.AnimationListener {
    lateinit var logonanimation:AnimationDrawable
    lateinit var image3:ImageView
    lateinit var logoanimation:Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val image:ImageView=findViewById(R.id.uvpce_logo)
        image.setBackgroundResource(R.drawable.uvpce_logo_animation)
        logonanimation=image.background as AnimationDrawable
        logoanimation = AnimationUtils.loadAnimation(this , R.anim.twin_animation)
        logoanimation.setAnimationListener(this)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if(hasFocus){
            image3.startAnimation(logoanimation)
            logonanimation.start()
        }
        else{
            logonanimation.stop()
        }
        super.onWindowFocusChanged(hasFocus)
    }
    override fun onAnimationStart(p0: Animation?) {

    }

    override fun onAnimationEnd(p0: Animation?) {
        Intent(this , MainActivity::class.java).apply { startActivity(this) }
    }

    override fun onAnimationRepeat(p0: Animation?) {
    }
}


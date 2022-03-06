package com.example.android.minipaint

import android.os.Build
import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myCanvasView = MyCanvasView(this)
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R){
            myCanvasView.systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN
            myCanvasView.contentDescription = getString(R.string.canvasContentDescription)
            setContentView(myCanvasView)
        } else {
            myCanvasView.windowInsetsController?.let {
                it.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                window.navigationBarColor = getColor(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)
                it.hide(WindowInsets.Type.systemBars())
            }
            myCanvasView.contentDescription = getString(R.string.canvasContentDescription)
            setContentView(myCanvasView)
        }


    }
}
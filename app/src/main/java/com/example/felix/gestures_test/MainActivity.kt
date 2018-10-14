package com.example.felix.gestures_test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var mainCanvas: CustomCanvas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainLayout = findViewById<LinearLayout>(R.id.main_layout)
        mainCanvas = CustomCanvas(this)
        mainLayout.addView(mainCanvas)

        mainLayout.setOnTouchListener() {
            view, motionEvent -> mainCanvas.displayLines(motionEvent)
        }
    }

}

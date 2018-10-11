package com.example.felix.gestures_test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    private lateinit var mainCanvas: CustomCanvas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainLayout = findViewById<LinearLayout>(R.id.main_layout)
        mainCanvas = CustomCanvas(this)
        mainLayout.addView(mainCanvas)

        mainLayout.setOnTouchListener() { view, motionEvent -> onLayoutClick(view, motionEvent) }
    }

    private fun onLayoutClick(v: View, motionEvent: MotionEvent): Boolean {
        if (motionEvent.action == MotionEvent.ACTION_DOWN)
            mainCanvas.drawCircle = true
        else if (motionEvent.action == MotionEvent.ACTION_UP)
            mainCanvas.drawCircle = false

        mainCanvas.refreshCircle(motionEvent.x, motionEvent.y)
        return true
    }

}

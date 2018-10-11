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

        mainLayout.setOnTouchListener() { view, motionEvent -> onLayoutClick(view, motionEvent) }
    }

    private fun onLayoutClick(v: View, motionEvent: MotionEvent): Boolean {
        if (motionEvent.action == MotionEvent.ACTION_DOWN)
            mainCanvas.drawCircle = true
        else if (motionEvent.action == MotionEvent.ACTION_UP)
            mainCanvas.drawCircle = false
        if (motionEvent.pointerCount > 1) {
            val x = (motionEvent.getX(0) + motionEvent.getX(1)) / 2
            val y = (motionEvent.getY(0) + motionEvent.getY(1)) / 2
            mainCanvas.refreshCircle(x, y, getDistanceBetweenFingers(motionEvent) / 2)
        } else
            mainCanvas.refreshCircle(motionEvent.x, motionEvent.y)
        return true
    }

    fun getDistanceBetweenFingers(motionEvent: MotionEvent): Float {
        val xDistance = Math.abs(motionEvent.getX(0) - motionEvent.getX(1))
        val yDistance = Math.abs(motionEvent.getY(0) - motionEvent.getY(1))
        return sqrt(xDistance.pow(2) + yDistance.pow(2))
    }

}

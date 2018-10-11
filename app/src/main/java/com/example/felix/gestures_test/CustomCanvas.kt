package com.example.felix.gestures_test

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View

class CustomCanvas(context: Context): View(context) {

    private var circleX = 0F
    private var circleY = 0F
    private var circleSize = 100F
    private val paint = Paint()
    var drawCircle = false

    init {
        paint.style = Paint.Style.FILL
        paint.setARGB(255, 255, 0, 0)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if(drawCircle)
            canvas.drawCircle(circleX, circleY, circleSize, paint)
    }

    fun refreshCircle(x: Float, y: Float, size: Float = 100F) {
        circleX = x
        circleY = y
        circleSize = size
        this.invalidate()
    }

}
package com.example.felix.gestures_test

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View

class CustomCanvas(context: Context) : View(context) {
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val paint = Paint()
        paint.setStyle(Paint.Style.FILL)
        paint.setARGB(255, 255, 0, 0)
        canvas.drawCircle(50F, 50F, 50F, paint)
    }
}
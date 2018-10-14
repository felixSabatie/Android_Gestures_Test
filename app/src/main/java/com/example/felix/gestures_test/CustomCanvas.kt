package com.example.felix.gestures_test

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Point
import android.view.MotionEvent
import android.view.View

class CustomCanvas(context: Context): View(context) {

    private val paint = Paint()
    private var coordinates = ArrayList<Coordinates>()

    init {
        paint.style = Paint.Style.FILL
        paint.setARGB(255, 0, 255, 0)
        paint.strokeWidth = 6F
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if(coordinates.count() > 0) {
            val centerPoint = getCenterPoint()
            coordinates.forEach {
                canvas.drawLine(it.x, it.y, centerPoint.x, centerPoint.y, paint)
            }
            canvas.drawCircle(centerPoint.x, centerPoint.y, 20F, paint)
        }
    }

    fun displayLines(motionEvent: MotionEvent): Boolean {
        coordinates.clear()
        if (motionEvent.pointerCount > 1) {
            for (i in 1..motionEvent.pointerCount) {
                coordinates.add(Coordinates(motionEvent.getX(i - 1), motionEvent.getY(i - 1)))
            }
        }

        this.invalidate()
        return true
    }

    fun getCenterPoint(): Coordinates {
        val x = coordinates.sumByDouble { it.x.toDouble() }.toFloat() / coordinates.count()
        val y = coordinates.sumByDouble { it.y.toDouble() }.toFloat() / coordinates.count()
        return Coordinates(x, y)
    }
}
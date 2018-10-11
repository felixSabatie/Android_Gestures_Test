package com.example.felix.gestures_test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainLayout = findViewById<LinearLayout>(R.id.main_layout)
        mainLayout.addView(CustomCanvas(this))
    }


}

package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.myapplication.R.drawable
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(drawable.ic_launcher)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}

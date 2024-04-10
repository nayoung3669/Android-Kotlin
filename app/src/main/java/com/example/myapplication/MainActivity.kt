package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.view.View
import android.widget.TextView
import com.example.myapplication.R.drawable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tv1 : TextView
        var tv2 : TextView
        var tv3 : TextView
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(drawable.ic_launcher)

        tv1 = findViewById<TextView>(R.id.textView1)
        tv2 = findViewById<TextView>(R.id.textView2)
        tv3 = findViewById<TextView>(R.id.textView3)

        tv1.setText("안녕하세요")
        tv1.setTextColor(Color.RED)
        tv2.setText("Textview 연습 2")
        tv2.setTextSize(30.0f)
        tv2.setTypeface(android.graphics.Typeface.SERIF,
            android.graphics.Typeface.BOLD_ITALIC)
        tv3.setText("가나다라마바사아자차카타파하가나다라마바사아자차카타파하")
        tv3.setSingleLine()

    }
}
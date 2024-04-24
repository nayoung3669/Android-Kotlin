package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.myapplication.R.drawable
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    lateinit internal var edit1: EditText
    lateinit internal var edit2: EditText
    lateinit internal var btnAdd: Button
    lateinit internal var btnSub: Button
    lateinit internal var btnMul: Button
    lateinit internal var btnDiv: Button
    lateinit internal var textResult: TextView
    lateinit internal var num1: String
    lateinit internal var num2: String
    internal var result: Int? = null
    internal var numButtons = ArrayList<Button>(10)
    internal var numBtnIDs = arrayOf(
        R.id.BtnNum0,
        R.id.BtnNum1,
        R.id.BtnNum2,
        R.id.BtnNum3,
        R.id.BtnNum4,
        R.id.BtnNum5,
        R.id.BtnNum6,
        R.id.BtnNum7,
        R.id.BtnNum8,
        R.id.BtnNum9
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(drawable.ic_launcher)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}

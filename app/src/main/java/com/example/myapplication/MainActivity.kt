package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.myapplication.R.drawable
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    lateinit var edit1: EditText;
    lateinit var edit2: EditText
    lateinit var btnAdd: Button;
    lateinit var btnSubtract: Button
    lateinit var btnMultiply: Button;
    lateinit var btnDivide: Button
    lateinit var btnSquare: Button;
    lateinit var textResult: TextView
    lateinit var num1: String;
    lateinit var num2: String
    var result: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        title = "초간단 계산기"
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(drawable.ic_launcher)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edit1 = findViewById(R.id.Edit1)
        edit2 = findViewById(R.id.Edit2)
        textResult = findViewById(R.id.TextResult)

        btnAdd = findViewById(R.id.BtnAdd)
        btnSubtract = findViewById(R.id.BtnSubtract)
        btnMultiply = findViewById(R.id.BtnMultiply)
        btnDivide = findViewById(R.id.BtnDivide)
        btnSquare = findViewById(R.id.BtnSquare)

        btnAdd.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) + Integer.parseInt(num2)
            textResult.text = "계산 결과 : " + result.toString()
            false
        }

        btnSubtract.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) - Integer.parseInt(num2)
            textResult.text = "계산 결과 : " + result.toString()
            false
        }

        btnMultiply.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) * Integer.parseInt(num2)
            textResult.text = "계산 결과 : " + result.toString()
            false
        }

        btnDivide.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) / Integer.parseInt(num2)
            textResult.text = "계산 결과 : " + result.toString()
            false
        }

        btnSquare.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if (num2.isNotEmpty()) {
                result = Integer.parseInt(num1).toDouble().pow(Integer.parseInt(num2)).toInt()
                textResult.text = "계산 결과 : $result"
            } else {
                textResult.text = "두 번째 숫자를 입력해주세요."
            }
            false
        }
    }
}

package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "명화 선호도 투표"

        var voteCount = IntArray(9)
        for (i in 0..8)
            voteCount[i] = 0
        var image = arrayOfNulls<ImageView>(9)
        var imageId = arrayOf(
            R.id.iv1, R.id.iv2, R.id.iv3,
            R.id.iv4, R.id.iv5, R.id.iv6,
            R.id.iv7, R.id.iv8, R.id.iv9
        )
        var imgName =
            arrayOf(
                "name1", "name2", "name3",
                "name4", "name5", "name6",
                "name7", "name8", "name9"
            )


        for (i in imageId.indices) {
            image[i] = findViewById(imageId[i])
            image[i]!!.setOnClickListener {
                voteCount[i]++
                Toast.makeText(
                    applicationContext,
                    imgName[i] + ": 총 " + voteCount[i] + "표",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
        var btnFinish = findViewById<Button>(R.id.btnResult)

        btnFinish.setOnClickListener {
            var intent = Intent(applicationContext, ResultActivity::class.java)
            intent.putExtra("VoteCount", voteCount)
            intent.putExtra("ImageName", imgName)
            startActivity(intent)
        }
    }
}
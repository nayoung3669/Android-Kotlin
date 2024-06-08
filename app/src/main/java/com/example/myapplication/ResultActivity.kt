package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView

class ResultActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)
        title = "투표 결과"

        var intent = intent
        var voteResult = intent.getIntArrayExtra("VoteCount")
        val imageName = intent.getStringArrayExtra("ImageName") ?: emptyArray<String>()
        var tv = arrayOfNulls<TextView>(imageName.size)
        var rbar = arrayOfNulls<RatingBar>(imageName.size)

        var tvID = arrayOf(
            R.id.tv1,
            R.id.tv2,
            R.id.tv3,
            R.id.tv4,
            R.id.tv5,
            R.id.tv6,
            R.id.tv7,
            R.id.tv8,
            R.id.tv9
        )
        var rbarID = arrayOf(
            R.id.rbar1,
            R.id.rbar2,
            R.id.rbar3,
            R.id.rbar4,
            R.id.rbar5,
            R.id.rbar6,
            R.id.rbar7,
            R.id.rbar8,
            R.id.rbar9
        )

        for (i in voteResult!!.indices) {
            tv[i] = findViewById(tvID[i])
            rbar[i] = findViewById(rbarID[i])
        }

        for (i in voteResult.indices) {
            tv[i]!!.setText(imageName[i])
            rbar[i]!!.setRating(voteResult[i].toFloat())
        }

        var btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener{
            finish()
        }
    }
}
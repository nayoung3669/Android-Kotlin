package com.example.myapplication

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    lateinit var ibZoomin: ImageButton
    lateinit var ibZoomout: ImageButton
    lateinit var ibRotate: ImageButton
    lateinit var ibBright: ImageButton
    lateinit var ibDark: ImageButton
    lateinit var ibGray: ImageButton
    lateinit var graphicView: MyGraphicView

    companion object{
        var sX = 1f
        var sY = 1f
        var angle = 0f
        var color = 1f
        var satur = 1f
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setIcon(R.drawable.ic_launcher)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        title = "미니 포토샵"

        var pictureLayout = findViewById<LinearLayout>(R.id.pictureLayout)
        graphicView = MyGraphicView(this)
        pictureLayout.addView(graphicView)

        clickIcons()

    }

    class MyGraphicView(context: Context): View(context){
        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)

            var picture = BitmapFactory.decodeResource(resources, R.drawable.dog)

            var cenX = this.width/2f
            var cenY = this.height/2f
            canvas.scale(sX, sY, cenX, cenY)
            canvas.rotate(angle, cenX, cenY)

            var picX = (this.width - picture.width)/2f
            var picY = (this.height - picture.height)/2f
            canvas.drawBitmap(picture, picX, picY, null)

            val paint = Paint()
            val array = floatArrayOf(color, 0f, 0f, 0f, 0f,
                0f, color, 0f, 0f, 0f,
                0f, 0f, color, 0f, 0f,
                0f, 0f, 0f, 1f, 0f)
            val cm = ColorMatrix(array)

            if(satur == 0f) cm.setSaturation(satur)

            paint.colorFilter = ColorMatrixColorFilter(cm)
            canvas.drawBitmap(picture, picX, picY, paint)

            picture.recycle()

        }
    }

    private fun clickIcons(){
        ibZoomin = findViewById(R.id.ibZoomin)
        ibZoomin.setOnClickListener {
            sX = sX + 0.2f
            sY = sY + 0.2f
            graphicView.invalidate()
        }

        ibZoomout = findViewById(R.id.ibZoomout)
        ibZoomout.setOnClickListener {
            sX = sX - 0.2f
            sY = sY - 0.2f
            graphicView.invalidate()
        }

        ibRotate = findViewById(R.id.ibRotate)
        ibRotate.setOnClickListener {
            angle = angle + 20
            graphicView.invalidate()
        }

        ibBright = findViewById(R.id.ibBright)
        ibBright.setOnClickListener {
            color = color + 0.2f
            graphicView.invalidate()
        }

        ibDark = findViewById(R.id.ibDark)
        ibDark.setOnClickListener {
            color = color - 0.2f
            graphicView.invalidate()
        }

        ibGray = findViewById(R.id.ibGray)
        ibGray.setOnClickListener {
            if(satur == 0f)
                satur = 1f
            else
                satur = 0f
            graphicView.invalidate()
        }
    }
}
package com.example.myapplication

import android.app.Activity
import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.Paint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "암시적 인텐트 예제"

        var btnDial = findViewById<Button>(R.id.btnDial)
        var btnWeb = findViewById<Button>(R.id.btnWeb)
        var btnGoogle = findViewById<Button>(R.id.btnGoogle)
        var btnSearch = findViewById<Button>(R.id.btnSearch)
        var btnSms = findViewById<Button>(R.id.btnSms)
        var btnPhoto = findViewById<Button>(R.id.btnPhoto)

        btnDial.setOnClickListener {
            var uri = Uri.parse("tel:010-1234-3849")
            var intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }

        btnWeb.setOnClickListener {
            var uri = Uri.parse("https://www.google.com/")
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        btnGoogle.setOnClickListener {
            var uri =
                Uri.parse("https://www.google.co.kr/maps/place/%EA%B0%80%EC%B2%9C%EB%8C%80%ED%95%99%EA%B5%90+%EA%B8%80%EB%A1%9C%EB%B2%8C%EC%BA%A0%ED%8D%BC%EC%8A%A4/@37.4510282,127.1294041,17z/data=!4m15!1m8!3m7!1s0x357ca8a5b5998fd7:0xc9a7e24e2909c1ad!2z64yA7ZWc66-86rWtIOqyveq4sOuPhCDshLHrgqjsi5wg7IiY7KCV6rWsIOyEseuCqOuMgOuhnCAxMzQy!3b1!8m2!3d37.4510282!4d127.1294041!16s%2Fg%2F11bzmg8pb0!3m5!1s0x357ca8a401f3127b:0x39d64e7ee201cd15!8m2!3d37.4507128!4d127.1288495!16s%2Fm%2F0j6766j?hl=ko&entry=ttu")
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        btnSearch.setOnClickListener {
            var intent = Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY, "안드로이드")
            startActivity(intent)
        }

        btnSms.setOnClickListener {
            var intent = Intent(Intent.ACTION_SENDTO)
            intent.putExtra("sms_body", "안녕하세요?")
            intent.data = Uri.parse("smsto:" + Uri.encode("010-1234-1234"))
            startActivity(intent)
        }

        btnPhoto.setOnClickListener {
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
    }

}
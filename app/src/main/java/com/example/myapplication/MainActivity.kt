package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "토스트 연습"

        var button1 = findViewById<Button>(R.id.button1)

        //기본 대화상자
//        button1.setOnClickListener {
//            var dlg = AlertDialog.Builder(this@MainActivity)
//            dlg.setTitle("제목입니다.")
//            dlg.setIcon(R.mipmap.ic_launcher)
//            dlg.setMessage("이곳이 내용입니다.")
//
//            dlg.setPositiveButton("확인"){ dialog, which ->
//                Toast.makeText(this@MainActivity,
//                    "확인을 눌렀네요", Toast.LENGTH_SHORT).show()
//            }
//            dlg.setPositiveButton("확인", null)
//            dlg.show()
//        }

        //목록 대화상자
//        button1.setOnClickListener {
//            var versionArray = arrayOf("오레오", "파이", "큐(10)")
//            var dlg = AlertDialog.Builder(this@MainActivity) //dlg.setTitle("제목입니다.")
//            dlg.setTitle("좋아하는 버전은?")
//            dlg.setIcon(R.mipmap.ic_launcher)
//            dlg.setItems(versionArray) { dialog, which ->
//                button1.text = versionArray[which]
//            }
//            dlg.setPositiveButton("닫기", null)
//            dlg.show()
//
//        }

        //동시선택 대화 샂아
        button1.setOnClickListener {
            var versionArray = arrayOf("오레오", "파이", "큐(10)")
            var dlg = AlertDialog.Builder(this@MainActivity)
            var checkArray = booleanArrayOf(true, false, false)
            dlg.setTitle("좋아하는 버전은?")
            dlg.setMultiChoiceItems(versionArray,
                checkArray) { dialog, which, isChecked ->
                button1.text = versionArray[which]
            }
            dlg.setPositiveButton("닫기", null)
            dlg.show()

        }
    }
}
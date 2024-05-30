package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ActivityCompat
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), Context.MODE_PRIVATE)

        var btnMkdir: Button
        var btnRmdir: EditText
        btnMkdir = findViewById(R.id.btnMkdir)
        btnRmdir = findViewById(R.id.btnRmdir)

        var strSDpath = Environment.getExternalStorageDirectory().absolutePath
        var myDir = File("$strSDpath/mydir")

        btnMkdir.setOnClickListener {
            myDir.mkdir()
        }

        btnRmdir.setOnClickListener {
            myDir.delete()
        }
    }
}
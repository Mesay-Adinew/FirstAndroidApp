package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

class newactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newactivity)

    }

    override fun onDestroy() {
        super.onDestroy()
        val builder = AlertDialog.Builder(this@newactivity)
        builder.setTitle("Do you want to save?")
        startActivity( Intent(this@newactivity,MainActivity::class.java))

    }
}
package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.os.FileUtils.copy
import android.provider.OpenableColumns
import android.system.Os.rename
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.io.*


class SecondActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second2)
                val bt1=findViewById<Button>(R.id.btnOpenMain)
          val std=findViewById<Button>(R.id.student)
         val txtview=findViewById<TextView>(R.id.textView)

       bt1.setOnClickListener {
       val intent = Intent(this@SecondActivity, MainActivity::class.java)
            startActivity(intent)

         /*   val file = File("C:\Users\Mesay_Adinew", "me.txt")
            val inputAsString = FileInputStream(file).bufferedReader().use { it.readText()}
        }*/
           data class Student(
                   val name: String,
                   val grade: Double,
                   val passing: Boolean
           )
           val students = listOf(
                   Student("John", 4.2, true),
                   Student("Bill", 3.5, true),
                   Student("John", 3.2, false),
                   Student("Aron", 4.3, true),
                   Student("Jimmy", 3.1, true)
           )
           val bestStudents = students.filter { it.passing } // 1
                   .withIndex() // 2
                   .sortedBy { it.value.grade } // 3
                   .take(3) // 4
                   .sortedBy { it.index } // 5
                   .map { it.value } // 6
// Print list of names
           val stu=bestStudents.map { it.name }
           std.setOnClickListener {
               txtview.text=std.toString()
               Toast.makeText(applicationContext,stu.toString(),Toast.LENGTH_SHORT).show() // [John, Bill, Jimmy
           }

                }

    }}

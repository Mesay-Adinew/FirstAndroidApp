package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

class LoginForm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_form2)
        setSupportActionBar(findViewById(R.id.toolbar))
        val user = findViewById<TextView>(R.id.username)
        val password = findViewById<TextView>(R.id.textPassword)
            val btn1 = findViewById<Button>(R.id.loginbutton)
        val builder = AlertDialog.Builder(this@LoginForm)
            btn1.setOnClickListener {
                if (user.text.toString().equals("Mesay")&&password.text.toString().equals("deleli") ){
                    val intent = Intent(this@LoginForm, MainActivity::class.java)
                    startActivity(intent)
                }
                else {
                    builder.setTitle("error login")
                    val dialog = builder.create()
                    dialog.show()
                }
        }

    }
}
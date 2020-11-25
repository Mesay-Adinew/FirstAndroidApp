package com.example.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ComplexColorCompat.inflate
class Menu : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.exam_menu, menu)
        return true
    }
}
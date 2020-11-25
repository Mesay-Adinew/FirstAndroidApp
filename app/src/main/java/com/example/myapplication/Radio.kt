package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun

class Radio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio)
        setSupportActionBar(findViewById(R.id.toolbar))

        //  val android = findViewById<RadioButton>(R.id.radioButton);
        //val angular = findViewById<RadioButton>(R.id.radioButton2);
        //val java = findViewById<RadioButton>(R.id.radioButton3);
        //val python = findViewById<RadioButton>(R.id.radioButton);
        //val str = findViewById<TextView>(R.id.textView2);
        //  val btn = findViewById<Button>(R.id.button6);
        /*btn.setOnClickListener {
                var result = "Selected Course: ";
                result += (android.isChecked())?"Android":(angular.isChecked())?"AngularJS":(java.isChecked())?"Java":(python.isChecked())?"Python":"";
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            }*/


        /*  btn.setOnClickListener(View.OnClickListener() {

            switch(view.getId()) {

                case R.id.rdbAndroid:
                if(checked)
                    str = "Android Selected";
                break;
                case R.id.rdbAngular:
                if(checked)
                    str = "AngularJS Selected";
                break;
                case R.id.rdbJava:
                if(checked)
                    str = "Java Selected";
                break;
                case R.id.rdbPython:
                if(checked)
                    str = "Python Selected";
                break;
            }
            Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
        })*/
    }

}
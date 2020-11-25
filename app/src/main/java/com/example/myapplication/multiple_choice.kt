package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlin.system.exitProcess

class multiple_choice : AppCompatActivity() {
   val question1 = arrayOf("1. what is your name?", "Abebe", "Girma", "Yewudar", "Weyinishet")
    val question2 = arrayOf("2. what is your Country name?", "Eritira", "Ethiopia", "Yemen", "Kenya")
    val question3 = arrayOf("2. what is your family name?", "Abebe", "Girma", "Deleli", "Hailu", "Deleli")
    val question4 = arrayOf("4. what is your Religion name?", "Ortodox", "Musilm", "Catolik", "Peniteqonite")
    val question5 = arrayOf("5. what is your first Child name?", "Firohim", "Girma", "Yewudar", "Weyinishet")
    val answers = arrayOf(1, 2, 3, 1, 1)
    //val Questionlist:Array<Array<String>> = arrayOf(arrayOf("1. what is your name?", "Abebe", "Girma", "Yewudar", "Weyinishet"), arrayOf("2. what is your Country name?", "Eritira", "Ethiopia", "Yemen", "Kenya"), arrayOf("2. what is your family name?", "Abebe", "Girma", "Deleli", "Hailu", "Deleli"), arrayOf("4. what is your Religion name?", "Ortodox", "Musilm", "Catolik", "Peniteqonite"), arrayOf("5. what is your first Child name?", "Firohim", "Girma", "Yewudar", "Weyinishet"))
    val Questionlist = arrayOf(question1, question2, question3, question4, question5)
    var i =0
    var Score = 0
    var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.multiple_choice)
        setSupportActionBar(findViewById(R.id.toolbar))
        val a = findViewById<RadioButton>(R.id.a)
        val b = findViewById<RadioButton>(R.id.b)
        val c = findViewById<RadioButton>(R.id.c)
        val d = findViewById<RadioButton>(R.id.d)
        //val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val question = findViewById<TextView>(R.id.question)
        var answer = findViewById<TextView>(R.id.answer)
        val cancel = findViewById<Button>(R.id.cancel)
        val submit = findViewById<Button>(R.id.submit)
        val button = findViewById<Button>(R.id.button)
        val start = findViewById<Button>(R.id.start)
button.setOnClickListener { Toast.makeText(applicationContext, "you clicked the new button", Toast.LENGTH_SHORT).show() // [John, Bill, Jimmy
}
        a.isVisible = false
        b.isVisible = false
        c.isVisible = false
        d.isVisible = false
        answer.isVisible = false
        submit.isEnabled = false
      //  cancel.isEnabled = true
        start.setOnClickListener {
            answer.isVisible = true
            a.isVisible = true
            b.isVisible = true
            c.isVisible = true
            d.isVisible = true
            submit.isEnabled = true
            if(i<Questionlist.size) {
                question.text = Questionlist[i][0]
                a.text = "a)" + Questionlist[i][1]
                b.text = "b)" + Questionlist[i][2]
                c.text = "c)" + Questionlist[i][3]
                d.text = "d)" + Questionlist[i][4]
                start.text="Next"
            }
            answer.text = Score.toString()
            if(i==Questionlist.size-2)
            start.text="Finish"
            start.isEnabled = false
        }
        fun answerof(x: Int, indx: Int) {
            if (answers[x] == indx) {
                Score += 1
                answer.text = "You Scored "+Score.toString()
            }
        }
        /* a.setOnClickListener {answer.text="You are very good Person" }
        b.setOnClickListener {answer.text="You are good Person"}
            c.setOnClickListener {answer.text="you are abnormal person"}
                d.setOnClickListener {answer.text="you are abnormal person"}*/
        a.setOnClickListener { index = 1 }
        b.setOnClickListener { index = 2 }
        c.setOnClickListener { index = 3 }
        d.setOnClickListener { index = 4 }
        fun clear()
        {   a.isVisible = false
            b.isVisible = false
            c.isVisible = false
            d.isVisible = false
            question.text = ""
            a.text = ""
            b.text = ""
            c.text = ""
            d.text = ""
            a.setChecked(false);
            b.setChecked(false);
            c.setChecked(false);
            d.setChecked(false);
            }
        submit.setOnClickListener {
            answerof(i, index)
                 i=i+1
            submit.isEnabled = false
            if(i<Questionlist.size)
                  clear()
        }
        cancel.setOnClickListener {
            exitProcess(-1)
        }


    }

}
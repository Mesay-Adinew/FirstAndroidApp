package com.example.myapplication


import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.view.Menu
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.PopupMenu.OnMenuItemClickListener
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.BarcodeFormat
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.qrcode.QRCodeWriter
import com.google.zxing.qrcode.encoder.QRCode
import com.journeyapps.barcodescanner.CaptureActivity
import java.io.File
import java.io.InputStream
import java.nio.charset.Charset
import java.util.*
import java.time.Instant
import java.time.Instant.from
import java.time.LocalTime.from
import java.time.OffsetDateTime.from


class MainActivity: AppCompatActivity() {
   val questions = listOf(
           "What are the two official languages for Android development? \n\n A) Kotlin and Java \n\n B) Java and Python \n\n C) Kotlin and Python",
           "How do you define a function in Kotlin? \n\n A) void \n\n B) var \n\n C) function",
           "What is a variable used for? \n\n A) To contain data \n\n B) To insert a random value \n\n C) Don't know",
           "What does SDK stand for in Android SDK? \n\n A) Software Development Kit \n\n B) Software Development Kotlin \n\n C) Something Don't Know"
   )

    val questionNo = 0
    val rightAnswers = listOf(1, 2, 1, 1)
      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          setContentView(R.layout.activity_main)

          val btn1 = findViewById<Button>(R.id.button1)
          val btn2 = findViewById<Button>(R.id.button2)
          val btn3 = findViewById<Button>(R.id.button3)
          val btn4 = findViewById<Button>(R.id.button4)
          val btn5 = findViewById<Button>(R.id.button5)
          val btn7 = findViewById<Button>(R.id.button7)
          val imageView = findViewById<ImageView>(R.id.imageView)

          val questionbutton = findViewById<Button>(R.id.questionbutton)
          val txtView = findViewById<TextView>(R.id.Text1)
          val male = findViewById<RadioButton>(R.id.radioButtonMale)
          val female = findViewById<RadioButton>(R.id.radioButtonFemale)
          val other = findViewById<RadioButton>(R.id.radioButtonOther)
          val spin = findViewById<Spinner>(R.id.positionSpinner)
          //val spin = findViewById<View>(R.id.spinner1) as Spinner
          //val  myqcode = findViewById(R.id.my_qrcode) as MenuItem
          val videoView = findViewById<VideoView>(R.id.videoView)
          //Creating MediaController
          val mediaController = MediaController(this)
          mediaController.setAnchorView(videoView)
          //specify the location of media file
          // val uri: Uri = parse(Environment.getExternalStorageDirectory().getPath() + "happy.mp3")
          //Setting MediaController and URI, then starting the videoView
          // videoView.setMediaController(mediaController)
          // videoView.setVideoURI(Uri.parse("android.resource://"
          //        + packageName + "/" + "ICDE2020video.mp4"))
          // videoView.requestFocus()
          //videoView.start()
          val users = arrayOf(
                  "Suresh Dasari",
                  "Trishika Dasari",
                  "Rohini Alavala",
                  "Praveen Kumar",
                  "Madhav Sai"
          )
          val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, users)
          adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
          spin.setAdapter(adapter)
          spin.adapter = adapter
          /*@Override
          fun onItemSelected(arg0: AdapterView<Adapter>, arg1: View, position: Int, id: Long) {
              Toast.makeText(getApplicationContext(), "Selected User: " + users[position], Toast.LENGTH_SHORT).show();
          }

           */

        /*  myqcode.setOnMenuItemClickListener {
                   myQRcode()
                            true
                       }

         */

  btn7.setOnClickListener {
              scanQRCode()
                       }
          spin.setOnItemSelectedListener(object : OnItemSelectedListener {
              override fun onItemSelected(
                      adapterView: AdapterView<*>?,
                      view: View,
                      i: Int,
                      l: Long
              ) {
                  when (i) {

                      1 -> Toast.makeText(
                              this@MainActivity,
                              "Selected User : " + users[1].toString(),
                              Toast.LENGTH_SHORT
                      ).show()

                      2 -> Toast.makeText(
                              this@MainActivity,
                              "Selected User : " + users[2].toString(),
                              Toast.LENGTH_SHORT
                      ).show()

                      3 -> Toast.makeText(
                              this@MainActivity,
                              "Selected User : " + users[3].toString(),
                              Toast.LENGTH_SHORT
                      ).show()

                      4 -> Toast.makeText(
                              getApplicationContext(),
                              "Selected User : " + users[4].toString(),
                              Toast.LENGTH_SHORT
                      ).show()
                      5 -> Toast.makeText(
                              getApplicationContext(),
                              "Selected User: " + users[5].toString(),
                              Toast.LENGTH_SHORT
                      ).show()
                      // 6 -> Toast.makeText(this@MainActivity, "You Clicked : " +spin.selectedItem, Toast.LENGTH_SHORT).show()
                  }
              }

              override fun onNothingSelected(adapterView: AdapterView<*>?) {
                  return
              }
          })
          questionbutton.setOnClickListener {
              val intent = Intent(this@MainActivity, multiple_choice::class.java)
              startActivity(intent)

          }

          btn5.setOnClickListener {
              val fileName = "C:/tmp/me.txt"
              val myFile = File(fileName)

              var ins: InputStream = myFile.inputStream()

              var content = ins.readBytes().toString(Charset.defaultCharset())
              //println(content)
              txtView.setText(content)
          }
       btn4.setOnClickListener {
              txtView.setTextColor(3)

          }
          /*   btn1.setOnClickListener (
              showToast(1)
          }

          btn2.setOnClickListener {
              showToast(2)
          }
          btn3.setOnClickListener {
              showToast(3)
          }

           */

          btn1.setOnClickListener {
              txtView.text = "you are clicked" + btn1.text
              Toast.makeText(this@MainActivity, "You clicked Send button", Toast.LENGTH_SHORT).show()

    }
          txtView.setOnClickListener {
              val popupMenu: PopupMenu = PopupMenu(this, txtView)
              popupMenu.menuInflater.inflate(R.menu.exam_menu, popupMenu.menu)
              popupMenu.setOnMenuItemClickListener(OnMenuItemClickListener { item ->
                  when (item.itemId) {
                      R.id.button1 ->
                          Toast.makeText(
                                  this@MainActivity,
                                  "You Clicked : " + item.title,
                                  Toast.LENGTH_SHORT
                          ).show()
                      R.id.button2 ->
                          Toast.makeText(
                                  this@MainActivity,
                                  "You Clicked : " + item.title,
                                  Toast.LENGTH_SHORT
                          ).show()
                      R.id.button3 ->
                          Toast.makeText(
                                  this@MainActivity,
                                  "You Clicked : " + item.title,
                                  Toast.LENGTH_SHORT
                          ).show()
                  }
                  true
              })
              popupMenu.show()
          }
              @Override
          fun showPopup(v: View) {
              val popup = PopupMenu(this, v)
              val inflater: MenuInflater = popup.menuInflater
              inflater.inflate(R.menu.exam_menu, popup.menu)
              popup.show()
          }
txtView.setOnClickListener {
    showPopup(btn1)
                      }
          btn2.setOnClickListener {
              /* val intent = Intent(this@MainActivity,Menu::class.java)
            startActivity(intMesayent)*/
              //showPopup(btn4)
              val popupMenu: PopupMenu = PopupMenu(this, btn2)
              popupMenu.menuInflater.inflate(R.menu.exam_menu, popupMenu.menu)
              popupMenu.setOnMenuItemClickListener(OnMenuItemClickListener { item ->
                  when (item.itemId) {
                      R.id.file ->
                          Toast.makeText(
                                  this@MainActivity,
                                  "You Clicked : " + item.title,
                                  Toast.LENGTH_SHORT
                          ).show()
                      R.id.open ->
                          Toast.makeText(
                                  this@MainActivity,
                                  "You Clicked : " + item.title,
                                  Toast.LENGTH_SHORT
                          ).show()
                      R.id.create ->
                          Toast.makeText(
                                  this@MainActivity,
                                  "You Clicked : " + item.title,
                                  Toast.LENGTH_SHORT
                          ).show()
                      //R.id.my_qrcode -> myQRcode()

                  }
                  true
              })
              popupMenu.show()
          }

          btn3.setOnClickListener {
              txtView.text = "you are clicked" + btn3.text
              val intent = Intent()
                      .setType("*/*")
                      .setAction(Intent.ACTION_GET_CONTENT)

              startActivityForResult(Intent.createChooser(intent, "Select a file"), 111)

             /* val intent = Intent(this@MainActivity, SecondActivity::class.java)
              startActivity(intent)*/
          }

          btn4.setOnClickListener {
              txtView.text = "you are clicked" + btn4.text
              Toast.makeText(this@MainActivity, "You clicked germany button", Toast.LENGTH_SHORT).show()
              val intent = Intent(this@MainActivity, LoginForm::class.java)
              startActivity(intent)

          }
          // Specify the layout to use when the list of choices appears
          female.setOnClickListener {
              txtView.text = "you are selected" + female.text
          }
          male.setOnClickListener {
              txtView.text = "you are selected" + female.text
          }
          other.setOnClickListener {
              txtView.text = "you are selected" + other.text
          }
          fun updateQuestion() {
              txtView.setText(questions.get(questionNo + 1))
          }

          fun showToast(answer: Int) {
              if (answer == rightAnswers.get(questionNo)) {
                  Toast.makeText(applicationContext, "CORRECT!", Toast.LENGTH_SHORT).show()
                  updateQuestion()
              } else {
                  Toast.makeText(applicationContext, "WRONGO!", Toast.LENGTH_SHORT).show()
              }
          }
          //val mSlctdTxtTv = findViewById<TextView>(R.id.txtView)
          btn1.setOnClickListener {
              val builder = AlertDialog.Builder(this@MainActivity)
              // String array for alert dialog multi choice items
              val colorsArray = arrayOf("Black", "Orange", "Green", "Yellow", "White", "Purple")
              // Boolean array for initial selected items
              val checkedColorsArray = booleanArrayOf(
                      true, // Black checked
                      false, // Orange
                      false, // Green
                      true, // Yellow checked
                      false, // White
                      false  //Purple
              )
              // Convert the color array to list
              val colorsList = Arrays.asList(*colorsArray)
              //setTitle
              builder.setTitle("Select colors")
              //set multichoice
              builder.setMultiChoiceItems(colorsArray, checkedColorsArray) { dialog, which, isChecked ->
                  // Update the current focused item's checked status
                  checkedColorsArray[which] = isChecked
                  // Get the current focused item
                  val currentItem = colorsList[which]
                  // Notify the current action
                  Toast.makeText(
                          applicationContext,
                          currentItem + " " + isChecked,
                          Toast.LENGTH_SHORT
                  ).show()
              }
              // Set the positive/yes button click listener
              builder.setPositiveButton("OK") { dialog, which ->
                  // Do something when click positive button
                  txtView.text = "Your preferred colors..... \n"
                  for (i in checkedColorsArray.indices) {
                      val checked = checkedColorsArray[i]
                      if (checked) {
                          txtView.text = txtView.text.toString() + colorsList[i] + "\n"
                      }
                  }
              }
              // Set the neutral/cancel button click listener
              builder.setNeutralButton("Cancel") { dialog, which ->
                  // Do something when click the neutral button
              }
              val dialog = builder.create()
              // Display the alert dialog on interface
              dialog.show()
          }
      }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.exam_menu, menu)

        return true
    }

   /* override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 111 && resultCode == RESULT_OK) {
            val selectedFile = data?.data //The uri with the location of the file
        }
    }
        */
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_DPAD_CENTER -> Toast.makeText(
                    baseContext, "Center was clicked",
                    Toast.LENGTH_LONG
            ).show()
            KeyEvent.KEYCODE_DPAD_LEFT -> Toast.makeText(
                    baseContext, "Left arrow was clicked",
                    Toast.LENGTH_LONG
            ).show()
            KeyEvent.KEYCODE_DPAD_RIGHT -> Toast.makeText(
                    baseContext, "Right arrow was clicked",
                    Toast.LENGTH_LONG
            ).show()
            KeyEvent.KEYCODE_DPAD_UP -> Toast.makeText(
                    baseContext, "Up arrow was clicked",
                    Toast.LENGTH_LONG
            ).show()
            KeyEvent.KEYCODE_DPAD_DOWN -> Toast.makeText(
                    baseContext, "Down arrow was clicked",
                    Toast.LENGTH_LONG
            ).show()
        }
        return false
    }
    private fun scanQRCode(){
        val integrator = IntentIntegrator(this).apply {
            captureActivity = CaptureActivity::class.java
            setOrientationLocked(false)
            setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
            setPrompt("Scanning Code")
        }
        integrator.initiateScan()
    }

    // Get the results:
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
            else Toast.makeText(this, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
    fun myQRcode() {
        //val myBitmap: Bitmap = QRCode.from("www.example.org").bitmap()
        //myImage.setImageBitmap(myBitmap)
        val content = "bitcoin:3J98t1WpEZ73CNmQviecrnyiWrnqRhWNLy"

        val writer = QRCodeWriter()
        val bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, 512, 512)
        val width = bitMatrix.width
        val height = bitMatrix.height
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
        for (x in 0 until width) {
            for (y in 0 until height) {
                bitmap.setPixel(
                        x,
                        y,
                        if (bitMatrix.get(x, y)) Color.BLACK else Color.WHITE
                )
            }
        }

        val myImage = findViewById<View>(R.id.imageView) as ImageView

        myImage.setImageBitmap(bitmap)
      // R.id.imageView.setImageBitmap(bitmap)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.my_qrcode ->
                myQRcode()
            R.id.open ->
                startActivity(Intent(this@MainActivity, newactivity::class.java))
            //R.id.open ->
            R.id.create -> startActivity(Intent(this@MainActivity, Execel::class.java))


        }
        return true
    }

}
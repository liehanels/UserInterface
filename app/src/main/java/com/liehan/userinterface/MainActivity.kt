package com.liehan.userinterface

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //code starts here
        //create our elements
        val btnGreet = findViewById<Button>(R.id.BtnGreet)
        val edtName = findViewById<EditText>(R.id.EdtName)
        //here we set a click listener on our button
        btnGreet.setOnClickListener {
            //here we get EdtName text and store it in a variable
            var name = edtName.text.toString()
            //create an intent to navigate from one activity to another
            val intent = Intent(this, GreetActivity::class.java)
            //here we pass the name to the next activity
            intent.putExtra("name", name)
            //here we start the activity
            startActivity(intent)
        }

    }
}
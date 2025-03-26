package com.liehan.userinterface

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GreetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_greet)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //code starts here
        //here we get the name from the previous activity
        val intent: Intent = intent
        //here we get the name from the previous activity
        var name = intent.getStringExtra("name")
        //here we set the elements
        val tvGreeting = findViewById<TextView>(R.id.TvGreeting)
        val btnBye = findViewById<Button>(R.id.BtnBye)
        //here we set the text of the text view
        tvGreeting.text = "Hello $name"
        Toast.makeText(this, name.toString(), Toast.LENGTH_LONG).show()
        btnBye.setOnClickListener {
            val intent = Intent(this, LastScreenActivity::class.java)
            startActivity(intent)
        }
    }
}
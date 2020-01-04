package com.example.test

import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_login1.*

class Login1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login1)

        val button = findViewById<Button>(R.id.forgot_password)
        button.paintFlags = button.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        val button1 = findViewById<Button>(R.id.register2_button)
        button1.paintFlags = button1.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        val button2 = findViewById<Button>(R.id.forgot_password)
        button2.setOnClickListener{
            val intent = Intent(this, Forgot_Password:: class.java)
            startActivity(intent)
        }

        val button3 = findViewById<Button>(R.id.register2_button)
        button3.setOnClickListener{
            val intent = Intent(this, Register:: class.java)
            startActivity(intent)
        }
    }
}

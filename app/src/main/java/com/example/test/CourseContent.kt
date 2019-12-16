package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import com.example.test.ui.course.courseContent.ComputerScience

class CourseContent : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_content)

        val toolbar = findViewById<View>(R.id.toolbar2) as Toolbar
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayShowTitleEnabled(false)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)

        /*Testing for button click to another page*/

        val btnBinary = findViewById<Button>(R.id.btnTopicOne)
        val btnStartCourse = findViewById<Button>(R.id.btnStartCourse)

        btnStartCourse.setOnClickListener {
            val intent = Intent(this, ComputerScience ::class.java)
            startActivity(intent)
        }


        btnBinary.setOnClickListener {
            val intent = Intent(this, ComputerScience ::class.java)
            startActivity(intent)
         }

    }

    override fun onSupportNavigateUp(): Boolean {

        super.onBackPressed()
        return true
    }
}

package com.example.test

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class QuizResult : Activity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_us)




//        val myIntent = intent
//        var correct = myIntent.getIntExtra("score", 0)
//        var totalQuestion = myIntent.getIntExtra("totalQuestion", 0)
//
//
//
//        val totalQuestionText : TextView = findViewById(R.id.totalQuestionText)
//        val correctText : TextView = findViewById(R.id.correctText)
//        val wrongText : TextView = findViewById(R.id.wrongText)
//        val scoreText : TextView = findViewById(R.id.scoreText)
//
//        totalQuestionText.text = "Total Questions: " + totalQuestion
//        correctText.text = "Correct Answers: " + correct
//        wrongText.text = "Wrong Answers: " + totalQuestion.minus(correct)
//        scoreText.text = "Your score: " + correct.div(totalQuestion).times(100)
//
//        val retryBut : Button = findViewById(R.id.retry)
//        val backBut : Button = findViewById(R.id.back)
//
//        retryBut.setOnClickListener {
//
//            super.onBackPressed()
//        }



    }
}

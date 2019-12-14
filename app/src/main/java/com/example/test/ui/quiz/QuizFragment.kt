package com.example.test.ui.quiz

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.test.QuizQuestion
import com.example.test.R
import kotlinx.android.synthetic.main.fragment_quiz.view.*

class QuizFragment : Fragment() {

    private lateinit var quizViewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        quizViewModel =
            ViewModelProviders.of(this).get(QuizViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_quiz, container, false)

        view.q1.setOnClickListener {

            val intent = Intent(activity, QuizQuestion::class.java)
            startActivity(intent)
        }

        return view
    }

}
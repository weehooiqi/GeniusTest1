package com.example.test.ui.quiz

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
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

        val b = view.q1 as Button
        val buttonText = b.text.toString()

        view.q1.setOnClickListener {

            val builder = AlertDialog.Builder(activity, R.style.AlertDialogCustom)

            builder.setTitle("Quiz Time")
            builder.setMessage("Start $buttonText?")
            builder.setPositiveButton("Yes"){dialog, which ->
                val intent = Intent(activity, QuizQuestion::class.java)
                startActivity(intent)
                Toast.makeText(activity,"Start!", Toast.LENGTH_SHORT).show()
            }
            builder.setNeutralButton("Cancel"){_,_ ->

            }

            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

        return view
    }

}
package com.example.test

import android.app.Activity
import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil

import com.example.test.databinding.QuizQuestionBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.quiz_question.*
import android.content.Intent
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class QuizResult3 : AppCompatActivity() {

    data class Question(
        val text: String,
        val answers: List<String>)

    private val questions: MutableList<Question> = mutableListOf(
        Question(text = "What is Android Jetpack?",
            answers = listOf("All of these", "Tools", "Documentation", "Libraries")),
        Question(text = "What is the base class for layouts?",
            answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")),
        Question(text = "What layout do you use for complex screens?",
            answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout")),
        Question(text = "What do you use to push structured data into a layout?",
            answers = listOf("Data binding", "Data pushing", "Set text", "An OnClick method"))
//        Question(text = "What method do you use to inflate layouts in fragments?",
//            answers = listOf("onCreateView()", "onActivityCreated()", "onCreateLayout()", "onInflateLayout()")),
//        Question(text = "What's the build system for Android?",
//            answers = listOf("Gradle", "Graddle", "Grodle", "Groyle")),
//        Question(text = "Which class do you use to create a vector drawable?",
//            answers = listOf("VectorDrawable", "AndroidVectorDrawable", "DrawableVector", "AndroidVector")),
//        Question(text = "Which one of these is an Android navigation component?",
//            answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher")),
//        Question(text = "Which XML element lets you register an activity with the launcher activity?",
//            answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher")),
//        Question(text = "What do you use to mark a layout for data binding?",
//            answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>"))
    )

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = questions.size
    private lateinit var binding: QuizQuestionBinding
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.quiz_question)

        val toolbar = findViewById<View>(R.id.toolbar2) as Toolbar
        setSupportActionBar(toolbar)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close_24px);
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        toolbar.setBackgroundColor(Color.parseColor("#ffff00"))

        randomizeQuestions()



        var check = true

        // Set the onClickListener for the submitButton
        binding.submitButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->

            if (check) {

                val checkedId = binding.questionRadioGroup.checkedRadioButtonId
                // Do nothing if nothing is checked (id == -1)
                if (-1 != checkedId) {
                    var answerIndex = 0
                    when (checkedId) {
                        R.id.secondAnswerRadioButton -> answerIndex = 1
                        R.id.thirdAnswerRadioButton -> answerIndex = 2
                        R.id.fourthAnswerRadioButton -> answerIndex = 3
                    }

                    submitButton.text = "Continue"
                    check = false
                    // The first answer in the original question is always the correct one, so if our
                    // answer matches, we have the correct answer.
                    if (answers[answerIndex] == currentQuestion.answers[0]) {

                        Snackbar.make(findViewById(R.id.drawerLayout), "Correct answer! ", Snackbar.LENGTH_SHORT).show()
                        submitButton.setBackgroundColor(Color.GREEN)
                        score += 1

                    } else {

                        Snackbar.make(findViewById(R.id.drawerLayout), "Sorry, the answer is '" + currentQuestion.answers[0] + "'", Snackbar.LENGTH_SHORT).show()
                        submitButton.setBackgroundColor(Color.RED)

                    }
                }
            }

            else {

                questionIndex++

                if (questionIndex < numQuestions) {
                    currentQuestion = questions[questionIndex]
                    setQuestion()
                    binding.invalidateAll()
                    submitButton.text = "Submit"
                    submitButton.setBackgroundColor(Color.parseColor("#60A9FF"))
                    check = true
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Quiz Completed.",
                        Toast.LENGTH_SHORT
                    ).show()

                    super.onBackPressed()


                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {

        onBackPressed()
        return true
    }

    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        answers = currentQuestion.answers.toMutableList()
        answers.shuffle()
        supportActionBar?.title = "Question " + String.format("%d",questionIndex+1)
    }

    override fun onBackPressed() {

        val builder = AlertDialog.Builder(this@QuizResult3, R.style.AlertDialogCustom)

        // Set the alert dialog title
        builder.setTitle("Exit?")

        // Display a message on alert dialog
        builder.setMessage("The quiz progress will be lost!")

        // Set a positive button and its click listener on alert dialog
        builder.setPositiveButton("Yes"){ _, _ ->
            // Do something when user press the positive button
            Toast.makeText(applicationContext,"Quiz cancelled.",Toast.LENGTH_SHORT).show()
            super.onBackPressed()
        }

        // Display a neutral button on alert dialog
        builder.setNeutralButton("Cancel"){_,_ ->

        }

        // Finally, make the alert dialog using builder
        val dialog: AlertDialog = builder.create()

        // Display the alert dialog on app interface
        dialog.show()
    }
}

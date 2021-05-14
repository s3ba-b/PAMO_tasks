package com.example.zadanie4

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


class QuizActivity : AppCompatActivity(), View.OnClickListener {
    private var falseButton: Button? = null
    private var trueButton: Button? = null
    private var nextButton: Button? = null
    private var prevButton: Button? = null
    private var questionTextView: TextView? = null
    private var correct = 0
    private var currentQuestionIndex = 0
    private val questionBank = arrayOf(
        Question(R.string.a, false),
        Question(R.string.b, true),
        Question(R.string.c, true),
        Question(R.string.d, false),
        Question(R.string.e, true),
        Question(R.string.f, false)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        // setting up the buttons
        // associated with id
        falseButton = findViewById(R.id.false_button)
        trueButton = findViewById(R.id.true_button)
        nextButton = findViewById(R.id.next_button)
        prevButton = findViewById(R.id.prev_button)
        // register our buttons to listen to
        // click events
        questionTextView = findViewById(R.id.answer_text_view)
        falseButton?.setOnClickListener(this)
        trueButton?.setOnClickListener(this)
        nextButton?.setOnClickListener(this)
        prevButton?.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    override fun onClick(v: View) {
        // checking which button is
        // clicked by user
        // in this case user choose false
        when (v.id) {
            R.id.false_button -> checkAnswer(false)
            R.id.true_button -> checkAnswer(true)
            R.id.next_button ->                 // go to next question
                // limiting question bank range
                if (currentQuestionIndex < 7) {
                    currentQuestionIndex = currentQuestionIndex + 1
                    // we are safe now!
                    // last question reached
                    // making buttons
                    // invisible
                    if (currentQuestionIndex == 6) {
                        questionTextView!!.text = getString(
                            R.string.correct, correct
                        )
                        nextButton!!.visibility = View.INVISIBLE
                        prevButton!!.visibility = View.INVISIBLE
                        trueButton!!.visibility = View.INVISIBLE
                        falseButton!!.visibility = View.INVISIBLE
                        if (correct > 3) questionTextView!!.text = ("CORRECTNESS IS " + correct
                                + " "
                                + "OUT OF 6")
                        // showing correctness
                        // if correctness<3 showing sad emoji
                    } else {
                        updateQuestion()
                    }
                }
            R.id.prev_button -> if (currentQuestionIndex > 0) {
                currentQuestionIndex = ((currentQuestionIndex - 1)
                        % questionBank.size)
                updateQuestion()
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private fun updateQuestion() {
        Log.d(
            "Current",
            "onClick: $currentQuestionIndex"
        )
        questionTextView!!.setText(
            questionBank[currentQuestionIndex]
                .answerResId
        )
    }

    private fun checkAnswer(userChooseCorrect: Boolean) {
        val answerIsTrue = questionBank[currentQuestionIndex]
            .isAnswerTrue
        // getting correct ans of current question
        val toastMessageId: Int
        // if ans matches with the
        // button clicked
        if (userChooseCorrect == answerIsTrue) {
            toastMessageId = R.string.correct_answer
            correct++
        } else {
            // showing toast
            // message correct
            toastMessageId = R.string.wrong_answer
        }
        Toast
            .makeText(
                this@QuizActivity, toastMessageId,
                Toast.LENGTH_SHORT
            )
            .show()
    }
}
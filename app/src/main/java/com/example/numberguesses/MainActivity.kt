package com.example.numberguesses

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var guessCount = 0
    val secretNumber = kotlin.random.Random.nextInt(100) + 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val numberEditText = findViewById<EditText>(R.id.numberEditText)
        val guessButton = findViewById<Button>(R.id.guessButton)
        val feedbackTextView = findViewById<TextView>(R.id.feedbackTextView)

        guessButton.setOnClickListener {
          var guess = numberEditText.text.toString().toInt()
          guessCount++

          if (guessCount >= 5 && guess != secretNumber) {
              feedbackTextView.text ="You Lose! The number was $secretNumber"
          }
          else if (guess == secretNumber) {
              feedbackTextView.text ="Correct"
          }
          else if (guess < secretNumber) {
              feedbackTextView.text = "Too Low"
          }
          else if (guess > secretNumber) {
              feedbackTextView.text ="Too High"
          }

        }








        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
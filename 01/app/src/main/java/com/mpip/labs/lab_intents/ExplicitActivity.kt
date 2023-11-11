package com.mpip.labs.lab_intents

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ExplicitActivity : AppCompatActivity() {
    private lateinit var submitButton: Button
    private lateinit var discardButton: Button
    private lateinit var textInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit)
        submitButton = findViewById(R.id.submitButton)
        discardButton = findViewById(R.id.discardButton)
        textInput = findViewById(R.id.inputEditText)
    }

    fun onSubmitClick(view: View){
        val input = textInput.text.toString()
        val resultIntent = Intent()
        resultIntent.putExtra("input", input)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }

    fun onDiscardClick(view: View){
        val resultIntent = Intent()
        setResult(Activity.RESULT_CANCELED, resultIntent)
        finish()
    }

}
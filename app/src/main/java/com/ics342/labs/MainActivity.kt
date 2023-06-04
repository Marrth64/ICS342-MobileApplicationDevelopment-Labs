package com.ics342.labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        editText = findViewById(R.id.editText)
        button.setOnClickListener{
            handleButtonClick()
        }
    }

    private fun handleButtonClick() {
        val txt = editText.text.toString()

        if(txt.isEmpty())
            showErrorAlert()
        else
          showTextInAlert(txt)
    }

    private fun showTextInAlert(text: String) {
        AlertDialog
            .Builder(this)
            .setTitle(R.string.entered_text)
            .setMessage(text)
            .setPositiveButton(R.string.okay, null)
            .create()
            .show()
    }

    private fun showErrorAlert() {
        AlertDialog
            .Builder(this)
            .setTitle(R.string.error_title)
            .setMessage(R.string.error_message)
            .setPositiveButton(R.string.okay, null)
            .create()
            .show()
    }
}

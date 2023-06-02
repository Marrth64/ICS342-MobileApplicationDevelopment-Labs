package com.ics342.labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun handleButtonClick() {
        /** Implement the functionality to display the alert here. **/
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

package com.example.lab_week_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var displayTextView: TextView
    private lateinit var nameInputEditText: TextInputEditText
    private lateinit var studentNumberInputEditText: TextInputEditText
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeUIComponents()
        setSubmitButtonClickListener()
    }

    private fun initializeUIComponents() {
        displayTextView = findViewById(R.id.display_text_view)
        nameInputEditText = findViewById(R.id.name_input_edit_text)
        studentNumberInputEditText = findViewById(R.id.student_number_input_edit_text)
        submitButton = findViewById(R.id.submit_button)
    }

    private fun setSubmitButtonClickListener() {
        submitButton.setOnClickListener {
            validateAndProcessInput()
        }
    }

    private fun validateAndProcessInput() {
        val name = nameInputEditText.text.toString().trim()
        val studentNumber = studentNumberInputEditText.text.toString().trim()

        if (name.isEmpty()) {
            showErrorMessage("Please enter your name")
            return
        }

        if (studentNumber.isEmpty()) {
            showErrorMessage("Student number field is empty!")
            return
        }

        if (studentNumber.length != 11) {
            showErrorMessage("Student number has to be 11 digits long")
            return
        }

        processValidData(name, studentNumber)
    }

    private fun showErrorMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).apply {
            setGravity(Gravity.CENTER, 0, 0)
            show()
        }
    }

    private fun processValidData(name: String, studentNumber: String) {
        val result = "My name is: $name\nMy student number is: $studentNumber"
        displayTextView.text = result

        Toast.makeText(this, "Information submitted successfully!", Toast.LENGTH_SHORT).show()
        clearInputFields()
    }

    private fun clearInputFields() {
        nameInputEditText.text?.clear()
        studentNumberInputEditText.text?.clear()
    }
}
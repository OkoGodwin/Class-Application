package com.example.exams

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.classapplication.R

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val btnSubmit: Button = findViewById(R.id.buttonSubmitSignup)
        val fullNameTextEdit = findViewById<EditText>(R.id.editTextSignupFullname)
        val usernameEditText = findViewById<EditText>(R.id.editTextTextUsername)
        val passwordEditText = findViewById<EditText>(R.id.editTextPassword)

        // function for validation
        fun fieldValidations(): Boolean {
            if (usernameEditText.text.isEmpty()){
                Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show()
                return false
            } else if (passwordEditText.text.isEmpty()) {
                Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show()
                return false
            } else if (!usernameEditText.text.trim().equals(intent.getStringExtra("USERNAME").toString())) {
                Toast.makeText(this,"Username is not correct or not found", Toast.LENGTH_SHORT).show()
                return false
            } else if (passwordEditText.text.trim() != intent.getStringExtra("PASSWORD").toString()){
                Toast.makeText(this, "Password is not correct", Toast.LENGTH_SHORT).show()
                return false
            } else {
                return true
            }
        }

        btnSubmit.setOnClickListener {
            if (fieldValidations()){

                val intent = Intent(this, SigninActivity::class.java)
                intent.putExtra("FULLNAME", fullNameTextEdit.text.trim())
                intent.putExtra("USERNAME", usernameEditText.text.trim())
                intent.putExtra("PASSWORD", passwordEditText.text.trim())


                startActivity(intent)
            }
        }
    }
}
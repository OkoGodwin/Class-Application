package com.example.exams

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.classapplication.Board
import com.example.classapplication.R

class SigninActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val intent = intent
        val myIntent = getIntent()


        if (!intent.equals(null)){

        }
        if (intent.hasExtra("GREETING")){
            val greetingMsg = intent.getStringExtra("GREETING")
            Toast.makeText(this, greetingMsg,Toast.LENGTH_SHORT).show()
        }

        val btnSignin: Button = findViewById(R.id.buttonSigninNow)
        val username = findViewById<EditText>(R.id.txtUsername)
        val password: EditText = findViewById(R.id.txtPassword)
        val forgotPassword: TextView = findViewById(R.id.textViewForgotPassword)
        val goToSignup: TextView = findViewById(R.id.textViewSinginSignup)


        fun validateFields(): Boolean {
            if (username.text.isEmpty()){
                Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show()
                return false
            } else if (password.text.isEmpty()) {
                Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show()
                return false
            } else if (!username.text.trim().equals(intent.getStringExtra("USERNAME").toString())) {
                Toast.makeText(this,"Username is not correct or not found", Toast.LENGTH_SHORT).show()
                return false
            } else if (password.text.trim() != intent.getStringExtra("PASSWORD").toString()){
                Toast.makeText(this, "Password is not correct", Toast.LENGTH_SHORT).show()
                return false
            } else {
                return true
            }
        }


        btnSignin.setOnClickListener {
            if (validateFields()){


                val dashboardIntent = Intent(this, Board::class.java)
                dashboardIntent.putExtra("USERNAME", username.text.trim())
                dashboardIntent.putExtra("PASSWORD", password.text.trim())

                startActivity(dashboardIntent)
            }
        }


        forgotPassword.setOnClickListener {
            Toast.makeText(this, "This feature is not implented yet", Toast.LENGTH_SHORT).show()
        }


        goToSignup.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }
}
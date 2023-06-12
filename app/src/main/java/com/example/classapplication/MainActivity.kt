package com.example.exams

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.classapplication.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainSigninButton: Button = findViewById(R.id.buttonMainSignin)
        val mainSignupButton: Button = findViewById(R.id.buttonMainSignup)


        mainSigninButton.setOnClickListener {
            val intent = Intent(this, SigninActivity::class.java)
            intent.putExtra(" GREETING", "You just came to the Main screen")
            startActivity(intent)
        }


        mainSignupButton.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }
}
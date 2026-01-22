package com.example.login_page

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.login_page.SignInActivity
import com.example.login_page.SignUpActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        val signinBtn = findViewById<Button>(R.id.btnSignin)
        val newacc=findViewById<TextView>(R.id.CreateAccount)
        signinBtn.setOnClickListener {
            val intent=Intent(this,SignInActivity::class.java)
            startActivity(intent)

        }
        newacc.setOnClickListener{
            val intent=Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}


package com.example.login_page

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forgot_password)
        val cnt=findViewById<Button>(R.id.continuebtn)
        val bck=findViewById<TextView>(R.id.back2)
        cnt.setOnClickListener{
            val intent=Intent(this,DigitcodeActivity::class.java)
            startActivity(intent)
        }
        bck.setOnClickListener{
            val intent=Intent(this,SignInActivity::class.java)
            startActivity(intent)
        }
    }
}

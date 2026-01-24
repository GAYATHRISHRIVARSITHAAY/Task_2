package com.example.task_2

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin)
        val forgotbtn = findViewById<TextView>(R.id.idforgotpassword)
        val bck=findViewById<TextView>(R.id.idback)
        val mail=findViewById<EditText>(R.id.idemail_box).text.toString()
        val pass=findViewById<EditText>(R.id.idpassword_box).text.toString()

        forgotbtn.setOnClickListener{
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
        bck.setOnClickListener{
            if(mail.isEmpty() || pass.isEmpty()){
                Toast.makeText(this, "Fields should not be empty", Toast.LENGTH_SHORT).show()
            }
            val intent=Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

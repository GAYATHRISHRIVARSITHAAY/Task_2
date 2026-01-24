package com.example.task_2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val signin=view.findViewById<Button>(R.id.btnSignin)
        val creatacc=view.findViewById<TextView>(R.id.CreateAccount)
        signin.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container,SignInFragment())
                .addToBackStack(null)
                .commit()

        }
        creatacc.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container,SignUpFragment())
                .addToBackStack(null)
                .commit()

        }
    }
}
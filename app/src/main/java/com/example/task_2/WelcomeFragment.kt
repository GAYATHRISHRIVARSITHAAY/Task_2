package com.example.task_2.welcome

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.task_2.R
import com.example.task_2.signin.SignInFragment
import com.example.task_2.signup.SignUpFragment

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val signin=view.findViewById<Button>(R.id.btnSignin)
        val creatacc=view.findViewById<TextView>(R.id.CreateAccount)
        signin.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SignInFragment())
                .addToBackStack(null)
                .commit()

        }
        creatacc.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SignUpFragment())
                .addToBackStack(null)
                .commit()

        }
    }
}
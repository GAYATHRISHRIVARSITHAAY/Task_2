package com.example.task_2.signup

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.task_2.R

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val signup=view.findViewById<Button>(R.id.signupbutton)
        val back=view.findViewById<TextView>(R.id.back1)
        signup.setOnClickListener{

            val name=view.findViewById<EditText>(R.id.email_box).text.toString()
            val email=view.findViewById<EditText>(R.id.password_box).text.toString()
            val password=view.findViewById<EditText>(R.id.password_box1).text.toString()
            val box=view.findViewById<CheckBox>(R.id.checkbox1)
            if(name.isEmpty() || email.isEmpty() || password.isEmpty()){
                Toast.makeText(requireContext(),"Fields should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else if (!(box.isChecked))
            {
                Toast.makeText(requireContext(),"Tick the check box", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else{
                Toast.makeText(requireContext(),"Signed up sucessfully!!", Toast.LENGTH_LONG).show()
            }
        }
        back.setOnClickListener{
            parentFragmentManager.popBackStack()
        }

    }

}
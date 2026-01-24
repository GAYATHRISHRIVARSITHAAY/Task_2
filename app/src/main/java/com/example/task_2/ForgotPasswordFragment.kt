package com.example.task_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class ForgotPasswordFragment : Fragment(R.layout.fragment_forgot_password) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cont=view.findViewById<Button>(R.id.continuebtn)
        val back=view.findViewById<TextView>(R.id.back2)
        back.setOnClickListener{
            parentFragmentManager.popBackStack()
        }
        cont.setOnClickListener {
            val email=view.findViewById<EditText>(R.id.email__box).text.toString()
            if(email.isEmpty())
            {
                Toast.makeText(requireContext(),"Field should not be empty",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, DigitcodeFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }


}
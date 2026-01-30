package com.example.task_2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout

class ForgotPasswordFragment : Fragment(R.layout.fragment_forgot_password) {
    private val viewModel: ForgotPasswordViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cont = view.findViewById<Button>(R.id.continuebtn)
        val back = view.findViewById<TextView>(R.id.back2)
        val emailEt = view.findViewById<EditText>(R.id.email__box)
        val maillayout=view.findViewById<TextInputLayout>(R.id.emailLayout)
        cont.setOnClickListener {
            val mail = emailEt.text.toString()
            maillayout.error=null
            viewModel.conti(mail)
        }
        viewModel.msg.observe(viewLifecycleOwner) {
            message ->
            if(message.equals("invalid"))
            {
                maillayout.error="Invalid email"
            }
            else if(message.equals("no mail"))
            {
                maillayout.error="Mail field must be filled"
            }
        }
        viewModel.navigateNext.observe(viewLifecycleOwner) {
            shouldNavigate ->
            if (shouldNavigate) {
                findNavController().navigate(R.id.forgotpassword_to_pin)
                viewModel.next()
            }
        }
        back.setOnClickListener {
           findNavController().popBackStack()
        }


    }

}

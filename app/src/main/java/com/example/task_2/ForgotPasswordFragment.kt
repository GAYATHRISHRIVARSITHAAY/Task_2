package com.example.task_2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

class ForgotPasswordFragment : Fragment(R.layout.fragment_forgot_password) {
    private val viewModel: ForgotPasswordViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cont = view.findViewById<Button>(R.id.continuebtn)
        val back = view.findViewById<TextView>(R.id.back2)
        val emailEt = view.findViewById<EditText>(R.id.email__box)
        cont.setOnClickListener {
            val mail = emailEt.text.toString()
            viewModel.conti(mail)
        }
        viewModel.msg.observe(viewLifecycleOwner) {
            message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
        viewModel.navigateNext.observe(viewLifecycleOwner) {
            shouldNavigate ->
            if (shouldNavigate) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, DigitcodeFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }
        back.setOnClickListener {
            parentFragmentManager.popBackStack()
        }


    }

}

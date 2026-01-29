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
import androidx.fragment.app.viewModels
import com.example.task_2.viewmodel.DigitcodeViewModel
import com.example.task_2.viewmodel.SignInViewModel


class SignInFragment : Fragment(R.layout.fragment_sign_in) {
    private val viewModel: SignInViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val forg=view.findViewById<TextView>(R.id.idforgotpassword)
        val signin=view.findViewById<Button>(R.id.idsigninbutton)
        val back=view.findViewById<TextView>(R.id.idback)
        forg.setOnClickListener{
            viewModel.forgot()

        }
        viewModel.forgotStatus.observe(viewLifecycleOwner){
            shouldforgot->
            if(shouldforgot){
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container,ForgotPasswordFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }
        signin.setOnClickListener{
            val mail=view.findViewById<EditText>(R.id.idemail_box).text.toString()
            val password=view.findViewById<EditText>(R.id.idpassword_box).text.toString()
            viewModel.signin(mail,password)
        }
        viewModel.signInStatus.observe(viewLifecycleOwner){
            message->
                Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()
        }
        back.setOnClickListener{
            parentFragmentManager.popBackStack()
        }
    }
}
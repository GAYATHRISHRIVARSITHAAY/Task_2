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
import androidx.navigation.fragment.findNavController
import com.example.task_2.viewmodel.DigitcodeViewModel
import com.example.task_2.viewmodel.SignInViewModel
import com.google.android.material.textfield.TextInputLayout


class SignInFragment : Fragment(R.layout.fragment_sign_in) {
    private val viewModel: SignInViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val forg=view.findViewById<TextView>(R.id.idforgotpassword)
        val signin=view.findViewById<Button>(R.id.idsigninbutton)
        val back=view.findViewById<TextView>(R.id.idback)
        val maillayout=view.findViewById<TextInputLayout>(R.id.emailLayout)
        val passwordlayout=view.findViewById<TextInputLayout>(R.id.passwordLayout)
        forg.setOnClickListener{
            viewModel.forgot()

        }
        viewModel.forgotStatus.observe(viewLifecycleOwner){
            shouldforgot->
            if(shouldforgot){
                findNavController().navigate(R.id.signin_to_forgotpassword)
                viewModel.onForgotNavigationDone()

//                parentFragmentManager.beginTransaction()
//                    .replace(R.id.fragment_container,ForgotPasswordFragment())
//                    .addToBackStack(null)
//                    .commit()
            }
        }
        signin.setOnClickListener{
            maillayout.error=null
            passwordlayout.error=null
            val mail=view.findViewById<EditText>(R.id.idemail_box).text.toString()
            val password=view.findViewById<EditText>(R.id.idpassword_box).text.toString()
            viewModel.signin(mail,password)
        }
        viewModel.signInStatus.observe(viewLifecycleOwner){
            message->
            if(message.equals("no email"))
            {
                maillayout.error="Mail field must be filled"
            }
            else if(message.equals("no password"))
            {
                passwordlayout.error="Password field must be filled"
            }
            else if(message.equals("invalid"))
            {
                maillayout.error="Invalid mail"
            }
            else{
                Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()
            }
        }
        back.setOnClickListener{
            findNavController().popBackStack()
            //parentFragmentManager.popBackStack()
        }


    }
}
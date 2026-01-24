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


class SignInFragment : Fragment(R.layout.fragment_sign_in) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val forg=view.findViewById<TextView>(R.id.idforgotpassword)
        val signin=view.findViewById<Button>(R.id.idsigninbutton)
        val back=view.findViewById<TextView>(R.id.idback)
        forg.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container,ForgotPasswordFragment())
                .addToBackStack(null)
                .commit()
        }
        signin.setOnClickListener{
            val mail=view.findViewById<EditText>(R.id.idemail_box).text.toString()
            val password=view.findViewById<EditText>(R.id.idpassword_box).text.toString()
            if(mail.isEmpty() || password.isEmpty()){
                Toast.makeText(requireContext(),"Fields should not be empty",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else if(mail.equals("user@gmail.com") && password.equals("userpassword"))
            {
                Toast.makeText(requireContext(),"Signed in",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(requireContext(),"Email or password is wrong",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
        back.setOnClickListener{
            parentFragmentManager.popBackStack()
        }
    }

}
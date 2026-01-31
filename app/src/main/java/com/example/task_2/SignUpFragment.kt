//package com.example.task_2
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.CheckBox
//import android.widget.EditText
//import android.widget.TextView
//import android.widget.Toast
//
//
//class SignUpFragment : Fragment(R.layout.fragment_sign_up) {
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val signup=view.findViewById<Button>(R.id.signupbutton)
//        val back=view.findViewById<TextView>(R.id.back1)
//        signup.setOnClickListener{
//
//            val name=view.findViewById<EditText>(R.id.email_box).text.toString()
//            val email=view.findViewById<EditText>(R.id.password_box).text.toString()
//            val password=view.findViewById<EditText>(R.id.password_box1).text.toString()
//            val box=view.findViewById<CheckBox>(R.id.checkbox1)
//            if(name.isEmpty() || email.isEmpty() || password.isEmpty()){
//                Toast.makeText(requireContext(),"Fields should not be empty",Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//            else if (!(box.isChecked))
//            {
//                Toast.makeText(requireContext(),"Tick the check box",Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//            else{
//                Toast.makeText(requireContext(),"Signed up sucessfully!!",Toast.LENGTH_LONG).show()
//            }
//        }
//        back.setOnClickListener{
//            parentFragmentManager.popBackStack()
//        }
//
//    }
//
//}

package com.example.task_2

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.task_2.viewmodel.SignUpViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    private val viewModel: SignUpViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val signup = view.findViewById<Button>(R.id.signupbutton)
        val back = view.findViewById<TextView>(R.id.back1)
        val nameEt = view.findViewById<EditText>(R.id.email_box)
        val emailEt = view.findViewById<EditText>(R.id.password_box)
        val passwordEt = view.findViewById<EditText>(R.id.password_box1)
        val checkBox = view.findViewById<CheckBox>(R.id.checkbox1)
        val namelayout=view.findViewById<TextInputLayout>(R.id.nameLayout)
        val maillayout=view.findViewById<TextInputLayout>(R.id.emailLayout)
        val passwordlayout=view.findViewById<TextInputLayout>(R.id.passwordLayout)
        val checkboxerror=view.findViewById<TextView>(R.id.checkerror)

        signup.setOnClickListener {
            namelayout.error=null
            maillayout.error=null
            passwordlayout.error=null
            checkboxerror.visibility=View.GONE
            viewModel.signUp(
                nameEt.text.toString(),
                emailEt.text.toString(),
                passwordEt.text.toString(),
                checkBox.isChecked
            )
        }

        viewModel.signUpStatus.observe(viewLifecycleOwner) { message ->
            if(message.equals("no name"))
            {
                namelayout.error="Name field must be filled"
            }
            else if(message.equals("no mail"))
            {
                maillayout.error="Mail field must be filled"
            }
            else if(message.equals("no password"))
            {
                passwordlayout.error="Password field must be filled"
            }
            else if(message.equals("no check"))
            {
                checkboxerror.visibility=View.VISIBLE
            }
            else if(message.equals("invalid mail"))
            {
                maillayout.error="Invalid email"
            }
            else if(message.equals("short"))
            {
                passwordlayout.error="Password must be minimum of 6 characters"
            }
            else{
                Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()
            }
        }

        back.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}

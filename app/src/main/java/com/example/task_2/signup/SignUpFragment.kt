package com.example.task_2.signup

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.task_2.R
import com.example.task_2.databinding.FragmentSignUpBinding
import com.example.task_2.signup.SignUpViewModel

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SignUpViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSignUpBinding.bind(view)

//        val signup = view.findViewById<Button>(R.id.signupbutton)
//        val back = view.findViewById<TextView>(R.id.back1)
//        val nameEt = view.findViewById<EditText>(R.id.email_box)
//        val emailEt = view.findViewById<EditText>(R.id.password_box)
//        val passwordEt = view.findViewById<EditText>(R.id.password_box1)
//        val checkBox = view.findViewById<CheckBox>(R.id.checkbox1)
//        val namelayout=view.findViewById<TextInputLayout>(R.id.nameLayout)
//        val maillayout=view.findViewById<TextInputLayout>(R.id.emailLayout)
//        val passwordlayout=view.findViewById<TextInputLayout>(R.id.passwordLayout)
//        val checkboxerror=view.findViewById<TextView>(R.id.checkerror)

        binding.signupbutton.setOnClickListener {
            binding.nameLayout.error = null
            binding.emailLayout.error = null
            binding.passwordLayout.error = null
            binding.checkerror.visibility = View.GONE

            viewModel.signUp(
                binding.emailBox.text.toString(),
                binding.passwordBox.text.toString(),
                binding.passwordBox1.text.toString(),
                binding.checkbox1.isChecked
            )
        }
//        signup.setOnClickListener {
//            namelayout.error=null
//            maillayout.error=null
//            passwordlayout.error=null
//            checkboxerror.visibility=View.GONE
//            viewModel.signUp(
//                nameEt.text.toString(),
//                emailEt.text.toString(),
//                passwordEt.text.toString(),
//                checkBox.isChecked
//            )
//        }

        viewModel.signUpStatus.observe(viewLifecycleOwner) { message ->
            if(message.equals("no name"))
            {
                binding.nameLayout.error="Name field must be filled"
            }
            else if(message.equals("no mail"))
            {
                binding.emailLayout.error="Mail field must be filled"
            }
            else if(message.equals("no password"))
            {
                binding.passwordLayout.error="Password field must be filled"
            }
            else if(message.equals("no check"))
            {
                binding.checkerror.visibility= View.VISIBLE
            }
            else if(message.equals("invalid mail"))
            {
                binding.emailLayout.error="Invalid email"
            }
            else if(message.equals("short"))
            {
                binding.passwordLayout.error="Password must be minimum of 6 characters"
            }
            else{
                Toast.makeText(requireContext(),message, Toast.LENGTH_SHORT).show()
            }
        }

        binding.back1.setOnClickListener {
            findNavController().popBackStack()

            //parentFragmentManager.popBackStack()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}
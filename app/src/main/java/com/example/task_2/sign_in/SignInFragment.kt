package com.example.task_2.sign_in

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.task_2.R
import com.example.task_2.databinding.FragmentSignInBinding
import com.example.task_2.listeners.FragmentClickListener
import com.example.task_2.sign_in.SignInViewModel

class SignInFragment : Fragment(R.layout.fragment_sign_in), FragmentClickListener {
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SignInViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSignInBinding.bind(view)
        //val forgot=view.findViewById<Button>(R.id.idforgotpassword)
        //val signin=view.findViewById<Button>(R.id.idsigninbutton)
        //val back=view.findViewById<TextView>(R.id.idback)
        //val maillayout=view.findViewById<TextInputLayout>(R.id.emailLayout)
        //val passwordlayout=view.findViewById<TextInputLayout>(R.id.passwordLayout)
        binding.idforgotpassword.setOnClickListener{
            onClick(it.id)


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
        binding.idsigninbutton.setOnClickListener{
            onClick(it.id)
        }
        viewModel.signInStatus.observe(viewLifecycleOwner){
            message->
            if(message.equals("no email"))
            {
                binding.emailLayout.error="Mail field must be filled"
            }
            else if(message.equals("no password"))
            {
                binding.passwordLayout.error="Password field must be filled"
            }
            else if(message.equals("invalid"))
            {
                binding.emailLayout.error="Invalid mail"
            }
            else{
                Toast.makeText(requireContext(),message, Toast.LENGTH_SHORT).show()
            }
        }
        binding.idback.setOnClickListener{
            onClick(it.id)
            //findNavController().popBackStack()
            //parentFragmentManager.popBackStack()
        }


    }

    override fun onClick(viewId: Int) {
        when(viewId){
            R.id.idback->{
                findNavController().popBackStack()
            }
            R.id.idsigninbutton->{
                binding.emailLayout.error=null
                binding.passwordLayout.error=null
                val mail=binding.idemailBox.text.toString()
                val password=binding.idpasswordBox.text.toString()
                viewModel.signin(mail,password)
            }
            R.id.idforgotpassword->{
                viewModel.forgot()
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}
package com.example.task_2.forgot_password

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.task_2.forgot_password.ForgotPasswordViewModel
import com.example.task_2.R
import com.example.task_2.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment : Fragment(R.layout.fragment_forgot_password) {
    private var _binding: FragmentForgotPasswordBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ForgotPasswordViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentForgotPasswordBinding.bind(view)


        binding.continuebtn.setOnClickListener {
            val mail = binding.emailBox.text.toString()
            binding.emailLayout.error = null

            viewModel.conti(mail)
        }
        viewModel.msg.observe(viewLifecycleOwner) {
            message ->
            if(message.equals("invalid"))
            {
                binding.emailLayout.error="Invalid email"
            }
            else if(message.equals("no mail"))
            {
                binding.emailLayout.error="Mail field must be filled"
            }
        }
        viewModel.navigateNext.observe(viewLifecycleOwner) {
            shouldNavigate ->
            if (shouldNavigate) {
                findNavController().navigate(R.id.forgotpassword_to_pin)
                viewModel.next()
            }
        }
        binding.back2.setOnClickListener {
           findNavController().popBackStack()
        }


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
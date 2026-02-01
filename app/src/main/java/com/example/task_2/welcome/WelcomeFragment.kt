package com.example.task_2.welcome

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.task_2.R
import com.example.task_2.welcome.WelcomeViewModel
import com.example.task_2.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: WelcomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentWelcomeBinding.bind(view)
//        val signin = view.findViewById<Button>(R.id.btnSignin)
//        val createAcc = view.findViewById<TextView>(R.id.CreateAccount)

//        signin.setOnClickListener {
//            viewModel.onSignInClicked()
//        }
//        createAcc.setOnClickListener {
//            viewModel.onCreateAccountClicked()
//        }
        binding.btnSignin.setOnClickListener {
            viewModel.onSignInClicked()
        }

        binding.CreateAccount.setOnClickListener {
            viewModel.onCreateAccountClicked()
        }
        viewModel.navigateToSignIn.observe(viewLifecycleOwner) { shouldNavigate ->
            if (shouldNavigate == true) {
                findNavController().navigate(R.id.welcome_to_signin)
                viewModel.onNavigationDone()
//                parentFragmentManager.beginTransaction()
//                    .replace(R.id.fragment_container, SignInFragment())
//                    .addToBackStack(null)
//                    .commit()

            }
        }
        viewModel.navigateToSignUp.observe(viewLifecycleOwner) { shouldNavigate ->
            if (shouldNavigate == true) {
                findNavController().navigate(R.id.welcome_to_signup)
                viewModel.onNavigationDone()
//                parentFragmentManager.beginTransaction()
//                    .replace(R.id.fragment_container, SignUpFragment())
//                    .addToBackStack(null)
//                    .commit()

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}
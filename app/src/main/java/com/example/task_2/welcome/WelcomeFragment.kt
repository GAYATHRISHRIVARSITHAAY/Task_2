package com.example.task_2.welcome

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.task_2.R
import com.example.task_2.base.BaseFragment
import com.example.task_2.welcome.WelcomeViewModel
import com.example.task_2.databinding.FragmentWelcomeBinding
import com.example.task_2.listeners.FragmentClickListener
//
//class WelcomeFragment : Fragment(R.layout.fragment_welcome),FragmentClickListener {
//
//    private var _binding: FragmentWelcomeBinding? = null
//    private val binding get() = _binding!!
//    private val viewModel: WelcomeViewModel by viewModels()
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        _binding = FragmentWelcomeBinding.bind(view)
//        binding.btnSignin.setOnClickListener {
//            onClick(it.id)
//        }
//
//        binding.CreateAccount.setOnClickListener {
//            onClick(it.id)
//        }
//        viewModel.navigateToSignIn.observe(viewLifecycleOwner) { shouldNavigate ->
//            if (shouldNavigate == true) {
//                findNavController().navigate(R.id.welcome_to_signin)
//                viewModel.onNavigationDone()
//            }
//        }
//        viewModel.navigateToSignUp.observe(viewLifecycleOwner) { shouldNavigate ->
//            if (shouldNavigate == true) {
//                findNavController().navigate(R.id.welcome_to_signup)
//                viewModel.onNavigationDone()
//            }
//        }
//    }
//    override fun onClick(viewId: Int) {
//        when(viewId){
//            R.id.btnSignin->{
//                viewModel.onSignInClicked()
//            }
//            R.id.CreateAccount->{
//                viewModel.onCreateAccountClicked()
//            }
//        }
//    }
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding=null
//    }
//}

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>(
    FragmentWelcomeBinding::inflate

){
    private val viewModel: WelcomeViewModel by viewModels()

    override fun setupViews() {
        binding.btnSignin.setOnClickListener { onClick(it.id) }
        binding.CreateAccount.setOnClickListener { onClick(it.id)}
    }

    override fun observeViewModel() {
        viewModel.navigateToSignIn.observe(viewLifecycleOwner){
            shouldnavigate->
            if(shouldnavigate){
                findNavController().navigate(R.id.welcome_to_signin)
                viewModel.onNavigationDone()
            }
        }
        viewModel.navigateToSignUp.observe(viewLifecycleOwner){
            shouldnavigate->
            if(shouldnavigate){
                findNavController().navigate(R.id.welcome_to_signup)
                viewModel.onNavigationDone()
            }
        }
    }
    override fun onClick(viewId: Int) {
        when(viewId){
            R.id.btnSignin->viewModel.onSignInClicked()
            R.id.CreateAccount->viewModel.onCreateAccountClicked()
        }
    }
}
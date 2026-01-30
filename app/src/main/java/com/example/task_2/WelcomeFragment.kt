//package com.example.task_2.welcome
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.View
//import android.widget.Button
//import android.widget.TextView
//import com.example.task_2.R
//import com.example.task_2.SignInFragment
//import com.example.task_2.SignUpFragment
//
//class WelcomeFragment : Fragment(R.layout.fragment_welcome) {
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val signin=view.findViewById<Button>(R.id.btnSignin)
//        val creatacc=view.findViewById<TextView>(R.id.CreateAccount)
//        signin.setOnClickListener{
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, SignInFragment())
//                .addToBackStack(null)
//                .commit()
//
//        }
//        creatacc.setOnClickListener{
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, SignUpFragment())
//                .addToBackStack(null)
//                .commit()
//
//        }
//    }
//}

package com.example.task_2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController


class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    private val viewModel: WelcomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val signin = view.findViewById<Button>(R.id.btnSignin)
        val createAcc = view.findViewById<TextView>(R.id.CreateAccount)

        signin.setOnClickListener {
            viewModel.onSignInClicked()
        }
        createAcc.setOnClickListener {
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
}

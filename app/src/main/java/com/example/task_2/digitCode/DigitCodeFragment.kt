package com.example.task_2.digitCode

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.task_2.R
import com.example.task_2.databinding.FragmentDigitcodeBinding

class DigitCodeFragment : Fragment(R.layout.fragment_digitcode) {
    private var _binding: FragmentDigitcodeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DigitcodeViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentDigitcodeBinding.bind(view)
//        val con = view.findViewById<Button>(R.id.conformbtn)
//        val can = view.findViewById<Button>(R.id.cancelbtn)
//        val num1 = view.findViewById<EditText>(R.id.pin1)
//        val num2 = view.findViewById<EditText>(R.id.pin2)
//        val num3 = view.findViewById<EditText>(R.id.pin3)
//        val num4 = view.findViewById<EditText>(R.id.pin4)
//        val pinerror=view.findViewById<TextView>(R.id.pinerror)
//        con.setOnClickListener {
            binding.conformbtn.setOnClickListener{
                binding.pinerror.visibility = View.GONE

                val n1 = binding.pin1.text.toString()
                val n2 = binding.pin2.text.toString()
                val n3 = binding.pin3.text.toString()
                val n4 = binding.pin4.text.toString()

                viewModel.conform(n1, n2, n3, n4)
        }
//        can.setOnClickListener {
        binding.cancelbtn.setOnClickListener{
            binding.pinerror.visibility= View.GONE
            viewModel.cancel()
        }
        viewModel.conformStatus.observe(viewLifecycleOwner) { message ->
            if(message.equals("missing"))
            {
                binding.pinerror.visibility= View.VISIBLE
            }
            else {
                Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.cancelStatus.observe(viewLifecycleOwner) { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
        viewModel.navigateBack.observe(viewLifecycleOwner) { shouldNavigate ->
            if (shouldNavigate) {
                findNavController().navigate(R.id.pin_to_welcome)
                viewModel.next()
//                parentFragmentManager.beginTransaction()
//                    .replace(R.id.fragment_container,WelcomeFragment())
//                    .addToBackStack(null)
//                    .commit()
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
package maryam.projects.firstproject

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import maryam.projects.firstproject.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {


    private var email = ""
    private var password = ""
    private lateinit var homeView: View
    private val viewModel: LoginViewModel by viewModels()
    lateinit var loginBinding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeView = inflater.inflate(R.layout.fragment_login, container, false)
        loginBinding= DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false)

        // Inflate the layout for this fragment
        return loginBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeStates()
        clickLoginBtn()
    }

    private fun observeStates() {
        viewModel.loginLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.homeFragment, null, null)
        }
        viewModel.loginErrorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

    }



    private fun getValue() {
        email = loginBinding.emailEd.text.toString()
        password = loginBinding.passEd.text.toString()
    }

    private fun clickLoginBtn() {
        loginBinding.loginBtn.setOnClickListener {
            getValue()
            if (email.isEmpty()) {
                Toast.makeText(requireContext(), "please enter phone number", Toast.LENGTH_SHORT)
                    .show()
            } else if (password.isEmpty()) {
                Toast.makeText(requireContext(), "please enter password", Toast.LENGTH_SHORT).show()
            } else if (password.length < 5) {
                Toast.makeText(
                    requireContext(),
                    "password must be more than 5 character",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                viewModel.login(email, password)
            }

        }
    }
}
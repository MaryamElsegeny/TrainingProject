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
import androidx.navigation.fragment.findNavController


class LoginFragment : Fragment() {

    private lateinit var phoneEd: EditText
    private lateinit var passwordEd: EditText
    private lateinit var loginBtn: Button
    private var phoneNum = ""
    private var password = ""
    private lateinit var homeView : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeView = inflater.inflate(R.layout.fragment_login, container, false)
        // Inflate the layout for this fragment
        return homeView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        clickLoginBtn()
    }
    private fun initViews() {
        phoneEd = homeView.findViewById(R.id.phoneNumEd)
        passwordEd = homeView.findViewById(R.id.passEd)
        loginBtn = homeView.findViewById(R.id.loginBtn)
    }

    private fun getValue() {
        phoneNum = phoneEd.text.toString()
        password = passwordEd.text.toString()
    }

    private fun clickLoginBtn() {
        loginBtn.setOnClickListener {
            getValue()
            if (phoneNum.isEmpty()) {
                Toast.makeText(requireContext(), "please enter phone number", Toast.LENGTH_SHORT).show()
            } else if (phoneNum.length != 11) {
                Toast.makeText(requireContext(), "phone number must be 11 number", Toast.LENGTH_SHORT).show()
            } else if (password.isEmpty()) {
                Toast.makeText(requireContext(), "please enter password", Toast.LENGTH_SHORT).show()
            } else if (password.length < 8) {
                Toast.makeText(requireContext(), "password must be more than 8 character", Toast.LENGTH_SHORT)
                    .show()
            } else {

                findNavController().navigate(R.id.homeFragment , null , null)

//                val intent = Intent(requireContext(), HomeActivity::class.java)
//                startActivity(intent)
            }

        }
    }
}
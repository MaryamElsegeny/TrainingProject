package maryam.projects.firstproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var phoneEd: EditText
    private lateinit var passwordEd: EditText
    private lateinit var loginBtn: Button
    private var phoneNum = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        clickLoginBtn()

    }

    private fun initViews() {
        phoneEd = findViewById(R.id.phoneNumEd)
        passwordEd = findViewById(R.id.passEd)
        loginBtn = findViewById(R.id.loginBtn)
    }

    private fun getValue() {
        phoneNum = phoneEd.text.toString()
        password = passwordEd.text.toString()
    }

    private fun clickLoginBtn() {
        loginBtn.setOnClickListener {
            getValue()
            if (phoneNum.isEmpty()) {
                Toast.makeText(this, "please enter phone number", Toast.LENGTH_SHORT).show()
            } else if (phoneNum.length != 11) {
                Toast.makeText(this, "phone number must be 11 number", Toast.LENGTH_SHORT).show()
            } else if (password.isEmpty()) {
                Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show()
            } else if (password.length < 8) {
                Toast.makeText(this, "password must be more than 8 character", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }

        }
    }
}
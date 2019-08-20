package com.tullahnazari.kotlinmessenger

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //sets the screen it goes to when it switches to this activity
        setContentView(R.layout.activity_login)

        login_button_login.setOnClickListener {
            loginUser()


        }
        back_to_register_text_view.setOnClickListener {
            finish()
        }

    }
        private fun loginUser() {
            val email = email_edittext_logina.text.toString()
            val password = password_edittext_login.text.toString()

            Log.d("Login", "Attempt login with email/pw: $email")

            if (email.isNotEmpty() || password.isNotEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->

                        if (task.isSuccessful) {
                            // Sign in success, update UI with signed-in user's information
                            Log.d("Login", "signInWithEmail:success")

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.e("Login", "signInWithEmail:failure", task.exception)
                            Toast.makeText(this@LoginActivity, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show()
            }
        }


}
package com.cerengumus.bitcointrackerapp.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.cerengumus.bitcointrackerapp.R
import com.cerengumus.bitcointrackerapp.databinding.ActivityLoginScreenBinding
import com.cerengumus.bitcointrackerapp.ui.MainScreenActivity
import com.cerengumus.bitcointrackerapp.utils.EventObserver
import com.cerengumus.bitcointrackerapp.utils.GOOGLE_LOGIN
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginScreenBinding
    private lateinit var googleSignInClient: GoogleSignInClient
    private val viewModel: LoginScreenViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.navigateToNextScreen.observe(
            this,
            EventObserver {
                navigateToMainActivity()
            }
        )

        viewModel.availability.observe(this, Observer {
            binding.progressBar.isVisible = it == true
        })
        googleSignInImpl()
    }
    private fun navigateToMainActivity() {
        startActivity(Intent(this, MainScreenActivity::class.java))
        finish()
    }
    private fun googleSignInImpl() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(R.string.default_web_client_id.toString())
            .requestEmail()
            .requestProfile()
            .requestId()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        binding.googleSignInButton.setOnClickListener {
            navigateToMainActivity()
            //val intent = googleSignInClient.signInIntent
            //startActivityForResult(intent, GOOGLE_LOGIN)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GOOGLE_LOGIN) {
            data?.let {
                viewModel.signIn(data)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.controlFirebaseUser()
    }
}
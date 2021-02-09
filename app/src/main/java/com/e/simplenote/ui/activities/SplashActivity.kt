package com.e.simplenote.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.ViewModelProvider
import com.e.simplenote.R
import com.e.simplenote.utilits.TYPE_ROOM

class SplashActivity : AppCompatActivity() {

    private lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        }, 3000)
        init()


    }


    private fun init() {
        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
        viewModel.initDatabase(TYPE_ROOM)
    }
}
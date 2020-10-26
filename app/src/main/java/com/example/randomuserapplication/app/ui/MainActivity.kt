package com.example.randomuserapplication.app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.randomuserapplication.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainUsersViewModel>()

    private val binding by lazy {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
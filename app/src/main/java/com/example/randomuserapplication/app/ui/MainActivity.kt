package com.example.randomuserapplication.app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.randomuserapplication.R
import com.example.randomuserapplication.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private val viewModel by viewModel<MainUsersViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureView()
        observerUsers()
        observerError()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAll()
    }

    private fun configureView() {
        binding?.viewModel = viewModel
        binding?.lifecycleOwner = this
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private fun observerUsers() {
        viewModel.users.observe(this,
        Observer {data ->
            data.results.forEach { user ->
                Toast.makeText(this, "Users: $user", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun observerError() {
        viewModel.error.observe(this,
        Observer {error ->
            Toast.makeText(this, "Users: ${error.message}", Toast.LENGTH_SHORT).show()

        })
    }
}
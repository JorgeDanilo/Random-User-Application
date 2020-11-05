package com.example.randomuserapplication.app.ui

import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.randomuserapplication.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.randomuserapplication.databinding.ActivityMainBinding as Binding

class MainActivity : BaseActivity() {

    private val viewModel by viewModel<MainUsersViewModel>()

    private val binding by lazy {
        DataBindingUtil.setContentView<Binding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideActionBar()
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
    }

    private fun observerUsers() {
        viewModel.users.observe(this,
            Observer { data ->
                binding?.recyclerView?.adapter = ListUsersAdapter(data.results, this)
            }
        )
    }

    private fun observerError() {
        viewModel.error.observe(this,
            Observer { error ->
                Toast.makeText(this, "Users: ${error.message}", Toast.LENGTH_SHORT).show()
            })
    }
}
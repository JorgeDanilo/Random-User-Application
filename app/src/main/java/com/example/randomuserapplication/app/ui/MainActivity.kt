package com.example.randomuserapplication.app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.Window
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.randomuserapplication.R
import com.example.randomuserapplication.databinding.ActivityMainBinding as Binding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

//    private var binding: ActivityMainBinding? = null
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
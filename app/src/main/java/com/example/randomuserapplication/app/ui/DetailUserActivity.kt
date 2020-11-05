package com.example.randomuserapplication.app.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.randomuserapplication.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.randomuserapplication.databinding.ActivityDetailUserBinding as Binding

class DetailUserActivity : BaseActivity() {

    private val viewModel by viewModel<DetailUserViewModel>()

    private val binding by lazy {
        DataBindingUtil.setContentView<Binding>(this, R.layout.activity_detail_user)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideActionBar()
        configureView()
    }

    private fun configureView() {
        binding?.viewModel = viewModel
        binding?.lifecycleOwner = this
    }
}
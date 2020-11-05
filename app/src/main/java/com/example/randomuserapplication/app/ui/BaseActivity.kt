package com.example.randomuserapplication.app.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    protected fun hideActionBar() {
        supportActionBar?.hide();
    }

}
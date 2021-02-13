package com.example.randomuserapplication.app.ui

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import com.example.randomuserapplication.R
import kotlinx.android.synthetic.main.activity_popup.*

class PopupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup)
        btnShowToast.setOnClickListener {
            onShowToast(findViewById<View>(R.id.btnShowToast))
        }
    }

    private fun onShowToast(view : View) {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.toast_layout, null) as View

        val width = LinearLayout.LayoutParams.WRAP_CONTENT
        val height = LinearLayout.LayoutParams.WRAP_CONTENT;
        val focusable = true
        val popupWindow = PopupWindow(popupView, width, height, focusable)

        val location = IntArray(2)
        view.getLocationOnScreen(location)


        popupWindow.showAtLocation(view, Gravity.NO_GRAVITY, location[0], location[1] - 120)
//        popupWindow.showAsDropDown(view, view.x.toInt(), view.y.toInt())

        popupView.setOnTouchListener { _, _ ->
            popupWindow.dismiss()
            true
        }
    }
}
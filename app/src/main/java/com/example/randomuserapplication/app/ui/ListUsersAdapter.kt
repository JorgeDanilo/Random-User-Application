package com.example.randomuserapplication.app.ui

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.randomuserapplication.R
import com.example.randomuserapplication.databinding.ListUsersItemBinding
import com.example.randomuserapplication.domain.model.User
import com.facebook.drawee.generic.RoundingParams

class ListUsersAdapter(
    private val users: List<User>,
    private val mActivity: Activity
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ListUserViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.list_users_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as ListUserViewHolder).binding
        val user = users[position]
        binding.user = user
        configureAnimation(holder)
    }

    private fun configureAnimation(holder: ListUserViewHolder) {
        val loadAnimation =
            AnimationUtils.loadAnimation(mActivity, R.anim.layout_animation_from_rigth)
        holder.itemView.startAnimation(loadAnimation)
    }

    override fun getItemCount() = users.size
}


class ListUserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding: ListUsersItemBinding = ListUsersItemBinding.bind(view)
}

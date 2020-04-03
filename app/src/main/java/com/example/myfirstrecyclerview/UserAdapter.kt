package com.example.myfirstrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.user_details.view.*

class UserAdapter(val users : List<UserDetails>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return  UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.user_details, parent, false)
        )
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.view.textViewName.text = user.name
        holder.view.textViewLogin.text = user.owner.login
        holder.view.textViewDescription.text = user.description

        Glide.with(holder.view.context).load(user.owner.avatar_url).into(holder.view.imageView)
    }

    class UserViewHolder(val view : View) : RecyclerView.ViewHolder(view)
}
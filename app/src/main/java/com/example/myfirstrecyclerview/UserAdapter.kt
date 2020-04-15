package com.example.myfirstrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.user_details.view.*

class UserAdapter(val users : List<UserDetails>, var clickListener: onUserItemClickListener) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return  UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.user_details, parent, false)
        )
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
//        holder.view.textViewName.text = user.name
//        holder.view.textViewLogin.text = user.owner.login
//        holder.view.textViewDescription.text = user.description
          holder.initialize(users[position],clickListener)

        Glide.with(holder.view.context).load(user.owner.avatar_url).into(holder.view.imageView)
    }

    class UserViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
        var UserName = view.textViewName
        var UserLogin = view.textViewLogin
        var UserDescription = view.textViewDescription


        fun initialize(users: UserDetails, action: onUserItemClickListener) {
            UserName.text = users.name
            UserLogin.text = users.owner.login
            UserDescription.text = users.description
            //Glide.with(view.context).load(users.owner.avatar_url).into(ImageUser)

            view.setOnClickListener {
                action.onItemClick(users,adapterPosition)
            }
        }
    }
}

interface onUserItemClickListener {
    fun onItemClick(users: UserDetails, position: Int) {
    }
}
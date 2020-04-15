package com.example.myfirstrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfirstrecyclerview.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), onUserItemClickListener {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        UsersApi().getUsers().enqueue(object: Callback<List<UserDetails>> {
            override fun onFailure(call: Call<List<UserDetails>>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<UserDetails>>, response: Response<List<UserDetails>>) {
                val users = response.body()

                users?.let {
                    showUsers(it)
                }
            }
        })
    }

    private fun showUsers(users: List<UserDetails> ) {
        recyclerViewUsers.layoutManager = LinearLayoutManager(this)
        recyclerViewUsers.addItemDecoration(DividerItemDecoration(this,1))
        recyclerViewUsers.adapter = UserAdapter(users,this)
    }

    override fun onItemClick(users: UserDetails, position: Int) {

        Toast.makeText(this,users.name, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, RepoDetailsActivity::class.java)
        intent.putExtra("User Name",users.name)
        intent.putExtra("Full Name",users.full_name)
        intent.putExtra("Login",users.owner.login)
        intent.putExtra("Type",users.owner.type)
        intent.putExtra("Site Admin",users.owner.site_admin)
        intent.putExtra("Fork",users.fork)
        intent.putExtra("Description",users.description)
        startActivity(intent)
    }
}

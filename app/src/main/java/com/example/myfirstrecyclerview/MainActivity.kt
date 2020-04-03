package com.example.myfirstrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        recyclerViewUsers.adapter = UserAdapter(users)
    }
}

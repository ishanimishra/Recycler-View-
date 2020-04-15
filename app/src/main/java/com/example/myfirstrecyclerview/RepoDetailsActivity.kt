package com.example.myfirstrecyclerview

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.myfirstrecyclerview.databinding.ActivityRepoDetailsBinding
import kotlinx.android.synthetic.main.activity_repo_details.*

class RepoDetailsActivity : AppCompatActivity() {
    lateinit var binding : ActivityRepoDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_repo_details)

        user_name.text = getIntent().getStringExtra("User Name")
        user_full_name.text = getIntent().getStringExtra("Full Name")
        user_login.text = getIntent().getStringExtra("Login")
        user_type.text = getIntent().getStringExtra("Type")
        site_admin.text = getIntent().getStringExtra("Site Admin")
        fork.text = getIntent().getStringExtra("Fork")
        description.text = getIntent().getStringExtra("Description")
    }
}

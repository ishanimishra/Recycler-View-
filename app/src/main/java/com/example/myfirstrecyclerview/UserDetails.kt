package com.example.myfirstrecyclerview

data class UserDetails (
    val name : String,
    val owner : Owner,
    val description : String
)

data class Owner (
    val login : String,
    val avatar_url : String
)
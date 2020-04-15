package com.example.myfirstrecyclerview

data class UserDetails (
    val name : String,
    val full_name : String,
    //val private : String,
    val owner : Owner,
    val fork : String,
    val description : String
)

data class Owner (
    val login : String,
    val avatar_url : String,
    val type : String,
    val site_admin : String
)
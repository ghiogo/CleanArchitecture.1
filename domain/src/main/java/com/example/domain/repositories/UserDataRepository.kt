package com.example.domain.repositories

import com.example.domain.models.User

interface UserDataRepository {

    fun authUser(name: String, age: Int, surname: String)

    fun getUser(): User
}
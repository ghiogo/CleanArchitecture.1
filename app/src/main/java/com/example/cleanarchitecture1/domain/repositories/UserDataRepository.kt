package com.example.cleanarchitecture1.domain.repositories

import com.example.cleanarchitecture1.models.UserData

interface UserDataRepository {

    fun authUser(name: String, age: Int, surname: String)

    fun getUser(): UserData
}
package com.example.data.repositories

import com.example.data.local.preferences.UserDataPreferencesHelper
import com.example.data.remote.dtos.UserDto
import com.example.data.remote.dtos.toDomain
import com.example.domain.repositories.UserDataRepository
import javax.inject.Inject

class UserDataRepositoryImpl @Inject constructor(
    private val userDataPreferencesHelper: UserDataPreferencesHelper
) : UserDataRepository {

    override fun authUser(name: String, age: Int, surname: String) {
        userDataPreferencesHelper.apply {
            this.name = name
            this.age = age
            this.surname = surname
        }
    }

    override fun getUser() = UserDto(
        userDataPreferencesHelper.name.toString(),
        userDataPreferencesHelper.surname.toString(),
        userDataPreferencesHelper.age
    ).toDomain()
}
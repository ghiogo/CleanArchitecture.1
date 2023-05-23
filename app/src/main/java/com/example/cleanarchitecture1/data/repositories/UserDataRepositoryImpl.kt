package com.example.cleanarchitecture1.data.repositories

import com.example.cleanarchitecture1.data.local.preferences.UserDataPreferencesHelper
import com.example.cleanarchitecture1.domain.repositories.UserDataRepository
import com.example.cleanarchitecture1.models.UserData
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

    override fun getUser()= UserData(
        userDataPreferencesHelper.name.toString(),
        userDataPreferencesHelper.age,
        userDataPreferencesHelper.surname.toString()
    )
}
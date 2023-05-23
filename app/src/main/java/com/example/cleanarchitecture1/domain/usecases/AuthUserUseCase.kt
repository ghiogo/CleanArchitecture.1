package com.example.cleanarchitecture1.domain.usecases

import com.example.cleanarchitecture1.domain.repositories.UserDataRepository
import javax.inject.Inject

class AuthUserUseCase @Inject constructor(
    private val userDataRepository: UserDataRepository
) {

    operator fun invoke(name: String, age: Int, surname: String){
        userDataRepository.authUser(name, age, surname)
    }
}
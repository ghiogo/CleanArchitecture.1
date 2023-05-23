package com.example.cleanarchitecture1.domain.usecases

import com.example.cleanarchitecture1.domain.repositories.UserDataRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userDataRepository: UserDataRepository
) {

    operator fun invoke() = userDataRepository.getUser()
}
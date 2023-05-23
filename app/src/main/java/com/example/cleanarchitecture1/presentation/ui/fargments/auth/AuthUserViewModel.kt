package com.example.cleanarchitecture1.presentation.ui.fargments.auth

import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture1.domain.usecases.AuthUserUseCase
import com.example.cleanarchitecture1.domain.usecases.GetUserUseCase
import com.example.cleanarchitecture1.models.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthUserViewModel @Inject constructor(
    private val authUserUseCase: AuthUserUseCase,
    private val getUserUseCase: GetUserUseCase
): ViewModel() {

    fun authUser(name: String, age: Int, surname: String) {
        authUserUseCase(name, age, surname)
    }

    fun getUser(): UserData {
        return getUserUseCase()
    }
}
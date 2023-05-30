package com.example.presentation.ui.fargments.auth

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.AuthUserUseCase
import com.example.domain.usecases.GetUserUseCase
import com.example.presentation.models.UserUI
import com.example.presentation.models.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthUserViewModel @Inject constructor(
    private val authUserUseCase: AuthUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    fun authUser(name: String, age: Int, surname: String) {
        authUserUseCase(name, age, surname)
    }

    fun getUser(): UserUI {
        return getUserUseCase().toUI()
    }
}
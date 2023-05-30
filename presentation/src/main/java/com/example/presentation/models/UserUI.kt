package com.example.presentation.models

import com.example.domain.models.User

data class UserUI(
    val name: String,
    val surname: String,
    val age: Int
)

fun User.toUI() : UserUI {
    return UserUI(
        name,
        surname,
        age
    )
}

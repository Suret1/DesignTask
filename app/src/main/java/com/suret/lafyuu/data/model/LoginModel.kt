package com.suret.lafyuu.data.model

import androidx.annotation.Keep

@Keep
data class LoginModel(
    val email: String,
    val password: String
)
@Keep
data class ResponseLoginModel(
    val message: String,
    val name: String,
    val photo: String,
    val token: String
)
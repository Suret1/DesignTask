package com.suret.lafyuu.data.model

import androidx.annotation.Keep

@Keep
data class RegisterModel(
    val name: String,
    val email: String,
    val password: String
)
@Keep
data class ResponseRegisterModel(
    val message: String,
    val name: String
)
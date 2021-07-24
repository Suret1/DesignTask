package com.suret.lafyuu.data.api

import com.suret.lafyuu.data.model.LoginModel
import com.suret.lafyuu.data.model.RegisterModel
import com.suret.lafyuu.data.model.ResponseLoginModel
import com.suret.lafyuu.data.model.ResponseRegisterModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthAPI {
    @POST("/register")
    suspend fun register(@Body registerModel: RegisterModel): Response<ResponseRegisterModel>

    @POST("/login")
    suspend fun login(@Body loginModel: LoginModel): Response<ResponseLoginModel>
}
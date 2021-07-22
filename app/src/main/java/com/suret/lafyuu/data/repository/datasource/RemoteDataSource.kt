package com.suret.lafyuu.data.repository.datasource

import com.suret.lafyuu.data.model.LoginModel
import com.suret.lafyuu.data.model.RegisterModel
import com.suret.lafyuu.data.model.ResponseLoginModel
import com.suret.lafyuu.data.model.ResponseRegisterModel
import retrofit2.Response

interface RemoteDataSource {
    suspend fun register(registerModel: RegisterModel): Response<ResponseRegisterModel>
    suspend fun login(loginModel: LoginModel): Response<ResponseLoginModel>
}
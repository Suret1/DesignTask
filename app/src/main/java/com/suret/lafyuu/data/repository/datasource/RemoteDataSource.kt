package com.suret.lafyuu.data.repository.datasource

import com.suret.lafyuu.data.model.*
import retrofit2.Response

interface RemoteDataSource {
    suspend fun register(registerModel: RegisterModel): Response<ResponseRegisterModel>
    suspend fun login(loginModel: LoginModel): Response<ResponseLoginModel>
    suspend fun getListForHome(token: String): Response<HomeModel>

}
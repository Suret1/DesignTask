package com.suret.lafyuu.domain.repository

import com.suret.lafyuu.data.model.LoginModel
import com.suret.lafyuu.data.model.RegisterModel
import com.suret.lafyuu.data.model.ResponseLoginModel
import com.suret.lafyuu.data.model.ResponseRegisterModel
import com.suret.lafyuu.data.util.Resource
import retrofit2.Response

interface LafyuuRepository {
    suspend fun register(registerModel: RegisterModel): Response<ResponseRegisterModel>
    suspend fun login(loginModel: LoginModel): Resource<ResponseLoginModel>
}

package com.suret.lafyuu.domain.repository

import com.suret.lafyuu.data.model.*
import com.suret.lafyuu.data.util.Resource
import retrofit2.Response

interface LafyuuRepository {
    suspend fun register(registerModel: RegisterModel): Resource<ResponseRegisterModel>
    suspend fun login(loginModel: LoginModel): Resource<ResponseLoginModel>
    suspend fun getListForHome(token : String): Resource<HomeModel>

}

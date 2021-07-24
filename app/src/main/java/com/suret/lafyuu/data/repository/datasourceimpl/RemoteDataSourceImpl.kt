package com.suret.lafyuu.data.repository.datasourceimpl

import com.suret.lafyuu.data.api.AuthAPI
import com.suret.lafyuu.data.api.HomePageAPI
import com.suret.lafyuu.data.model.*
import com.suret.lafyuu.data.repository.datasource.RemoteDataSource
import retrofit2.Response

class RemoteDataSourceImpl(
    private val authApi: AuthAPI,
    private val homePageAPI: HomePageAPI
) : RemoteDataSource {
    override suspend fun register(registerModel: RegisterModel): Response<ResponseRegisterModel> {
        return authApi.register(registerModel)
    }

    override suspend fun login(loginModel: LoginModel): Response<ResponseLoginModel> {
        return authApi.login(loginModel)
    }

    override suspend fun getListForHome(token: String): Response<HomeModel> {
        return homePageAPI.getListForHome(token)
    }

}
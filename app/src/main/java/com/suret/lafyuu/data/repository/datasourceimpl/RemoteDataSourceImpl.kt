package com.suret.lafyuu.data.repository.datasourceimpl

import com.suret.lafyuu.data.api.IAuthAPI
import com.suret.lafyuu.data.model.LoginModel
import com.suret.lafyuu.data.model.RegisterModel
import com.suret.lafyuu.data.model.ResponseLoginModel
import com.suret.lafyuu.data.model.ResponseRegisterModel
import com.suret.lafyuu.data.repository.datasource.RemoteDataSource
import retrofit2.Response

class RemoteDataSourceImpl(
    private val authApi: IAuthAPI
) : RemoteDataSource {
    override suspend fun register(registerModel: RegisterModel): Response<ResponseRegisterModel> {
        return authApi.register(registerModel)
    }
    override suspend fun login(loginModel: LoginModel): Response<ResponseLoginModel> {
        return authApi.login(loginModel)
    }

}
package com.suret.lafyuu.data.repository

import com.suret.lafyuu.data.model.LoginModel
import com.suret.lafyuu.data.model.RegisterModel
import com.suret.lafyuu.data.model.ResponseLoginModel
import com.suret.lafyuu.data.model.ResponseRegisterModel
import com.suret.lafyuu.data.repository.datasource.LocalDataSource
import com.suret.lafyuu.data.repository.datasource.RemoteDataSource
import com.suret.lafyuu.data.util.Resource
import com.suret.lafyuu.domain.repository.LafyuuRepository
import retrofit2.Response

class LafyuuRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : LafyuuRepository {
    override suspend fun register(registerModel: RegisterModel): Response<ResponseRegisterModel> {
        return remoteDataSource.register(registerModel)
    }

    override suspend fun login(loginModel: LoginModel): Resource<ResponseLoginModel> {
        val result = remoteDataSource.login(loginModel)
        if (result.isSuccessful){
            result.body()?.let {data->
                return Resource.Success(data)
            } ?: kotlin.run {
                return Resource.Error(result.message())
            }
        }else{
            return Resource.Error(result.message())
        }
    }


}
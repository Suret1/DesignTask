package com.suret.lafyuu.data.repository

import android.util.Log
import com.suret.lafyuu.data.model.*
import com.suret.lafyuu.data.repository.datasource.LocalDataSource
import com.suret.lafyuu.data.repository.datasource.RemoteDataSource
import com.suret.lafyuu.data.util.Resource
import com.suret.lafyuu.domain.repository.LafyuuRepository
import retrofit2.Response

class LafyuuRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : LafyuuRepository {

    override suspend fun register(registerModel: RegisterModel): Resource<ResponseRegisterModel> {
        val result = remoteDataSource.register(registerModel)
        if (result.isSuccessful) {
            result.body()?.let { data ->
                return Resource.Success(data)
            } ?: kotlin.run {
                return Resource.Error(result.message())
            }
        } else {
            return Resource.Error(result.message())
        }
    }

    override suspend fun login(loginModel: LoginModel): Resource<ResponseLoginModel> {
        val response = remoteDataSource.login(loginModel)
        if (response.isSuccessful) {
            response.body()?.let { data ->
                return Resource.Success(data)
            } ?: kotlin.run {
                return Resource.Error(response.message())
            }
        } else {
                return Resource.Error(response.message())
        }
    }

    override suspend fun getListForHome(token: String): Resource<HomeModel> {
        val result = remoteDataSource.getListForHome(token)
        if (result.isSuccessful) {
            result.body()?.let { data ->
                return Resource.Success(data)
            } ?: kotlin.run {
                return Resource.Error(result.message())
            }
        } else {
            return Resource.Error(result.message())
        }
    }


}
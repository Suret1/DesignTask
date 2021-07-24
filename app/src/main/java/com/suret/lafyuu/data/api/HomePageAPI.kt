package com.suret.lafyuu.data.api

import com.suret.lafyuu.data.model.HomeModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface HomePageAPI {
    @GET("/home-page")
    suspend fun getListForHome(
        @Header("Authorization") token: String
    ): Response<HomeModel>
}
package com.suret.lafyuu.domain.usecase

import com.suret.lafyuu.data.model.HomeModel
import com.suret.lafyuu.data.util.Resource
import com.suret.lafyuu.domain.repository.LafyuuRepository

class GetHomeListUseCase(private val lafyuuRepository: LafyuuRepository) {
    suspend fun execute(token: String): Resource<HomeModel> {
        return lafyuuRepository.getListForHome(token)
    }
}
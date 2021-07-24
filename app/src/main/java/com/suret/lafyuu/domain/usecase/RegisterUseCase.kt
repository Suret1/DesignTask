package com.suret.lafyuu.domain.usecase

import com.suret.lafyuu.data.model.RegisterModel
import com.suret.lafyuu.data.model.ResponseRegisterModel
import com.suret.lafyuu.data.util.Resource
import com.suret.lafyuu.domain.repository.LafyuuRepository
import retrofit2.Response

class RegisterUseCase(private val lafyuuRepository: LafyuuRepository) {
    suspend fun execute(registerModel: RegisterModel): Resource<ResponseRegisterModel> {
        return lafyuuRepository.register(registerModel)
    }
}
package com.suret.lafyuu.domain.usecase

import com.suret.lafyuu.data.model.LoginModel
import com.suret.lafyuu.data.model.ResponseLoginModel
import com.suret.lafyuu.domain.repository.LafyuuRepository
import com.suret.lafyuu.data.util.Resource

class LoginUseCase(private val lafyuuRepository: LafyuuRepository) {

    suspend fun execute(loginModel: LoginModel): Resource<ResponseLoginModel> {
        return lafyuuRepository.login(loginModel)
    }

}
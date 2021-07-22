package com.suret.lafyuu.data.model

data class ErrorModel(val message: String?, val typeError: TypeError?)

enum class TypeError {
    FULLNAME_ERROR,
    EMAIL_ERROR,
    EMAIL_PASSWORD_ERROR,
    INVALID_EMAIL_ERROR,
    PASSWORD_ERROR,
    CONFIRM_PASS_ERROR,
    CONFIRM_PASS_SAME_ERROR
}

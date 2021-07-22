package com.suret.lafyuu.data.util

import androidx.annotation.Keep

@Keep
object Common {

    fun isEmailInValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}
package com.suret.lafyuu.ui.auth.viewmodel

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.suret.lafyuu.data.model.ErrorModel
import com.suret.lafyuu.data.model.LoginModel
import com.suret.lafyuu.data.model.TypeError
import com.suret.lafyuu.data.util.Common
import com.suret.lafyuu.data.util.Resource
import com.suret.lafyuu.domain.usecase.LoginUseCase
import com.suret.lafyuu.domain.usecase.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    @ApplicationContext val context: Context,
    private val loginUseCase: LoginUseCase,
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    sealed class Event {
        class Success<T>(
            val result: T,
        ) : Event()

        class Failure(val errorModel: ErrorModel?) : Event()
        object Loading : Event()
    }

    private val loginChannel = Channel<Event>()
    val loginFlow = loginChannel.receiveAsFlow()

    private val registerChannel = Channel<Event>()
    val registerFlow = registerChannel.receiveAsFlow()


    fun login(email: String?, password: String?) = viewModelScope.launch {
        Dispatchers.IO

        if (email.isNullOrEmpty() && password.isNullOrEmpty()) {
            loginChannel.send(
                Event.Failure(
                    ErrorModel("Email bos ola bilmez", TypeError.EMAIL_PASSWORD_ERROR)
                )
            )
        } else if (email.isNullOrEmpty()) {
            loginChannel.send(
                Event.Failure(
                    ErrorModel("Email bos ola bilmez", TypeError.EMAIL_ERROR)
                )
            )
        } else if (!Common.isEmailInValid(email ?: "")) {
            loginChannel.send(
                Event.Failure(
                    ErrorModel(
                        "Duzgun email daxil edin",
                        TypeError.INVALID_EMAIL_ERROR
                    )
                )
            )
        } else if (password.isNullOrEmpty()) {
            loginChannel.send(
                Event.Failure(
                    ErrorModel("Parol bos ola bilmez", TypeError.PASSWORD_ERROR)
                )
            )
        }

        val body = LoginModel(email ?: " ", password ?: " ")
        if (isNetworkAvailable(context)) {
            loginChannel.send(Event.Loading)
            when (val result = loginUseCase.execute(body)) {
                is Resource.Success -> {
                    result.data?.let {
                        loginChannel.send(Event.Success(it))
                    } ?: kotlin.run {
                        loginChannel.send(Event.Failure(ErrorModel(result.message ?: "", null)))
                    }
                }
                else -> {
                    loginChannel.send(Event.Failure(ErrorModel(result.message ?: "", null)))
                }
            }
        } else {
            loginChannel.send(Event.Failure(ErrorModel("No internet" ?: "", null)))
        }
    }

    private fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // For 29 api or above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
                    ?: return false
            return when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                else -> false
            }
        }
        // For below 29 api
        else {
            if (connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo!!.isConnectedOrConnecting) {
                return true
            }
        }
        return false
    }
}
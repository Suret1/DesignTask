package com.suret.lafyuu.ui.home.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.suret.lafyuu.R
import com.suret.lafyuu.data.model.HomeModel
import com.suret.lafyuu.data.util.Resource
import com.suret.lafyuu.domain.usecase.GetHomeListUseCase
import com.suret.lafyuu.util.Utils
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    @ApplicationContext val context: Context,
    private val getHomeListUseCase: GetHomeListUseCase
) : ViewModel() {
    sealed class Event {
        class Success(
            val result: HomeModel?,
            val message: String?
        ) : Event()

        class Failure(val message: String?) : Event()
        object Loading : Event()
    }

    private val homeChannel = Channel<Event>()
    val homeFlow = homeChannel.receiveAsFlow()

    fun getHomeList(token: String) = viewModelScope.launch {
        if (Utils.isNetworkAvailable(context)) {
            homeChannel.send(Event.Loading)
            when (val result = getHomeListUseCase.execute(token)) {
                is Resource.Success -> {
                        result.let {
                            homeChannel.send(Event.Success(it.data, null))
                        }
                }
                is Resource.Error -> {
                    homeChannel.send(Event.Failure("Something went wrong"))
                }
            }
        } else {
            homeChannel.send(Event.Failure(context.getString(R.string.no_internet)))
        }
    }

}
package com.android.aigittest.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.android.aigittest.domain.model.Ip
import com.android.aigittest.domain.repository.IpRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class IpViewModel(
    private val ipRepository: IpRepository
) : ViewModel() {
    private val _ip = MutableStateFlow(Ip())
    val ip: StateFlow<Ip>
        get() = _ip.asStateFlow()

    init {
        getIp()
    }

    private fun getIp() {
        viewModelScope.launch {
            _ip.value = ipRepository.getIp()
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as IpApplication)
                val ipRepository = application.container.ipRepository
                IpViewModel(ipRepository = ipRepository)
            }
        }
    }
}
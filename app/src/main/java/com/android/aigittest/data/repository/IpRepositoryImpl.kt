package com.android.aigittest.data.repository

import com.android.aigittest.data.api.IpApi
import com.android.aigittest.domain.IpContainer
import com.android.aigittest.domain.model.Ip
import com.android.aigittest.domain.repository.IpRepository

class IpRepositoryImpl(
    private val ipService: IpApi
) : IpRepository {
    override suspend fun getIp(): Ip {
        val response = ipService.ipSearch()
        return Ip(ip = response.myip)
    }
}
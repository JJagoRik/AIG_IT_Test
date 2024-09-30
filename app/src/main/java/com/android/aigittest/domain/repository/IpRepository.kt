package com.android.aigittest.domain.repository

import com.android.aigittest.domain.model.Ip

interface IpRepository {
    suspend fun getIp() : Ip
}
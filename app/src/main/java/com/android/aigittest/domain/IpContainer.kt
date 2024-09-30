package com.android.aigittest.domain

import com.android.aigittest.domain.repository.IpRepository

interface IpContainer {
    val ipRepository: IpRepository
}
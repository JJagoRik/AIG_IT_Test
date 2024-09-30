package com.android.aigittest.data.api

import com.android.aigittest.data.repository.IpRepositoryImpl
import com.android.aigittest.domain.IpContainer
import com.android.aigittest.domain.repository.IpRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient() : IpContainer {
    private val BASE_URL = "https://functions.yandexcloud.net/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitService: IpApi by lazy {
        retrofit.create(IpApi::class.java)
    }

    override val ipRepository: IpRepository by lazy {
        IpRepositoryImpl(retrofitService)
    }
}
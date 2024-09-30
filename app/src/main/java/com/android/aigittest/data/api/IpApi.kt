package com.android.aigittest.data.api

import com.android.aigittest.data.model.IpDTO
import retrofit2.http.GET

interface IpApi {
    @GET("d4e2bt6jba6cmiekqmsv")
    suspend fun ipSearch() : IpDTO
}
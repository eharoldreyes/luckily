package com.eharoldreyes.freelancemovies.network

import com.eharoldreyes.freelancemovies.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val url = request.url()

        val newUrl = url.newBuilder()
            .addQueryParameter("api_key", BuildConfig.API_KEY)
            .build()

        return chain.proceed(
            request.newBuilder()
                .url(newUrl)
                .build()
        )
    }
}
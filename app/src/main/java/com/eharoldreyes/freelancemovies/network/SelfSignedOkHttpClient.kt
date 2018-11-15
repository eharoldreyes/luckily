package com.eharoldreyes.freelancemovies.network

import okhttp3.OkHttpClient
import java.lang.Exception
import java.lang.RuntimeException
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

object SelfSignedOkHttpClient {

    fun create(): OkHttpClient {
        try {

            val trustAllCerts = arrayOf<TrustManager>(object: X509TrustManager {
                override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {}

                override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {}

                override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
            })

            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, SecureRandom())

            val sslServerSocketFactory = sslContext.socketFactory

            return OkHttpClient.Builder().apply {
                addInterceptor(AuthenticationInterceptor())
                sslSocketFactory(sslServerSocketFactory, trustAllCerts[0] as X509TrustManager)
            }.build()

        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }


}
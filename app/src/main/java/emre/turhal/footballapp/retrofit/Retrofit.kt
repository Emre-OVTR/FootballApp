package emre.turhal.footballapp.retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Retrofit {
    companion object{
        private const val BASE_URL="https://api.football-data.org"

        private val interceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY

        }

        //network request

        private val client = OkHttpClient.Builder().apply {
            addNetworkInterceptor(interceptor)
            addInterceptor{chain->
                val url = chain
                    .request()
                    .url
                    .newBuilder()
                    .build()
                chain.proceed(
                    chain.request()
                        .newBuilder()
                        .url(url)
                        .addHeader("X-Auth-Token","996216aa0f4343158d040d9c0178d687")
                        .build()
                )
            }
            connectTimeout(20, TimeUnit.SECONDS)
        }.build()


        //retrofit constructor

        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }
    }
}
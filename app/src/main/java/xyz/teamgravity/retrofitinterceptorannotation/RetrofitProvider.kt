package xyz.teamgravity.retrofitinterceptorannotation

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitProvider {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com"

    val dummyApi: DummyApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(AuthenticatedInterceptor())
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()
            )
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(DummyApi::class.java)
    }
}
package xyz.teamgravity.retrofitinterceptorannotation

import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Invocation

class AuthenticatedInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val invocation = chain.request().tag(Invocation::class.java)
            ?: return chain.proceed(chain.request())

        val shouldAttachAuthHeader = invocation
            .method()
            .annotations
            .any { it.annotationClass == Authenticated::class }

        return if (shouldAttachAuthHeader) chain.proceed(
            chain.request()
                .newBuilder()
                .addHeader("Authorization", "50 cent or some kinda token man")
                .build()
        ) else chain.proceed(chain.request())
    }
}
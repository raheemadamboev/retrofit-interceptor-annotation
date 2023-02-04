package xyz.teamgravity.retrofitinterceptorannotation

import retrofit2.http.GET

interface DummyApi {

    ///////////////////////////////////////////////////////////////////////////
    // GET
    ///////////////////////////////////////////////////////////////////////////

    @GET("users/1")
    suspend fun getUser()

    @GET("/posts/1")
    @Authenticated
    suspend fun getPost()
}
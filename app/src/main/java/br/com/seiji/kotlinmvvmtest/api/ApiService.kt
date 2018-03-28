package br.com.seiji.kotlinmvvmtest.api

import br.com.seiji.kotlinmvvmtest.api.model.MyModel
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET(".")
    fun getJsonResponse(): Single<MyModel>

}
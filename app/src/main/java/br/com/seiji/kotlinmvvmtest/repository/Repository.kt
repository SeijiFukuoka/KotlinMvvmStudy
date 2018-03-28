package br.com.seiji.kotlinmvvmtest.repository

import br.com.seiji.kotlinmvvmtest.api.ApiService
import br.com.seiji.kotlinmvvmtest.api.model.MyModel
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val apiService: ApiService) {

    fun getDataFromApi(): Single<MyModel> = apiService.getJsonResponse()

}
package br.com.seiji.kotlinmvvmtest.repository

import br.com.seiji.kotlinmvvmtest.api.ApiService
import br.com.seiji.kotlinmvvmtest.api.model.MyModel
import io.reactivex.Single

class Repository constructor(private val apiService: ApiService) {

    fun getDataFromApi(): Single<MyModel> = apiService.getJsonResponse()

}
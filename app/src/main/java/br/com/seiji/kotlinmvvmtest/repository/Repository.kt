package br.com.seiji.kotlinmvvmtest.repository

import br.com.seiji.kotlinmvvmtest.api.ApiService
import br.com.seiji.kotlinmvvmtest.api.model.GitHubRepositoryListResponse
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val apiService: ApiService) {

    fun getDataFromApi(query: String, sort: String, page: Int): Single<GitHubRepositoryListResponse> = apiService.getRepositories(query, sort, page)

}
package br.com.seiji.kotlinmvvmtest.data.remote

import javax.inject.Inject

class GitHubDataSource @Inject constructor(private val apiService: ApiService) {

    fun requestRepositoriesList(query: String, sort: String, page: Int) =
            apiService.getRepositories(query, sort = "stars", page = 1)
}
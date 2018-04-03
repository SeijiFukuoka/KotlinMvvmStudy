package br.com.seiji.kotlinmvvmtest.data.remote

import br.com.seiji.kotlinmvvmtest.domain.GitHubRepositoryListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/search/repositories")
    fun getRepositories(
            @Query("q") query: String,
            @Query("sort") sort: String,
            @Query("page") page: Int): Single<GitHubRepositoryListResponse>
}
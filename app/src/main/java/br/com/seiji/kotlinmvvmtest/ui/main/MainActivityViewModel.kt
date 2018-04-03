package br.com.seiji.kotlinmvvmtest.ui.main

import br.com.seiji.kotlinmvvmtest.api.model.GitHubRepositoryListResponse
import br.com.seiji.kotlinmvvmtest.repository.Repository
import br.com.seiji.kotlinmvvmtest.util.SchedulerProvider
import io.reactivex.Single

class MainActivityViewModel(private val repository: Repository, private val schedulerProvider: SchedulerProvider) {

    fun showDataFromApi(query: String, sort: String, page: Int): Single<GitHubRepositoryListResponse> = repository.getDataFromApi(query, sort, page)
            .compose(schedulerProvider.getSchedulersForSingle())

}
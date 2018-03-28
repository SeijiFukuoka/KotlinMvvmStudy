package br.com.seiji.kotlinmvvmtest.ui.main

import br.com.seiji.kotlinmvvmtest.api.model.MyModel
import br.com.seiji.kotlinmvvmtest.repository.Repository
import br.com.seiji.kotlinmvvmtest.util.SchedulerProvider
import io.reactivex.Single

class MainActivityViewModel(private val repository: Repository, private val schedulerProvider: SchedulerProvider) {

    fun showDataFromApi(): Single<MyModel> = repository.getDataFromApi()
            .compose(schedulerProvider.getSchedulersForSingle())

}
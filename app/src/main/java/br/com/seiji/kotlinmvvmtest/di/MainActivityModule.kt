package br.com.seiji.kotlinmvvmtest.di

import br.com.seiji.kotlinmvvmtest.repository.Repository
import br.com.seiji.kotlinmvvmtest.ui.main.MainActivityViewModel
import br.com.seiji.kotlinmvvmtest.util.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideViewModel(repository: Repository, schedulerProvider: SchedulerProvider) = MainActivityViewModel(repository, schedulerProvider)

}
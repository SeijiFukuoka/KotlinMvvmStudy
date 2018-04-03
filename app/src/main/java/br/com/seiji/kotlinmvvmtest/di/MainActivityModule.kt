package br.com.seiji.kotlinmvvmtest.di

import br.com.seiji.kotlinmvvmtest.view.MainActivityViewModel
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {
    @Provides
    fun provideViewModel() = MainActivityViewModel()
}
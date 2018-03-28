package br.com.seiji.kotlinmvvmtest.di

import br.com.seiji.kotlinmvvmtest.ui.main.MainActivityViewModel
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideViewModel() = MainActivityViewModel()

}
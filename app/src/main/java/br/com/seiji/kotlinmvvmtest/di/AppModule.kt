package br.com.seiji.kotlinmvvmtest.di

import android.content.Context
import br.com.seiji.kotlinmvvmtest.CustomApplication
import br.com.seiji.kotlinmvvmtest.data.repository.GitHubRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private val currencyApplication: CustomApplication) {

    @Provides
    @Singleton
    fun provideContext(): Context = currencyApplication
}
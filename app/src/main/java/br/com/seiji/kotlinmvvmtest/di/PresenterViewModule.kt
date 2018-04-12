package br.com.seiji.kotlinmvvmtest.di

import br.com.seiji.kotlinmvvmtest.view.CustomView
import br.com.seiji.kotlinmvvmtest.view.MainActivity
import dagger.Binds
import dagger.Module

@Module
abstract class PresenterViewModule {

    @Binds
    internal abstract fun provideLobbyView(mainActivity: MainActivity): CustomView
}
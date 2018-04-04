package br.com.seiji.kotlinmvvmtest.di

import br.com.seiji.kotlinmvvmtest.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(FragmentBuildersModule::class))
    internal abstract fun bindMainActivity(): MainActivity
}
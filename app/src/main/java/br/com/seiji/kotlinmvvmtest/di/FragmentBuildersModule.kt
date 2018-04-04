package br.com.seiji.kotlinmvvmtest.di


import br.com.seiji.kotlinmvvmtest.view.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    internal abstract fun contributesListFragment(): ListFragment
}
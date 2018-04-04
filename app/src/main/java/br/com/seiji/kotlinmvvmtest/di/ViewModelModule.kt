package br.com.seiji.kotlinmvvmtest.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.seiji.kotlinmvvmtest.util.ViewModelFactory
import br.com.seiji.kotlinmvvmtest.view.RepositoriesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RepositoriesViewModel::class)
    internal abstract fun bindUserViewModel(repositoriesViewModel: RepositoriesViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
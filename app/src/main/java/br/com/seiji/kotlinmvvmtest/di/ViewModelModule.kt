package br.com.seiji.kotlinmvvmtest.di

import android.content.Context
import br.com.seiji.kotlinmvvmtest.view.CustomView
import br.com.seiji.kotlinmvvmtest.view.Presenter
import br.com.seiji.kotlinmvvmtest.view.RepositoriesPresenterImpl
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
internal abstract class ViewModelModule {

//    @Binds
//    @IntoMap
//    @ViewModelKey(RepositoriesViewModel::class)
//    internal abstract fun bindUserViewModel(repositoriesViewModel: RepositoriesViewModel): ViewModel
//
//    @Binds
//    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory



    @Binds
    internal abstract fun bindPresenter(repositoriesPresenterImpl: RepositoriesPresenterImpl): Presenter

}
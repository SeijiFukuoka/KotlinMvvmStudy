package br.com.seiji.kotlinmvvmtest.di

import br.com.seiji.kotlinmvvmtest.view.RepositoriesViewModel
import dagger.Component
import javax.inject.Singleton


@Component(modules = arrayOf(AppModule::class, RoomModule::class, RemoteModule::class))
@Singleton
interface AppComponent {

    fun inject(repositoriesViewModel: RepositoriesViewModel)

}
package br.com.seiji.kotlinmvvmtest.di

import android.app.Application
import br.com.seiji.kotlinmvvmtest.CustomApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        RoomModule::class,
        RemoteModule::class,
        ActivityBuilder::class,
        PresenterViewModule::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun remoteModule(appModule: RemoteModule): Builder

        fun roomModule(appModule: RoomModule): Builder

        fun build(): AppComponent
    }

    fun inject(app: CustomApplication)
}
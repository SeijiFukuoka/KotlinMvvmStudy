package br.com.seiji.kotlinmvvmtest

import android.app.Application
import br.com.seiji.kotlinmvvmtest.di.*

class CustomApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        initializeDagger()
    }

    fun initializeDagger() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .roomModule(RoomModule())
                .remoteModule(RemoteModule(this)).build()
    }
}
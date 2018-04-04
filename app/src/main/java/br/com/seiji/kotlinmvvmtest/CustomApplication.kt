package br.com.seiji.kotlinmvvmtest

import android.app.Activity
import android.app.Application
import br.com.seiji.kotlinmvvmtest.di.AppComponent
import br.com.seiji.kotlinmvvmtest.di.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class CustomApplication : Application(), HasActivityInjector {

    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
        @Inject set

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        AppInjector.initInjector(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> =
            activityDispatchingAndroidInjector
}
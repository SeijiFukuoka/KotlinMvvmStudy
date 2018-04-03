package br.com.seiji.kotlinmvvmtest.ui.main

import android.os.Bundle
import android.util.Log
import br.com.seiji.kotlinmvvmtest.R
import dagger.android.DaggerActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class MainActivity : DaggerActivity() {

    private val compositeDisposable by lazy { CompositeDisposable() }

    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        compositeDisposable.add(mainActivityViewModel.showDataFromApi("kotlin", "stars", 1)
                .subscribeBy(onSuccess = {
                    Log.d("MainActivity", it.total_count.toString())
                }, onError = {
                    Log.d("MainActivity", it.message)
                }))
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }
}

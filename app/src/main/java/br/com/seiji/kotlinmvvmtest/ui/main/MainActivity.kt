package br.com.seiji.kotlinmvvmtest.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.seiji.kotlinmvvmtest.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel.doSomething()
    }
}

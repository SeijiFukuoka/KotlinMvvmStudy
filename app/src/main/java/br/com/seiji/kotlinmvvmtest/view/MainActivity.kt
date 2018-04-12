package br.com.seiji.kotlinmvvmtest.view

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import br.com.seiji.kotlinmvvmtest.R
import br.com.seiji.kotlinmvvmtest.di.Injectable
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


//class MainActivity : AppCompatActivity(), HasSupportFragmentInjector, CustomView {
class MainActivity : AppCompatActivity(), CustomView {
//    @Inject
//    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

//    @Inject
//    lateinit var viewModelFactory: ViewModelProvider.Factory

//    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
//        return dispatchingAndroidInjector
//    }

    @Inject
    lateinit var repositoriesPresenterImpl: RepositoriesPresenterImpl

    override fun showView() {
        Log.d("TAG", "showView")
    }

    override fun getContext(): Context {
        return this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            repositoriesPresenterImpl.test()
//            replaceFragment(ListFragment.newInstance())

//            val viewModel = ViewModelProviders.of(this, viewModelFactory).get(RepositoriesViewModel::class.java)
//            viewModel.let { lifecycle.addObserver(it) }
//            viewModel.getRespositories("kotlin", "starts", 1).observe(this, Observer { repositoriesList ->
//                Log.d(MainActivity::class.java.simpleName, repositoriesList?.get(0)?.name)
//            })
//            viewModel.getRepositoriesTotal().observe(this, Observer { total -> Log.d(MainActivity::class.java.simpleName, total.toString()) })
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.content, fragment)
                .commit()
    }
}

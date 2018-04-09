package br.com.seiji.kotlinmvvmtest.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import br.com.seiji.kotlinmvvmtest.R
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

//    @Inject
//    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            replaceFragment(ListFragment.newInstance())

//            val viewModel = ViewModelProviders.of(this, viewModelFactory).get(RepositoriesViewModel::class.java)
//            viewModel.let { lifecycle.addObserver(it) }
//            viewModel.getRepositories("kotlin", "starts", 1).observe(this, Observer { repositoriesList ->
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

/**
 * Copyright 2017 Erik Jhordan Rey.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.seiji.kotlinmvvmtest.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.seiji.kotlinmvvmtest.R
import br.com.seiji.kotlinmvvmtest.di.Injectable
import javax.inject.Inject

class ListFragment : Fragment(), Injectable {

    companion object {
        fun newInstance() = ListFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        initViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(RepositoriesViewModel::class.java)
        viewModel.let { lifecycle.addObserver(it) }
        viewModel.getRepositories("kotlin", "starts", 1)?.observe(this, Observer { repositoriesList ->
            Log.d(ListFragment::class.java.simpleName, repositoriesList?.get(0)?.name)
        })
        viewModel.getRepositoriesTotal().observe(this, Observer { total ->
            Log.d(ListFragment::class.java.simpleName, total.toString())
        })
    }

//    private fun initViewModel() {
//        val repositoriesViewModel : RepositoriesViewModel = ViewModelProviders.of(this, viewModelFactory).get(RepositoriesViewModel::class.java)
//        repositoriesViewModel.let { lifecycle.addObserver(it) }
//        repositoriesViewModel.getRepositories("kotlin", "starts", 1)?.observe(this, Observer { repositoriesList ->
//            Log.d(MainActivity::class.java.simpleName, repositoriesList?.get(0)?.name)
//        })
//    }
}

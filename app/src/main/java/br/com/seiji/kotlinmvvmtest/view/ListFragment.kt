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
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.seiji.kotlinmvvmtest.R
import javax.inject.Inject


class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    @Inject
    internal lateinit var viewModelFactory: GithubViewModelFactory

    private var mainActivityViewModel: MainActivityViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initViewModel() {
        mainActivityViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel::class.java)
        mainActivityViewModel?.let { lifecycle.addObserver(it) }
        mainActivityViewModel?.getRepositoriesList("kotlin", "starts", 1)?.observe(this, Observer { repositoriesList ->
            Log.d(MainActivity::class.java.simpleName, repositoriesList?.get(0)?.name)
        })
    }
}

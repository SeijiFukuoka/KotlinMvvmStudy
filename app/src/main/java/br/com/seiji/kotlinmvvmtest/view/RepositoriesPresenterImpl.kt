package br.com.seiji.kotlinmvvmtest.view

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import br.com.seiji.kotlinmvvmtest.data.repository.GitHubRepository
import br.com.seiji.kotlinmvvmtest.domain.Repo
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class RepositoriesPresenterImpl @Inject constructor(private val repository: GitHubRepository) : Presenter {

    private val compositeDisposable = CompositeDisposable()

    @Inject
    lateinit var view: CustomView

    private lateinit var liveAvailableExchange: LiveData<List<Repo>>

    override fun test(): LiveData<List<Repo>> {
        Log.d("TEST", "TEST")
        view.showView()
        liveAvailableExchange = MutableLiveData<List<Repo>>()
        liveAvailableExchange = repository.getRepositoriesList("query", "stars", 1)
        Log.d("TEST", liveAvailableExchange.toString())
        return liveAvailableExchange
    }
}



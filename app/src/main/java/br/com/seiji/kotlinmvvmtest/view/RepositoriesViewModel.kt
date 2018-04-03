package br.com.seiji.kotlinmvvmtest.view

import android.arch.lifecycle.*
import br.com.seiji.kotlinmvvmtest.CustomApplication
import br.com.seiji.kotlinmvvmtest.data.repository.GitHubRepository
import br.com.seiji.kotlinmvvmtest.domain.Repo
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class RepositoriesViewModel : ViewModel(), LifecycleObserver {

    @Inject
    lateinit var repository: GitHubRepository

    private val compositeDisposable = CompositeDisposable()
    private lateinit var liveAvailableExchange: LiveData<List<Repo>>

    init {
        initializeDagger()
    }

    fun getRespositories(query: String, sort: String, page: Int): LiveData<List<Repo>> {
        liveAvailableExchange = MutableLiveData<List<Repo>>()
        liveAvailableExchange = repository.getRepositoriesList(query, sort, page)
        return liveAvailableExchange
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun unSubscribeViewModel() {
        for (disposable in repository.allCompositeDisposable) {
            compositeDisposable.addAll(disposable)
        }
        compositeDisposable.clear()
    }

    override fun onCleared() {
        unSubscribeViewModel()
        super.onCleared()
    }

    private fun initializeDagger() = CustomApplication.appComponent.inject(this)
}



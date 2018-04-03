package br.com.seiji.kotlinmvvmtest.view

import android.arch.lifecycle.*
import br.com.seiji.kotlinmvvmtest.data.repository.GitHubRepository
import br.com.seiji.kotlinmvvmtest.domain.Repo
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class MainActivityViewModel : ViewModel(), LifecycleObserver {

    @Inject
    lateinit var repository: GitHubRepository

    private val compositeDisposable = CompositeDisposable()
    private lateinit var liveRepositoryData: LiveData<List<Repo>>

    fun getRepositoriesList(query: String, sort: String, page: Int): LiveData<List<Repo>>? {
        liveRepositoryData = MutableLiveData<List<Repo>>()
        liveRepositoryData = repository.getRepositoriesList(query, sort, page)
        return liveRepositoryData
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
}
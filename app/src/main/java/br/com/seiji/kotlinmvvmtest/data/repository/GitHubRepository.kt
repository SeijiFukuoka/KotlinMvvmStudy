package br.com.seiji.kotlinmvvmtest.data.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import br.com.seiji.kotlinmvvmtest.data.remote.GitHubDataSource
import br.com.seiji.kotlinmvvmtest.data.room.RoomRepositoriesDataSource
import br.com.seiji.kotlinmvvmtest.domain.Repo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitHubRepository @Inject constructor(
        private val remoteDataSource: GitHubDataSource,
        private val roomDataSource: RoomRepositoriesDataSource
) : Repository {

    val allCompositeDisposable: MutableList<Disposable> = arrayListOf()

    override fun getTotalRepositories(): LiveData<Int> {
        val mutableLiveData = MutableLiveData<Int>()
        val disposable = roomDataSource.repositoriesDao().getRepositoriesTotal()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    mutableLiveData.value = response
                }, { t: Throwable? -> t!!.printStackTrace() })
        allCompositeDisposable.add(disposable)
        return mutableLiveData
    }


    override fun addRepositories() {
    }

    override fun getRepositoriesList(query: String, sort: String, page: Int): LiveData<List<Repo>> {
        val mutableLiveData = MutableLiveData<List<Repo>>()
        val disposable = remoteDataSource.requestRepositoriesList(query, sort, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    mutableLiveData.value = response.items
                }, { t: Throwable? -> t!!.printStackTrace() })
        allCompositeDisposable.add(disposable)
        return mutableLiveData
    }
}
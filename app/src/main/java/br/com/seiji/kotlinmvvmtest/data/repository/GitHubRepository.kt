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
        private val roomDataSource: RoomRepositoriesDataSource,
        private val remoteDataSource: GitHubDataSource
) : Repository {

    val allCompositeDisposable: MutableList<Disposable> = arrayListOf()

    override fun getTotalRepositories() =
            roomDataSource.repositoriesDao().getRepositoriesTotal()

    override fun addRepositories() {
//        val repositoriesEntityList = RoomRepositoriesDataSource.
//        roomDataSource.repositoriesDao().insertAll(repositoriesEntityList)
    }

    override fun getRepositoriesList(query: String, sort: String, page: Int): LiveData<List<Repo>> {
//        val roomDao = roomDataSource.repositoriesDao()
//        val mutableLiveData = MutableLiveData<List<Repo>>()
//        val disposable = roomDao.getAllRepositories()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ repositoriesList ->
//                    mutableLiveData.value = transform(repositoriesList)
//                }, { t: Throwable ->
//                    t!!.printStackTrace()
//                })
//        allCompositeDisposable.add(disposable)
//        return mutableLiveData

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

    private companion object {
        var TAG = GitHubRepository::class.simpleName
    }
}
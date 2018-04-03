package br.com.seiji.kotlinmvvmtest.data.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Single

@Dao
interface RoomRepositoriesDao {
    @Query(RoomContract.SELECT_REPOSITORIES_COUNT)
    fun getRepositoriesTotal(): Single<Int>

    @Insert
    fun insertAll(repos: List<RepositoriesEntity>)

    @Query(RoomContract.SELECT_REPOSITORIES)
    fun getAllRepositories(): Single<List<RepositoriesEntity>>
}
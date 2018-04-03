package br.com.seiji.kotlinmvvmtest.data.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(
        entities = arrayOf(RepositoriesEntity::class),
        version = 1)
abstract class RoomRepositoriesDataSource : RoomDatabase() {

    abstract fun repositoriesDao(): RoomRepositoriesDao

    companion object {
        fun buildPersistentRepositories(context: Context): RoomRepositoriesDataSource = Room.databaseBuilder(
                context.applicationContext,
                RoomRepositoriesDataSource::class.java,
                RoomContract.DATABASE_REPOSITORIES
        ).build()


//        fun getAllCurrencies(): List<RepositoriesEntity> {
//            val mutableCurrencyList = mutableListOf<RepositoriesEntity>()
//            mutableCurrencyList.addAll(().getAllRepositories().blockingGet())
//            return mutableCurrencyList
//        }
    }
}
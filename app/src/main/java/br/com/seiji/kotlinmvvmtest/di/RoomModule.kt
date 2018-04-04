package br.com.seiji.kotlinmvvmtest.di

import br.com.seiji.kotlinmvvmtest.CustomApplication
import br.com.seiji.kotlinmvvmtest.data.room.RoomRepositoriesDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(val application: CustomApplication) {

    @Provides
    @Singleton
    fun provideRoomDataSource() =
            RoomRepositoriesDataSource.buildPersistentRepositories(application)
}
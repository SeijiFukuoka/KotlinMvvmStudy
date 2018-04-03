package br.com.seiji.kotlinmvvmtest.di

import android.content.Context
import br.com.seiji.kotlinmvvmtest.data.repository.GitHubRepository
import br.com.seiji.kotlinmvvmtest.data.room.RoomRepositoriesDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {
    @Provides
    @Singleton
    fun provideRoomDataSource(context: Context) =
            RoomRepositoriesDataSource.buildPersistentRepositories(context)
}
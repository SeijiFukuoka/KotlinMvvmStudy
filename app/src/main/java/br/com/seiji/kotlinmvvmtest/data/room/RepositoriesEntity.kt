package br.com.seiji.kotlinmvvmtest.data.room

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = RoomContract.TABLE_REPOSITORIES)
data class RepositoriesEntity(
        @PrimaryKey(autoGenerate = true) val id: Long,
        var name: String,
        var fullName: String,
        var description: String,
        var url: String
)
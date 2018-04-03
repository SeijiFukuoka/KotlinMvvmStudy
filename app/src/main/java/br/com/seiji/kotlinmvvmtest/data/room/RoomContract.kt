package br.com.seiji.kotlinmvvmtest.data.room

class RoomContract {

    companion object {
        const val DATABASE_REPOSITORIES = "repositories.db"
        const val TABLE_REPOSITORIES = "repositories"

        private const val SELECT_COUNT = "SELECT COUNT(*) FROM "
        private const val SELECT_FROM = "SELECT * FROM "

        const val SELECT_REPOSITORIES_COUNT = SELECT_COUNT + TABLE_REPOSITORIES
        const val SELECT_REPOSITORIES = SELECT_FROM + TABLE_REPOSITORIES
    }
}
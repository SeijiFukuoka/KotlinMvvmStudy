package br.com.seiji.kotlinmvvmtest.data.repository

import android.arch.lifecycle.LiveData
import br.com.seiji.kotlinmvvmtest.domain.Repo

interface Repository {
    fun addRepositories()
    fun getRepositoriesList(query: String, sort: String, page: Int): LiveData<List<Repo>>
    fun getTotalRepositories(): LiveData<Int>
}
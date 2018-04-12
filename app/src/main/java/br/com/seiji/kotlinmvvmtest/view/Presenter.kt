package br.com.seiji.kotlinmvvmtest.view

import android.arch.lifecycle.LiveData
import br.com.seiji.kotlinmvvmtest.domain.Repo

interface Presenter {

    fun test(): LiveData<List<Repo>>
}
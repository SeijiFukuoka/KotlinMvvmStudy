package br.com.seiji.kotlinmvvmtest.view

import android.content.Context

interface CustomView {

    fun getContext() : Context
    fun showView()
}
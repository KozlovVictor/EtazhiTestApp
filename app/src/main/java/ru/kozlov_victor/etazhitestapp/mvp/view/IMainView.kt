package ru.kozlov_victor.etazhitestapp.mvp.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface IMainView : MvpView {
    fun showSearchResult(repositorySearchCount: Int?)
    fun showLoading()
    fun hideLoading()
}
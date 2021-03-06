package ru.kozlov_victor.etazhitestapp.mvp.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.kozlov_victor.etazhitestapp.mvp.model.entity.Property

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface IMainView : MvpView {
    fun init()
    fun updateRepositoryList()
    fun showSearchResult(repositorySearchCount: Int?)
    fun startDetailedView(property: Property?)
}
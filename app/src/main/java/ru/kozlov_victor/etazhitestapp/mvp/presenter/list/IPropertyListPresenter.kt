package ru.kozlov_victor.etazhitestapp.mvp.presenter.list

import ru.kozlov_victor.etazhitestapp.mvp.view.item.IItemPropertyView

interface IPropertyListPresenter {
    fun bindView(view: IItemPropertyView)
    fun getPropertyCount(): Int?
    fun onItemClick(position: Int)
}
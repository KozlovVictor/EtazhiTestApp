package ru.kozlov_victor.etazhitestapp.mvp.view.item


interface IItemPropertyView {
    fun getPosition(): Int
    fun setPrice(price: String?)
    fun setAddress(address: String?)
    fun setShortDesc(description: String?)
}
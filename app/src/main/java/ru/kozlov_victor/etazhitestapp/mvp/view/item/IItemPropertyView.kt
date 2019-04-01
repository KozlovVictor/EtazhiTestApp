package ru.kozlov_victor.etazhitestapp.mvp.view.item


interface IItemPropertyView {
    fun getPos(): Int
    fun setPrice(price: String?)
    fun setAddress(address: String?)
    fun setShortDesc(description: String?)
}
package ru.kozlov_victor.etazhitestapp.mvp.model.api

object ApiHolder {
    val instance = ApiHolder
    val api = IDataSource.create()
}
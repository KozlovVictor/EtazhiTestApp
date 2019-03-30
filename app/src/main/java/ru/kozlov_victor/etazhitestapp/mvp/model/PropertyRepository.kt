package ru.kozlov_victor.etazhitestapp.mvp.model

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.kozlov_victor.etazhitestapp.mvp.model.api.ApiHolder
import ru.kozlov_victor.etazhitestapp.mvp.model.entity.CountResponse
import ru.kozlov_victor.etazhitestapp.mvp.model.entity.PropertyResponse

class PropertyRepository() {
    fun getData(apiKey: String, filter: String, limit: Int, offset: Int): Single<PropertyResponse> {
        return ApiHolder.api.getData(apiKey, filter, limit, offset).subscribeOn(Schedulers.io())
    }

    fun getCount(apiKey: String, filter: String, count: Int): Single<CountResponse> {
        return ApiHolder.api.getCount(apiKey, filter, count).subscribeOn(Schedulers.io())
    }
}
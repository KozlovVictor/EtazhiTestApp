package ru.kozlov_victor.etazhitestapp.mvp.model

import io.reactivex.Single
import ru.kozlov_victor.etazhitestapp.mvp.model.api.ApiHolder
import ru.kozlov_victor.etazhitestapp.mvp.model.entity.CountResponse
import ru.kozlov_victor.etazhitestapp.mvp.model.entity.PropertyResponse

class PropertyRepository() {
    fun getData(apiKey: String, filter: String, limit: String, offset: String): Single<PropertyResponse> {
        return ApiHolder.api.getData(apiKey, filter, limit, offset)
    }

    fun getCount(apiKey: String, filter: String, count: String): Single<CountResponse> {
        return ApiHolder.api.getCount(apiKey, filter, count)
    }
}
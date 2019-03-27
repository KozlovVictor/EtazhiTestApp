package ru.kozlov_victor.etazhitestapp.mvp.model

import io.reactivex.Single
import ru.kozlov_victor.etazhitestapp.mvp.model.api.ApiHolder
import ru.kozlov_victor.etazhitestapp.mvp.model.entity.Property
import ru.kozlov_victor.etazhitestapp.mvp.model.entity.SearchCount

class PropertyRepository() {
    fun getData(apiKey: String, filter: String, limit: String, offset: String): Single<List<Property>> {
        return ApiHolder.instance.api.getData(apiKey, filter, limit, offset)
    }
    fun getCount(apiKey: String, filter: String, count: Int): Single<SearchCount> {
        return ApiHolder.instance.api.getCount(apiKey, filter, count)
    }
}
package ru.kozlov_victor.etazhitestapp.mvp.model.api

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import ru.kozlov_victor.etazhitestapp.mvp.model.entity.CountResponse
import ru.kozlov_victor.etazhitestapp.mvp.model.entity.PropertyResponse

interface IDataSource {

    @GET("api/v2/objects")
    fun getData(
        @Query("api_key") apiKey: String,
        @Query("filter") filter: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Single<PropertyResponse>

    @GET ("api/v2/objects")
    fun getCount(
        @Query("api_key") apiKey: String,
        @Query("filter") filter: String,
        @Query("count") count: Int
    ): Single<CountResponse>

    companion object {
        fun create(): IDataSource {
            val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                //.excludeFieldsWithoutExposeAnnotation()
                .create()
            val api = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://developers.etagi.com/")
                .build()
            return api.create(IDataSource::class.java)
        }
    }
}
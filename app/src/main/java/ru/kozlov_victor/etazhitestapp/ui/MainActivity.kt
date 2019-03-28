package ru.kozlov_victor.etazhitestapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.schedulers.Schedulers
import ru.kozlov_victor.etazhitestapp.R
import ru.kozlov_victor.etazhitestapp.mvp.model.PropertyRepository

private const val filter =
    "['AND', ['=', ''city_id, '23' ], [\"=\", \"action\", \"sale\"], [\"=\", \"class\", \"flats\"], [\"=\", \"status\", \"active\"]]"

private const val apiKey = "vns78gr623bduqb2389rb3fsyaf326fa"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val propertyRepository = PropertyRepository().getData(apiKey, filter, "3", "0")
        propertyRepository
            .subscribeOn(Schedulers.io())
            .subscribe({ response ->
                Log.d("TEST", "City: ${response.data?.get(0)?.city}, size: ${response.data?.size} !")
            }, { error -> error.printStackTrace() })

//        val propertyCount = PropertyRepository().getCount(apiKey, filter, "1")
//        propertyCount.subscribeOn(Schedulers.io())
//            .subscribe({ response ->
//                Log.d("TEST", "Count: ${response.count?.count}!")
//            })
    }
}
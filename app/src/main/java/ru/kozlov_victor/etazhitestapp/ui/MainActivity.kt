package ru.kozlov_victor.etazhitestapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.schedulers.Schedulers
import ru.kozlov_victor.etazhitestapp.R
import ru.kozlov_victor.etazhitestapp.mvp.model.PropertyRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val propertyRepository = PropertyRepository().getData(
//            "vns78gr623bduqb2389rb3fsyaf326fa",
//            "['AND', ['=', ''city_id, '23' ], [\"=\", \"action\", \"sale\"], [\"=\", \"class\", \"flats\"], [\"=\", \"status\", \"active\"]]",
//            "3", "0"
//        )
//        propertyRepository
//            .subscribeOn(Schedulers.io())
//            .subscribe({ properties ->
//                Log.d("TEST", "City: ${properties.get(0).city}, size: ${properties.size} !")
//            }, { error -> error.printStackTrace() })
        val propertyRepository = PropertyRepository().getCount("vns78gr623bduqb2389rb3fsyaf326fa",
            "['AND', ['=', ''city_id, '23' ], [\"=\", \"action\", \"sale\"], [\"=\", \"class\", \"flats\"], [\"=\", \"status\", \"active\"]]",
            1)
        //TODO
        // propertyRepository.subscribeOn(Schedulers.computation()).subscribe({result -> Log.d("Count: " ${result.count}),
//            error ->)
    }
}
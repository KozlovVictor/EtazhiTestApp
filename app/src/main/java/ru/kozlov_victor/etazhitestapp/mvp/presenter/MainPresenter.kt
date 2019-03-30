package ru.kozlov_victor.etazhitestapp.mvp.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Scheduler
import ru.kozlov_victor.etazhitestapp.mvp.model.PropertyRepository
import ru.kozlov_victor.etazhitestapp.mvp.view.IMainView

@InjectViewState
class MainPresenter() : MvpPresenter<IMainView>() {

    companion object {
        private const val filter =
            "['AND', ['=', ''city_id, '23' ], [\"=\", \"action\", \"sale\"], [\"=\", \"class\", \"flats\"], [\"=\", \"status\", \"active\"]]"
        private const val apiKey = "vns78gr623bduqb2389rb3fsyaf326fa"
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    init {
        PropertyRepository().getData(apiKey, filter, 3, 0)
            .subscribe({ response ->
                val propertyList = response.data
//                Log.d("TEST", "City: ${response.data?.get(0)?.city}, size: ${response.data?.size} !")
            }, { error -> error.printStackTrace() })
        PropertyRepository().getCount(apiKey, filter, 1)
            .subscribe({response ->
                val repositorySearchCount = response.data?.count
                viewState.showSearchResult(repositorySearchCount?.toInt())
            }, {error -> error.printStackTrace()})
    }
}
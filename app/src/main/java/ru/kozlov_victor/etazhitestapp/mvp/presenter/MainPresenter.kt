package ru.kozlov_victor.etazhitestapp.mvp.presenter

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.kozlov_victor.etazhitestapp.mvp.model.PropertyRepository
import ru.kozlov_victor.etazhitestapp.mvp.model.entity.Property
import ru.kozlov_victor.etazhitestapp.mvp.presenter.list.IPropertyListPresenter
import ru.kozlov_victor.etazhitestapp.mvp.view.IMainView
import ru.kozlov_victor.etazhitestapp.mvp.view.item.IItemPropertyView

@InjectViewState
class MainPresenter : MvpPresenter<IMainView>() {

    val propertyListPresenter = PropertyListPresenter()

    companion object {
        private const val filter =
            "['AND', ['=', ''city_id, '23' ], [\"=\", \"action\", \"sale\"], [\"=\", \"class\", \"flats\"], [\"=\", \"status\", \"active\"]]"
        private const val apiKey = "vns78gr623bduqb2389rb3fsyaf326fa"
        var propertyList: List<Property?>? = null
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
    }

    private fun loadData() {
        PropertyRepository().getData(apiKey, filter, 3, 0)
            .subscribe({ response ->
                propertyList = response.data
                Log.d("TEST", "City: ${response.data?.get(0)?.city}, size: ${response.data?.size} !")
            }, { error -> error.printStackTrace() })
        PropertyRepository().getCount(apiKey, filter, 1)
            .subscribe({ response ->
                val repositorySearchCount = response.data?.count
                viewState.showSearchResult(repositorySearchCount?.toInt())
            }, { error -> error.printStackTrace() })
    }


    fun selectItem(position: Int) = viewState.startDetailedView(propertyList?.get(position))

    inner class PropertyListPresenter : IPropertyListPresenter {

        override fun bindView(view: IItemPropertyView) {
            val listItem = propertyList?.get(view.getPos())
            val costPerMeter = listItem?.price?.toInt()!! / listItem?.areaFlat!!.toInt()
            view.setPrice("${listItem?.price} ${listItem?.currencySymbol}")
            view.setAddress("${listItem?.city}, ${listItem?.street}, ${listItem?.houseNum}")
            view.setShortDesc(
                "${listItem?.type}, ${listItem?.areaFlat} м²," +
                        " этаж ${listItem?.floorsNum}/${listItem?.floorsCnt}, " +
                        "$costPerMeter ${listItem?.currencySymbol}/м²"
            )
        }

        override fun getPropertyCount(): Int? = propertyList?.size

        override fun onItemClick(position: Int) = this@MainPresenter.selectItem(position)
    }
}
package ru.kozlov_victor.etazhitestapp.mvp.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.kozlov_victor.etazhitestapp.mvp.model.PropertyRepository
import ru.kozlov_victor.etazhitestapp.mvp.model.entity.Property
import ru.kozlov_victor.etazhitestapp.mvp.presenter.list.IPropertyListPresenter
import ru.kozlov_victor.etazhitestapp.mvp.view.IMainView
import ru.kozlov_victor.etazhitestapp.mvp.view.item.IItemPropertyView

@InjectViewState
class MainPresenter : MvpPresenter<IMainView>() {

    companion object {
        private const val filter =
            "['AND', ['=', ''city_id, '23' ], [\"=\", \"action\", \"sale\"], [\"=\", \"class\", \"flats\"], [\"=\", \"status\", \"active\"]]"
        private const val apiKey = "vns78gr623bduqb2389rb3fsyaf326fa"
        var propertyList: List<Property?>? = null
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }
//TODO refactor mainPresenter
    init {
        PropertyRepository().getData(apiKey, filter, 3, 0)
            .subscribe({ response ->
                propertyList = response.data
//                Log.d("TEST", "City: ${response.data?.get(0)?.city}, size: ${response.data?.size} !")
            }, { error -> error.printStackTrace() })
        PropertyRepository().getCount(apiKey, filter, 1)
            .subscribe({ response ->
                val repositorySearchCount = response.data?.count
                viewState.showSearchResult(repositorySearchCount?.toInt())
            }, { error -> error.printStackTrace() })
    }

    fun selectItem(position: Int) {
        viewState.showDetailedView(propertyList?.get(position))
    }

    inner class PropertyListPresenter : IPropertyListPresenter {

        override fun bindView(view: IItemPropertyView) {
            val listItem = propertyList?.get(view.getPosition())
            view.setPrice("${listItem?.price} ${listItem?.currencySymbol}")
            //TODO view.setAddress("${listItem?.city}, ${listItem?.city}")
        }

        override fun getPropertyCount(): Int? {
            return propertyList?.size
        }

        override fun onItemClick(position: Int) {
            this@MainPresenter.selectItem(position)
        }
    }
}
package ru.kozlov_victor.etazhitestapp.ui.activity

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.activity_main.*
import ru.kozlov_victor.etazhitestapp.R
import ru.kozlov_victor.etazhitestapp.androidx.MvpAppCompatActivity
import ru.kozlov_victor.etazhitestapp.mvp.model.entity.Property
import ru.kozlov_victor.etazhitestapp.mvp.presenter.MainPresenter
import ru.kozlov_victor.etazhitestapp.mvp.view.IMainView
import ru.kozlov_victor.etazhitestapp.ui.adapter.PropertyRVAdapter

class MainActivity : MvpAppCompatActivity(), IMainView {

    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    @ProvidePresenter
    fun provideMainPresenter(): MainPresenter {
        return MainPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }

    override fun init() {
        rv_property.layoutManager = LinearLayoutManager(this)
        rv_property.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        val propertyRVAdapter = PropertyRVAdapter(mainPresenter.propertyListPresenter)
        rv_property.adapter = propertyRVAdapter
    }

    override fun updateRepositoryList() {
        rv_property.adapter?.notifyDataSetChanged()
    }
    override fun showSearchResult(repositorySearchCount: Int?) {
        toolbar.subtitle = when (repositorySearchCount!! % 10) {
            1 -> "$repositorySearchCount объект"
            2 -> "$repositorySearchCount объекта"
            3 -> "$repositorySearchCount объекта"
            4 -> "$repositorySearchCount объекта"
            else -> "$repositorySearchCount объектов"
        }
    }

    override fun startDetailedView(property: Property?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
package ru.kozlov_victor.etazhitestapp.ui.activity

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import ru.kozlov_victor.etazhitestapp.R
import ru.kozlov_victor.etazhitestapp.androidx.MvpAppCompatActivity
import ru.kozlov_victor.etazhitestapp.mvp.model.entity.Property
import ru.kozlov_victor.etazhitestapp.mvp.presenter.MainPresenter
import ru.kozlov_victor.etazhitestapp.mvp.view.IMainView

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
    }

    override fun showSearchResult(repositorySearchCount: Int?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun showDetailedView(property: Property?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
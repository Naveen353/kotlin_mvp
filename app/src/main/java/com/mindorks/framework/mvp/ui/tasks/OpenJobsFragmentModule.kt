package com.mindorks.framework.mvp.ui.tasks

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.mindorks.framework.mvp.ui.tasks.interactor.OpenJobsInteractor
import com.mindorks.framework.mvp.ui.tasks.interactor.OpenJobsMVPInteractor
import com.mindorks.framework.mvp.ui.tasks.presenter.OpenJobsMVPPresenter
import com.mindorks.framework.mvp.ui.tasks.presenter.OpenJobsPresenter
import com.mindorks.framework.mvp.ui.tasks.view.OpenJobsAdapter
import com.mindorks.framework.mvp.ui.tasks.view.OpenJobsFragment
import com.mindorks.framework.mvp.ui.tasks.view.OpenJobsMvpView
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class OpenJobsFragmentModule{

    @Inject lateinit var mActivity: AppCompatActivity

    @Provides
    internal fun provideContext(): Context {
        return mActivity
    }

    @Provides
    internal fun provideActivity(): AppCompatActivity {
        return mActivity
    }

    @Provides
    internal fun provideLinearLayoutManager(fragment: OpenJobsFragment): LinearLayoutManager = LinearLayoutManager(fragment.activity)

    @Provides
    internal fun provideOpenJobsInteractor(interactor: OpenJobsInteractor): OpenJobsMVPInteractor = interactor

    @Provides
    internal fun provideOpenJobsPresenter(presenter: OpenJobsPresenter<OpenJobsMvpView, OpenJobsMVPInteractor>)
            : OpenJobsMVPPresenter<OpenJobsMvpView, OpenJobsMVPInteractor> = presenter

    @Provides
    internal fun provideOpenJobsAdapter(): OpenJobsAdapter = OpenJobsAdapter()

}
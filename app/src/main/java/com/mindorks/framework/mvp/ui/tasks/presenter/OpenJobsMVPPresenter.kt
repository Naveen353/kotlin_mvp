package com.mindorks.framework.mvp.ui.tasks.presenter

import com.mindorks.framework.mvp.ui.base.presenter.MVPPresenter
import com.mindorks.framework.mvp.ui.tasks.interactor.OpenJobsMVPInteractor
import com.mindorks.framework.mvp.ui.tasks.view.OpenJobsMvpView

interface OpenJobsMVPPresenter<V : OpenJobsMvpView, I : OpenJobsMVPInteractor> : MVPPresenter<V, I> {
    fun onViewPrepared()
}
package com.mindorks.framework.mvp.ui.tasks.presenter

import com.mindorks.framework.mvp.ui.base.presenter.BasePresenter
import com.mindorks.framework.mvp.ui.tasks.interactor.OpenJobsMVPInteractor
import com.mindorks.framework.mvp.ui.tasks.view.OpenJobsMvpView
import com.mindorks.framework.mvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class OpenJobsPresenter<V : OpenJobsMvpView, I : OpenJobsMVPInteractor> @Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = compositeDisposable), OpenJobsMVPPresenter<V, I> {
    override fun onViewPrepared() {
        //getView()?.showProgress()
        interactor?.let {
            compositeDisposable.add(it.getOpenJobsList()
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe { openJobsResponse ->
                        getView()?.let {
                            //it.hideProgress()
                            openJobsResponse.jobs?.let { it1 -> it.onJobListRetrieved(it1) }
                        }
                    })
        }
    }
}
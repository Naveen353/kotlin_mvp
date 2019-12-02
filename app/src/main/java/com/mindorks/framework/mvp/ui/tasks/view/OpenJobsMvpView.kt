package com.mindorks.framework.mvp.ui.tasks.view

import com.mindorks.framework.mvp.data.network.Job
import com.mindorks.framework.mvp.ui.base.view.MVPView

interface OpenJobsMvpView : MVPView {
    fun onJobListRetrieved(jobList: List<Job>)

    fun showUnknownErrorUi()

    fun showNoInternetUi()

    fun onNoJobPosts()

    fun onOpenJobsFailure(msg: String)
}
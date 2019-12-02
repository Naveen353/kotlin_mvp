package com.mindorks.framework.mvp.ui.tasks.interactor

import com.mindorks.framework.mvp.data.network.JobListModel
import com.mindorks.framework.mvp.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

interface OpenJobsMVPInteractor : MVPInteractor {

    fun getOpenJobsList(): Observable<JobListModel>
}
package com.mindorks.framework.mvp.ui.tasks.interactor

import com.mindorks.framework.mvp.data.network.ApiHelper
import com.mindorks.framework.mvp.data.network.JobListModel
import com.mindorks.framework.mvp.data.preferences.PreferenceHelper
import com.mindorks.framework.mvp.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

class OpenJobsInteractor @Inject internal constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : BaseInteractor(preferenceHelper, apiHelper), OpenJobsMVPInteractor {
    override fun getOpenJobsList(): Observable<JobListModel> {
        return apiHelper.getOpenJobsApiCall()
    }
}
package com.mindorks.framework.mvp.ui.tasks.view

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.data.network.Job
import com.mindorks.framework.mvp.ui.base.view.BaseFragment
import com.mindorks.framework.mvp.ui.tasks.interactor.OpenJobsMVPInteractor
import com.mindorks.framework.mvp.ui.tasks.presenter.OpenJobsMVPPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_open_tasks.*
import javax.inject.Inject

class OpenJobsFragment : BaseFragment(),OpenJobsMvpView,OpenJobsAdapter.TaskClickListener{


    companion object {
        internal val TAG = "OpenJobsFragment"

        fun newInstance(): OpenJobsFragment {
            return OpenJobsFragment()
        }
    }

    @Inject
    internal lateinit var openjobsAdapter: OpenJobsAdapter

    @Inject
    internal lateinit var layoutManager: LinearLayoutManager

    @Inject
    internal lateinit var presenter: OpenJobsMVPPresenter<OpenJobsMvpView, OpenJobsMVPInteractor>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_open_tasks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setUp() {
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerViewOpenJobs.setHasFixedSize(true)
        recyclerViewOpenJobs.layoutManager = layoutManager
        recyclerViewOpenJobs.itemAnimator = DefaultItemAnimator()
        openjobsAdapter.setTaskClickListener(this)

        recyclerViewOpenJobs.adapter = openjobsAdapter

        jobListSwipeRefreshLayout.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener { getConfirmedJobs() })
        jobListSwipeRefreshLayout.setColorSchemeResources(R.color.blue)
    }

    override fun onResume() {
        super.onResume()
        getConfirmedJobs()
    }

    private fun getConfirmedJobs(){
        jobListSwipeRefreshLayout.isRefreshing = true
        presenter.onViewPrepared()
    }

    override fun onJobListRetrieved(jobList: List<Job>) {
        jobListSwipeRefreshLayout.isRefreshing = false
        openjobsAdapter.setJobList(jobList)
    }

    override fun onTaskClicked(job: Job) {
        Log.d("job_clicked",job.orderId) //To change body of created functions use File | Settings | File Templates.
    }

    override fun showUnknownErrorUi() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showNoInternetUi() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onNoJobPosts() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onOpenJobsFailure(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

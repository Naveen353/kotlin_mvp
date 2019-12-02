package com.mindorks.framework.mvp.ui.tasks.view

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.data.network.Job
import kotlinx.android.synthetic.main.task_list_item.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class OpenJobsAdapter : RecyclerView.Adapter<OpenJobsAdapter.OpenJobsViewHolder>(){
    private var mJobList: ArrayList<Job>? = null
    private var mTaskClickListener: TaskClickListener? = null
    init {
       mJobList = ArrayList<Job>()
    }

    fun setJobList(jobList: ArrayList<Job>) {
        this.mJobList = jobList
        notifyDataSetChanged()
    }

    interface TaskClickListener {
        fun onTaskClicked(job: Job)
    }

//    fun setTaskClickListener(taskClickListener: OpenJobsFragment) {
//        this.mTaskClickListener = taskClickListener
//    }

    override fun getItemCount() = mJobList!!.size

    override fun onBindViewHolder(holder: OpenJobsViewHolder, position: Int): Unit = holder.run {
        val job = mJobList?.get(position)
        job?.let { onBind(position, it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = OpenJobsViewHolder(LayoutInflater.from(parent?.context)
            .inflate(R.layout.task_list_item, parent, false))

    inner class OpenJobsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun clear() {
            itemView.imageViewPickupImage.setImageDrawable(null)
            itemView.textViewPickUpName.text = ""
            itemView.textViewOrderCreatedAt.text = ""

        }

        fun onBind(position: Int, job: Job) {

//            if (job.status.equals("confirmed",true)) {
//                itemView.textViewOrderState.setBackgroundColor(ContextCompat.getColor(mContext, R.color.green))
//                itemView.pickupItemView.background = ContextCompat.getDrawable(mContext, R.drawable.list_item_white_bg)
//            } else if (job.status.equals("started_pickup",true) || job.status.equals("reached_pickup",true) || job.status.equals("picked_up",true)) {
//                itemView.textViewOrderState.setBackgroundColor(ContextCompat.getColor(mContext, R.color.green))
//                itemView.pickupItemView.background = ContextCompat.getDrawable(mContext, R.drawable.list_item_green_bg)
//            } else if (job.status.equals("started_delivery",true) || job.status.equals("reached_delivery",true)) {
//                itemView.textViewOrderState.setBackgroundColor(ContextCompat.getColor(mContext, R.color.red_dark))
//                itemView.pickupItemView.background = ContextCompat.getDrawable(mContext, R.drawable.list_item_orange_bg)
//            }

            itemView.textViewOrderState.text = job.status
            itemView.textViewPickUpOrderId.text = job.orderId
            itemView.textViewPickUpName.text = job.placedBy


            if (job.createdAt != null) {
                itemView.textViewOrderCreatedAtText.visibility = View.VISIBLE
                itemView.textViewOrderCreatedAt.visibility = View.VISIBLE
                try {
                    val sdf = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
                    sdf.timeZone = TimeZone.getTimeZone("UTC")
                    val convertedDate1 = sdf.parse(job.createdAt)
                    sdf.timeZone = TimeZone.getTimeZone("Asia/Dubai")
                    val time = sdf.format(convertedDate1).split("\\s".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1].split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0]

                    itemView.textViewOrderCreatedAt.text = time
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }

            itemView.setOnClickListener { view -> mTaskClickListener?.onTaskClicked(job) }

        }
    }
}
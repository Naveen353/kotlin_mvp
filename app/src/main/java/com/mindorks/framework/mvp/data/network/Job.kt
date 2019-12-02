package com.mindorks.framework.mvp.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Job(          @Expose
                         @SerializedName("name")
                         var name: String? = null,

                         @Expose
                         @SerializedName("job_id")
                         var jobId: Long? = null,

                         @Expose
                         @SerializedName("order_id")
                         var orderId: String? = null,

                         @Expose
                         @SerializedName("status")
                         var status: String? = null,

                         @Expose
                         @SerializedName("created_at")
                         var createdAt: String? = null,

                         @Expose
                         @SerializedName("order_created_at")
                         var orderCreatedAt: String? = null,

                         @Expose
                         @SerializedName("placed_by")
                         var placedBy: String? = null,

                         @Expose
                         @SerializedName("zone")
                         var zone: String? = null,

                         @Expose
                         @SerializedName("amount")
                         var amount: String? = null,

                         @Expose
                         @SerializedName("subjobs")
                         private var subJobs: List<SubJob>? = null)
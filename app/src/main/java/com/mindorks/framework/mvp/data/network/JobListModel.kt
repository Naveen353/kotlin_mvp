package com.mindorks.framework.mvp.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class JobListModel(
        @Expose
        @SerializedName("status")
        var status: String? = null,

        @Expose
        @SerializedName("jobs")
        var jobs: List<Job>? = null)

package com.mindorks.framework.mvp.data.network

import com.google.gson.annotations.SerializedName

data class SubJob(
        @SerializedName("id")
        private var id: Long? = null,

        @SerializedName("type")
        private var type: String? = null,

        @SerializedName("status")
        private var status: String? = null,

        @SerializedName("name")
        private var name: String? = null,

        @SerializedName("phone")
        private var phone: String? = null,

        @SerializedName("address")
        private var address: String? = null,

        @SerializedName("created_at")
        private var created_at: String? = null,

        @SerializedName("lat")
        private var lat: String? = null,

        @SerializedName("lng")
        private var lng: String? = null,

        @SerializedName("zone_name")
        private var zoneName: String? = null)
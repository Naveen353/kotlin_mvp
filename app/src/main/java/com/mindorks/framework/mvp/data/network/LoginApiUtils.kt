package com.mindorks.framework.mvp.data.network

import com.mindorks.framework.mvp.BuildConfig

object LoginApiUtils {
    val appApi: AppApi
        get() = RetrofitClient.getClient(BuildConfig.BASE_URL).create(AppApi::class.java)
}

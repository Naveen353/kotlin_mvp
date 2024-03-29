package com.mindorks.framework.mvp.data.network

import com.mindorks.framework.mvp.data.preferences.AppPreferenceHelper
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable
import java.util.HashMap
import javax.inject.Inject

/**
 * Created by jyotidubey on 04/01/18.
 */
class AppApiHelper @Inject constructor(private val mPreferenceHelper: AppPreferenceHelper) : ApiHelper {

    override fun performFBLogin(request: LoginRequest.FacebookLoginRequest): Observable<LoginResponse> =
            Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_FACEBOOK_LOGIN)
                    //.addHeaders(apiHeader.publicApiHeader)
                    .addBodyParameter(request)
                    .build()
                    .getObjectObservable(LoginResponse::class.java)

    override fun performGoogleLogin(request: LoginRequest.GoogleLoginRequest): Observable<LoginResponse> =
            Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_GOOGLE_LOGIN)
                    //.addHeaders(apiHeader.publicApiHeader)
                    .addBodyParameter(request)
                    .build()
                    .getObjectObservable(LoginResponse::class.java)

    override fun performLogoutApiCall(): Observable<LogoutResponse> =
            Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGOUT)
                    //.addHeaders(apiHeader.protectedApiHeader)
                    .build()
                    .getObjectObservable(LogoutResponse::class.java)

    override fun getBlogApiCall(): Observable<BlogResponse> =
            Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_BLOG)
                    //.addHeaders(apiHeader.protectedApiHeader)
                    .build()
                    .getObjectObservable(BlogResponse::class.java)

    override fun getOpenSourceApiCall(): Observable<OpenSourceResponse> =
            Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_OPEN_SOURCE)
                    //.addHeaders(apiHeader.protectedApiHeader)
                    .build()
                    .getObjectObservable(OpenSourceResponse::class.java)

    override fun performServerLogin(deid: String, password: String): Observable<LoginResponse> {
        val reqParams = HashMap<String, String>()
        reqParams["deid"] = deid
        reqParams["password"] = password
        reqParams["lat"] = "0.0"
        reqParams["lng"] = "0.0"

        return LoginApiUtils.appApi.make_login_request(reqParams)
    }

    override fun getOpenJobsApiCall(): Observable<JobListModel> {
        val reqParams = HashMap<String, Long?>()

        reqParams["rider_id"] = mPreferenceHelper.getCurrentUserId()

        return LoginApiUtils.appApi.get_active_jobs(mPreferenceHelper.getAccessToken(),reqParams)

    }

}
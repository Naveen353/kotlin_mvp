package com.mindorks.framework.mvp.data.network

import io.reactivex.Observable
import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.QueryMap

interface AppApi {
    @GET("check_for_update/")
    fun checkForUpdate(
            @QueryMap reqParams: Map<String, String>): Observable<Map<String, Boolean>>

    //    @GET("otp/") Observable<LoginApiResponses.OtpResponse> requestOtp(
    //            @QueryMap Map<String, Object> queryParams);
    //
    //    @POST("otp/verify/") Observable<LoginApiResponses.VerifyOtpResponse> verifyOtp(
    //            @Body Map<String, Object> reqBody);
    //
    //    @POST("signup/") Observable<LoginApiResponses.LoginResponse> signUp(@Body SignUpData data);
    //
    //    @POST("login/") Observable<LoginApiResponses.LoginResponse> login(
    //            @Body Map<String, String> queryMap);

    @POST("validate_token/")
    fun validateToken(
            @Header("Authorization") token: String, @Body queryParams: Map<String, String>): Observable<Map<String, Boolean>>

    @POST("588d15f5100000a8072d2945/")
    fun make_mvp_request(
            @Body queryParams: Map<String, String>): Observable<LoginResponse>

    @POST("rider/login")
    fun make_login_request(
            @Body queryParams: Map<String, String>): Observable<LoginResponse>


    @GET("jobs/get_active_jobs")
    fun get_active_jobs(
            @Header("x-access-token") token: String, @QueryMap queryMap: Map<String, Long?>): Observable<JobListModel>

    //    @GET("rider/logout") Observable<Logout> make_logout_request(
    //            @Header("x-access-token") String token, @QueryMap Map<String, String> queryMap);
    //
    //    @GET("jobs/get_active_jobs") Observable<JobsListModel> jobs_request(@Header("x-access-token") String token, @QueryMap Map<String, Long> queryMap);
    //    //@GET("jobsnew/") Observable<JobsListModel> jobs_request(@Header("x-access-token") String token,@QueryMap Map<String, Long> queryMap);
    //
    //    @GET("jobsnew/") Observable<JobsListModel> jobs_request_test();
    //
    //    @POST("sub_job/status_update") Observable<OrderStatusResponse>  update_order_status(
    //            @Header("x-access-token") String token, @Body Map<String, String> queryParams);
    //
    //    @GET("rider/location/updates") Observable<Status> send_location_updates(
    //            @Header("x-access-token") String token, @QueryMap Map<String, String> queryMap);
    //
    //    @GET("jobs/get_jobs") Observable<JobsListModel> completed_jobs_request(
    //            @Header("x-access-token") String token, @QueryMap Map<String, Long> queryMap);
    //
    //    @POST("rider/update_registration") Observable<Status> update_fcm_token(
    //            @Header("x-access-token") String token, @Body Map<String, String> queryParams);
    //
    //    @POST("rider/duty_change") Observable<Status> is_rider_active(
    //            @Header("x-access-token") String token, @Body Map<String, String> queryParams);
    //
    //    @GET("jobs/completed_task_count") Observable<TaskCount> completed_tasks_count(
    //            @Header("x-access-token") String token, @QueryMap Map<String, String> queryMap);
    //
    //    @POST("rider/device_updates") Observable<Status> post_device_info(
    //            @Header("x-access-token") String token, @Body Map<String, String> queryParams);
    //
    //    @GET("rider/search") Observable<RiderStatusModel> get_rider_status(
    //            @Header("x-access-token") String token, @QueryMap Map<String, Long> queryMap);
    //
    //    @PUT("jobs/confirm") Observable<Status> put_confirm_order(
    //            @Header("x-access-token") String token, @Body Map<String, String> queryParams);
    //
    //    @PUT("jobs/cancel") Observable<Status> put_cancel_order(
    //            @Header("x-access-token") String token, @Body Map<String, String> queryParams);
    //
    //    @Multipart
    //    @POST("user_info/") Observable<GenericResponse> createNewUser(
    //            @Header("Authorization") String token, @Part MultipartBody.Part image,
    //            @Part MultipartBody.Part name, @Part MultipartBody.Part latitude,
    //            @Part MultipartBody.Part longitude, @Part MultipartBody.Part referral_code, @Part MultipartBody.Part address,
    //            @Part MultipartBody.Part city, @Part MultipartBody.Part number,
    //            @Part MultipartBody.Part email,
    //            @Part MultipartBody.Part deviceId, @Part MultipartBody.Part deviceModel,
    //            @Part MultipartBody.Part osVersion, @Part MultipartBody.Part appVersion);
    //
    //    @Multipart @POST("user_info/") Observable<GenericResponse> createNewUser(
    //            @Header("Authorization") String token, @Part MultipartBody.Part name,
    //            @Part MultipartBody.Part latitude, @Part MultipartBody.Part longitude, @Part MultipartBody.Part referral_code,
    //            @Part MultipartBody.Part address, @Part MultipartBody.Part city,
    //            @Part MultipartBody.Part number, @Part MultipartBody.Part email,
    //            @Part MultipartBody.Part deviceId,
    //            @Part MultipartBody.Part deviceModel, @Part MultipartBody.Part osVersion,
    //            @Part MultipartBody.Part appVersion);

    @POST("register/device/")
    fun fcmRegistration(
            @Header("Authorization") token: String, @Body data: Map<*, *>): Observable<Boolean>
}

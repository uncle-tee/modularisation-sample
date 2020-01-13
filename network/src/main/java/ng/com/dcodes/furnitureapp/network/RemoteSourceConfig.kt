package ng.com.dcodes.furnitureapp.network

import android.content.Context
import ng.com.dcodes.furnitureapp.network.R.string.base_url
import ng.com.dcodes.mobile.common.utils.network.BaseNetworkSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


open class RemoteSourceConfig<T> constructor(context: Context,clazz: Class<T>) : BaseNetworkSource<T>(context,clazz) {


    private fun getHttpLoggerInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }


    override fun createOkHttpClient(): OkHttpClient? {
        return OkHttpClient.Builder().addInterceptor(getHttpLoggerInterceptor()).build()
    }

    override fun provideBaseEndpoint() = context.getString(base_url)

}
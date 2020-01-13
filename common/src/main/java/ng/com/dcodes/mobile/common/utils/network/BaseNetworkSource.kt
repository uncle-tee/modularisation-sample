package ng.com.dcodes.mobile.common.utils.network

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


@Suppress("LeakingThis")
abstract  class BaseNetworkSource<T>(protected val context: Context, clazz: Class<T>) {


    protected val api = config().create(clazz)


    fun config(): Retrofit {
        val builder = Retrofit.Builder()
        createOkHttpClient()?.let {
            builder.client(it)
        }

        return  builder.addConverterFactory(MoshiConverterFactory.create()).baseUrl(provideBaseEndpoint()).build()

    }

    abstract fun provideBaseEndpoint(): String


    abstract fun createOkHttpClient(): OkHttpClient?
}
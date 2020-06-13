package app.siatechtask.network

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by mostafa Anter.
 */
object RestClient {
    private val gson = GsonBuilder()
        .setLenient()
        .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
        .create()
    private var retrofit: Retrofit? = null
    private var apiServices: ApiService? = null

    fun getInterfaceInstance(BASE_URL: String): ApiService? {
        return if (apiServices == null) {
            apiServices =
                getClient(BASE_URL)!!.create(ApiService::class.java)
            apiServices
        } else {
            apiServices
        }
    }

    fun getClient(BASE_URL: String): Retrofit? {
        val logging: HttpLoggingInterceptor = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.MINUTES)
            .writeTimeout(15, TimeUnit.MINUTES)
            .addInterceptor(logging)
            .build()
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
        return retrofit
    }
}
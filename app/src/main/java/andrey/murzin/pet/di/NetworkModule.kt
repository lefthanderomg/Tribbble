package andrey.murzin.pet.di

import andrey.murzin.pet.BuildConfig
import andrey.murzin.pet.data.network.IMovieDbApi
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val TIME_OUT_CONNECTION = 30L

val networkModule = module {
    single<Gson> { GsonBuilder().serializeNulls().create() }
    single<RxJava2CallAdapterFactory> { RxJava2CallAdapterFactory.create() }
    single<LoggingInterceptor> {
        LoggingInterceptor
            .Builder()
            .loggable(BuildConfig.DEBUG)
            .setLevel(Level.BASIC)
            .log(Log.INFO)
            .request("Request")
            .response("Response")
            .build()
    }
    single<OkHttpClient> {
        OkHttpClient
            .Builder()
            .connectTimeout(TIME_OUT_CONNECTION, TimeUnit.SECONDS)
            .addInterceptor(get<LoggingInterceptor>())
            .build()
    }
    single<GsonConverterFactory> {
        GsonConverterFactory.create(get())
    }
    single<Retrofit.Builder> {
        Retrofit
            .Builder()
            .addConverterFactory(get<GsonConverterFactory>())
            .addCallAdapterFactory(get<RxJava2CallAdapterFactory>())
            .client(get<OkHttpClient>())
            .baseUrl(BuildConfig.BASE_URL)
    }
    single<IMovieDbApi> {
        get<Retrofit.Builder>()
            .build()
            .create(IMovieDbApi::class.java)
    }

}

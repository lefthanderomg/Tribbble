package andrey.murzin.pet.data.network.intersepter

import andrey.murzin.pet.BuildConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AppInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
        val url = request.url().newBuilder().addQueryParameter(
            "api_key",
            BuildConfig.TheMovieDbApiKey
        ).build()

        val builder: Request.Builder = request.newBuilder().url(url)

        return chain.proceed(builder.build())
    }

}
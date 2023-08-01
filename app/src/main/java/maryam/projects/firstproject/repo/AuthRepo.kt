package maryam.projects.firstproject

import maryam.projects.firstproject.api.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AuthRepo {
    private val apiInterface = RetrofitHelper.getInstance().create(ApiInterface::class.java)

    suspend fun login(email: String, password: String) = apiInterface.login(email, password)
}

object RetrofitHelper {

    private const val baseUrl = "https://android-training.appssquare.com/api/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            // we need to add converter factory to
            // convert JSON object to Java object
            .build()
    }
}
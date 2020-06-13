package app.siatechtask.network
import app.siatechtask.BuildConfig
import app.siatechtask.models.AnswerResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/*
* create by mostafa anter
 */
interface ApiService {
    // get cars data
    @GET("api/v1/cars")
    fun getAnswer(@Header("x-rapidapi-host") host: String = BuildConfig.HOST,
                  @Header("x-rapidapi-key") key: String = BuildConfig.KEY,
                  @Query("q") question: String): Single<AnswerResponse>

}
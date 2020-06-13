package app.siatechtask.models.reposatories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import app.siatechtask.models.AnswerResponse
import app.siatechtask.network.ApiService
import app.siatechtask.network.RestClient
import io.reactivex.android.schedulers.AndroidSchedulers


import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

import app.siatechtask.BuildConfig


// created by mostafa Anter
class AnswersDataRepo(val question: String) {
    lateinit var apiService: ApiService
    lateinit var compositeDisposable: CompositeDisposable

    public fun getAnswer(): MutableLiveData<AnswerResponse> {
        val serverData: MutableLiveData<AnswerResponse> = MutableLiveData()
        if (question.isNotEmpty()) {
            apiService = RestClient.getInterfaceInstance(BuildConfig.BASE_URL)!!
            compositeDisposable = CompositeDisposable()
            compositeDisposable.add(apiService.getAnswer(question = question)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { respone, error ->
                    serverData.value = respone
                    if (error != null)
                        Log.e("error", error.message)
                })
        }

        return serverData

    }
}
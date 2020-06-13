package app.siatechtask.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import app.siatechtask.models.AnswerResponse
import app.siatechtask.models.reposatories.AnswersDataRepo

class AnswersViewModel (val question: String): ViewModel() {

    private val reloadTrigger = MutableLiveData<String>()

    private val mutableLiveData: LiveData<AnswerResponse> = Transformations.switchMap(reloadTrigger){
        AnswersDataRepo(question = it).getAnswer()
    }

    init {
        refreshData("")
    }

    fun getDataRepository(): LiveData<AnswerResponse>? {
        return mutableLiveData
    }

    fun refreshData(question: String) {
        reloadTrigger.value = question
    }
}
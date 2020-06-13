package app.siatechtask.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CustomAnswersViewModelFactory (val question: String) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AnswersViewModel(question) as T
    }
}
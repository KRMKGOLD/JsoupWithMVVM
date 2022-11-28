package kr.co.cotton.myapplication.ui.sportsnews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.launch
import kr.co.cotton.myapplication.SportsNews
import kr.co.cotton.myapplication.base.BaseViewModel
import kr.co.cotton.myapplication.data.repository.SportsNewsRepository
import javax.inject.Inject

@HiltViewModel
class SportsNewsViewModel @Inject constructor(
    private val sportsNewsRepository: SportsNewsRepository
) : BaseViewModel() {

    private val _sportsList = MutableLiveData<List<SportsNews>>()
    val sportsList: LiveData<List<SportsNews>> = _sportsList

    init {
        getSportsNews()
    }

    private fun getSportsNews() = viewModelScope.launch {
        _isLoading.value = true

        sportsNewsRepository.getMainSportsNews().onCompletion {
            _isLoading.value = false
        }.collect {
            _sportsList.value = it
        }
    }
}
package kr.co.cotton.myapplication.ui.sportsnews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.co.cotton.myapplication.SportsNews
import javax.inject.Inject

@HiltViewModel
class SportsNewsViewModel @Inject constructor() : ViewModel() {

    private val _sportsList = MutableLiveData<List<SportsNews>>()
    val sportsList: LiveData<List<SportsNews>> = _sportsList
}
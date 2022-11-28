package kr.co.cotton.myapplication.data.repository

import kotlinx.coroutines.flow.Flow
import kr.co.cotton.myapplication.SportsNews

interface SportsNewsRepository {

    fun getMainSportsNews(): Flow<List<SportsNews>>
}
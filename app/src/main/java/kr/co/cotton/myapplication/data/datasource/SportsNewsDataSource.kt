package kr.co.cotton.myapplication.data.datasource

import kotlinx.coroutines.flow.Flow
import kr.co.cotton.myapplication.data.SportsNews

interface SportsNewsDataSource {

    fun getMainSportsNews(): Flow<List<SportsNews>>
}
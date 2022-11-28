package kr.co.cotton.myapplication.data.repository

import kotlinx.coroutines.flow.Flow
import kr.co.cotton.myapplication.data.SportsNews
import kr.co.cotton.myapplication.data.datasource.SportsNewsDataSource

class DefaultSportsNewsRepository(
    private val remoteSportsNewsDataSource: SportsNewsDataSource
) : SportsNewsRepository {

    override fun getMainSportsNews(): Flow<List<SportsNews>> {
        return remoteSportsNewsDataSource.getMainSportsNews()
    }
}
package kr.co.cotton.myapplication.data.datasource

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kr.co.cotton.myapplication.SportsNews

object RemoteSportsNewsDataSource : SportsNewsDataSource {

    override fun getMainSportsNews(): Flow<List<SportsNews>> = flow {
        emit(emptyList<SportsNews>())
    }.flowOn(Dispatchers.IO)
}
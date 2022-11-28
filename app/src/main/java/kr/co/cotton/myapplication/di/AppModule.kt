package kr.co.cotton.myapplication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.cotton.myapplication.data.datasource.RemoteSportsNewsDataSource
import kr.co.cotton.myapplication.data.datasource.SportsNewsDataSource
import kr.co.cotton.myapplication.data.repository.DefaultSportsNewsRepository
import kr.co.cotton.myapplication.data.repository.SportsNewsRepository
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class RemoteSportsDataSource

    @Singleton
    @RemoteSportsDataSource
    @Provides
    fun provideRemoteSportsDataSource(): SportsNewsDataSource {
        return RemoteSportsNewsDataSource
    }
}

/**
 * Make Testable SportsNews Data Module
 */
@Module
@InstallIn(SingletonComponent::class)
object SportsNewsRepositoryModule {

    @Singleton
    @Provides
    fun provideSportsNewsRepository(
        @AppModule.RemoteSportsDataSource remoteSportsNewsDataSource: SportsNewsDataSource
    ): SportsNewsRepository {
        return DefaultSportsNewsRepository(remoteSportsNewsDataSource)
    }
}
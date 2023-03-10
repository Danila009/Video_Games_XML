package com.example.core_network_data.di.api

import com.example.core_common.di.AppScope
import com.example.core_network_data.api.GamesApi
import com.example.core_network_data.repository.GamesRepositoryImpl
import com.example.core_network_domain.repository.GamesRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class GamesApiModule {

    @[Provides AppScope]
    fun providerVideoGamesRepository(
        gamesApi: GamesApi
    ): GamesRepository = GamesRepositoryImpl(
        gamesApi = gamesApi
    )

    @[Provides AppScope]
    fun providerVideoGamesApi(
        retrofit: Retrofit
    ): GamesApi = retrofit.create(GamesApi::class.java)


}